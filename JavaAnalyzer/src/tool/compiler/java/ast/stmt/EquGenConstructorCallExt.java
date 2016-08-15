package tool.compiler.java.ast.stmt;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import polyglot.ast.ConstructorCall;
import polyglot.ast.Expr;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5ClassType;
import polyglot.ext.jl5.types.JL5ProcedureInstance;
import polyglot.types.Type;
import polyglot.util.SerialVersionUID;
import polyglot.util.SubtypeSet;
import tool.compiler.java.ast.expr.EquGenExprExt;
import tool.compiler.java.effect.EffectSet;
import tool.compiler.java.effect.EffectSetVariable;
import tool.compiler.java.effect.ExnEffect;
import tool.compiler.java.info.MethodCallInfo;
import tool.compiler.java.util.ReportUtil;
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
		
		// this(e1, ..., en); / super(e1, ..., en);
		final LinkedHashMap<EffectSetVariable, EffectSetVarSource> x_effs = new LinkedHashMap<>();
		
		//   1. qualifier를 분석하면 나오는 exn effect인 exn effect인 X_eff0를 가져오고, 
		final Expr qualifier = ctorCall.qualifier();
		if (qualifier != null) {
			final EffectSetVariable x_eff0 = EquGenExprExt.exceptionEffect(qualifier);
			if (x_eff0 != null) {
				x_effs.put(x_eff0, EffectSetVarSource.SubExpression);
			}
		}
		
		//   2. e1, ... , en를 분석해서 나오는 exn effects인 X_eff1, ... , X_effn를 찾은 다음,
		for (Expr arg : ctorCall.arguments()) {
			EffectSetVariable x_effi = EquGenExprExt.exceptionEffect(arg);
			if (x_effi != null) {
				x_effs.put(x_effi, EffectSetVarSource.SubExpression);
			}
		}
		
		//   3. 메서드 내부에서 발생할 수 있는 Exception의 타입들을 가져와 EffectSet X_eff_trw을 만들어,
		//      TODO: 3번 항목이 필요한지, 유효한지 확인 필요
		final SubtypeSet exceptions = ctorCall.exceptions();
		if (exceptions != null) {
			ArrayList<ExnEffect> exns = new ArrayList<>();
			for (Type exn : exceptions) {
				exns.add(new ExnEffect((JL5ClassType) exn));
			}
			if (!exns.isEmpty()) {
				EffectSet x_eff_trw = new EffectSet(exns);
				x_effs.put(x_eff_trw, EffectSetVarSource.MethodCall);
			} 
		}
		
		//   4. X_eff0 ∪ X_eff1 ∪ ... ∪ X_effn ∪ X_eff_trw를 구하고, 이를 리턴할 exn effect로 지정.
		setExceptionEffect(x_effs);
		
		setLocalEnv(v.peekTypeEnv().getCurrEnv());
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
}