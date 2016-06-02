package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5ProcedureInstance;
import tool.compiler.java.util.CollUtil;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * lam (Chi1, ..., Chin, Chi_ret). Constraint Set
 */
public class MethodConstraint implements ConstraintFunction {
	
	private JL5ProcedureInstance method;
	private LinkedHashSet<MetaSetVariable> chi_formals;
	private LinkedHashSet<MetaSetVariable> chi_locals;
	private MetaSetVariable chi_ret;
	
	/**
	 * @param 
	 */
	public MethodConstraint(JL5ProcedureInstance m) {
		this.method = m;
	}
	
	public MethodConstraint(JL5ProcedureInstance m, Collection<MetaSetVariable> chiFormals) {
		this(m);
		this.chi_formals = new LinkedHashSet<>(chiFormals);
	}
	
	public MethodConstraint(JL5ProcedureInstance m, Collection<MetaSetVariable> chiFormals, MetaSetVariable chiReturn) {
		this(m, chiFormals);
		this.chi_ret = chiReturn;
	}
	
	public MethodConstraint(JL5ProcedureInstance m, Collection<MetaSetVariable> chiFormals, Collection<MetaSetVariable> chiLocals, MetaSetVariable chiReturn) {
		this(m, chiFormals, chiReturn);
		this.chi_locals = new LinkedHashSet<>(chiLocals);
	}
	
	
	public ConstraintsPair apply() {
		return null;
	}
	
	
	/**
	 * @return the method
	 */
	public JL5ProcedureInstance getMethod() {
		return method;
	}
	
	/**
	 * @return the chi_formals
	 */
	public LinkedHashSet<MetaSetVariable> getChiFormals() {
		return new LinkedHashSet<>(chi_formals);
	}
	
	/**
	 * @param chiFormals the chi_formals to set
	 */
	public void addChiFormals(Collection<MetaSetVariable> chiFormals) {
		if(this.chi_formals == null) {
			this.chi_formals = new LinkedHashSet<MetaSetVariable>(chiFormals);
		} else {
			this.chi_formals.clear();
			this.chi_formals.addAll(chiFormals);
		}
	}
	
	/**
	 * @param chiFormal
	 */
	public void addChiFormal(MetaSetVariable chiFormal) {
		try {
			this.chi_formals.add(chiFormal);
		} catch (NullPointerException e) {
			this.chi_formals = new LinkedHashSet<>();
			this.chi_formals.add(chiFormal);
		}
	}
	
	/**
	 * @return the chi_locals
	 */
	public LinkedHashSet<MetaSetVariable> getChiLocals() {
		return new LinkedHashSet<>(chi_locals);
	}
	
	/**
	 * @param chiLocals the chi_locals to set
	 */
	public void addChiLocals(Collection<MetaSetVariable> chiLocals) {
		if(this.chi_locals == null) {
			this.chi_locals = new LinkedHashSet<MetaSetVariable>(chiLocals);
		} else {
			this.chi_locals.clear();
			this.chi_locals.addAll(chiLocals);
		}
	}
	
	/**
	 * @param chiLocal
	 */
	public void addChiLocal(MetaSetVariable chiLocal) {
		try {
			this.chi_locals.add(chiLocal);
		} catch (NullPointerException e) {
			this.chi_locals = new LinkedHashSet<>();
			this.chi_locals.add(chiLocal);
		}
	}
	
	/**
	 * @return the chi_ret
	 */
	public MetaSetVariable getChiRet() {
		return chi_ret;
	}
	
	/**
	 * @param chiRet the chi_ret to set
	 */
	public void setChiRet(MetaSetVariable chiRet) {
		this.chi_ret = chiRet;
	}
	
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result =  "MC " + method + ": λ(";
		result += chi_formals != null ? CollUtil.getStringOf(chi_formals) : "";
		result += chi_ret != null ? (chi_formals != null ? ", " : "") + chi_ret : "";
		result += ")";
		
		return result;
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + ((chi_formals == null) ? 0 : chi_formals.hashCode());
		result = prime * result + ((chi_locals == null) ? 0 : chi_locals.hashCode());
		result = prime * result + ((chi_ret == null) ? 0 : chi_ret.hashCode());
		
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
		if (method == null) {
			if (other.method != null) {
				return false;
			}
		} else if (!method.equals(other.method)) {
			return false;
		}
		if (chi_formals == null) {
			if (other.chi_formals != null) {
				return false;
			}
		} else if (!chi_formals.equals(other.chi_formals)) {
			return false;
		}
		if (chi_locals == null) {
			if (other.chi_locals != null) {
				return false;
			}
		} else if (!chi_locals.equals(other.chi_locals)) {
			return false;
		}
		if (chi_ret == null) {
			if (other.chi_ret != null) {
				return false;
			}
		} else if (!chi_ret.equals(other.chi_ret)) {
			return false;
		}
		return true;
	}
}