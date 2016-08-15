package tool.compiler.java.ast.expr;

import polyglot.ast.Instanceof;
import polyglot.ast.Node;
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
 * Instanceof <: Expr <: Term <: Node				<br>
 * Instanceof <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenInstanceofExt extends EquGenExprExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Instanceof";
	
	private AbstractObject absObj;
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ReportUtil.enterReport(this);
		Instanceof insof = (Instanceof) this.node();
		
		absObj = new AbstractObject(insof);
		v.addToSet(absObj);
		ReportUtil.report(absObj);
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		ReportUtil.leaveReport(this);
		Instanceof insof = (Instanceof) this.node();
		
		// e instanceof C
		//   1. boolean{Chi} 변수 생성
		MetaSetVariable tchi = MetaSetVariable.create(insof.type());
		ReportUtil.report(tchi, MetaSetVarSource.New, MetaSetVarGoal.Return);
		
		//   2. boolean{o} <: boolean{Chi} 제약식을 추가
		ObjsSubseteqX ox = new ObjsSubseteqX(absObj, tchi);
		v.getCurrCF().addMetaConstraint(ox);
		ReportUtil.report(ox);
		
		//   3. return boolean{Chi}
		setMetaSetVar(tchi);
		
		//   4. e를 분석하면 나오는 exn effect인 exnEffect를 가져와
		final EffectSetVariable exnEffect = EquGenExprExt.exceptionEffect(insof.expr());
		
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