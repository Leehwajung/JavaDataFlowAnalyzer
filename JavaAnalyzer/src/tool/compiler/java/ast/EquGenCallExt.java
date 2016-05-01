package tool.compiler.java.ast;

import java.util.ArrayList;

import polyglot.ast.Call;
import polyglot.ast.Expr;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5ProcedureInstance;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.InvokeMth;
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
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		Call call = (Call) this.node();
//		Report.report(0, "Call: " + call/*.name()*/);
		
		// e.m(e1, ..., en)
		//   1. e의 타입 C{X0}를 가져오고
		TypedSetVariable cx0 = EquGenExt.typedSetVar(call.target());
		
		//   2. e1~en의 타입 Ci{Xi}를 가져온 다음
		ArrayList<TypedSetVariable> argSetVars = new ArrayList<>();
		for(Expr arg: call.arguments()) {
			argSetVars.add(EquGenExt.typedSetVar(arg));
		}
		
		//   3. 리턴할 타입 D{X}를 만든다. (X는 새로 만들고 D는 이 노드 자신의 타입)
		TypedSetVariable dx = new TypedSetVariable(call.type());
		
		//   4. C{X0}.m <: (C1{X1}, ... , Cn{Xn}) -> D{X} 제약식을 추가
		InvokeMth im = new InvokeMth(cx0, (JL5ProcedureInstance) call.methodInstance(), 
				argSetVars, dx);
		v.addToSet(im);
		
		//   5. D{X}를 리턴 타입으로 지정
		setTypedSetVar(dx);
		
		
//		ArrayList<TypedSetVariable> argSetVars = new ArrayList<>();
//		for(Expr arg: call.arguments()) {
//			argSetVars.add(typedSetVar(arg));
//		}
//		
//		JL5MethodInstance ins = (JL5MethodInstance) call.methodInstance();
//		if(ins.flags().isStatic()) {
//			v.addToSet(new InvokeStaticMth(ins, argSetVars, new TypedSetVariable(call.type())));
//		} else {
//			v.addToSet(new InvokeMth(typedSetVar(), ins, argSetVars, new TypedSetVariable(call.type())));
//		}
		
		return super.equGenLeave(v);
	}
}