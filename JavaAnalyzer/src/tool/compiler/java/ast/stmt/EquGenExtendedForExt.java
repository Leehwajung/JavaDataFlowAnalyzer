package tool.compiler.java.ast.stmt;

import java.util.LinkedHashMap;

import polyglot.ast.Node;
import polyglot.ext.jl5.ast.ExtendedFor;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.ast.expr.EquGenExprExt;
import tool.compiler.java.effect.EffectSetVariable;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.EffectSetVarSource;
import tool.compiler.java.visit.EquGenerator;

/**
 * ExtendedFor <: Loop <: CompoundStmt <: Stmt <: Term <: Node
 * @author LHJ
 */
public class EquGenExtendedForExt extends EquGenStmtExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
//	public static final String KIND = "Enhanced For";
	public static final String KIND = "Extended For";
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ReportUtil.enterReport(this);
//		ExtendedFor forLoop = (ExtendedFor) this.node();
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		ReportUtil.leaveReport(this);
		ExtendedFor forLoop = (ExtendedFor) this.node();
		
		// for ( stmt0 : expr ) { stmt1 }
		final LinkedHashMap<EffectSetVariable, EffectSetVarSource> x_effs = new LinkedHashMap<>();
		
		//   1. stmt0을 분석하면 나오는 exn effect인 X_eff0를 가져오고, 
		final EffectSetVariable x_eff0 = EquGenStmtExt.exceptionEffect(forLoop.decl());
		if (x_eff0 != null) {
			x_effs.put(x_eff0, EffectSetVarSource.SubStatement);
		}
		
		//   2. expr을 분석하면 나오는 exn effect인 X_eff1를 가져온 다음, 
		final EffectSetVariable x_eff1 = EquGenExprExt.exceptionEffect(forLoop.expr());
		if (x_eff1 != null) {
			x_effs.put(x_eff1, EffectSetVarSource.SubExpression);
		}
		
		//   3. stmt1을 분석하면 나오는 exn effect인 X_eff2를 가져와, 
		final EffectSetVariable x_eff2 = EquGenStmtExt.exceptionEffect(forLoop.body());
		if (x_eff2 != null) {
			x_effs.put(x_eff2, EffectSetVarSource.SubStatement);
		}
		
		//   4. X_eff0 ∪ X_eff1 ∪ X_eff2를 구하고, 이를 리턴할 exn effect로 지정.
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