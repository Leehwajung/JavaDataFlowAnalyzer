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
	
	private Constraint headerConstraint;
	private LinkedHashSet<Constraint> bodyConstraints;
	
	/**
	 * @param 
	 */
	public MethodConstraint(MetaSetVariable caos, JL5ProcedureInstance m, Collection<MetaSetVariable> daoss, MetaSetVariable eaos) {
		this.headerConstraint = new InvokeMth(caos, m, daoss, eaos);
		this.bodyConstraints = new LinkedHashSet<>();
	}
	
	public MethodConstraint(JL5MethodInstance cm, Collection<MetaSetVariable> daoss, MetaSetVariable eaos) {
		this.headerConstraint = new InvokeStaticMth(cm, daoss, eaos);
		this.bodyConstraints = new LinkedHashSet<>();
	}
	
	public void addConstraints(Constraint bodyConstraint) {
		bodyConstraints.add(bodyConstraint);
	}
	
	public ConstraintsPair apply() {
		return null;
	}
}

class ConstraintsPair {
	public static enum Type {
		ret
	}
}