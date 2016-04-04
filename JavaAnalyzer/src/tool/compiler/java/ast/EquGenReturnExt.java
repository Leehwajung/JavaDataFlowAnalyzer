package tool.compiler.java.ast;

import polyglot.ast.Node;
import polyglot.ast.Return;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;

/**
 * Return <: Stmt <: Term <: Node
 * @author LHJ
 */
public class EquGenReturnExt extends EquGenExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		Return rtn = (Return)this.node();
		Report.report(0, "Return: " + rtn/*.name()*/);
		
		System.out.println("Return:  " + rtn.expr());
		
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGen(EquGenerator v) {
		return super.equGen(v);
	}
}
