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
	
	public MethodConstraint(JL5ProcedureInstance m, Collection<MetaSetVariable> chi_formals) {
		this(m);
		this.chi_formals = new LinkedHashSet<>(chi_formals);
	}
	
	public MethodConstraint(JL5ProcedureInstance m, Collection<MetaSetVariable> chi_formals, MetaSetVariable chi_return) {
		this(m, chi_formals);
		this.chi_ret = chi_return;
	}
	
	public MethodConstraint(JL5ProcedureInstance m, Collection<MetaSetVariable> chi_formals, Collection<MetaSetVariable> chi_locals, MetaSetVariable chi_return) {
		this(m, chi_formals, chi_return);
		this.chi_locals = new LinkedHashSet<>(chi_locals);
	}
	
	public ConstraintsPair apply() {
		return null;
	}
	
	
	/**
	 * @return the chi_formals
	 */
	public LinkedHashSet<MetaSetVariable> getChi_formals() {
		return new LinkedHashSet<>(chi_formals);
	}
	
	/**
	 * @param chi_formals the chi_formals to set
	 */
	public void setChi_formals(LinkedHashSet<MetaSetVariable> chi_formals) {
		this.chi_formals = chi_formals;
	}
	
	/**
	 * @return the chi_locals
	 */
	public LinkedHashSet<MetaSetVariable> getChi_locals() {
		return new LinkedHashSet<>(chi_locals);
	}
	
	/**
	 * @param chi_locals the chi_locals to set
	 */
	public void setChi_locals(LinkedHashSet<MetaSetVariable> chi_locals) {
		this.chi_locals = chi_locals;
	}
	
	/**
	 * @return the chi_ret
	 */
	public MetaSetVariable getChi_ret() {
		return chi_ret;
	}
	
	/**
	 * @param chi_ret the chi_ret to set
	 */
	public void setChi_ret(MetaSetVariable chi_ret) {
		this.chi_ret = chi_ret;
	}
	
	/**
	 * @return the method
	 */
	public JL5ProcedureInstance getMethod() {
		return method;
	}
	
	
	public static class ConstraintsPair {
		public static enum Type {
			ret
		}
	}
}