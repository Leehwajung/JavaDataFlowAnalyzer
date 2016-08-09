package tool.compiler.java.effect;

import tool.compiler.java.aos.MetaSetVariable;

public class EffectVariable extends EffectSetVariable {
	
	private MetaSetVariable chi_effect;
	
	/**
	 * @param type
	 */
	public EffectVariable(EffectName type) {
		super(type);
	}
	
	/**
	 * @param type
	 * @param chi_effect
	 */
	public EffectVariable(EffectName type, MetaSetVariable chi_effect) {
		super(type);
		this.chi_effect = chi_effect;
	}
	
	/**
	 * @return the chi_effect
	 */
	public MetaSetVariable getMetaSetVar() {
		return chi_effect;
	}
}