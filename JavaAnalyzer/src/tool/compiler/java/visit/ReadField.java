package tool.compiler.java.visit;

/**
 * C{X}.f <: D{Y}<br>
 * ... read an instance field
 */
public class ReadField extends AbstractReadField {
	
	/* Abstract */
	// C{X}
//	ReferenceType c;	// C
//	SetVariable x;		// X
//	FieldTable f;		// f
//	Type d;				// D
//	SetVariable Y;		// Y
	
	
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
	 * @return	X (SetVariable)
	 */
	public SetVariable getLeftSetVar() {	// X
		return getFieldTable().getSetVariable();
	}
	
	/**
	 * @return	X (ID String)
	 */
	public String getLeftSetVarID() {		// X
		return getLeftSetVar().getID();
	}
	
	/**
	 * @return	Y (SetVariable)
	 */
	@Override
	public SetVariable getRightSetVar() {	// Y
		return super.getRightSetVar();
	}
	
	/**
	 * @return	Y (ID String)
	 */
	@Override
	public String getRightSetVarID() {		// Y
		return super.getRightSetVarID();
	}
	
	
	/**
	 * Form: C{X}.f <: D{Y}
	 */
	@Override
	public String toString() {
		return getLeftType().toString() + getLeftSetVar() + "." + getFieldName() + inclusion + getRightSetVar();
	}
}