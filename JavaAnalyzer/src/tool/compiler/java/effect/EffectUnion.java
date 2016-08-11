package tool.compiler.java.effect;

import java.util.ArrayList;
import java.util.List;

/**
 * X ∪ Y <: Z		(Z is this)
 */
public class EffectUnion extends EffectSetVariable {
	
	// fields
	
	private EffectSetVariable x, y;	// X, Y (NOT null)
	
	
	// constructor
	
	/**
	 * @param x
	 * @param y
	 */
	public EffectUnion(EffectSetVariable x, EffectSetVariable y) {
		super(check(x, y));
		this.x = x;
		this.y = y;
	}
	
	private static EffectName check(EffectSetVariable x, EffectSetVariable y) {
		if (x.getEffectType().equals(y.getEffectType())){
			return x.getEffectType();
		} else {
			throw new IllegalArgumentException("Effect Type NOT match.");
		}
	}
	
	// getter methods
	
	/**
	 * @return the x
	 */
	public EffectSetVariable getX() {
		return x;
	}
	
	/**
	 * @return the y
	 */
	public EffectSetVariable getY() {
		return y;
	}
	
	
	public List<? extends EffectSetVariable> getAllEffectSetVariables() {
		ArrayList<EffectSetVariable> abss = new ArrayList<>();
		abss.add(x);
		abss.add(y);
		return abss;
	}
	
	public boolean contains(EffectSetVariable esv) {
		if (x.equals(esv)) {
			return true;
		}
		if (y.equals(esv)) {
			return true;
		}
		return false;
	}
	
	/**
	 * @see tool.compiler.java.constraint.Constraint#getKind()
	 */
	public String getKind() {
		return this.getClass().getSimpleName();
	}
	
	/**
	 * Form:	Effect{X} ∪ Effect{Y} <: Effect{Z}	(Z is this)
	 */
	@Override
	public String toString() {
		return getX() + " ∪ " + getY() + " <: " + super.toString();
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		EffectUnion other = (EffectUnion) obj;
		if (x == null) {
			if (other.x != null) {
				return false;
			}
		} else if (!x.equals(other.x)) {
			return false;
		}
		if (y == null) {
			if (other.y != null) {
				return false;
			}
		} else if (!y.equals(other.y)) {
			return false;
		}
		return true;
	}
}