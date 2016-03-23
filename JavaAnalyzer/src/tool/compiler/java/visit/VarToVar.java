package tool.compiler.java.visit;

/**
 * C{X}   <: D{Y}<br>
 * ... variable-to-variable assign  (Not mandatory)
 */
class VarToVar extends Constraint {
	
//	??? c;			// C
	SetVariable x;	// X
//	??? d;			// D
	SetVariable y;	// Y
}