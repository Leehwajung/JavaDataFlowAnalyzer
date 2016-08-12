package tool.compiler.java.ast.stmt;

import polyglot.ast.LocalDecl;
import polyglot.ast.Node;
import polyglot.ext.jl7.ast.TryWithResources;
import polyglot.util.Pair;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.effect.EffectSetVariable;
import tool.compiler.java.effect.EffectUnion;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.EffectSetVarGoal;
import tool.compiler.java.util.ReportUtil.EffectSetVarSource;
import tool.compiler.java.visit.EquGenerator;

import java.util.ArrayList;

/**
 * TryWithResources <: Try <: CompoundStmt <: Stmt <: Term <: Node
 * @author LHJ
 */
public class EquGenTryWithResourcesExt extends EquGenTryExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Try with Resources";
	
	private EffectSetVariable resourcesExnEffect = null;
	private EffectSetVarSource srcResourcesExnEffect = null;
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		EquGenerator superEnter = super.equGenEnter(v);
//		TryWithResources tryRes = (TryWithResources) this.node();
		
		// 로컬 환경 구성 (Resources를 위해)
		v.peekTypeEnv().push();
		
		return superEnter;
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		TryWithResources tryRes = (TryWithResources) super.equGenLeave(v);
		
		// 로컬 환경 해제
		v.peekTypeEnv().pop();	// super에서 설정(setLocalEnv())했던 LocalEnv임
		
		return tryRes;
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
	
	
	/**
	 * @return the Resources
	 */
	@Override
	protected final Pair<EffectSetVariable, EffectSetVarSource> findResources() {
		if (resourcesExnEffect == null || srcResourcesExnEffect == null) {
			TryWithResources tryRes = (TryWithResources) this.node();
			ArrayList<EffectSetVariable> resEffects = new ArrayList<>();
			for (LocalDecl resource : tryRes.resources()) {
				EffectSetVariable x_stmt_resj = EquGenStmtExt.exceptionEffect(resource);
				if (x_stmt_resj != null) {
					resEffects.add(x_stmt_resj);
				}
			}
			if (resEffects.size() > 1) {
				srcResourcesExnEffect = EffectSetVarSource.New;
				ReportUtil.report(resEffects, EffectSetVarSource.SubStatement, EffectSetVarGoal.Flow);
			} else {
				srcResourcesExnEffect = EffectSetVarSource.SubStatement;
			}
			resourcesExnEffect = EffectUnion.unionize(resEffects);
		}
		return new Pair<EffectSetVariable, EffectSetVarSource>(resourcesExnEffect, srcResourcesExnEffect);
	}
}