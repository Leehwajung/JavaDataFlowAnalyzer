package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5ClassType;
import polyglot.ext.jl5.types.JL5ParsedClassType;
import polyglot.ext.jl5.types.JL5SubstClassType;
import polyglot.ext.jl5.types.TypeVariable;
import polyglot.types.FieldInstance;

import java.util.LinkedHashSet;

/**
 * lam (Y1,..., Yl, Chi_this,Chi_f1,...,Chi_fj). env_C
 */
public class ClassConstraint implements ConstraintFunction {
	
	private MetaSetVariable chi_this;
	private LinkedHashSet<MetaSetVariable> chi_typeVars;
	private LinkedHashSet<MetaSetVariable> chi_fields;
	
	/**
	 * @param type Class Type
	 */
	public ClassConstraint(JL5ClassType type) {
		this.chi_this = new MetaSetVariable(type, false);	// this
		
		if (type instanceof JL5ParsedClassType) {
			this.chi_typeVars = new LinkedHashSet<>();
			
			for(TypeVariable tv : ((JL5ParsedClassType)type).typeVariables()) {
				chi_fields.add(new MetaSetVariable(tv));	// field
			}
		}
		
		this.chi_fields = new LinkedHashSet<>();
		for(FieldInstance field : type.fields()) {
			chi_fields.add(new MetaSetVariable(field.type()));	// field
		}
	}
	
	
	
	
}
