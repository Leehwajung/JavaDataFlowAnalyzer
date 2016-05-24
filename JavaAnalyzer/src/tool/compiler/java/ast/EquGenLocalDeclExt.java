package tool.compiler.java.ast;

import polyglot.ast.LocalDecl;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5LocalInstance;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.MetaSetVariable;
import tool.compiler.java.visit.AbsObjSet;
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
		LocalDecl lclDecl = (LocalDecl) this.node();
		Report.report(0, "[Enter] Local Declaration: " + lclDecl/*.name()*/);
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		LocalDecl lclDecl = (LocalDecl) this.node();
//		Report.report(0, "[Leave] Local Declaration: " + lclDecl/*.name()*/);
		
		// C x = e;
		//   1. x : C{AOS1}을 현재 env에 추가 (X1은 새로운 변수)
		MetaSetVariable caos1 = new MetaSetVariable(lclDecl.type().type());
		getLocalEnv().add((JL5LocalInstance) lclDecl.localInstance(), caos1);
		
		//   2. e가 있는지 확인 후 e의 타입 D{AOS2}를 가져오고 D{AOS2} <: C{AOS1}을 제약식 집합에 추가 
		//      e가 없으면 e의 타입은 C{AOS2} (AOS2는 새로운 변수)를 만들고 C{AOS2}<: C{AOS1}을 제약식 집합에 추가
		AbsObjSet daos2;
		if(lclDecl.init() != null) {
			daos2 = EquGenExt.AbsObjSet(lclDecl.init());
		} else {
			daos2 = new MetaSetVariable(lclDecl.type().type());
		}
		
		XSubseteqY xy = new XSubseteqY(daos2, caos1);
		v.addToSet(xy);
		Report.report(0, "[Leave] Local Declaration: " + lclDecl + "\n\t[XSubseteqY] " + xy);
		
		//   3. 리턴할 AbsObjSet은 없음
		
		return super.equGenLeave(v);
	}
}