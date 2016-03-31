package tool.compiler.java.visit;

/**
 * X \subseteq Y
 */
public class XSubseteqY extends Constraint {
	
	// fields
	
	private TypedSetVariable x, y;	// X, Y
	
	
	// constructor
	
	/**
	 * X \subseteq Y
	 * @param x	set X
	 * @param y	set Y
	 */
	public XSubseteqY(TypedSetVariable x, TypedSetVariable y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
	// getter methods
	
	/**
	 * @return the X
	 */
	public TypedSetVariable getX() {
		return x;
	}
	
	/**
	 * @return the Y
	 */
	public TypedSetVariable getY() {
		return y;
	}
	
	
	/**
	 * Form:	X \subseteq Y
	 */
	@Override
	public String toString() {
		return getX() + " \\subseteq " + getY();
	}
}