package tool.compiler.java.ast;

import polyglot.ast.ConstructorCall;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5ProcedureInstance;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.MethodCallInfo;

/**
 * ConstructorCall <: Stmt <: Term <: Node	<br>
 * ConstructorCall <: ProcedureCall <: Term <: Node
 * @author LHJ
 */
public class EquGenConstructorCallExt extends EquGenExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ConstructorCall cc = (ConstructorCall) this.node();
		Report.report(0, "Constructor Call: " + cc);
		
		// (호출) 메서드 인포 생성
		MethodCallInfo mtdInfo = new MethodCallInfo((JL5ProcedureInstance) cc.procedureInstance());
		v.addToSet(mtdInfo);
		Report.report(0, "Constructor Call: " + cc + ": " + mtdInfo);
	
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGen(EquGenerator v) {
		return super.equGen(v);
	}
}