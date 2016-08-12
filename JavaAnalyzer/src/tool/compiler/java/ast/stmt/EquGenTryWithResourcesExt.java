package tool.compiler.java.ast.stmt;

import java.util.ArrayList;

import polyglot.ast.LocalDecl;
import polyglot.ast.Node;
import polyglot.ext.jl7.ast.TryWithResources;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.ast.EquGenExt;
import tool.compiler.java.effect.EffectSetVariable;
import tool.compiler.java.util.EquGenUtil;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.EffectSetVarGoal;
import tool.compiler.java.util.ReportUtil.EffectSetVarSource;
import tool.compiler.java.visit.EquGenerator;

/**
 * TryWithResources <: Try <: CompoundStmt <: Stmt <: Term <: Node
 * @author LHJ
 */
public class EquGenTryWithResourcesExt extends EquGenTryExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Try with Resources";
	
	private EffectSetVariable resourcesExnEffect = null;
	
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
	public final EffectSetVariable resources() {
		if (resourcesExnEffect != null) {
			return resourcesExnEffect;
		}
		
		TryWithResources tryRes = (TryWithResources) this.node();
		ArrayList<EffectSetVariable> resEffects = new ArrayList<>();
		for (LocalDecl resource : tryRes.resources()) {
			EffectSetVariable resEffect = EquGenStmtExt.exceptionEffect(resource);
			if (resEffect != null) {
				resEffects.add(resEffect);
				ReportUtil.report(resEffect, EffectSetVarSource.SubExpression, EffectSetVarGoal.Flow);
			}
		}
		setResources(EquGenUtil.unionize(resEffects));
		return resourcesExnEffect;
	}
	
	/**
	 * @param n node
	 * @return the Resources of node n
	 */
	public static final EffectSetVariable resources(TryWithResources n) {
		return ((EquGenTryWithResourcesExt) EquGenExt.ext(n)).resources();
	}
	
	/**
	 * @param resources the Resources to set
	 */
	private final void setResources(EffectSetVariable resources) {
		resourcesExnEffect = resources;
	}
}