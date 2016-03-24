package tool.compiler.java.visit;

import polyglot.types.ReferenceType;
import polyglot.types.Type;

/**
 * C{X} <: D{Y}.f<br>
 * ... assign to an instance field
 */
public class AssignField extends AbstractFieldConstraint {
	
	/* ### Abstract Fields ###
	 * Type c;				// C
	 * SetVariable x;		// X
	 * ReferenceType d;		// D
	 * SetVariable y;		// Y
	 * FieldTable f;		// f
	 */
	
	
	// constructor
	
	/**
	 * 
	 * @param x	set C, X	( C{X} )
	 * @param f	set D, Y, f	( D{Y}.f )
	 */
	public AssignField(SetVariable x, FieldTable f) {
		super(f, x);
	}
	
	
	// getter methods
	
	/**
	 * @return	C
	 */
	@Override
	public Type getLeftType() {	// C
		return super.getSetVarType();
	}
	
	/**
	 * @return	X (SetVariable)
	 */
	public SetVariable getLeftSetVar() {	// X
		return super.getSetVar();
	}
	
	/**
	 * @return	X (ID String)
	 */
	public String getLeftSetVarID() {	// X
		return super.getSetVarID();
	}
	
	/**
	 * @return	D
	 */
	@Override
	public ReferenceType getRightType() {	// D
		return super.getClassType();
	}
	
	/**
	 * @return	Y (SetVariable)
	 */
	public SetVariable getRightSetVar() {	// Y
		return getFieldTable().getSetVariable();
	}
	
	/**
	 * @return	Y (ID String)
	 */
	public String getRightSetVarID() {	// Y
		return getRightSetVar().getID();
	}
	
	
	/**
	 * Form:	C{X} <: D{Y}.f
	 */
	@Override
	public String toString() {
		return getLeftSetVar() + inclusion + getRightSetVar() + "." + getFieldName();
	}
}