package tool.compiler.java.ast;

import polyglot.ast.Call;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5MethodInstance;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.GenericMethodInfo;
import tool.compiler.java.visit.MethodInfo;

/**
 * Call <: Expr <: Term <: Node
 * Call <: Expr <: Receiver <: Prefix <: Node
 * Call <: ProcedureCall <: Term <: Node
 * @author LHJ
 */
public class EquGenCallExt extends EquGenExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		Call call = (Call)this.node();
//		Report.report(0, "Call: " + call/*.name()*/);
		JL5MethodInstance methIns = (JL5MethodInstance) call.methodInstance();
		
		// 메서드 인포 생성 (일반)
		MethodInfo mtdInfo = null;
		if(MethodInfo.isGenericMethod(methIns)) {	// 제네릭 메서드인 경우
			mtdInfo = new GenericMethodInfo(methIns);
		} else {														// 일반 메서드인 경우
			mtdInfo = new MethodInfo(methIns);
		}
		
		Report.report(0, "Call: " + call/*.name()*/ + ": " + mtdInfo);
		v.addToCallSet(mtdInfo);
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGen(EquGenerator v) {
		return super.equGen(v);
	}
}