package tool.compiler.java.visit;

/**
 * C{X} <: D{Y}.f<br>
 * ... assign to an instance field
 */
public class AssignField extends Constraint {
	
//	??? c;	// C
	SetVariable x;	// X
//	??? d;	// D
	SetVariable y;	// Y
//	??? f;	// f
}