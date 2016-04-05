package tool.compiler.java.ast;

import polyglot.ast.FieldAssign;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5FieldInstance;
import polyglot.main.Report;
import polyglot.types.Type;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.AssignField;
import tool.compiler.java.visit.AssignStaticField;
import tool.compiler.java.visit.EquGenerator;

/**
 * FieldAssign <: Assign <: Expr <: Term <: Node	<br>
 * FieldAssign <: Assign <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenFieldAssignExt extends EquGenAssignExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		FieldAssign fasgn = (FieldAssign) this.node();
		Type rValType = fasgn.right().type();
		JL5FieldInstance lValIns = (JL5FieldInstance) fasgn.left().fieldInstance();
		
		Report.report(0, "Field Assign: " + fasgn);
		
		if(lValIns.flags().isStatic()) {
			v.addToSet(new AssignStaticField(rValType, lValIns));
		} else {
			v.addToSet(new AssignField(rValType, lValIns));
		}
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGen(EquGenerator v) {
		return super.equGen(v);
	}
}