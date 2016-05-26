package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5MethodInstance;
import polyglot.ext.jl5.types.JL5ProcedureInstance;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * lam (Chi1, ..., Chin, Chi_ret). Constraint Set
 */
public class MethodConstraint implements ConstraintFunction {
	
	private LinkedHashSet<MetaSetVariable> chi_formals;
	private LinkedHashSet<MetaSetVariable> chi_locals;
	private MetaSetVariable chi_ret;
	
	/**
	 * @param 
	 */
	public MethodConstraint() {
	}
	
	public MethodConstraint(JL5MethodInstance cm, Collection<MetaSetVariable> daoss, MetaSetVariable eaos) {
	}
	
	public ConstraintsPair apply() {
		return null;
	}
	
	public static class ConstraintsPair {
		public static enum Type {
			ret
		}
	}
}