package tool.compiler.java.visit;

import polyglot.types.Type;
import tool.compiler.java.util.CollUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * (C1{X1}, ..., Cn{Xn}) -- effect1 --> E1{X} 
 * 	<: (D1{Y1}, ..., Dn{Ym}) -- effect2 --> E2{Y}<br>
 * 	(Not mandatory)
 */
public class MthToMth extends Constraint {
	
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
	
	/* ### Actual Fields ### */
	private ArrayList<TypedSetVariable> cxs;	// Cs, Xs ( C1{X1}, ..., Cn{Xn} )
	private TypedSetVariable e1x;					// E1, X
	private ArrayList<TypedSetVariable> dys;	// Ds, Ys ( D1{Y1}, ..., Dn{Yn} )
	private TypedSetVariable e2y;					// E2, Y
	
	
	// constructor
	
	/**
	 * (C1{X1}, ..., Cn{Xn}) -- effect1 --> E1{X} 
	 * 	<: (D1{Y1}, ..., Dn{Ym}) -- effect2 --> E2{Y}
	 * @param cxs	set Cs, Xs	( C1{X1}, ..., Cn{Xn} )
	 * @param e1x	set E1, X	( E1{X} )
	 * @param dys	set Ds, Ys	( D1{Y1}, ..., Dn{Yn} )
	 * @param e2y	set E2, Y	( E2{Y} )
	 */
	public MthToMth(Collection<TypedSetVariable> cxs, TypedSetVariable e1x, Collection<TypedSetVariable> dys, TypedSetVariable e2y) {
		super();
		this.cxs = new ArrayList<TypedSetVariable>(cxs);
		this.e1x = e1x;
		this.dys = new ArrayList<TypedSetVariable>(dys);
		this.e2y = e2y;
	}
	
	
	// getter methods
	
	/**
	 * @return C1{X1}, ..., Cn{Xn}
	 */
	public List<TypedSetVariable> getCXs() {
		return new ArrayList<TypedSetVariable>(cxs);
	}
	
	/**
	 * @param i	index
	 * @return Ci{Xi}
	 */
	public TypedSetVariable getCX(int i) {
		return cxs.get(i);
	}
	
	/**
	 * @return the E1{X}
	 */
	public TypedSetVariable getE1X() {
		return e1x;
	}
	
	/**
	 * @return the E1
	 */
	public Type getE1() {
		return e1x.getType();
	}
	
	/**
	 * @return the X
	 */
	public String getX() {
		return e1x.getID();
	}
	
	/**
	 * @return D1{Y1}, ..., Dn{Yn}
	 */
	public List<TypedSetVariable> getDYs() {
		return new ArrayList<TypedSetVariable>(dys);
	}
	
	/**
	 * @param i	index
	 * @return Di{Yi}
	 */
	public TypedSetVariable getDY(int i) {
		return dys.get(i);
	}
	
	/**
	 * @return the E2{Y}
	 */
	public TypedSetVariable getE2Y() {
		return e2y;
	}
	
	/**
	 * @return the E2
	 */
	public Type getE2() {
		return e2y.getType();
	}
	
	/**
	 * @return the Y
	 */
	public String getY() {
		return e2y.getID();
	}
	
	
	/**
	 * Form:	(C1{X1}, ..., Cn{Xn}) -- effect1 --> E1{X} 
	 * 				<: (D1{Y1}, ..., Dn{Ym}) -- effect2 --> E2{Y}
	 */
	@Override
	public String toString() {
		return CollUtil.getStringOf(getCXs(), '{', '}') + " -- " + "effect1" + " --> "	+ getE1X() 
				+ " <: " + CollUtil.getStringOf(getDYs(), '{', '}') + " -- " + "effect2" + " --> "	+ getE2Y();
	}
}