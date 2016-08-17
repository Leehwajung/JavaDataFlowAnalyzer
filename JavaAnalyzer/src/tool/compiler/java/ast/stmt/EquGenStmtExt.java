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
	
	@Override
	public void setExceptionEffect(EffectSetVariable exceptionEffect) {
		effectable.setExceptionEffect(exceptionEffect);
	}
	
	@Override
	public void setExceptionEffect(Map<EffectSetVariable, EffectSetVarSource> exceptionEffects) {
		effectable.setExceptionEffect(exceptionEffects);
	}
	
	@Override
	public EffectSetVariable effect(EffectName type) {
		return effectable.effect(type);
	}
	
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
	
	@Override
	public void addEffect(EffectSetVariable effect) {
		effectable.addEffect(effect);
	}
	
	@Override
	public void addEffect(EffectName type, EffectSetVariable effect) {
		effectable.addEffect(type, effect);
	}
}