package tool.compiler.java.effect;

import java.util.LinkedHashSet;

import polyglot.ext.jl5.types.JL5ClassType;

/**
 * Android Activity Effect
 */
@Deprecated
public class ActivityEffect implements Effect {
	
	private LinkedHashSet<JL5ClassType> activities;
	
	public ActivityEffect() {
		activities = new LinkedHashSet<>();
	}
	
	@Override
	public EffectName getEffectType() {
		return EffectName.ActivityEff;
	}
}
