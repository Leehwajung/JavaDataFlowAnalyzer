package tool.compiler.java.ast;

import polyglot.ast.Instanceof;
import polyglot.ast.Node;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.TypedSetVariable;

/**
 * Instanceof <: Expr <: Term <: Node				<br>
 * Instanceof <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenInstanceofExt extends EquGenExprExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		Instanceof insof = (Instanceof) this.node();
		Report.report(0, "Instanceof: " + insof);
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGen(EquGenerator v) {
		return super.equGen(v);
	}
	
	@Override
	protected TypedSetVariable setVarImpl() {
		return super.setVarImpl();
	}
}