package tool.compiler.java.ast;

import java.util.ArrayList;

import polyglot.ast.Call;
import polyglot.ast.Expr;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5FieldInstance;
import polyglot.ext.jl5.types.JL5MethodInstance;
import polyglot.ext.jl5.types.JL5ProcedureInstance;
import polyglot.main.Report;
import polyglot.types.Type;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.InvokeMth;
import tool.compiler.java.visit.InvokeStaticMth;
import tool.compiler.java.visit.MethodCallInfo;
import tool.compiler.java.visit.TypedSetVariable;

/**
 * Call <: Expr <: Term <: Node					<br>
 * Call <: Expr <: Receiver <: Prefix <: Node	<br>
 * Call <: ProcedureCall <: Term <: Node
 * @author LHJ
 */
public class EquGenCallExt extends EquGenExprExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		Call call = (Call) this.node();
//		Report.report(0, "Call: " + call/*.name()*/);
		
		// (호출) 메서드 인포 생성
		MethodCallInfo mtdInfo = new MethodCallInfo((JL5ProcedureInstance) call.procedureInstance());
		v.addToSet(mtdInfo);
		Report.report(0, "Call: " + call + ": " + mtdInfo);
		
//		System.out.print("args:   ");
//		for(Expr aa: call.arguments()) {
//			System.out.print(aa.type()+", ");
//		}
//		
//		System.out.println();
//		
//		System.out.println("formal types: " + call.methodInstance().formalTypes());
//		call.arguments()
//		call.type();
		
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGen(EquGenerator v) {
		Call call = (Call) this.node();
//		Report.report(0, "Call: " + call/*.name()*/);
		
		ArrayList<TypedSetVariable> argSetVars = new ArrayList<>();
		for(Expr arg: call.arguments()) {
			argSetVars.add(setVar(arg));
		}
		
		JL5MethodInstance ins = (JL5MethodInstance) call.methodInstance();
		if(ins.flags().isStatic()) {
			v.addToSet(new InvokeStaticMth(ins, argSetVars, new TypedSetVariable(call.type())));
		} else {
			v.addToSet(new InvokeMth(setVar(), ins, argSetVars, new TypedSetVariable(call.type())));
		}
		
		return super.equGen(v);
	}
	
	@Override
	protected TypedSetVariable setVarImpl() {
		Call call = (Call) this.node();
		return new TypedSetVariable(call.methodInstance().container());
	}
}