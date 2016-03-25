package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5FieldInstance;
import polyglot.types.Type;

/**
 * C.f <: D{X}<br>
 * ... read a static field
 */
public class ReadStaticField extends Constraint {
	
	// fields
	
	/* ### Abstract Fields ###
	 * Type c;				// C
	 * FieldInstance f;		// f
	 * Type d;				// D
	 * SetVariable x;		// X
	 */
	
	/* ### Actual Fields ### */
	private JL5FieldInstance cf;	// C, f
	private TypedSetVariable dx;	// D, X
	
	
	// constructor
	
	/**
	 * C.f <: D{X}
	 * @param cf	set C, f	( C.f )
	 * @param dx	set D, X	( D{X} )
	 */
	public ReadStaticField(JL5FieldInstance cf, TypedSetVariable dx) {
		super();
		this.cf = cf;
		this.dx = dx;
	}
	
	
	// getter methods
	
	/**
	 * @return the C
	 */
	public Type getC() {
		return cf.container();
	}
	
	/**
	 * @return the f
	 */
	public JL5FieldInstance getF() {
		return cf;
	}
	
	/**
	 * @return the D{X}
	 */
	public TypedSetVariable getDX() {
		return dx;
	}
	
	/**
	 * @return the D
	 */
	public Type getD() {
		return dx.getType();
	}
	
	/**
	 * @return the X
	 */
	public String getX() {
		return dx.getID();
	}
	
	
	/**
	 * Form:	C.f <: D{X}
	 */
	@Override
	public String toString() {
		return getC() + "." + getF().name() + " <: " + getDX();
	}
}