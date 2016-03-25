package tool.compiler.java.visit;

/**
 * C{X}.m <: (D1{X1}, ..., Dn{Xn}) -- effect --> E{Y}
 */
public class InvokeMth extends Constraint {
	
	// fields
	
	/* ### Abstract Fields ###
	 * Type c;						// C
	 * SetVariable x;				// X
	 * MethodInstance m;			// method name m
	 * ArrayList<Type> ds;			// D1, ... , Dn
	 * ArrayList<SetVariable> xs;	// X1, ..., Xn
	 * (effect)						// effect
	 * Type e;						// E
	 * SetVariable y;				// Y
	 */
}