package tool.compiler.java.ast;

import polyglot.ast.Formal;
import polyglot.ast.Node;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.MetaSetVariable;

/**
 * Formal <: VarDecl <: Term <: Node
 * @author LHJ
 */
public class EquGenFormalExt extends EquGenExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		Formal fm = (Formal) this.node();
		Report.report(0, "[Enter] Formal: " + fm);
		
		v.getCurrentMethodConstraint().addChiFormal(new MetaSetVariable(fm.type().type()));
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		Formal fm = (Formal) this.node();
		Report.report(0, "[Leave] Formal: " + fm);
		
		return super.equGenLeave(v);
	}
}