package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5ConstructorInstance;
import polyglot.ext.jl5.types.JL5MethodInstance;
import polyglot.ext.jl5.types.JL5ProcedureInstance;
import polyglot.ext.jl5.types.JL5Subst;
import polyglot.ext.jl5.types.JL5TypeSystem;
import polyglot.ext.jl5.types.TypeVariable;
import polyglot.ext.jl5.types.inference.InferenceSolver;
import polyglot.ext.jl5.types.inference.InferenceSolver_c;
import polyglot.types.ReferenceType;
import polyglot.types.Type;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GenericMethodInfo extends MethodInfo {
	
	private JL5ProcedureInstance origProcIns;
	private JL5Subst typeArgs;
	
	public GenericMethodInfo(JL5ProcedureInstance procedureInstance) {
		super(procedureInstance);
		setOrigTypeInstance();
		inferTypeArgs();
	}
	
	@Override
	public List<TypeVariable> getTypeParams() {
		return origProcIns.typeParams();
	}
	
	/**
	 * @return the substitutions
	 */
	public Map<TypeVariable, ReferenceType> getSubstitutions() {
		try {
			return typeArgs.substitutions();
		} catch (NullPointerException e) {
			return null;
		}
	}
	
	/**
	 * @return the actual type arguments
	 */
	@Override
	public List<ReferenceType> getMethodSubstitutionTypes() {
		if(typeArgs != null) {
			LinkedList<ReferenceType> result = new LinkedList<>();
			for(TypeVariable typeVar: getTypeParams()) {
				result.add(typeArgs.substitutions().get(typeVar));
			}
			return result;
		}
		return null;
	}
	
	/**
	 * Infer type arguments for origProcIns, when it is called with arguments of type argTypes.
	 */
	protected final void inferTypeArgs() {
		JL5TypeSystem ts = (JL5TypeSystem) origProcIns.typeSystem();
		InferenceSolver s = inferenceSolver(origProcIns, getFormalTypes(), ts);
		Map<TypeVariable, ReferenceType> m = s.solve(getType());
		if (m != null) {
			typeArgs = (JL5Subst) ts.subst(m);
		} else {
			typeArgs = null;
		}
	}
	
	private final InferenceSolver inferenceSolver(JL5ProcedureInstance pi, List<? extends Type> argTypes,
			JL5TypeSystem ts) {
		return new InferenceSolver_c(pi, argTypes, ts);
	}
	
	/**
	 * @return the original ProcedureInstance
	 */
	public JL5ProcedureInstance getOrigTypeInstance() {
		return origProcIns;
	}
	
	/**
	 * set original procedure instance
	 */
	private final void setOrigTypeInstance() {
		if(isNormalMethod()) {
			origProcIns = (JL5MethodInstance) ((JL5MethodInstance)getTypeInstance()).orig();
		} else if(isConstructor()) {
			origProcIns = (JL5ConstructorInstance) ((JL5ConstructorInstance)getTypeInstance()).orig();
		} else {		// 발생하지 않는 경우임.
			origProcIns = null;
		}
	}
}