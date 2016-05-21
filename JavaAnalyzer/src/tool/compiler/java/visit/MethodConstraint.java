package tool.compiler.java.visit;

import polyglot.ast.Block;
import polyglot.ast.Stmt;
import polyglot.ext.jl5.types.JL5MethodInstance;
import polyglot.ext.jl5.types.JL5ProcedureInstance;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * lam (Chi1, ..., Chin, Chi_ret). Constraint Set					<br>
 * C{AOSc}.m <: (D1{AOS1}, ..., Dn{AOSn}) --> E{AOSe}
 */
public class MethodConstraint implements ConstraintFunction {
	
	private Constraint invokeConstraint;
	private LinkedHashSet<Constraint> bodyConstraints;
	
	/**
	 * @param 
	 */
	public MethodConstraint(MetaSetVariable caos, JL5ProcedureInstance m, Collection<MetaSetVariable> daoss, MetaSetVariable eaos, Block body) {
		this.invokeConstraint = new InvokeMth(caos, m, daoss, eaos);
		this.bodyConstraints = createMetaConstraints(body);
	}
	
	public MethodConstraint(JL5MethodInstance cm, Collection<MetaSetVariable> daoss, MetaSetVariable eaos, Block body) {
		this.invokeConstraint = new InvokeStaticMth(cm, daoss, eaos);
		this.bodyConstraints = createMetaConstraints(body);
	}
	
	private LinkedHashSet<Constraint> createMetaConstraints(Block body) {
		for(Stmt stmt : body.statements()) {
			
		}
		
		return null;
	}
}