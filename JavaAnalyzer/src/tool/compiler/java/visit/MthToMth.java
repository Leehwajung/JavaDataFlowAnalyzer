package tool.compiler.java.visit;

/**
 * (C1{X1}, ..., Cn{Xn}) -- effect1 --> E1{X} 
 * 	<: (D1{Y1}, ..., Dn{Ym}) -- effect2 --> E2{Y}<br>
 * 	(Not mandatory)
 */
<<<<<<< HEAD
public class MthToMth extends Constraint {
=======
public class MthToMth extends AbstractMethodConstraint {
>>>>>>> branch 'develop' of https://hjtl22.visualstudio.com/DefaultCollection/Java%20Analyzer/_git/JavaAnalyzer
	
	// fields
	
	/* ### Abstract Fields ###
	 * ArrayList<Type> cs;			// C1, ... , Cn
	 * ArrayList<SetVariable> xs;	// X1, ..., Xn
	 * (effect1)					// effect1
	 * Type e1;						// E1
	 * SetVariable x;				// X
	 * 
	 * ArrayList<Type> ds;			// D1, ... , Dn
	 * ArrayList<SetVariable> ys;	// Y1, ..., Yn
	 * (effect2)					// effect2
	 * Type e2;						// E2
	 * SetVariable y;				// Y
	 */
}