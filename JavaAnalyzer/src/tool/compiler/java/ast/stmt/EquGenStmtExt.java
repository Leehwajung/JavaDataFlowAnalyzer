package tool.compiler.java.ast.stmt;

import java.util.HashMap;

import polyglot.ast.Node;
import polyglot.ast.Stmt;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.ast.EquGenExt;
import tool.compiler.java.effect.EffectName;
import tool.compiler.java.effect.EffectSetVariable;
import tool.compiler.java.env.LocalEnvironment;
import tool.compiler.java.visit.EquGenerator;

/**
 * Stmt <: Term <: Node
 * @author LHJ
 */
public class EquGenStmtExt extends EquGenExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Statement";
	
	private LocalEnvironment localEnv = null;
	private HashMap<EffectName, EffectSetVariable> effects = null;
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
//		ReportUtil.enterReport(this);
//		Stmt stmt = (Stmt)this.node();
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
//		ReportUtil.leaveReport(this);
//		Stmt stmt = (Stmt)this.node();
		
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
		return ((EquGenStmtExt)EquGenExt.ext(n)).localEnv();
	}
	
	/**
	 * @param localEnv the LocalEnvironment to set
	 */
	protected final void setLocalEnv(LocalEnvironment localEnv) {
		this.localEnv = localEnv;
	}
	
	/**
	 * @return the Effect
	 */
	public final EffectSetVariable effect(EffectName type) {
		try {
			return effects.get(type);
		} catch(NullPointerException e) {
			return null;
		}
	}
	
	public final HashMap<EffectName, EffectSetVariable> effects() {
		try {
			return effects;
		} catch(NullPointerException e) {
			return null;
		}
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
	 */
	protected final void setEffect(EffectName type, EffectSetVariable effect) {
		if(effects == null) {
			effects = new HashMap<>();
		}
		effects.put(type, effect);
	}
}