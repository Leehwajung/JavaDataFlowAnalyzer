package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5MethodInstance;
import polyglot.types.Type;
import tool.compiler.java.util.CollUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * C.m <: (D1{X1}, ..., Dn{Xn}) -- effect --> E{Y}
 */
public class InvokeStaticMth extends Constraint {
	
	// fields
	
	/* ### Abstract Fields ###
	 * Type c;						// C
	 * MethodInstance m;			// method name m
	 * ArrayList<Type> ds;			// D1, ... , Dn
	 * ArrayList<SetVariable> xs;	// X1, ..., Xn
	 * (effect)						// effect
	 * Type e;						// E
	 * SetVariable y;				// Y
	 */
	
	/* ### Actual Fields ### */
	private JL5MethodInstance cm;					// C, m
	private ArrayList<TypedSetVariable> dxs;	// Ds, Xs ( D1{X1}, ..., Dn{Xn} )
	private TypedSetVariable ey;					// E, Y
	
	
	// constructor
	
	/**
	 * C.m <: (D1{X1}, ..., Dn{Xn}) -- effect --> E{Y}
	 * @param cm	set C, m	( C.m )
	 * @param dxs	set Ds, Xs	( D1{X1}, ..., Dn{Xn} )
	 * @param ey	set E, Y	( E{Y} )
	 */
	public InvokeStaticMth(JL5MethodInstance cm, Collection<TypedSetVariable> dxs, TypedSetVariable ey) {
		super();
		this.cm = cm;
		this.dxs = new ArrayList<TypedSetVariable>(dxs);
		this.ey = ey;
	}
	
	
	// getter methods
	
	/**
	 * @return the C
	 */
	public Type getC() {
		return cm.container();
	}
	
	/**
	 * @return the m
	 */
	public JL5MethodInstance getM() {
		return cm;
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
	 * Form:	C.m <: (D1{X1}, ..., Dn{Xn}) -- effect --> E{Y}
	 */
	@Override
	public String toString() {
		return getC() + "." + getM().name() + " <: " + CollUtil.getStringOf(getDXs(), '{', '}') 
				+ " -- " + "effect" + " --> "	+ getEY();
	}
}