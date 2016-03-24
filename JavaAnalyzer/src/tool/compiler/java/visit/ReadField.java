package tool.compiler.java.visit;

import polyglot.types.ReferenceType;
import polyglot.types.Type;

/**
 * C{X}.f <: D{Y}<br>
 * ... read an instance field
 */
public class ReadField extends AbstractFieldConstraint {
	
	/* ### Abstract Fields ###
	 * ReferenceType c;		// C
	 * SetVariable x;		// X
	 * FieldTable f;		// f
	 * Type d;				// D
	 * SetVariable Y;		// Y
	 */
	
	
	// constructor
	
	/**
	 * 
	 * @param f	set C, X, f	( C{X}.f )
	 * @param y	set D, Y	( D{Y} )
	 */
	public ReadField(FieldTable f, SetVariable y) {
		super(f, y);
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
	 * @return	X (SetVariable)
	 */
	public SetVariable getLeftSetVar() {	// X
		return getFieldTable().getSetVariable();
	}
	
	/**
	 * @return	X (ID String)
	 */
	public String getLeftSetVarID() {	// X
		return getLeftSetVar().getID();
	}
	
	/**
	 * @return	D
	 */
	@Override
	public Type getRightType() {	// D
		return super.getSetVarType();
	}
	
	/**
	 * @return	Y (SetVariable)
	 */
	public SetVariable getRightSetVar() {	// Y
		return super.getSetVar();
	}
	
	/**
	 * @return	Y (ID String)
	 */
	public String getRightSetVarID() {	// Y
		return super.getSetVarID();
	}
	
	
	/**
	 * Form:	C{X}.f <: D{Y}
	 */
	@Override
	public String toString() {
		return getLeftSetVar() + "." + getFieldName() + inclusion + getRightSetVar();
	}
}