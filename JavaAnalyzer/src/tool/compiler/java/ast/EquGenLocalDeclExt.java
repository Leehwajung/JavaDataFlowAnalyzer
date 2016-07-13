package tool.compiler.java.ast;

import polyglot.ast.LocalDecl;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5LocalInstance;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
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
		
		// C x = e;
		//   1. x : C{Chi1}을 현재 env에 추가 (X1은 새로운 변수)
		MetaSetVariable cchi1 = new MetaSetVariable(localDecl.type().type());
		v.getLocalEnv().add((JL5LocalInstance) localDecl.localInstance(), cchi1);
		
		//   2. e가 있는지 확인 후 e의 타입 D{Chi2}를 가져오고 D{Chi2} <: C{Chi1}을 제약식 집합에 추가 
		//      e가 없으면 e의 타입은 C{Chi2} (Chi2는 새로운 변수)를 만들고 C{Chi2}<: C{Chi1}을 제약식 집합에 추가
		MetaSetVariable dchi2;
		if(localDecl.init() != null) {
			dchi2 = EquGenExt.MetaSetVar(localDecl.init());
		} else {
			dchi2 = new MetaSetVariable(localDecl.type().type());
		}
		
		XSubseteqY xy = new XSubseteqY(dchi2, cchi1);
		v.getCurrMC().addMetaConstraint(xy);
		
		//   3. 리턴할 MataSetVar는 없음
		
		Report.report(3, "\t[XSubseteqY] " + xy);
		return super.equGenLeave(v);
	}
}