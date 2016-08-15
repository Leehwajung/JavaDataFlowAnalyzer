package tool.compiler.java.ast.stmt;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import polyglot.ast.Node;
import polyglot.ast.Switch;
import polyglot.ast.SwitchElement;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.ast.expr.EquGenExprExt;
import tool.compiler.java.effect.EffectSetVariable;
import tool.compiler.java.effect.EffectUnion;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.EffectSetVarSource;
import tool.compiler.java.visit.EquGenerator;

/**
 * Switch <: CompoundStmt <: Stmt <: Term <: Node
 * @author LHJ
 */
public class EquGenSwitchExt extends EquGenStmtExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Switch";
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ReportUtil.enterReport(this);
//		Switch switchStmt = (Switch) this.node();
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		ReportUtil.leaveReport(this);
		Switch switchStmt = (Switch) this.node();
		
		// switch ( expr ) { stmt1 ... stmtn }
		final LinkedHashMap<EffectSetVariable, EffectSetVarSource> x_effs = new LinkedHashMap<>();
		
		//   1. expr을 분석하면 나오는 exn effect인 X_eff0를 가져오고, 
		final EffectSetVariable x_eff0 = EquGenExprExt.exceptionEffect(switchStmt.expr());
		if (x_eff0 != null) {
			x_effs.put(x_eff0, EffectSetVarSource.SubExpression);
		}
		
		//   2. stmt1, ... , stmtn를 분석해서 나오는 exn effects의 집합 X_eff1을 만들고,
		final ArrayList<EffectSetVariable> x_eff_elems = new ArrayList<>();
		for (SwitchElement elem : switchStmt.elements()) {
			final EffectSetVariable x_eff_elemi = EquGenStmtExt.exceptionEffect(elem);
			if (x_eff_elemi != null) {
				x_eff_elems.add(x_eff_elemi);
			}
		}
		final EffectSetVariable x_eff1 = EffectUnion.unionize(x_eff_elems);
		if (x_eff_elems.size() > 1) {	// 새로운 합집합이 생성되면
			x_effs.put(x_eff1, EffectSetVarSource.New);
		} else {
			x_effs.put(x_eff1, EffectSetVarSource.SubStatement);
		}
		
		//   3. X_eff0 ∪ X_eff1를 구하고, 이를 리턴할 exn effect로 지정.
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