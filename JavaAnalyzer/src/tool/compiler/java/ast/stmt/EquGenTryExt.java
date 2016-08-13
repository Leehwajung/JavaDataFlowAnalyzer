package tool.compiler.java.ast.stmt;

import polyglot.ast.Catch;
import polyglot.ast.Node;
import polyglot.ast.Try;
import polyglot.util.Pair;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.effect.EffectDifference;
import tool.compiler.java.effect.EffectSet;
import tool.compiler.java.effect.EffectSetVariable;
import tool.compiler.java.effect.EffectUnion;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.EffectSetVarGoal;
import tool.compiler.java.util.ReportUtil.EffectSetVarSource;
import tool.compiler.java.visit.EquGenerator;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Try <: CompoundStmt <: Stmt <: Term <: Node
 * @author LHJ
 */
public class EquGenTryExt extends EquGenStmtExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Try";
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ReportUtil.enterReport(this);
//		Try tryStmt = (Try) this.node();
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		ReportUtil.leaveReport(this);
		Try tryStmt = (Try) this.node();
		
		// 주의! 여기서는 EffectSetVariable이 소모될 때 - 흘러갈 곳을 찾았을 때 - Report함!
		
		// try ( stmt_res0; ... ; stmt_resm ) { stmt0 } catch (C1 e1) { stmt1 } ... catch (Ck ek) { stmtk } finally { stmtn } 	(단, k = n-1)
		final LinkedHashMap<EffectSetVariable, EffectSetVarSource> x_effs = new LinkedHashMap<>();
		
		//   1. stmt_res0, ... , stmt_resm를 분석해서 나오는 exn effects의 집합 X_eff_res을 가져오고,
		final Pair<EffectSetVariable, EffectSetVarSource> resources = findResources();
		final EffectSetVariable x_eff_res = resources.part1();
		
		//   2. stmt0을 분석하면 나오는 exn effect인 X_eff0를 가져온 다음, 
		final EffectSetVariable x_eff0 = EquGenStmtExt.exceptionEffect(tryStmt.tryBlock());
		
		//   3. X_eff_res ∪ X_eff0를 구한다.
		if (x_eff0 != null || x_eff_res != null) {	// X_eff_res와 X_eff0가 둘 다 공집합이면 X_C를 차집합하는 것이 의미 없음
			final EffectSetVariable x_eff_try = EffectUnion.unionize(x_eff_res, x_eff0);
			EffectSetVarSource src_x_eff_try = EffectSetVarSource.SubStatement;
			if (x_eff_try != x_eff0 && x_eff_try != x_eff_res) {	// 새롭게 생성된 합집합이면 (둘 다 null이 아님)
				src_x_eff_try = EffectSetVarSource.New;
				ReportUtil.report(x_eff_res, EffectSetVarSource.New, EffectSetVarGoal.Flow);
				ReportUtil.report(x_eff0, EffectSetVarSource.SubStatement, EffectSetVarGoal.Flow);
			} else if (x_eff_try == x_eff_res) {
				src_x_eff_try = resources.part2();
			}
		
		//   4. catch되는 타입들 C1, ... , Ck을 가져와 그들의 합집합인 X_C를 만들어,
			final ArrayList<EffectSet> cks = new ArrayList<>();
			for (Catch catchBlock : tryStmt.catchBlocks()) {
				final EffectSet ci = EquGenCatchExt.formalTypes(catchBlock);
				cks.add(ci);
			}
			EffectSetVarSource src_x_c = EffectSetVarSource.SubStatement;
			if (cks.size() > 1) {	// 새로운 합집합이 생성될 예정이면
				src_x_c = EffectSetVarSource.New;
				ReportUtil.report(cks, EffectSetVarSource.SubStatement, EffectSetVarGoal.Flow);
			}
			final EffectSetVariable x_c = EffectUnion.unionize(cks);
			
		//   5. X_eff_res ∪ X_eff0 ∖ X_C를 구한다.
			final EffectSetVariable x_eff_try_differed = EffectDifference.differ(x_eff_try, x_c);
			EffectSetVarSource src_x_eff_try_differed = src_x_eff_try;
			if (x_eff_try_differed != x_eff_try) {
				src_x_eff_try_differed = EffectSetVarSource.New;
				ReportUtil.report(x_eff_try, src_x_eff_try, EffectSetVarGoal.Flow);
				ReportUtil.report(x_c, src_x_c, EffectSetVarGoal.Flow);
			}
			if (x_eff_try_differed != null) {
				x_effs.put(x_eff_try_differed, src_x_eff_try_differed);
			}
		}
		
		//   6. stmt1, ... , stmtk를 분석하면 나오는 exn effect들인 X_eff1, ... , X_effk를 각각 가져오고, 
		for (Catch catchBlock : tryStmt.catchBlocks()) {
			final EffectSetVariable x_effi = EquGenStmtExt.exceptionEffect(catchBlock.body());
			if (x_effi != null) {
				x_effs.put(x_effi, EffectSetVarSource.SubStatement);
			}
		}
		
		//   7. stmtn을 분석하면 나오는 exn effect인 X_effn를 가져온 다음,
		EffectSetVariable x_effn = EquGenStmtExt.exceptionEffect(tryStmt.finallyBlock());
		if (x_effn != null) {
			x_effs.put(x_effn, EffectSetVarSource.SubStatement);
		}
		
		//   8. 최종적으로 X_eff_res ∪ X_eff0 ∖ X_C ∪ X_eff1 ∪ ... ∪ X_effk ∪ X_effn을 구하고, 이를 리턴한다.
		setExceptionEffect(x_effs);
		
		setLocalEnv(v.peekTypeEnv().getCurrEnv());
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
	
	
	/**
	 * For EquGenTryWithResourcesExt
	 * @return null
	 */
	protected Pair<EffectSetVariable, EffectSetVarSource> findResources() {
		// For EquGenTryWithResourcesExt
		return null;
	}
}