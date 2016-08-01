package tool.compiler.java.env;

import java.util.Collection;
import java.util.LinkedHashSet;

import tool.compiler.java.constraint.Constraint;

/**
 * base constraint function interface
 */
public interface ConstraintFunction {
	
	/**
	 * @return the meta-constraints
	 */
	public LinkedHashSet<? extends Constraint> getMetaConstraints();
	
	/**
	 * add meta-constraints, after it removes old meta-constraints
	 * @param metaConstraints
	 */
	void setMetaConstraints(Collection<? extends Constraint> metaConstraints);
	
	/**
	 * add meta-constraints
	 * @param metaConstraints
	 */
	void addMetaConstraints(Collection<? extends Constraint> metaConstraints);
	
	/**
	 * add meta-constraint
	 * @param metaConstraint
	 */
	void addMetaConstraint(Constraint metaConstraint);
	
	/**
	 * @return kind of constraint function
	 */
	public String getKind();
}