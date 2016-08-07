package tool.compiler.java.ast.expr;

import java.util.HashMap;

import polyglot.ast.Expr;
import polyglot.ast.Node;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.aos.MetaSetVariable;
import tool.compiler.java.ast.EquGenExt;
import tool.compiler.java.effect.EffectName;
import tool.compiler.java.visit.EquGenerator;

/**
 * Expr <: Term <: Node					<br>
 * Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenExprExt extends EquGenExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Expression";
	
	private MetaSetVariable metaSetVar = null;
	private HashMap<EffectName, MetaSetVariable> effects = null;
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
//		ReportUtil.enterReport(this);
//		Expr expr = (Expr)this.node();
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
//		ReportUtil.leaveReport(this);
//		Expr expr = (Expr)this.node();
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
	
	
	/**
	 * @return the MetaSetVariable
	 */
	public final MetaSetVariable metaSetVar() {
		return metaSetVar;
	}
	
	/**
	 * @param n node
	 * @return the MetaSetVariable of node n
	 */
	public static final MetaSetVariable metaSetVar(Expr n) {
		return ((EquGenExprExt)EquGenExt.ext(n)).metaSetVar();
	}
	
	/**
	 * @param metaSetVar the MetaSetVariable to set
	 */
	protected final void setMetaSetVar(MetaSetVariable metaSetVar) {
		this.metaSetVar = metaSetVar;
	}
	
	/**
	 * @return the Effect
	 */
	public final MetaSetVariable effect(EffectName type) {
		try {
			return effects.get(type);
		} catch(NullPointerException e) {
			return null;
		}
	}
	
	public final HashMap<EffectName, MetaSetVariable> effects() {
		try {
			return new HashMap<>(effects);
		} catch(NullPointerException e) {
			return null;
		}
	}
	
	/**
	 * @param n node
	 * @param type Effect Name
	 * @return the Effect of node n
	 */
	public static final MetaSetVariable effect(Expr n, EffectName type) {
		return ((EquGenExprExt) EquGenExt.ext(n)).effect(type);
	}
	
	/**
	 * @param n node 
	 * @return Effects of node n
	 */
	public static final HashMap<EffectName, MetaSetVariable> effects(Expr n) {
		return ((EquGenExprExt) EquGenExt.ext(n)).effects();
	}
	
	/**
	 * @param effect the Effect to set
	 */
	protected final void setEffect(EffectName type, MetaSetVariable effect) {
		if(effects == null) {
			effects = new HashMap<>();
		}
		effects.put(type, effect);
	}
}