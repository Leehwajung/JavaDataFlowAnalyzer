package tool.compiler.java.ast.stmt;

import polyglot.ast.Catch;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5ClassType;
import polyglot.types.Type;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.effect.EffectSet;
import tool.compiler.java.effect.ExnEffect;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.EffectSetVarGoal;
import tool.compiler.java.util.ReportUtil.EffectSetVarSource;
import tool.compiler.java.visit.EquGenerator;

/**
 * Catch <: CompoundStmt <: Stmt <: Term <: Node
 * @author LHJ
 */
public class EquGenSingleCatchExt extends EquGenCatchExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Catch";
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ReportUtil.enterReport(this);
//		Catch singleCatch = (Catch) this.node();
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		ReportUtil.leaveReport(this);
		Catch singleCatch = (Catch) this.node();
		
		Type catchType = singleCatch.catchType();
		EffectSet exnEffect = new EffectSet(new ExnEffect((JL5ClassType) catchType));
		setFormalTypes(exnEffect);
		ReportUtil.report(exnEffect, EffectSetVarSource.New, EffectSetVarGoal.Return);
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
}