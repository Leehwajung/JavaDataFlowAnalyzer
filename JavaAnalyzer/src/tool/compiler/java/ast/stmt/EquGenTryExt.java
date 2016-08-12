package tool.compiler.java.ast.stmt;

import java.util.ArrayList;

import polyglot.ast.Catch;
import polyglot.ast.Node;
import polyglot.ast.Try;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.effect.EffectDifference;
import tool.compiler.java.effect.EffectSet;
import tool.compiler.java.effect.EffectSetVariable;
import tool.compiler.java.util.EquGenUtil;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.EffectSetVarGoal;
import tool.compiler.java.util.ReportUtil.EffectSetVarSource;
import tool.compiler.java.visit.EquGenerator;

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
		
		// try ( stmt_res0, ... , stmt_resm ) { stmt0 } catch (C1 e1) { stmt1 } ... catch (Ck ek) { stmtk } finally { stmtn } 	(단, k = n-1)
		//   1. stmt_res0, ... , stmt_resm를 분석해서 나오는 effects의 집합 X_eff_res을 가져오고,
		ArrayList<EffectSetVariable> x_eff_try = new ArrayList<>();
		EffectSetVariable x_eff_res = resources();
		if (x_eff_res != null) {
			x_eff_try.add(x_eff_res);
			ReportUtil.report(x_eff_res, EffectSetVarSource.SubStatement, EffectSetVarGoal.Flow);
		}
		
		//   2. stmt0을 분석하면 나오는 effect인 X_eff0를 가져오고, 
		EffectSetVariable x_eff0 = EquGenStmtExt.exceptionEffect(tryStmt.tryBlock());
		if (x_eff0 != null) {
			x_eff_try.add(x_eff0);
			ReportUtil.report(x_eff0, EffectSetVarSource.SubStatement, EffectSetVarGoal.Flow);
		}
			
		//   3. catch되는 타입들 C1, ... , Ck을 가져와 그들의 합집합인 X_C를 만든 다음,
		ArrayList<EffectSet> cks = new ArrayList<>();
		EffectSet ck = null;
		for (Catch catchBlock : tryStmt.catchBlocks()) {
			ck = EquGenCatchExt.formalTypes(catchBlock);
			cks.add(ck);
			ReportUtil.report(ck, EffectSetVarSource.SubStatement, EffectSetVarGoal.Flow);
		}
		EffectSetVariable x_c = EquGenUtil.unionize(cks);
		if (x_c != ck) {
			ReportUtil.report(x_c, EffectSetVarSource.New, EffectSetVarGoal.Flow);
		}
			
		//   4. X_eff_res ∪ X_eff0 ∖ X_C를 구한다.
		ArrayList<EffectSetVariable> x_effs = new ArrayList<>();
		if (ck != null) {
			EffectSetVariable ExnEffect = new EffectDifference(EquGenUtil.unionize(x_eff_try), x_c);
			x_effs.add(ExnEffect);
			ReportUtil.report(ExnEffect, EffectSetVarSource.New, EffectSetVarGoal.Flow);
		}
		
		//   5. stmt1, ... , stmtk를 분석하면 나오는 effect들인 X_eff1, ... , X_effk를 각각 가져오고, 
		for (Catch catchBlock : tryStmt.catchBlocks()) {
			EffectSetVariable x_effi = EquGenStmtExt.exceptionEffect(catchBlock.body());
			if (x_effi != null) {
				x_effs.add(x_effi);
				ReportUtil.report(x_effi, EffectSetVarSource.SubStatement, EffectSetVarGoal.Flow);
			}
		}
		
		//   6. stmtn을 분석하면 나오는 effect인 X_effn를 가져온 다음,
		EffectSetVariable x_effn = EquGenStmtExt.exceptionEffect(tryStmt.finallyBlock());
		if (x_effn != null) {
			x_effs.add(x_effn);
			ReportUtil.report(x_effn, EffectSetVarSource.SubStatement, EffectSetVarGoal.Flow);
		}
		
		//   7. 최종적으로 X_eff_res ∪ X_eff0 ∖ X_C ∪ X_eff1 ∪ ... ∪ X_effk ∪ X_effn을 구하고, 이를 리턴한다.
		if (!x_effs.isEmpty()) {
			EffectSetVariable ExnEffect = EquGenUtil.unionize(x_effs);
			if (ExnEffect != null) {
				setExceptionEffect(ExnEffect);
				ReportUtil.report(ExnEffect, EffectSetVarSource.New, EffectSetVarGoal.Return);
			} 
		}
		
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
	public EffectSetVariable resources() {
		// For EquGenTryWithResourcesExt
		return null;
	}
}