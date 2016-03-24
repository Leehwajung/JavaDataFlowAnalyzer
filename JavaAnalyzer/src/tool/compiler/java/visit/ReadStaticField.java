package tool.compiler.java.visit;

import polyglot.types.ReferenceType;
import polyglot.types.Type;

/**
 * C.f <: D{X}<br>
 * ... read a static field
 */
class ReadStaticField extends AbstractFieldConstraint {
	
	/* ### Abstract Fields ###
	 * ReferenceType c;		// C
	 * FieldTable f;		// f
	 * Type d;				// D
	 * SetVariable x;		// X
	 */
	
	
	// constructor
	
	/**
	 * 
	 * @param f	set C, f	( C.f )
	 * @param x	set D, X	( D{X} )
	 */
	public ReadStaticField(FieldTable f, SetVariable x) {
		super(f, x);
	}
	
	
	// getter methods
	
	/**
	 * @return	C
	 */
	@Override
	public ReferenceType getLeftType() {	// C
		return super.getClassType();
	}
	
	/**
	 * @return	D
	 */
	@Override
	public Type getRightType() {	// D
		return super.getSetVarType();
	}
	
	/**
	 * @return	X (SetVariable)
	 */
	public SetVariable getRightSetVar() {	// X
		return super.getSetVar();
	}
	
	/**
	 * @return	X (ID String)
	 */
	public String getRightSetVarID() {	// X
		return super.getSetVarID();
	}
	
	
	/**
	 * Form:	C.f <: D{X}
	 */
	@Override
	public String toString() {
		return getLeftType() + "." + getFieldName() + inclusion + getRightSetVar();
	}
}