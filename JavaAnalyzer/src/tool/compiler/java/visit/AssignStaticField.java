package tool.compiler.java.visit;

/**
 * C{X} <: D.f<br>
 * ... assign to a static field
 */
class AssignStaticField extends Constraint {
	
//	??? c;			// C
	SetVariable x;	// X
//	??? d;			// D
//	??? f;			// f
}