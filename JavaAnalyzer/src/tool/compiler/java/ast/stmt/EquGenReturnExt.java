package tool.compiler.java.ast.stmt;

import java.util.ArrayList;

import polyglot.ast.Expr;
import polyglot.ast.Node;
import polyglot.ast.Return;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.aos.ArrayMetaSetVariable;
import tool.compiler.java.aos.MetaSetVariable;
import tool.compiler.java.ast.expr.EquGenExprExt;
import tool.compiler.java.constraint.XSubseteqY;
import tool.compiler.java.effect.EffectSetVariable;
import tool.compiler.java.env.MethodConstraint;
import tool.compiler.java.util.EquGenUtil;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.EffectSetVarGoal;
import tool.compiler.java.util.ReportUtil.EffectSetVarSource;
import tool.compiler.java.util.ReportUtil.MetaSetVarGoal;
import tool.compiler.java.util.ReportUtil.MetaSetVarSource;
import tool.compiler.java.visit.EquGenerator;

/**
 * Return <: Stmt <: Term <: Node
 * @author LHJ
 */
public class EquGenReturnExt extends EquGenStmtExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Return";
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ReportUtil.enterReport(this);
//		Return returnStmt = (Return) this.node();
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		ReportUtil.leaveReport(this);
		Return returnStmt = (Return) this.node();
		
		// return expr;
		final Expr expr = returnStmt.expr();
		if (expr != null) {
			//   1. 메서드의 리턴 타입 T1{Chi1}을 가져온 다음,
			MetaSetVariable t1chi1 = ((MethodConstraint) v.getCurrMC()).getReturn();
			ReportUtil.report(t1chi1, MetaSetVarSource.MethodEnvironment, MetaSetVarGoal.Flow);
			
			//   2. e의 타입 T2{Chi2}를 가져온다.
			MetaSetVariable t2chi2 = EquGenExprExt.metaSetVar(expr);
			ReportUtil.report(t2chi2, MetaSetVarSource.SubExpression, MetaSetVarGoal.Flow);
			
			//   3-1. T2{Chi2} <: T1{Chi1} 제약식을 추가
			XSubseteqY xy = new XSubseteqY(t2chi2, t1chi1);
			v.getCurrCF().addMetaConstraint(xy);
			ReportUtil.report(xy);
			
			//   3-2. 배열인 경우, T2{Chi2} <: T1{Chi1}의 하위 레벨 제약식을 추가
			//         (Top Level 아래의 MetaSetVariable(s)의 데이터 플로우)
			if (EquGenUtil.isArray(t1chi1) && EquGenUtil.isArray(t2chi2)) {
				ArrayList<XSubseteqY> xys = XSubseteqY.constrain(
						(ArrayMetaSetVariable) t2chi2, 
						(ArrayMetaSetVariable) t1chi1);
				v.getCurrMC().addMetaConstraints(xys);
			}
			
			//   4. 리턴할 MataSetVar는 없음
			
			// TODO: 아래의 1번과 2번 중에 알맞은 것을 선택해야 함.
			// 1번
			//   5. expr를 분석하면 나오는 exn effect인 exnEffect를 가져와 이를 리턴한다.
			final EffectSetVariable exnEffect = EquGenExprExt.exceptionEffect(expr);
			if (exnEffect != null) {
				setExceptionEffect(exnEffect);
				ReportUtil.report(exnEffect, EffectSetVarSource.SubExpression, EffectSetVarGoal.Return);
			} 
			
			// 2번
//			//   5-1. e를 분석하면 나오는 exn effect인 X_eff2를 가져오고,
//			final EffectSetVariable x_eff2 = EquGenExprExt.exceptionEffect(e);
//			if (x_eff2 != null) {
//				setExceptionEffect(x_eff2);	// 이 노드의 Exn Effect는 X_eff2이다.
//				ReportUtil.report(x_eff2, EffectSetVarSource.SubExpression, EffectSetVarGoal.Flow);
//				
//				//   5-2. 메서드의 exn effect인 X_eff1을 가져온 다음,
//				final EffectVariable x_eff1 = ((MethodConstraint) v.getCurrMC()).getExceptionEffect();
//				ReportUtil.report(x_eff1, EffectSetVarSource.MethodEnvironment, EffectSetVarGoal.Flow);
//				
//				//   TODO:5-3. X_eff2 <: X_eff1 제약식을 추가
//				
//				// TODO: return 문이 생략된 메서드에 대해서도 대응 필요
//			}
		}
		
		setLocalEnv(v.peekTypeEnv().getCurrEnv());
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
}