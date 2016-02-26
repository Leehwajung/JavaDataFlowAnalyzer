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
import tool.compiler.java.util.CollUtil;

import java.util.LinkedList;

public class EquGenerator extends ContextVisitor {
	
	private static LinkedList<MethodInfo> methodInfoSet;
	private static LinkedList<FieldInfo> fieldInfoSet;
	private static LinkedList<AbstractObjectInfo> abstractObjectInfoSet;
	
	private static LinkedList<MethodTable> methodTableSet;
	private static LinkedList<FieldTable> fieldTableSet;
	
	static {
		methodInfoSet = new LinkedList<>();
		fieldInfoSet = new LinkedList<>();
		abstractObjectInfoSet = new LinkedList<>();
		
		methodTableSet = new LinkedList<>();
		fieldTableSet = new LinkedList<>();
	}
	
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
		generateTables();
		
		Report.report(1, CollUtil.getNLStringOf(methodTableSet));
		Report.report(1, CollUtil.getNLStringOf(fieldTableSet));
		
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
	
	
	public void addToSet(MethodInfo methodInfo) {
		methodInfoSet.add(methodInfo);
	}
	
	public void addToSet(FieldInfo fieldInfo) {
		fieldInfoSet.add(fieldInfo);
	}
	
	public void addToSet(AbstractObjectInfo abstractObjectInfoInfo) {
		abstractObjectInfoSet.add(abstractObjectInfoInfo);
	}
	
	public void generateTables() {
		for(AbstractObjectInfo absObjInfo: abstractObjectInfoSet) {
			for(MethodInfo methodInfo: methodInfoSet) {
				if(absObjInfo.getBaseType().equals(methodInfo.getContainerBaseType())) {
					methodTableSet.add(new MethodTable(absObjInfo, methodInfo));
				}
			}
			
			for(FieldInfo fieldInfo: fieldInfoSet) {
				if(absObjInfo.getBaseType().equals(fieldInfo.getContainerBaseType())) {
					fieldTableSet.add(new FieldTable(absObjInfo, fieldInfo));
				}
			}
		}
	}
	
	
//	public void addToSet(MethodTable methodTable) {
//		methodTableSet.add(methodTable);
//	}
//	
//	public void addToSet(FieldTable fieldTable) {
//		fieldTableSet.add(fieldTable);
//	}
	
	
}