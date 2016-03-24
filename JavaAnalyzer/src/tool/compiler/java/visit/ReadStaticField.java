package tool.compiler.java.visit;

/**
 * C.f <: D{X}<br>
 * ... read a static field
 */
class ReadStaticField extends AbstractReadField {
	
	/* Abstract */
	// C.f
//	ReferenceType c;	// C
//	FieldTable f;		// f
//	Type d;				// D
//	SetVariable x;		// X
	
	
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
	 * @return	X (SetVariable)
	 */
	@Override
	public SetVariable getRightSetVar() {	// X
		return super.getRightSetVar();
	}
	
	/**
	 * @return	X (ID String)
	 */
	@Override
	public String getRightSetVarID() {		// X
		return super.getRightSetVarID();
	}
	
	
	/**
	 * Form: C.f <: D{X}
	 */
	@Override
	public String toString() {
		return getLeftType() + "." + getFieldName() + inclusion + getRightSetVar();
	}
}