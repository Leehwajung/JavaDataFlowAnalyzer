package tool.compiler.java.constraint;

import java.util.ArrayList;
import java.util.List;

import polyglot.ext.jl5.types.JL5ClassType;
import tool.compiler.java.aos.AbsObjSet;
import tool.compiler.java.aos.SetVariable;
import tool.compiler.java.aos.TypedSetVariable;

/**
 * Target(X) <: Y<br>
 * for android activity effect
 */
public class ReadTarget implements Constraint {
	
	// fields
	
	private JL5ClassType target;	// Target (NOT null)
	private SetVariable x;			// X (NOT null)
	private SetVariable y;			// Y (NOT null)
	
	
	// constructor
	
	/**
	 * @param x
	 * @param y
	 * @param z
	 */
	protected ReadTarget(JL5ClassType target, SetVariable x, SetVariable y) {
		super();
		this.target = target;
		this.x = x;
		this.y = y;
	}
	
	
	// substitution methods
	
	/**
	 * Substitute TypedSetVariable for AbsObjSet<br>
	 * Target(X) <: Y
	 * @param x	set X
	 * @param y	set Y
	 * @return	Substituted New Constraint
	 */
	public ReadTarget substitute(TypedSetVariable x, TypedSetVariable y) {
		if(!this.x.equalsForType(x)) {
			throw new IllegalArgumentException("The Type Mismatch for x. "
					+ "(orig: " + this.x.getType() + ", subst: " + x.getType() + ")");
		}
		
		if(!this.y.equalsForType(y)) {
			throw new IllegalArgumentException("The Type Mismatch for y. "
					+ "(orig: " + this.y.getType() + ", subst: " + y.getType() + ")");
		}
		
		return new ReadTarget(this.target, x, y);
	}
	
	/**
	 * Substitute TypedSetVariable for AbsObjSet<br>
	 * Target(X) <: Y
	 * @param xy	X and Y	(The size is 2)
	 * @return		Substituted New Constraint
	 */
	@Override
	public Constraint substitute(List<TypedSetVariable> xy) {
		if(xy.size() != substitutableSize()) {
			throw new IllegalArgumentException("The Size of tsvs must be " + substitutableSize() + ". "
					+ "(Current size is " + xy.size() + ".)");
		}
		Object[] xyzArr = xy.toArray();
		return substitute((TypedSetVariable)xyzArr[0], (TypedSetVariable)xyzArr[1]);
	}
	
	
	// getter methods
	
	/**
	 * @return the target
	 */
	public JL5ClassType getTarget() {
		return target;
	}
	
	/**
	 * @return the x
	 */
	public SetVariable getX() {
		return x;
	}
	
	/**
	 * @return the y
	 */
	public SetVariable getY() {
		return y;
	}
	
	
	/**
	 * @see tool.compiler.java.constraint.Constraint#absObjSetSize()
	 */
	@Override
	public int absObjSetSize() {
		return 2;
	}
	
	/**
	 * @see tool.compiler.java.constraint.Constraint#substitutableSize()
	 */
	@Override
	public int substitutableSize() {
		return 2;
	}
	
	/**
	 * @see tool.compiler.java.constraint.Constraint#getAllAbsObjSets()
	 */
	@Override
	public List<? extends AbsObjSet> getAllAbsObjSets() {
		ArrayList<SetVariable> abss = new ArrayList<>();
		abss.add(x);
		abss.add(y);
		return abss;
	}
	
	/**
	 * @see tool.compiler.java.constraint.Constraint#contains(tool.compiler.java.aos.AbsObjSet)
	 */
	@Override
	public boolean contains(AbsObjSet aos) {
		if (x.equals(aos)) {
			return true;
		}
		if (y.equals(aos)) {
			return true;
		}
		return false;
	}
	
	/**
	 * @see tool.compiler.java.constraint.Constraint#getKind()
	 */
	@Override
	public String getKind() {
		return this.getClass().getSimpleName();
	}
	
	/**
	 * Form:	Target(C{X}) <: D{Y}
	 */
	@Override
	public String toString() {
		return getTarget() + "(" + getX() + ") <: " + getY();
//		return "Target(" + getX() + ") <: " + getY() + " [" + getTarget() + "]";
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((target == null) ? 0 : target.hashCode());
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
		ReadTarget other = (ReadTarget) obj;
		if (target == null) {
			if (other.target != null) {
				return false;
			}
		} else if (!target.equals(other.target)) {
			return false;
		}
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