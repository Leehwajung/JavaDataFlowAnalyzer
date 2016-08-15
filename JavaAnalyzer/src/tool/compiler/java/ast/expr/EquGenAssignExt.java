package tool.compiler.java.ast.expr;

import java.util.LinkedHashMap;

import polyglot.ast.Assign;
import polyglot.ast.Node;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.effect.EffectSetVariable;
import tool.compiler.java.util.ReportUtil.EffectSetVarSource;
import tool.compiler.java.visit.EquGenerator;

/**
 * Assign <: Expr <: Term <: Node				<br>
 * Assign <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenAssignExt extends EquGenExprExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Assign";
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
//		Assign asgn = (Assign) this.node();
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		Assign asgn = (Assign) this.node();
		
		// e1 = e2 / e1 op= e2
		final LinkedHashMap<EffectSetVariable, EffectSetVarSource> x_effs = new LinkedHashMap<>();
		
		//   4. e1을 분석하면 나오는 exn effect인 X_eff1를 가져오고, 
		final EffectSetVariable x_eff1 = EquGenExprExt.exceptionEffect(asgn.left());
		if (x_eff1 != null) {
			x_effs.put(x_eff1, EffectSetVarSource.SubExpression);
		}
		
		//   5. e2를 분석하면 나오는 exn effect인 X_eff2를 가져와, 
		final EffectSetVariable x_eff2 = EquGenExprExt.exceptionEffect(asgn.right());
		if (x_eff2 != null) {
			x_effs.put(x_eff2, EffectSetVarSource.SubExpression);
		}
		
		//   6. X_eff1 ∪ X_eff2를 구하고, 이를 리턴할 exn effect로 지정
		setExceptionEffect(x_effs);
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
}