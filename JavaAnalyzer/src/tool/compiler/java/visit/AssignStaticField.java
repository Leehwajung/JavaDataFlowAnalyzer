package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5FieldInstance;
import polyglot.types.Type;

/**
 * C{X} <: D.f<br>
 * ... assign to a static field
 */
public class AssignStaticField extends Constraint {
	
	// fields
	
	/* ### Abstract Fields ###
	 * Type c;				// C
	 * SetVariable x;		// X
	 * Type d;				// D
	 * FieldInstance f;		// f
	 */
	
	/* ### Actual Fields ### */
	private TypedSetVariable cx;	// C, X
	private JL5FieldInstance df;	// D, f
	
	
	// constructor
	
	/**
	 * C{X} <: D.f
	 * @param cx	set C, X	( C{X} )
	 * @param df	set D, f	( D.f )
	 */
	public AssignStaticField(TypedSetVariable cx, JL5FieldInstance df) {
		super();
		this.cx = cx;
		this.df = df;
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
	 * @return the D
	 */
	public Type getD() {
		return df.container();
	}
	
	/**
	 * @return the f
	 */
	public JL5FieldInstance getF() {
		return df;
	}
	
	
	/**
	 * Form:	C{X} <: D.f
	 */
	@Override
	public String toString() {
		return getCX() + " <: " + getD() + "." + getF().name();
	}
}