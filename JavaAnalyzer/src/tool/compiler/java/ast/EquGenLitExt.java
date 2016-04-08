package tool.compiler.java.ast;

import polyglot.ast.Lit;
import polyglot.ast.Node;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;

/**
 * Lit <: Expr <: Term <: Node					<br>
 * Lit <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenLitExt extends EquGenExprExt {
	private static final long serialVersionUID = SerialVersionUID.generate();

	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		Lit lit = (Lit) this.node();
		Report.report(0, "Lit: " + lit);
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGen(EquGenerator v) {
		return super.equGen(v);
	}
}