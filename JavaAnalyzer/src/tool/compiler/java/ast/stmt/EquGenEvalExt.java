package tool.compiler.java.ast.stmt;

import polyglot.ast.Eval;
import polyglot.ast.Node;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.ast.expr.EquGenExprExt;
import tool.compiler.java.effect.EffectSetVariable;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.EffectSetVarGoal;
import tool.compiler.java.util.ReportUtil.EffectSetVarSource;
import tool.compiler.java.visit.EquGenerator;

/**
 * Eval <: Stmt <: Term <: Node
 * @author LHJ
 */
public class EquGenEvalExt extends EquGenStmtExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Evaluation";
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ReportUtil.enterReport(this);
//		Eval eval = (Eval) this.node();
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		ReportUtil.leaveReport(this);
		Eval eval = (Eval) this.node();
		
		// expr;
		//   expr를 분석하면 나오는 exn effect인 exnEffect를 가져와 이를 리턴한다.
		final EffectSetVariable exnEffect = EquGenExprExt.exceptionEffect(eval.expr());
		if (exnEffect != null) {
			setExceptionEffect(exnEffect);
			ReportUtil.report(exnEffect, EffectSetVarSource.SubExpression, EffectSetVarGoal.Return);
		}
		
		setLocalEnv(v.peekTypeEnv().getCurrEnv());
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
}