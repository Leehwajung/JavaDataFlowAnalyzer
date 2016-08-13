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
		// TODO: Resources는 try block에서만 접근 가능하므로, 아래와 같이
		// Try Node의 탈출부에서 로컬 환경을 해제하는 것은 좋지 못한 것으로 판단된다. 
		// 따라서, try block의 탈출부에서 환경을 해제하는 방법을 강구해야한다.
		// 다만, 이미 컴파일러에서 catch/finally block가 Resources에 접근하는 것을 막으므로,
		// Resources에 대한 MetaSetVariable에 접근하는 경우가 없음이 보장된다.
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
		// try ( stmt_res0; ... ; stmt_resm ) { stmt0 } catch (C1 e1) { stmt1 } ... catch (Ck ek) { stmtk } finally { stmtn } 	(단, k = n-1)
		//   stmt_res0, ... , stmt_resm를 분석해서 나오는 exn effects의 집합 X_eff_res을 만든다.
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