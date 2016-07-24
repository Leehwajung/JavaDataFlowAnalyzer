package tool.compiler.java.ast;

import polyglot.ast.Node;
import polyglot.ast.ProcedureCall;
import polyglot.ext.jl5.types.JL5ProcedureInstance;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.MethodCallInfo;

/**
 * ProcedureCall <: Term <: Node
 * @author LHJ
 */
@Deprecated
public class EquGenProcedureCallExt extends EquGenExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Procedure Call";
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ReportUtil.enterReport(this);
		ProcedureCall pc = (ProcedureCall) this.node();
		
		// (호출) 메서드 인포 생성
		MethodCallInfo mtdInfo = new MethodCallInfo((JL5ProcedureInstance) pc.procedureInstance());
		v.addToSet(mtdInfo);
		ReportUtil.report(mtdInfo);
//		Report.report(3, "Procedure Call (" + this.getClass().getSimpleName() + "): " + pc + ": " + mtdInfo);
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		ReportUtil.leaveReport(this);
//		ProcedureCall pc = (ProcedureCall) this.node();
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
}