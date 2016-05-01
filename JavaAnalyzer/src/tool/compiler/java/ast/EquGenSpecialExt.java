package tool.compiler.java.ast;

import polyglot.ast.Node;
import polyglot.ast.Special;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;

/**
 * Special <: Expr <: Term <: Node					<br>
 * Special <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenSpecialExt extends EquGenExprExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		Special spc = (Special) this.node();
		Report.report(0, "Special: " + spc);
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		return super.equGenLeave(v);
	}
}