package tool.compiler.java.visit;

<<<<<<< HEAD
import polyglot.ext.jl5.types.JL5FieldInstance;
=======
import polyglot.types.ReferenceType;
>>>>>>> branch 'develop' of https://hjtl22.visualstudio.com/DefaultCollection/Java%20Analyzer/_git/JavaAnalyzer
import polyglot.types.Type;

/**
 * C{X}.f <: D{Y}<br>
 * ... read an instance field
 */
<<<<<<< HEAD
public class ReadField extends Constraint {
=======
public class ReadField extends AbstractFieldConstraint {
>>>>>>> branch 'develop' of https://hjtl22.visualstudio.com/DefaultCollection/Java%20Analyzer/_git/JavaAnalyzer
	
<<<<<<< HEAD
	// fields
	
	/* ### Abstract Fields ###
	 * Type c;				// C
	 * SetVariable x;		// X
	 * FieldInstance f;		// f
	 * Type d;				// D
	 * SetVariable Y;		// Y
	 */
	
	/* ### Actual Fields ### */
	private TypedSetVariable cx;	// C, X
	private JL5FieldInstance f;		// f
	private TypedSetVariable dy;	// D, Y
=======
	/* ### Abstract Fields ###
	 * ReferenceType c;		// C
	 * SetVariable x;		// X
	 * FieldTable f;		// f
	 * Type d;				// D
	 * SetVariable Y;		// Y
	 */
>>>>>>> branch 'develop' of https://hjtl22.visualstudio.com/DefaultCollection/Java%20Analyzer/_git/JavaAnalyzer
	
	
	// constructor
	
	/**
<<<<<<< HEAD
	 * C{X}.f <: D{Y}
	 * @param cx	set C, X	( C{X} )
	 * @param f		set f
	 * @param dy	set D, Y	( D{Y} )
	 */
	public ReadField(TypedSetVariable cx, JL5FieldInstance f, TypedSetVariable dy) {
		super();
		this.cx = cx;
		this.f = f;
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
	 * @return the f
	 */
	public JL5FieldInstance getF() {
		return f;
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
	 * Form:	C{X}.f <: D{Y}
	 */
	@Override
	public String toString() {
		return getCX() + "." + getF().name() + " <: " + getDY();
=======
	 * 
	 * @param f	set C, X, f	( C{X}.f )
	 * @param y	set D, Y	( D{Y} )
	 */
	public ReadField(FieldTable f, SetVariable y) {
		super(f, y);
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
	 * @return	X (SetVariable)
	 */
	public SetVariable getLeftSetVar() {	// X
		return getFieldTable().getSetVariable();
	}
	
	/**
	 * @return	X (ID String)
	 */
	public String getLeftSetVarID() {	// X
		return getLeftSetVar().getID();
	}
	
	/**
	 * @return	D
	 */
	@Override
	public Type getRightType() {	// D
		return super.getSetVarType();
	}
	
	/**
	 * @return	Y (SetVariable)
	 */
	public SetVariable getRightSetVar() {	// Y
		return super.getSetVar();
	}
	
	/**
	 * @return	Y (ID String)
	 */
	public String getRightSetVarID() {	// Y
		return super.getSetVarID();
	}
	
	
	/**
	 * Form:	C{X}.f <: D{Y}
	 */
	@Override
	public String toString() {
		return getLeftSetVar() + "." + getFieldName() + inclusion + getRightSetVar();
>>>>>>> branch 'develop' of https://hjtl22.visualstudio.com/DefaultCollection/Java%20Analyzer/_git/JavaAnalyzer
	}
}