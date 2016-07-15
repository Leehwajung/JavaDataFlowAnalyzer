package tool.compiler.java.ast;

import polyglot.ast.LocalDecl;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5ArrayType;
import polyglot.ext.jl5.types.JL5LocalInstance;
import polyglot.main.Report;
import polyglot.types.Type;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.AbstractObject;
import tool.compiler.java.visit.ArrayMetaSetVariable;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.MetaSetVariable;
import tool.compiler.java.visit.XSubseteqY;

/**
 * LocalDecl <: ForInit <: Stmt <: Term <: Node	<br>
 * LocalDecl <: VarDecl <: Term <: Node
 * @author LHJ
 */
public class EquGenLocalDeclExt extends EquGenStmtExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		LocalDecl localDecl = (LocalDecl) this.node();
		Report.report(2, "[Enter] Local Declaration: " + localDecl/*.name()*/);
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		LocalDecl localDecl = (LocalDecl) this.node();
		Report.report(2, "[Leave] Local Declaration: " + localDecl/*.name()*/);
		
		Type localDeclType = localDecl.type().type();
		if(localDeclType instanceof JL5ArrayType) {
			// C[] x = e;
			//   1. x : C[]{Chi1(base, elem)}을 현재 env에 추가 (X1은 새로운 변수)
			ArrayMetaSetVariable cchi1 = new ArrayMetaSetVariable((JL5ArrayType) localDeclType);
			v.getLocalEnv().add((JL5LocalInstance) localDecl.localInstance(), cchi1);
			
			AbstractObject absObj = new AbstractObject(localDecl.type());
			v.addToSet(absObj);
			
			//   2. e가 있는지 확인 후 e의 타입 D{Chi2}를 가져오고 D{Chi2} <: C{Chi1}을 제약식 집합에 추가 
			//      e가 없으면 e의 타입은 C{Chi2} (Chi2는 새로운 변수)를 만들고 C{Chi2} <: C{Chi1}을 제약식 집합에 추가
			ArrayMetaSetVariable dchi2;
			if(localDecl.init() != null) {
				dchi2 = (ArrayMetaSetVariable) EquGenExt.MetaSetVar(localDecl.init());
				
				XSubseteqY xy = new XSubseteqY(dchi2, cchi1);
				v.getCurrMC().addMetaConstraint(xy);
				
				MetaSetVariable cchi1_base = cchi1;
				MetaSetVariable dchi2_base = dchi2;
				do {
					cchi1 = (ArrayMetaSetVariable)cchi1_base;
					dchi2 = (ArrayMetaSetVariable)dchi2_base;
					
					xy = new XSubseteqY(dchi2.length(), cchi1.length());
					v.getCurrMC().addMetaConstraint(xy);
					
					cchi1_base = cchi1.base();
					dchi2_base = dchi2.base();
					xy = new XSubseteqY(dchi2_base, cchi1_base);
					v.getCurrMC().addMetaConstraint(xy);
				} while(cchi1_base instanceof ArrayMetaSetVariable && 
						dchi2_base instanceof ArrayMetaSetVariable);
				// TODO: cchi1_base와 dchi2_base 둘 중 하나만 
				// ArrayMetaSetVariable가 되는 경우가 발생하는가
				
				Report.report(3, "\t[XSubseteqY] " + xy);
			}
			
			//   3. 리턴할 MataSetVar는 없음
			
		} else {
			// C x = e;
			//   1. x : C{Chi1}을 현재 env에 추가 (X1은 새로운 변수)
			MetaSetVariable cchi1 = new MetaSetVariable(localDeclType);
			v.getLocalEnv().add((JL5LocalInstance) localDecl.localInstance(), cchi1);
			
			//   2. e가 있는지 확인 후 e의 타입 D{Chi2}를 가져오고 D{Chi2} <: C{Chi1}을 제약식 집합에 추가 
			//      e가 없으면 e의 타입은 C{Chi2} (Chi2는 새로운 변수)를 만들고 C{Chi2} <: C{Chi1}을 제약식 집합에 추가
			MetaSetVariable dchi2;
			if(localDecl.init() != null) {
				dchi2 = EquGenExt.MetaSetVar(localDecl.init());
				XSubseteqY xy = new XSubseteqY(dchi2, cchi1);
				v.getCurrMC().addMetaConstraint(xy);
				
				Report.report(3, "\t[XSubseteqY] " + xy);
			}
			
			//   3. 리턴할 MataSetVar는 없음
		}
		
		return super.equGenLeave(v);
	}
}