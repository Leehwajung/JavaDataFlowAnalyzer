package tool.compiler.java.effect;

import polyglot.ext.jl5.types.JL5ClassType;

/**
 * Android Activity Effect
 */
public class ActivityEffect implements EffectElem {
	
	private JL5ClassType activity;
	
	public ActivityEffect(JL5ClassType activity) {
		this.activity = activity;
	}
	
	@Override
	public EffectName getEffectType() {
		return EffectName.ActivityEff;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		try {
			return activity.name();
		} catch(NullPointerException e) {
			return null;
		}
	}
}
