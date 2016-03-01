package tool.compiler.java.ast;

import polyglot.ast.Ext;
import polyglot.ast.Ext_c;
import polyglot.ast.Node;
import polyglot.ext.jl5.ast.JL5ProcedureCallExt;
import polyglot.util.InternalCompilerError;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;

public class EquGenExt extends Ext_c implements EquGenOps {  // TODO: Not JL7Ext, but Ext_c to override lang()!!!
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public static EquGenExt ext(Node n) {
		Ext e = n.ext();
		while ( e != null && !(e instanceof EquGenExt) ) {
			e = e.ext();
		}
		if ( e == null ) {
			throw new InternalCompilerError("No EquGen extension object for node"
					+ n + " (" + n.getClass() + ")", n.position());
		}
		
		return (EquGenExt)e;
	}
		
	@Override  // TODO: Must extend Ext_c, not JL7Ext!!!
	public final EquGenLang lang() {
		return EquGenLang_c.instance;
	}
	
	// TODO:  Override operation methods for overridden AST operations.
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		// By default, return the given visitor.
		try{
//			JL5ProcedureCallExt ext = (JL5ProcedureCallExt)JL5ProcedureCallExt.ext(node());
//			System.out.println("&&&&&0" + node().getClass());
//			System.out.println("&&&&&1" + ext.getClass());
//		System.out.println("&&&&&2" + ext.typeArgs());
		
		}catch (ClassCastException e) {
			
		}
		
		return v;
	}

	@Override
	public Node equGen(EquGenerator v) {
		// By default, do nothing.
//		try{
//			JL5ProcedureCallExt ext = (JL5ProcedureCallExt)JL5ProcedureCallExt.ext(node());
//			System.out.println("&&&&&1" + ext.getClass());
//		System.out.println("&&&&&2" + ext.typeArgs());
//		
//		}catch (ClassCastException e) {
//			
//		}
		return node();
	}
}