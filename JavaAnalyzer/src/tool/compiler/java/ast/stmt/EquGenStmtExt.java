package tool.compiler.java.ast.stmt;

import java.util.HashMap;
import java.util.Map;

import polyglot.ast.Stmt;
import polyglot.ast.Node;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.ast.Effectable;
import tool.compiler.java.ast.EquGenExt;
import tool.compiler.java.effect.EffectName;
import tool.compiler.java.effect.EffectSetVariable;
import tool.compiler.java.env.LocalEnvironment;
import tool.compiler.java.util.ReportUtil.EffectSetVarSource;
import tool.compiler.java.visit.EquGenerator;

/**
 * Stmt <: Term <: Node
 * @author LHJ
 */
public class EquGenStmtExt extends EquGenExt implements Effectable {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Statement";
	
	private LocalEnvironment localEnv = null;
	private Effectable_c effectable = new Effectable_c();
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
//		ReportUtil.enterReport(this);
//		Stmt stmt = (Stmt) this.node();
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
//		ReportUtil.leaveReport(this);
//		Stmt stmt = (Stmt) this.node();
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
	
	
	/**
	 * @return the LocalEnvironment
	 */
	public final LocalEnvironment localEnv() {
		return localEnv;
	}
	
	/**
	 * @param n node
	 * @return the LocalEnvironment of node n
	 */
	public static final LocalEnvironment localEnv(Stmt n) {
		return ((EquGenStmtExt) EquGenExt.ext(n)).localEnv();
	}
	
	/**
	 * @param localEnv the LocalEnvironment to set
	 */
	protected final void setLocalEnv(LocalEnvironment localEnv) {
		this.localEnv = localEnv;
	}
	
	/**
	 * @see tool.compiler.java.ast.Effectable#exceptionEffect()
	 * @see tool.compiler.java.ast.Effectable.Effectable_c#exceptionEffect()
	 */
	@Override
	public EffectSetVariable exceptionEffect() {
		return effectable.exceptionEffect();
	}
	
	/**
	 * @param n node
	 * @return the Exception Effect of node n
	 */
	public static final EffectSetVariable exceptionEffect(Stmt n) {
		return ((EquGenStmtExt) EquGenExt.ext(n)).exceptionEffect();
	}
	
	/**
	 * @param exceptionEffect the Exception Effect to set
	 * @see tool.compiler.java.ast.Effectable.Effectable_c#setExceptionEffect(EffectSetVariable)
	 */
	protected void setExceptionEffect(EffectSetVariable exceptionEffect) {
		effectable.setExceptionEffect(exceptionEffect);
	}
	
	/**
	 * @param exceptionEffects Exception Effects to set
	 * @see tool.compiler.java.ast.Effectable.Effectable_c#setExceptionEffect(Map)
	 */
	protected void setExceptionEffect(Map<EffectSetVariable, EffectSetVarSource> exceptionEffects) {
		effectable.setExceptionEffect(exceptionEffects);
	}
	
	/**
	 * @see tool.compiler.java.ast.Effectable#effect(EffectName)
	 * @see tool.compiler.java.ast.Effectable.Effectable_c#effect(EffectName)
	 */
	@Override
	public EffectSetVariable effect(EffectName type) {
		return effectable.effect(type);
	}
	
	/**
	 * @see tool.compiler.java.ast.Effectable#effects()
	 * @see tool.compiler.java.ast.Effectable.Effectable_c#effects()
	 */
	@Override
	public HashMap<EffectName, EffectSetVariable> effects() {
		return effectable.effects();
	}
	
	/**
	 * @param n node
	 * @param type Effect Name
	 * @return the Effect of node n
	 */
	public static final EffectSetVariable effect(Stmt n, EffectName type) {
		return ((EquGenStmtExt) EquGenExt.ext(n)).effect(type);
	}
	
	/**
	 * @param n node
	 * @return Effects of node n
	 */
	public static final HashMap<EffectName, EffectSetVariable> effects(Stmt n) {
		return ((EquGenStmtExt) EquGenExt.ext(n)).effects();
	}
	
	/**
	 * @param effect the Effect to add
	 * @see tool.compiler.java.ast.Effectable.Effectable_c#addEffect(EffectSetVariable)
	 */
	protected void addEffect(EffectSetVariable effect) {
		effectable.addEffect(effect);
	}
	
	/**
	 * @param type the type of the effect
	 * @param effect the Effect to add
	 * @see tool.compiler.java.ast.Effectable.Effectable_c#addEffect(EffectName, EffectSetVariable)
	 */
	protected void addEffect(EffectName type, EffectSetVariable effect) {
		effectable.addEffect(type, effect);
	}
}