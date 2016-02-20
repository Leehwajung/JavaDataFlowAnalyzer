package tool.compiler.java.visit;

import polyglot.ast.Node;
import polyglot.ast.NodeFactory;
import polyglot.frontend.Job;
import polyglot.main.Report;
import polyglot.types.SemanticException;
import polyglot.types.TypeSystem;
import polyglot.visit.ContextVisitor;
import polyglot.visit.NodeVisitor;
import tool.compiler.java.ast.EquGenLang;

public class EquGenerator extends ContextVisitor {

	public EquGenerator(Job job, TypeSystem ts, NodeFactory nf) {
		super(job, ts, nf);
	}
	
	@Override
	public EquGenLang lang() {
		return (EquGenLang) super.lang();
	}

	@Override
	public NodeVisitor begin() {
		Report.report(1, "EquGenerator: begin()");
		NodeVisitor nv = super.begin();
		return nv;
	}

	@Override
	public void finish() {
		Report.report(1, "EquGenerator: finish()");
		super.finish();
	}

//	@Override
//	protected NodeVisitor enterCall(Node parent, Node n)
//			throws SemanticException {
//
////		reportPackage(n);
//		
//		return super.enterCall(parent, n);
//	}

	@Override
	protected NodeVisitor enterCall(Node n) throws SemanticException {

		return lang().equGenEnter(n, this);
	}

//	@Override
//	protected Node leaveCall(Node parent, Node old, Node n, NodeVisitor v)
//			throws SemanticException {
//
//		return super.leaveCall(parent, old, n, v);
//	}

	@Override
	protected Node leaveCall(Node old, Node n, NodeVisitor v)
			throws SemanticException {

		return lang().equGen(n,  this);
	}

//	@Override
//	protected Node leaveCall(Node n) throws SemanticException {
//
//		return super.leaveCall(n);
//	}

	@Override
	public TypeSystem typeSystem() {
		return super.typeSystem();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
}
