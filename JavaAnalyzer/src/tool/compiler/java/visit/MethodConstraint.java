package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5ProcedureInstance;

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
	 * @return the chi_formals
	 */
	public LinkedHashSet<MetaSetVariable> getChiFormals() {
		return new LinkedHashSet<>(chi_formals);
	}
	
	/**
	 * @param chiFormals the chi_formals to set
	 */
	public void setChiFormals(LinkedHashSet<MetaSetVariable> chiFormals) {
		this.chi_formals = chiFormals;
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
	 * @return the method
	 */
	public JL5ProcedureInstance getMethod() {
		return method;
	}
}