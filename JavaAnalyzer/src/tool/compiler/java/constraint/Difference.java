package tool.compiler.java.constraint;

import java.util.ArrayList;
import java.util.List;

import tool.compiler.java.aos.AbsObjSet;
import tool.compiler.java.aos.DataFlowSetVariable;
import tool.compiler.java.aos.TypedSetVariable;

/**
 * X ∖ Y <: Z
 */
@Deprecated
public class Difference implements Constraint {
	
	// fields
	
	private DataFlowSetVariable x, y, z;	// X, Y (NOT null)
	
	
	// constructor
	
	/**
	 * @param x
	 * @param y
	 * @param z
	 */
	public Difference(DataFlowSetVariable x, DataFlowSetVariable y, DataFlowSetVariable z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	// substitution methods
	
	/**
	 * Substitute TypedSetVariable for AbsObjSet<br>
	 * X ∖ Y <: Z
	 * @param x	set X
	 * @param y	set Y
	 * @param z	set Z
	 * @return	Substituted New Constraint
	 */
	public Difference substitute(TypedSetVariable x, TypedSetVariable y, TypedSetVariable z) {
		if(!this.x.equalsForType(x)) {
			throw new IllegalArgumentException("The Type Mismatch for x. "
					+ "(orig: " + this.x.getType() + ", subst: " + x.getType() + ")");
		}
		
		if(!this.y.equalsForType(y)) {
			throw new IllegalArgumentException("The Type Mismatch for y. "
					+ "(orig: " + this.y.getType() + ", subst: " + y.getType() + ")");
		}
		
		if(!this.z.equalsForType(z)) {
			throw new IllegalArgumentException("The Type Mismatch for z. "
					+ "(orig: " + this.z.getType() + ", subst: " + y.getType() + ")");
		}
		
		return new Difference(x, y, z);
	}
	
	/**
	 * Substitute TypedSetVariable for AbsObjSet<br>
	 * X ∖ Y <: Z
	 * @param xyz	X, Y and Z	(The size is 3)
	 * @return		Substituted New Constraint
	 */
	@Override
	public Constraint substitute(List<TypedSetVariable> xyz) {
		if(xyz.size() != substitutableSize()) {
			throw new IllegalArgumentException("The Size of tsvs must be " + substitutableSize() + ". "
					+ "(Current size is " + xyz.size() + ".)");
		}
		Object[] xyzArr = xyz.toArray();
		return substitute((TypedSetVariable)xyzArr[0], (TypedSetVariable)xyzArr[1], (TypedSetVariable)xyzArr[2]);
	}
	
	
	// getter methods
	
	/**
	 * @return the x
	 */
	public DataFlowSetVariable getX() {
		return x;
	}
	
	/**
	 * @return the y
	 */
	public DataFlowSetVariable getY() {
		return y;
	}
	
	/**
	 * @return the z
	 */
	public DataFlowSetVariable getZ() {
		return z;
	}
	
	
	/**
	 * @see tool.compiler.java.constraint.Constraint#absObjSetSize()
	 */
	@Override
	public int absObjSetSize() {
		return 3;
	}
	
	/**
	 * @see tool.compiler.java.constraint.Constraint#substitutableSize()
	 */
	@Override
	public int substitutableSize() {
		return 3;
	}
	
	/**
	 * @see tool.compiler.java.constraint.Constraint#getAllAbsObjSets()
	 */
	@Override
	public List<? extends AbsObjSet> getAllAbsObjSets() {
		ArrayList<DataFlowSetVariable> abss = new ArrayList<>();
		abss.add(x);
		abss.add(y);
		abss.add(z);
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
		if (z.equals(aos)) {
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
	 * Form:	C{X} ∖ D{Y} <: E{Z}
	 */
	@Override
	public String toString() {
		return getX() + " ∖ " + getY() + " <: " + getZ();
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
		result = prime * result + ((z == null) ? 0 : z.hashCode());
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
		Difference other = (Difference) obj;
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
		if (z == null) {
			if (other.z != null) {
				return false;
			}
		} else if (!z.equals(other.z)) {
			return false;
		}
		return true;
	}
}