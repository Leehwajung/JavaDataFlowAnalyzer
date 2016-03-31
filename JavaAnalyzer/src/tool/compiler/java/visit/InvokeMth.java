package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5MethodInstance;
import polyglot.types.Type;
import tool.compiler.java.util.CollUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

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
	
	/* ### Actual Fields ### */
	private TypedSetVariable cx;					// C, X
	private JL5MethodInstance m;					// m
	private ArrayList<TypedSetVariable> dxs;	// Ds, Xs ( D1{X1}, ..., Dn{Xn} )
	private TypedSetVariable ey;					// E, Y
	
	
	// constructor
	
	/**
	 * C{X}.m <: (D1{X1}, ..., Dn{Xn}) -- effect --> E{Y}
	 * @param cx	set C, X	( C{X} )
	 * @param m		set m
	 * @param dxs	set Ds, Xs	( D1{X1}, ..., Dn{Xn} )
	 * @param ey	set E, Y	( E{Y} )
	 */
	public InvokeMth(TypedSetVariable cx, JL5MethodInstance m, Collection<TypedSetVariable> dxs, TypedSetVariable ey) {
		super();
		this.cx = cx;
		this.m = m;
		this.dxs = new ArrayList<TypedSetVariable>(dxs);
		this.ey = ey;
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
	 * @return the m
	 */
	public JL5MethodInstance getM() {
		return m;
	}
	
	/**
	 * @return D1{X1}, ..., Dn{Xn}
	 */
	public List<TypedSetVariable> getDXs() {
		return new ArrayList<TypedSetVariable>(dxs);
	}
	
	/**
	 * @param i	index
	 * @return Di{Xi}
	 */
	public TypedSetVariable getDX(int i) {
		return dxs.get(i);
	}
	
	/**
	 * @return the E{Y}
	 */
	public TypedSetVariable getEY() {
		return ey;
	}
	
	/**
	 * @return the E
	 */
	public Type getE() {
		return ey.getType();
	}
	
	/**
	 * @return the Y
	 */
	public String getY() {
		return ey.getID();
	}
	
	
	/**
	 * Form:	C{X}.m <: (D1{X1}, ..., Dn{Xn}) -- effect --> E{Y}
	 */
	@Override
	public String toString() {
		return getCX() + "." + getM().name() + " <: " + CollUtil.getStringOf(getDXs(), '{', '}') 
				+ " -- " + "effect" + " --> "	+ getEY();
	}
}