package tool.compiler.java.ast.stmt;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import polyglot.ast.For;
import polyglot.ast.ForInit;
import polyglot.ast.ForUpdate;
import polyglot.ast.Node;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.ast.expr.EquGenExprExt;
import tool.compiler.java.effect.EffectSetVariable;
import tool.compiler.java.effect.EffectUnion;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.EffectSetVarSource;
import tool.compiler.java.visit.EquGenerator;

/**
 * For <: Loop <: CompoundStmt <: Stmt <: Term <: Node
 * @author LHJ
 */
public class EquGenForExt extends EquGenStmtExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "For";
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ReportUtil.enterReport(this);
//		For forLoop = (For) this.node();
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		ReportUtil.leaveReport(this);
		For forLoop = (For) this.node();
		
		// for ( stmt_i1, ... , stmt_in ; expr ; stmt_u1, ... , stmt_uk ) { stmt }
		final LinkedHashMap<EffectSetVariable, EffectSetVarSource> x_effs = new LinkedHashMap<>();
		
		//   1. stmt_i1, ... , stmt_in를 분석해서 나오는 exn effects의 집합 X_eff0을 만들고,
		final ArrayList<EffectSetVariable> x_eff_inits = new ArrayList<>();
		for (ForInit init : forLoop.inits()) {
			final EffectSetVariable x_eff_initi = EquGenStmtExt.exceptionEffect(init);
			if (x_eff_initi != null) {
				x_eff_inits.add(x_eff_initi);
			}
		}
		final EffectSetVariable x_eff0 = EffectUnion.unionize(x_eff_inits);
		if (x_eff_inits.size() > 1) {	// 새로운 합집합이 생성되면
			x_effs.put(x_eff0, EffectSetVarSource.New);
		} else {
			x_effs.put(x_eff0, EffectSetVarSource.SubStatement);
		}
		
		//   2. expr을 분석하면 나오는 exn effect인 X_eff1를 가져오고, 
		final EffectSetVariable x_eff1 = EquGenExprExt.exceptionEffect(forLoop.cond());
		if (x_eff1 != null) {
			x_effs.put(x_eff1, EffectSetVarSource.SubExpression);
		}
		
		//   3. stmt_u1, ... , stmt_uk를 분석해서 나오는 exn effects의 집합 X_eff2을 만들고,
		final ArrayList<EffectSetVariable> x_eff_upds = new ArrayList<>();
		for (ForUpdate update : forLoop.iters()) {
			final EffectSetVariable x_eff_updi = EquGenStmtExt.exceptionEffect(update);
			if (x_eff_updi != null) {
				x_eff_upds.add(x_eff_updi);
			}
		}
		final EffectSetVariable x_eff2 = EffectUnion.unionize(x_eff_upds);
		if (x_eff_upds.size() > 1) {	// 새로운 합집합이 생성되면
			x_effs.put(x_eff2, EffectSetVarSource.New);
		} else {
			x_effs.put(x_eff2, EffectSetVarSource.SubStatement);
		}
		
		//   4. stmt를 분석하면 나오는 exn effect인 X_eff3를 가져와, 
		final EffectSetVariable x_eff3 = EquGenStmtExt.exceptionEffect(forLoop.body());
		if (x_eff3 != null) {
			x_effs.put(x_eff3, EffectSetVarSource.SubStatement);
		}
		
		//   5. X_eff0 ∪ X_eff1 ∪ X_eff2 ∪ X_eff3를 구하고, 이를 리턴할 exn effect로 지정.
		setExceptionEffect(x_effs);
		
		// TODO: environment의 합집합을 구하는 동작이 필요 없음?
		setLocalEnv(v.peekTypeEnv().getCurrEnv());
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
}