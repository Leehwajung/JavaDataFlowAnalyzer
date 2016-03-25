package tool.compiler.java.visit;

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
}