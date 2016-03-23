package tool.compiler.java.visit;

/**
 * C{X}.f <: D{Y}
 */
public class ReadField extends Constraint {
	
	// C{X}
//	??? c;			// C
	SetVariable x;	// X
//	??? f;			// f
//	??? d;			// D
	SetVariable y;	// Y
}