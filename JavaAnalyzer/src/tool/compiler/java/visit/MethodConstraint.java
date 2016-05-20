package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5ConstructorInstance;
import polyglot.ext.jl5.types.JL5MethodInstance;
import polyglot.ext.jl5.types.JL5ProcedureInstance;
import polyglot.types.Type;
import tool.compiler.java.util.CollUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * C{AOSc}.m <: (D1{AOS1}, ..., Dn{AOSn}) --> E{AOSe}
 */
public class MethodConstraint extends ConstraintFunction {
	
	// fields
	
	/* ### Abstract Fields ###
	 * Type c;						// C
	 * AbsObjSet x;				// X
	 * MethodInstance m;			// method name m
	 * ArrayList<Type> ds;			// D1, ... , Dn
	 * ArrayList<AbsObjSet> xs;	// X1, ..., Xn
	 * Type e;						// E
	 * AbsObjSet y;				// Y
	 */
	
	/* ### Actual Fields ### */
	private AbsObjSet caos;				// C, AOS
	private JL5ProcedureInstance m;				// m
	private ArrayList<AbsObjSet> daoss;	// Ds, AOSs ( D1{AOS1}, ..., Dn{AOSn} )
	private AbsObjSet eaos;				// E, AOS
	
	
	// constructors
	
	/**
	 * C{AOSc}.m <: (D1{AOS1}, ..., Dn{AOSn}) --> E{AOSe}
	 * @param caosc	set C, AOS	( C{AOSc} )
	 * @param m		set m
	 * @param daoss	set Ds, AOSs	( D1{AOS1}, ..., Dn{AOSn} )
	 * @param eaose	set E, AOS	( E{AOSe} )
	 */
	public MethodConstraint(AbsObjSet caosc, JL5ProcedureInstance m, Collection<? extends AbsObjSet> daoss, AbsObjSet eaose) {
		super();
		this.caos = caosc;
		this.m = m;
		if(daoss != null) {
			this.daoss = new ArrayList<AbsObjSet>(daoss);
		} else {
			this.daoss = null;
		}
		this.eaos = eaose;
	}
	
	/**
	 * C{AOSc}.m <: (D1{AOS1}, ..., Dn{AOSn}) --> E{AOSe}
	 * @param caosc	set C, AOS	( C{AOSc} )
	 * @param m		set m
	 * @param daoss	set Ds, AOSs	( D1{AOS1}, ..., Dn{AOSn} )
	 * @param eaose	set E, AOS	( E{AOSe} )
	 */
	public MethodConstraint(AbsObjSet caosc, JL5MethodInstance m, Collection<AbsObjSet> daoss, AbsObjSet eaose) {
		this(caosc, (JL5ProcedureInstance) m, daoss, eaose);
	}
	
	/**
	 * C{AOSc}.m <: (D1{AOS1}, ..., Dn{AOSn}) --> E{AOSe}
	 * @param caosc	set C, AOS	( C{AOSc} )
	 * @param m		set m
	 * @param daoss	set Ds, AOSs	( D1{AOS1}, ..., Dn{AOSn} )
	 * @param eaose	set E, AOS	( E{AOSe} )
	 */
	public MethodConstraint(AbsObjSet caosc, JL5ConstructorInstance m, Collection<AbsObjSet> daoss, AbsObjSet eaose) {
		this(caosc, (JL5ProcedureInstance) m, daoss, eaose);
	}
	
	
	// getter methods
	
	/**
	 * @return the C{AOSc}
	 */
	public AbsObjSet getCAOS() {
		return caos;
	}
	
	/**
	 * @return the C
	 */
	public Type getC() {
		return caos.getType();
	}
	
	/**
	 * @return the AOSc
	 */
	public String getAOSc() {
		return caos.getID();
	}
	
	/**
	 * @return the m
	 */
	public JL5ProcedureInstance getM() {
		return m;
	}
	
	/**
	 * @return D1{AOS1}, ..., Dn{AOSn}
	 */
	public List<? extends AbsObjSet> getDAOSs() {
		return daoss;
	}
	
	/**
	 * @param i	index
	 * @return Di{AOSi}
	 */
	public AbsObjSet getDAOS(int i) {
		return daoss.get(i);
	}
	
	/**
	 * @return the E{AOSe}
	 */
	public AbsObjSet getEAOS() {
		return eaos;
	}
	
	/**
	 * @return the E
	 */
	public Type getE() {
		return eaos.getType();
	}
	
	/**
	 * @return the AOSe
	 */
	public String getAOSe() {
		return eaos.getID();
	}
	
	
	/**
	 * Form:	C{AOSc}.m <: (D1{AOS1}, ..., Dn{AOSn}) --> E{AOSe}
	 */
	@Override
	public String toString() {
		return getCAOS() + "." + getName()
				+ " <: " + CollUtil.getStringOf(getDAOSs(), '(', ')') 
				+ " --> "	+ getEAOS();
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caos == null) ? 0 : caos.hashCode());
		result = prime * result + ((m == null) ? 0 : m.hashCode());
		if(daoss != null) {
			for(AbsObjSet dx : daoss) {
				result = prime * result + ((dx == null) ? 0 : dx.hashCode());
			}
		}
		result = prime * result + ((eaos == null) ? 0 : eaos.hashCode());
		return result;
	}
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		MethodConstraint other = (MethodConstraint) obj;
		if (caos == null) {
			if (other.caos != null) {
				return false;
			}
		} else if (!caos.equals(other.caos)) {
			return false;
		}
		if (m == null) {
			if (other.m != null) {
				return false;
			}
		} else if (!m.equals(other.m)) {
			return false;
		}
		if (daoss == null) {
			if (other.daoss != null) {
				return false;
			}
		} else if (!daoss.equals(other.daoss)) {
			return false;
		}
		if (eaos == null) {
			if (other.eaos != null) {
				return false;
			}
		} else if (!eaos.equals(other.eaos)) {
			return false;
		}
		return true;
	}
	
	
	protected final String getName() {
		return getM() instanceof JL5MethodInstance ? ((JL5MethodInstance)getM()).name() : getM().container().toString();
	}
	
	public boolean isConstructor() {
		return m instanceof JL5ConstructorInstance;
	}
}