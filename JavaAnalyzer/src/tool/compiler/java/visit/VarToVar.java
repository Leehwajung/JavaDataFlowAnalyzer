package tool.compiler.java.visit;

import polyglot.types.Type;

/**
 * C{X} <: D{Y}<br>
 * ... variable-to-variable assign  (Not mandatory)
 */
public class VarToVar extends Constraint {
	
	// fields
	
	/* ### Abstract Fields ###
	 * Type c;			// C
	 * SetVariable x;	// X
	 * Type d;			// D
	 * SetVariable y;	// Y
	 */
	
	/* ### Actual Fields ### */
	private TypedSetVariable cx;	// C, X
	private TypedSetVariable dy;	// D, Y
	
	
	// constructor
	
	/**
	 * C{X} <: D{Y}
	 * @param cx	set C, X	( C{X} )
	 * @param dy	set D, Y	( D{Y} )
	 */
	public VarToVar(TypedSetVariable cx, TypedSetVariable dy) {
		super();
		this.cx = cx;
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
	 * Form:	C{X} <: D{Y}
	 */
	@Override
	public String toString() {
		return getCX() + " <: " + getDY();
	}
}