package tool.compiler.java.ast.stmt;

import java.util.LinkedHashMap;

import polyglot.ast.Node;
import polyglot.ast.Synchronized;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.ast.expr.EquGenExprExt;
import tool.compiler.java.effect.EffectSetVariable;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.EffectSetVarSource;
import tool.compiler.java.visit.EquGenerator;

/**
 * Synchronized <: CompoundStmt <: Stmt <: Term <: Node
 * @author LHJ
 */
public class EquGenSynchronizedExt extends EquGenStmtExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Synchronized";
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ReportUtil.enterReport(this);
//		Synchronized synchronizedStmt = (Synchronized) this.node();
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		ReportUtil.leaveReport(this);
		Synchronized synchronizedStmt = (Synchronized) this.node();
		
		// synchronized  ( expr ) { stmt }
		final LinkedHashMap<EffectSetVariable, EffectSetVarSource> x_effs = new LinkedHashMap<>();
		
		//   1. expr을 분석하면 나오는 exn effect인 X_eff0를 가져오고, 
		final EffectSetVariable x_eff0 = EquGenExprExt.exceptionEffect(synchronizedStmt.expr());
		if (x_eff0 != null) {
			x_effs.put(x_eff0, EffectSetVarSource.SubExpression);
		}
		
		//   2. stmt를 분석하면 나오는 exn effect인 X_eff1를 가져와, 
		final EffectSetVariable x_eff1 = EquGenStmtExt.exceptionEffect(synchronizedStmt.body());
		if (x_eff1 != null) {
			x_effs.put(x_eff1, EffectSetVarSource.SubStatement);
		}
		
		//   3. X_eff0 ∪ X_eff1를 구하고, 이를 리턴할 exn effect로 지정.
		setExceptionEffect(x_effs);
		
		setLocalEnv(v.peekTypeEnv().getCurrEnv());
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
}