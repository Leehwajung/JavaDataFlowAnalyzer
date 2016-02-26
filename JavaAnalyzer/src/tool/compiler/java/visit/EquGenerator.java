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

import java.util.HashSet;
import java.util.LinkedList;

public class EquGenerator extends ContextVisitor {
	
	private static LinkedList<MethodInfo> methodInfoList;
	private static LinkedList<FieldInfo> fieldInfoList;
	private static LinkedList<AbstractObjectInfo> abstractObjectInfoList;
	
	private static LinkedList<MethodTable> methodTableList;
	private static LinkedList<FieldTable> fieldTableList;
	
	static {
		methodInfoList = new LinkedList<>();
		fieldInfoList = new LinkedList<>();
		abstractObjectInfoList = new LinkedList<>();
		
		methodTableList = new LinkedList<>();
		fieldTableList = new LinkedList<>();
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
		
		Report.report(1, CollUtil.getNLStringOf(fieldTableList));
		Report.report(1, CollUtil.getNLStringOf(methodTableList));
		
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
		methodInfoList.add(methodInfo);
	}
	
	public void addToSet(FieldInfo fieldInfo) {
		fieldInfoList.add(fieldInfo);
	}
	
	public void addToSet(AbstractObjectInfo abstractObjectInfoInfo) {
		abstractObjectInfoList.add(abstractObjectInfoInfo);
	}
	
	public void generateTables() {
		for(AbstractObjectInfo absObjInfo: abstractObjectInfoList) {
			for(MethodInfo methodInfo: methodInfoList) {
				if(absObjInfo.getBaseType().equals(methodInfo.getContainerBaseType())) {
					methodTableList.add(new MethodTable(absObjInfo, methodInfo));
				}
			}
			
			for(FieldInfo fieldInfo: fieldInfoList) {
				if(absObjInfo.getBaseType().equals(fieldInfo.getContainerBaseType())) {
					fieldTableList.add(new FieldTable(absObjInfo, fieldInfo));
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