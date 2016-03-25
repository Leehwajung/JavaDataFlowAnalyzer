package tool.compiler.java.visit;

<<<<<<< HEAD
import polyglot.ext.jl5.types.JL5FieldInstance;
=======
import polyglot.types.ReferenceType;
>>>>>>> branch 'develop' of https://hjtl22.visualstudio.com/DefaultCollection/Java%20Analyzer/_git/JavaAnalyzer
import polyglot.types.Type;

/**
 * C.f <: D{X}<br>
 * ... read a static field
 */
<<<<<<< HEAD
public class ReadStaticField extends Constraint {
=======
public class ReadStaticField extends AbstractFieldConstraint {
>>>>>>> branch 'develop' of https://hjtl22.visualstudio.com/DefaultCollection/Java%20Analyzer/_git/JavaAnalyzer
	
<<<<<<< HEAD
	// fields
	
	/* ### Abstract Fields ###
	 * Type c;				// C
	 * FieldInstance f;		// f
	 * Type d;				// D
	 * SetVariable x;		// X
	 */
	
	/* ### Actual Fields ### */
	private JL5FieldInstance cf;	// C, f
	private TypedSetVariable dx;	// D, X
	
	
	// constructor
	
	/**
	 * C.f <: D{X}
	 * @param cf	set C, f	( C.f )
	 * @param dx	set D, X	( D{X} )
	 */
	public ReadStaticField(JL5FieldInstance cf, TypedSetVariable dx) {
		super();
		this.cf = cf;
		this.dx = dx;
	}
	
	
	// getter methods
	
	/**
	 * @return the C
	 */
	public Type getC() {
		return cf.container();
	}
	
	/**
	 * @return the f
	 */
	public JL5FieldInstance getF() {
		return cf;
	}
	
	/**
	 * @return the D{X}
	 */
	public TypedSetVariable getDX() {
		return dx;
	}
	
	/**
	 * @return the D
	 */
	public Type getD() {
		return dx.getType();
	}
	
	/**
	 * @return the X
	 */
	public String getX() {
		return dx.getID();
	}
	
	
	/**
	 * Form:	C.f <: D{X}
	 */
	@Override
	public String toString() {
		return getC() + "." + getF().name() + " <: " + getDX();
=======
	/* ### Abstract Fields ###
	 * ReferenceType c;		// C
	 * FieldTable f;		// f
	 * Type d;				// D
	 * SetVariable x;		// X
	 */
	
	
	// constructor
	
	/**
	 * 
	 * @param f	set C, f	( C.f )
	 * @param x	set D, X	( D{X} )
	 */
	public ReadStaticField(FieldTable f, SetVariable x) {
		super(f, x);
	}
	
	
	// getter methods
	
	/**
	 * @return	C
	 */
	@Override
	public ReferenceType getLeftType() {	// C
		return super.getClassType();
	}
	
	/**
	 * @return	D
	 */
	@Override
	public Type getRightType() {	// D
		return super.getSetVarType();
	}
	
	/**
	 * @return	X (SetVariable)
	 */
	public SetVariable getRightSetVar() {	// X
		return super.getSetVar();
	}
	
	/**
	 * @return	X (ID String)
	 */
	public String getRightSetVarID() {	// X
		return super.getSetVarID();
	}
	
	
	/**
	 * Form:	C.f <: D{X}
	 */
	@Override
	public String toString() {
		return getLeftType() + "." + getFieldName() + inclusion + getRightSetVar();
>>>>>>> branch 'develop' of https://hjtl22.visualstudio.com/DefaultCollection/Java%20Analyzer/_git/JavaAnalyzer
	}
}