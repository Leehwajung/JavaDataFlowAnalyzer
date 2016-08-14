package tool.compiler.java.ast.stmt;

import polyglot.ast.Labeled;
import polyglot.ast.Node;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.effect.EffectSetVariable;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.EffectSetVarGoal;
import tool.compiler.java.util.ReportUtil.EffectSetVarSource;
import tool.compiler.java.visit.EquGenerator;

/**
 * Labeled <: CompoundStmt <: Stmt <: Term <: Node
 * @author LHJ
 */
public class EquGenLabeledExt extends EquGenStmtExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Labeled";
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ReportUtil.enterReport(this);
//		Labeled labeled = (Labeled) this.node();
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		ReportUtil.leaveReport(this);
		Labeled labeled = (Labeled) this.node();
		
		// name: stmt
		//   stmt를 분석하면 나오는 exn effect인 exnEffect를 가져와 이를 리턴한다.
		final EffectSetVariable exnEffect = EquGenStmtExt.exceptionEffect(labeled.statement());
		if (exnEffect != null) {
			setExceptionEffect(exnEffect);
			ReportUtil.report(exnEffect, EffectSetVarSource.SubStatement, EffectSetVarGoal.Return);
		}
		
		setLocalEnv(v.peekTypeEnv().getCurrEnv());
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
}