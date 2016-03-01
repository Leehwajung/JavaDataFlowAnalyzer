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

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

public class EquGenerator extends ContextVisitor {
	
	// TODO: 인포와 테이블을 저장하는 자료구조 정하기
	// 후보1 LinkedList: 중복 발생가능하므로 좋지는 않은 듯.
	// 후보2 HashSet: 이 프로그램 논리 상의 중복이 제거되지 않으므로 대안 필요.
	//						인포와 테이블의 정렬 순서가 중요해 보이지는 않지만, 순서가 섞여 알아보기 힘듦.
	// 후보3 별도의 중복이 제거된 리스트: LinkedList를 확장하여 중복 제거 리스트 클래스를 별도로 만듦.
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
		
		Report.report(1, "\n----- Tables -----");
		Report.report(1, CollUtil.getNLStringOf(fieldTableList));
		Report.report(1, CollUtil.getNLStringOf(methodTableList));
		
		writeTablesToFile();
		
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
	
	/**
	 * 메서드 인포 리스트에 추가
	 * @param methodInfo
	 */
	public void addToList(MethodInfo methodInfo) {
		methodInfoList.add(methodInfo);
	}
	
	/**
	 * 필드 인포 리스트에 추가
	 * @param fieldInfo
	 */
	public void addToList(FieldInfo fieldInfo) {
		fieldInfoList.add(fieldInfo);
	}
	
	/**
	 * 추상 객체 인포 리스트에 추가
	 * @param abstractObjectInfo
	 */
	public void addToList(AbstractObjectInfo abstractObjectInfo) {
		abstractObjectInfoList.add(abstractObjectInfo);
	}
	
	/**
	 * 테이블 생성 및 테이블 리스트에 추가
	 */
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
	
	/**
	 * 테이블을 파일에 출력
	 */
	private void writeTablesToFile() {
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("tables.txt"));
			
			dos.write("----- Tables -----\n\n".getBytes());
			CollUtil.writeFile(dos, fieldTableList);
			CollUtil.writeFile(dos, methodTableList);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}