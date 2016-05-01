package tool.compiler.java.ast;

import polyglot.ast.Expr;
import polyglot.ast.Field;
import polyglot.ast.FieldAssign;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5FieldInstance;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.AssignField;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.TypedSetVariable;

/**
 * FieldAssign <: Assign <: Expr <: Term <: Node				<br>
 * FieldAssign <: Assign <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenFieldAssignExt extends EquGenAssignExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		
		FieldAssign fasgn = (FieldAssign) this.node();
		Expr rVal = fasgn.right();
		Field lVal = fasgn.left();
		JL5FieldInstance lValIns = (JL5FieldInstance) fasgn.left().fieldInstance();
		
		Report.report(0, "Field Assign: " + fasgn);
		
		// e1.f = e2
		//   1. e1의 타입 C{X1}을 가져오고
		TypedSetVariable cx1 = EquGenExt.typedSetVar(lVal);
		
		//   2. e2의 타입 D{X2}를 가져오고
		TypedSetVariable dx2 = EquGenExt.typedSetVar(rVal);
		
		//   3. D{X2} <: C{X1}.f 제약식을 추가
		AssignField af = new AssignField(dx2, cx1, lValIns);
		v.addToSet(af);
		
		//   4. e1.f의 타입 C{X1}을 리턴할 타입으로 지정
		setTypedSetVar(cx1);
		
//		if(lValIns.flags().isStatic()) {
////			v.addToSet(new AssignStaticField(rValType, lValIns));
//			v.addToSet(new AssignStaticField(typedSetVar(rVal), lValIns));
//		} else {
////			v.addToSet(new AssignField(rValType, lValIns));
//			v.addToSet(new AssignField(typedSetVar(rVal), typedSetVar(lVal), lValIns));
//		}
		
		return super.equGenLeave(v);
	}
}