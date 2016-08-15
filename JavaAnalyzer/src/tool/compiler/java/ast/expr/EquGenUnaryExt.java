package tool.compiler.java.ast.expr;

import polyglot.ast.Node;
import polyglot.ast.Unary;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.aos.AbstractObject;
import tool.compiler.java.aos.MetaSetVariable;
import tool.compiler.java.constraint.ObjsSubseteqX;
import tool.compiler.java.effect.EffectSetVariable;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.EffectSetVarGoal;
import tool.compiler.java.util.ReportUtil.EffectSetVarSource;
import tool.compiler.java.util.ReportUtil.MetaSetVarGoal;
import tool.compiler.java.util.ReportUtil.MetaSetVarSource;
import tool.compiler.java.visit.EquGenerator;

/**
 * Unary <: Expr <: Term <: Node				<br>
 * Unary <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenUnaryExt extends EquGenExprExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Unary";
	
	private AbstractObject absObj;
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ReportUtil.enterReport(this);
		Unary unary = (Unary) this.node();
		
		absObj = new AbstractObject(unary);
		v.addToSet(absObj);
		ReportUtil.report(absObj);
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		ReportUtil.leaveReport(this);
		Unary unary = (Unary) this.node();
		
		// +e / -e / ++e / --e / e++ / e-- / !e / ~e
		//   1. T{Chi} 변수 생성
		MetaSetVariable tchi = MetaSetVariable.create(unary.type());
		ReportUtil.report(tchi, MetaSetVarSource.New, MetaSetVarGoal.Return);
		
		//   2. T{o} <: T{Chi} 제약식을 추가
		ObjsSubseteqX ox = new ObjsSubseteqX(absObj, tchi);
		v.getCurrCF().addMetaConstraint(ox);
		ReportUtil.report(ox);
		
		//   3. return T{Chi}
		setMetaSetVar(tchi);
		
		//   4. e를 분석하면 나오는 exn effect인 exnEffect를 가져와
		final EffectSetVariable exnEffect = EquGenExprExt.exceptionEffect(unary.expr());
		
		//   5. exnEffect를 리턴할 exn effect로 지정
		if (exnEffect != null) {
			setExceptionEffect(exnEffect);
			ReportUtil.report(exnEffect, EffectSetVarSource.SubExpression, EffectSetVarGoal.Return);
		}
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
}