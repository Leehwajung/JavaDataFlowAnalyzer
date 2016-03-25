package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5FieldInstance;
import polyglot.types.Type;

/**
 * C{X}.f <: D{Y}<br>
 * ... read an instance field
 */
public class ReadField extends Constraint {
	
	// fields
	
	/* ### Abstract Fields ###
	 * Type c;				// C
	 * SetVariable x;		// X
	 * FieldInstance f;		// f
	 * Type d;				// D
	 * SetVariable Y;		// Y
	 */
	
	/* ### Actual Fields ### */
	private TypedSetVariable cx;	// C, X
	private JL5FieldInstance f;		// f
	private TypedSetVariable dy;	// D, Y
	
	
	// constructor
	
	/**
	 * C{X}.f <: D{Y}
	 * @param cx	set C, X	( C{X} )
	 * @param f		set f
	 * @param dy	set D, Y	( D{Y} )
	 */
	public ReadField(TypedSetVariable cx, JL5FieldInstance f, TypedSetVariable dy) {
		super();
		this.cx = cx;
		this.f = f;
		this.dy = dy;
	}
	
	
	// getter methods
	
	/**
	 * @return the C{X}
	 */
	public TypedSetVariable getCX() {
		return cx;
	}
	
	/**
	 * @return the C
	 */
	public Type getC() {
		return cx.getType();
	}
	
	/**
	 * @return the X
	 */
	public String getX() {
		return cx.getID();
	}
	
	/**
	 * @return the f
	 */
	public JL5FieldInstance getF() {
		return f;
	}
	
	/**
	 * @return the D{Y}
	 */
	public TypedSetVariable getDY() {
		return dy;
	}
	
	/**
	 * @return the D
	 */
	public Type getD() {
		return dy.getType();
	}
	
	/**
	 * @return the Y
	 */
	public String getY() {
		return dy.getID();
	}
	
	
	/**
	 * Form:	C{X}.f <: D{Y}
	 */
	@Override
	public String toString() {
		return getCX() + "." + getF().name() + " <: " + getDY();
	}
}