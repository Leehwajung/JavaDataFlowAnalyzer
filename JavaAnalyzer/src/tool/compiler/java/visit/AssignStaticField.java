package tool.compiler.java.visit;

<<<<<<< HEAD
import polyglot.ext.jl5.types.JL5FieldInstance;
=======
import polyglot.types.ReferenceType;
>>>>>>> branch 'develop' of https://hjtl22.visualstudio.com/DefaultCollection/Java%20Analyzer/_git/JavaAnalyzer
import polyglot.types.Type;

/**
 * C{X} <: D.f<br>
 * ... assign to a static field
 */
<<<<<<< HEAD
public class AssignStaticField extends Constraint {
=======
public class AssignStaticField extends AbstractFieldConstraint {
>>>>>>> branch 'develop' of https://hjtl22.visualstudio.com/DefaultCollection/Java%20Analyzer/_git/JavaAnalyzer
	
<<<<<<< HEAD
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
=======
	/* ### Abstract Fields ###
	 * Type c;				// C
	 * SetVariable x;		// X
	 * ReferenceType d;		// D
	 * FieldTable f;		// f
	 */
	
	
	// constructor
	
	/**
	 * 
	 * @param x	set C, X	( C{X} )
	 * @param f	set D, f	( D.f )
	 */
	public AssignStaticField(SetVariable x, FieldTable f) {
		super(f, x);
	}
	
	
	// getter methods
	
	/**
	 * @return	C
	 */
	@Override
	public Type getLeftType() {	// C
		return super.getSetVarType();
	}
	
	/**
	 * @return	X (SetVariable)
	 */
	public SetVariable getLeftSetVar() {	// X
		return super.getSetVar();
	}
	
	/**
	 * @return	X (ID String)
	 */
	public String getLeftSetVarID() {	// X
		return super.getSetVarID();
	}
	
	/**
	 * @return	D
	 */
	@Override
	public ReferenceType getRightType() {	// D
		return super.getClassType();
	}
	
	
	/**
	 * Form:	C{X} <: D.f
	 */
	@Override
	public String toString() {
		return getLeftSetVar() + inclusion + getRightType() + "." + getFieldName();
>>>>>>> branch 'develop' of https://hjtl22.visualstudio.com/DefaultCollection/Java%20Analyzer/_git/JavaAnalyzer
	}
}