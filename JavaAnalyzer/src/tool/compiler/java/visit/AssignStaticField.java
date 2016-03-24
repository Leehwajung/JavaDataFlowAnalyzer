package tool.compiler.java.visit;

import polyglot.types.ReferenceType;
import polyglot.types.Type;

/**
 * C{X} <: D.f<br>
 * ... assign to a static field
 */
class AssignStaticField extends AbstractFieldConstraint {
	
	/* ### Abstract Fields ###
	 * Type c;				// C
	 * SetVariable x;		// X
	 * ReferenceType d;		// D
	 * FieldTable f;		// f
	 */
	
	
	// constructor
	
	/**
	 * 
	 * @param x	set C, X	( C{X} )
	 * @param f	set D, f	( D.f )
	 */
	public AssignStaticField(SetVariable x, FieldTable f) {
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
	 * Form:	C{X} <: D.f
	 */
	@Override
	public String toString() {
		return getLeftSetVar() + inclusion + getRightType() + "." + getFieldName();
	}
}