package tool.compiler.java.ast;

import polyglot.ast.New;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5ConstructorInstance;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.AbstractObjectInfo;
import tool.compiler.java.visit.EquGenerator;

/**
 * New <: Expr <: Term <: Node
 * New <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenNewExt extends EquGenExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		New nw = (New) this.node();
		Report.report(0, "New: " + nw);
		
		AbstractObjectInfo aa = new AbstractObjectInfo((JL5ConstructorInstance) nw.constructorInstance());
		v.addToSet(aa);
		System.out.println(aa);
		
		
//		System.out.println("dddddddddd   " + ((JL5ProcedureInstance)nw.procedureInstance()).typeParams());
//		((JL5ProcedureInstance)nw.procedureInstance()).typeParams();
		
		
//		System.out.println(nw.precedence());
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGen(EquGenerator v) {
		return super.equGen(v);
	}
}