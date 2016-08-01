package tool.compiler.java.ast;

import polyglot.ast.Initializer;
import polyglot.ast.Node;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.env.InitializerConstraint;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.visit.EquGenerator;

/**
 * Initializer <: CodeDecl <: ClassMember <: Term <: Node			<br>
 * Initializer <: CodeDecl <: CodeBlock <: CodeNode <: Term <: Node
 */
public class EquGenInitializerExt extends EquGenClassMemberExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Initializer";
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ReportUtil.enterReport(this);
		Initializer init = (Initializer)this.node();
		
		// InitializerConstraint
		InitializerConstraint mc = new InitializerConstraint(init.initializerInstance());
		v.addToSet(mc);
		ReportUtil.report(mc);
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		ReportUtil.leaveReport(this);
//		Initializer init = (Initializer)this.node();
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
}