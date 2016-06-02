package tool.compiler.java.ast;

import polyglot.ast.ClassDecl;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5ClassType;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.ClassConstraint;
import tool.compiler.java.visit.EquGenerator;

/**
 * ClassDecl <: ClassMember <: Term <: Node	<br>
 * ClassDecl <: CodeNode <: Term <: Node
 */
public class EquGenClassDeclExt extends EquGenExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	private ClassConstraint cc;
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ClassDecl clzDecl = (ClassDecl)this.node();
		Report.report(0, "[Enter] Class Declaration: " + clzDecl/*.name()*/);
		
		cc = new ClassConstraint((JL5ClassType) clzDecl.type());
		v.addToSet(cc);
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		ClassDecl clzDecl = (ClassDecl)this.node();
		Report.report(0, "[Leave] Class Declaration: " + clzDecl/*.name()*/);
		
		return super.equGenLeave(v);
	}	
}