package tool.compiler.java.ast.stmt;

import polyglot.ast.Catch;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5LocalInstance;
import polyglot.types.Type;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.aos.MetaSetVariable;
import tool.compiler.java.ast.EquGenExt;
import tool.compiler.java.effect.EffectSet;
import tool.compiler.java.effect.EffectSetVariable;
import tool.compiler.java.env.LocalEnvironment;
import tool.compiler.java.env.TypeEnvironment;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.EffectSetVarGoal;
import tool.compiler.java.util.ReportUtil.EffectSetVarSource;
import tool.compiler.java.util.ReportUtil.MetaSetVarGoal;
import tool.compiler.java.util.ReportUtil.MetaSetVarSource;
import tool.compiler.java.visit.EquGenerator;

/**
 * Catch <: CompoundStmt <: Stmt <: Term <: Node
 * @see tool.compiler.java.ast.stmt.EquGenSingleCatchExt
 * @see tool.compiler.java.ast.stmt.EquGenMultiCatchExt
 * @author LHJ
 */
public abstract class EquGenCatchExt extends EquGenStmtExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Catch";
	
	private EffectSet effect_formal = null;
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		Catch catchStmt = (Catch) this.node();
		
		// 로컬 환경 구성 (Formal을 Local Env.에 등록하는 과정 포함)
		TypeEnvironment typeEnv = v.peekTypeEnv();
		typeEnv.push();
		Type catchType = catchStmt.catchType();
		MetaSetVariable chiFormal = MetaSetVariable.create(catchType);
		typeEnv.add((JL5LocalInstance) catchStmt.formal().localInstance(), chiFormal);
		ReportUtil.report(chiFormal, MetaSetVarSource.New, MetaSetVarGoal.LocalEnvironment);
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		Catch catchStmt = (Catch) this.node();
		
		// catch (C e) { stmt }
		//   stmt를 분석하면 나오는 exn effect인 exnEffect를 가져와 이를 리턴한다.
		final EffectSetVariable exnEffect = EquGenStmtExt.exceptionEffect(catchStmt.body());
		if (exnEffect != null) {
			setExceptionEffect(exnEffect);
			ReportUtil.report(exnEffect, EffectSetVarSource.SubExpression, EffectSetVarGoal.Return);
		}
		
		// 로컬 환경 해제
		LocalEnvironment localEnv = v.peekTypeEnv().pop();
		setLocalEnv(localEnv);
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
	
	
	/**
	 * @return the formalTypes
	 */
	public final EffectSet formalTypes() {
		return effect_formal;
	}
	
	/**
	 * @param n node
	 * @return the formalTypes of node n
	 */
	public static final EffectSet formalTypes(Catch n) {
		return ((EquGenCatchExt) EquGenExt.ext(n)).formalTypes();
	}
	
	/**
	 * @param formalTypes the formalTypes to set
	 */
	protected final void setFormalTypes(EffectSet formalTypes) {
		this.effect_formal = formalTypes;
	}
}