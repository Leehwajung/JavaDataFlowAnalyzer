package tool.compiler.java.ast;

import polyglot.ast.Expr;
import polyglot.ast.Field;
import polyglot.ast.FieldAssign;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5FieldInstance;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.AssignField;
import tool.compiler.java.visit.AssignStaticField;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.AbsObjSet;

/**
 * FieldAssign <: Assign <: Expr <: Term <: Node				<br>
 * FieldAssign <: Assign <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenFieldAssignExt extends EquGenAssignExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		FieldAssign fasgn = (FieldAssign) this.node();
		Report.report(0, "[Enter] Field Assign: " + fasgn);
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		FieldAssign fasgn = (FieldAssign) this.node();
		Field lVal = fasgn.left();
		Expr rVal = fasgn.right();
		JL5FieldInstance fldIns = (JL5FieldInstance) fasgn.left().fieldInstance();
//		Report.report(0, "[Leave] Field Assign: " + fasgn);
		
		// e1.f = e2 / C.f = e2
		//   1. e2의 타입 D{AOS2}를 가져오고
		AbsObjSet daos2 = EquGenExt.AbsObjSet(rVal);
		
		//   2-1. e1의 타입 C{AOS1}을 가져오고, D{AOS2} <: C{AOS1}.f 제약식을 추가 (non-static)
		if(!fldIns.flags().isStatic()) {
			AbsObjSet caos1 = EquGenExt.AbsObjSet(lVal.target());
			AssignField af = new AssignField(daos2, caos1, fldIns);
			v.addToSet(af);
			Report.report(1, "[Leave] Field Assign: " + fasgn + "\n\t[AssignField] " + af);
		}
		
		//   2-2. D{AOS2} <: C.f 제약식을 추가 (static)
		else {
			AssignStaticField asf = new AssignStaticField(daos2, fldIns);
			v.addToSet(asf);
			Report.report(1, "[Leave] Field Assign: " + fasgn + "\n\t[AssignStaticField] " + asf);
		}
		
		//   4. e1.f의 타입을 리턴할 타입으로 지정
		setAbsObjSet(EquGenExt.AbsObjSet(lVal));
		
		return super.equGenLeave(v);
	}
}