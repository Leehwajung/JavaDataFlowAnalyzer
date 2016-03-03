package tool.compiler.java.ast;

import polyglot.ast.Call;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5MethodInstance;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.GenericMethodInfo;

/**
 * Call <: Expr <: Term <: Node
 * Call <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenCallExt extends EquGenExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		Call call = (Call)this.node();
		JL5MethodInstance procIns = (JL5MethodInstance) call.methodInstance();
		
		if(procIns != procIns.orig()) {	// 제네릭 메서드인 경우 (타입 파라메터 전달)
			GenericMethodInfo mtdInfo = new GenericMethodInfo(procIns);
			v.addToList(mtdInfo);
			Report.report(0, "Call: " + call/*.name()*/ + ": " + mtdInfo);
		} else {
			Report.report(0, "Call: " + call/*.name()*/);
		}
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGen(EquGenerator v) {
		return super.equGen(v);
	}
}