package tool.compiler.java.ast.stmt;

import polyglot.ast.ConstructorCall;
import polyglot.ast.Expr;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5ProcedureInstance;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.ast.expr.EquGenExprExt;
import tool.compiler.java.effect.EffectSetVariable;
import tool.compiler.java.info.MethodCallInfo;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.EffectSetVarGoal;
import tool.compiler.java.util.ReportUtil.EffectSetVarSource;
import tool.compiler.java.visit.EquGenerator;

/**
 * ConstructorCall <: Stmt <: Term <: Node	<br>
 * ConstructorCall <: ProcedureCall <: Term <: Node
 * @author LHJ
 */
public class EquGenConstructorCallExt extends EquGenStmtExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Constructor Call";
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ReportUtil.enterReport(this);
		ConstructorCall ctorCall = (ConstructorCall) this.node();
		JL5ProcedureInstance porcIns = (JL5ProcedureInstance) ctorCall.procedureInstance();
		
		// (호출) 메서드 인포 생성
		MethodCallInfo mtdInfo = new MethodCallInfo(porcIns);
		v.addToSet(mtdInfo);
		ReportUtil.report(mtdInfo);
		
//		ArrayList<TypedSetVariable> argSetVars = new ArrayList<>();
//		for(Expr arg: cc.arguments()) {
//			argSetVars.add(typedSetVar(arg));
//		}
//		
//		JL5MethodInstance ins = (JL5MethodInstance) cc.methodInstance();
//		v.addToSet(new InvokeMth(typedSetVar(), ins, argSetVars, new TypedSetVariable(call.type())));
		
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		ReportUtil.leaveReport(this);
		ConstructorCall ctorCall = (ConstructorCall) this.node();
//		JL5ConstructorInstance ctorIns = (JL5ConstructorInstance) ctorCall.constructorInstance();
		
		// this(); / super();
		//   expr를 분석하면 나오는 exn effect인 exnEffect를 가져와 이를 리턴한다.
		final Expr qualifier = ctorCall.qualifier();
		if (qualifier != null) {
			final EffectSetVariable exnEffect = EquGenExprExt.exceptionEffect(qualifier);
			if (exnEffect != null) {
				setExceptionEffect(exnEffect);
				ReportUtil.report(exnEffect, EffectSetVarSource.SubExpression, EffectSetVarGoal.Return);
			} 
		}
		setLocalEnv(v.peekTypeEnv().getCurrEnv());
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
}