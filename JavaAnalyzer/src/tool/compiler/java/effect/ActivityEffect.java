package tool.compiler.java.effect;

import polyglot.ext.jl5.types.JL5ClassType;
import polyglot.ext.jl5.types.JL5MethodInstance;
import polyglot.types.ReferenceType;
import polyglot.types.Type;

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
	
	public static boolean checkCreatable(JL5MethodInstance mthIns) {
		String mthName = mthIns.name();
		if (mthName.equals("startActivity") || mthName.equals("startActivities")) {
			if (!mthIns.flags().isStatic()) {
				Type superType = mthIns.container();
				ReferenceType type;
				do {
					type = (ReferenceType) superType;
					if (type.toString().equals("android.content.Context")) {
						return true;
					}
					superType = type.superType();
				} while (superType instanceof ReferenceType && superType != null);
			} 
		}
		return false;
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
