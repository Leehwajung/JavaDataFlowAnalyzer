package tool.compiler.java.ast;

import java.util.HashMap;
import java.util.Map;

import tool.compiler.java.effect.EffectName;
import tool.compiler.java.effect.EffectSetVariable;
import tool.compiler.java.effect.EffectUnion;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.EffectSetVarGoal;
import tool.compiler.java.util.ReportUtil.EffectSetVarSource;

public interface Effectable {
	
	/**
	 * @return the Exception Effect
	 */
	public EffectSetVariable exceptionEffect();
	
	/**
	 * @param exceptionEffect the Exception Effect to set
	 */
	public void setExceptionEffect(EffectSetVariable exceptionEffect);
	
	/**
	 * @param exceptionEffects Exception Effects to set
	 */
	public void setExceptionEffect(Map<EffectSetVariable, EffectSetVarSource> exceptionEffects);
	
	/**
	 * @param type Effect Name
	 * @return the Effect
	 */
	public EffectSetVariable effect(EffectName type);
	
	/**
	 * @return all effects
	 */
	public HashMap<EffectName, EffectSetVariable> effects();
	
	/**
	 * @param effect the Effect to add
	 */
	public void addEffect(EffectSetVariable effect);
	
	/**
	 * @param type	the type of the effect
	 * @param effect	the Effect to add
	 */
	public void addEffect(EffectName type, EffectSetVariable effect);
	
	
	public static class Effectable_c implements Effectable {
		
		private HashMap<EffectName, EffectSetVariable> effects = null;
		
		/**
		 * @see tool.compiler.java.ast.Effectable#exceptionEffect()
		 */
		@Override
		public final EffectSetVariable exceptionEffect() {
			return effect(EffectName.ExnEff);
		}
		
		/**
		 * @see tool.compiler.java.ast.Effectable#setExceptionEffect(tool.compiler.java.effect.EffectSetVariable)
		 */
		@Override
		public final void setExceptionEffect(EffectSetVariable exceptionEffect) {
			try {
				addEffect(EffectName.ExnEff, exceptionEffect);
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("The argument exceptionEffect is not Exception Effect.");
			}
		}
		
		/**
		 * @see tool.compiler.java.ast.Effectable#setExceptionEffect(java.util.Map)
		 */
		@Override
		public final void setExceptionEffect(final Map<EffectSetVariable, EffectSetVarSource> exceptionEffects) {
			try {
				if (!exceptionEffects.isEmpty()) {		// 아래의 ExnEffect가 null이 아님이 보장됨.
					EffectSetVarSource src_ExnEffect;
					if (exceptionEffects.size() > 1) {	// 새로운 EffectUnion이 생성되는 것이 보장됨.
						src_ExnEffect = EffectSetVarSource.New;
						ReportUtil.report(exceptionEffects, EffectSetVarGoal.Flow);
					} else {										// exceptionEffects의 size가 1임이 보장됨.
						src_ExnEffect = (EffectSetVarSource) exceptionEffects.values().toArray()[0];
					}
					final EffectSetVariable ExnEffect = EffectUnion.unionize(exceptionEffects.keySet());
					setExceptionEffect(ExnEffect);
					ReportUtil.report(ExnEffect, src_ExnEffect, EffectSetVarGoal.Return);
				}
			} catch (NullPointerException e) {
				// x_effs가 null인 경우는 무시
			}
		}
		
		/**
		 * @see tool.compiler.java.ast.Effectable#effect(tool.compiler.java.effect.EffectName)
		 */
		@Override
		public final EffectSetVariable effect(EffectName type) {
			try {
				return effects.get(type);
			} catch(NullPointerException e) {
				return null;
			}
		}
		
		/**
		 * @see tool.compiler.java.ast.Effectable#effects()
		 */
		@Override
		public final HashMap<EffectName, EffectSetVariable> effects() {
			try {
				return effects;
			} catch(NullPointerException e) {
				return null;
			}
		}
		
		/**
		 * @see tool.compiler.java.ast.Effectable#addEffect(tool.compiler.java.effect.EffectSetVariable)
		 */
		@Override
		public final void addEffect(EffectSetVariable effect) {
			if (effect != null) {
				if(effects == null) {
					effects = new HashMap<>();
				}
				effects.put(effect.getEffectType(), effect);
			}
		}
		
		/**
		 * @see tool.compiler.java.ast.Effectable#addEffect(tool.compiler.java.effect.EffectName, tool.compiler.java.effect.EffectSetVariable)
		 */
		@Override
		public final void addEffect(EffectName type, EffectSetVariable effect) {
			if (effect != null) {
				if (effect.getEffectType().equals(type)) {
					addEffect(effect);
				} else {
					throw new IllegalArgumentException("Argumented type and effect's type are NOT matched.");
				}
			} else if (effects != null && effects.containsKey(type)) {
				effects.remove(type);
			}
		}
	}
}