package tool.compiler.java.ast;

import polyglot.ast.Expr;
import polyglot.ast.Node;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.TypedSetVariable;

/**
 * Expr <: Term <: Node	<br>
 * Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenExprExt extends EquGenExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		Expr expr = (Expr)this.node();
		Report.report(0, "Expression: " + expr);
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGen(EquGenerator v) {
		Expr expr = (Expr)this.node();
//		v.addToSet(new TypedSetVariable(expr.type()));
		return super.equGen(v);
	}
}