package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5ClassType;
import polyglot.ext.jl5.types.JL5ParsedClassType;
import polyglot.ext.jl5.types.JL5SubstClassType;
import polyglot.ext.jl5.types.TypeVariable;
import polyglot.types.FieldInstance;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * lam (Y1,..., Yl, Chi_this,Chi_f1,...,Chi_fj). env_C
 */
public class ClassConstraint implements ConstraintFunction {
	
	private JL5ClassType clz;
	private MetaSetVariable chi_this;
	private LinkedHashSet<MetaSetVariable> chi_typeVars;
	private LinkedHashSet<MetaSetVariable> chi_fields;
	
	/**
	 * @param type Class Type
	 */
	public ClassConstraint(JL5ClassType type) {
		this.clz = type;
		this.chi_this = new MetaSetVariable(type);
	}
	
	public ClassConstraint(JL5ClassType type, Collection<MetaSetVariable> chiTypeVars) {
		this(type);
		if(chiTypeVars == null) {
			this.chi_typeVars = null;
		} else {
			this.chi_typeVars = new LinkedHashSet<>(chiTypeVars);
		}
	}
	
	public ClassConstraint(JL5ClassType type, Collection<MetaSetVariable> chiTypeVars, Collection<MetaSetVariable> chiFields) {
		this(type, chiTypeVars);
		if(chiFields == null) {
			this.chi_fields = null;
		} else {
			this.chi_fields = new LinkedHashSet<>(chiFields);
		}
	}
	
	public ClassConstraint(MetaSetVariable chiThis) {
		this.clz = (JL5ClassType) chiThis.getType();
		this.chi_this = chiThis;
	}
	
	public ClassConstraint(MetaSetVariable chiThis, Collection<MetaSetVariable> chiTypeVars) {
		this(chiThis);
		if(chiTypeVars == null) {
			this.chi_typeVars = null;
		} else {
			this.chi_typeVars = new LinkedHashSet<>(chiTypeVars);
		}
	}
	
	public ClassConstraint(MetaSetVariable chiThis, Collection<MetaSetVariable> chiTypeVars, Collection<MetaSetVariable> chiFields) {
		this(chiThis, chiTypeVars);
		if(chiFields == null) {
			this.chi_fields = null;
		} else {
			this.chi_fields = new LinkedHashSet<>(chiFields);
		}
	}
	
	/**
	 * @param type Class Type
	 */
	public ClassConstraint(JL5ClassType type, boolean autoGen) {
		this(type);		//this
		
		if(autoGen) {
			if (type instanceof JL5ParsedClassType) {
				this.chi_typeVars = new LinkedHashSet<>();
				
				for(TypeVariable tv : ((JL5ParsedClassType)type).typeVariables()) {
					this.chi_typeVars.add(new MetaSetVariable(tv));	// field
				}
			}
			
			this.chi_fields = new LinkedHashSet<>();
			for(FieldInstance field : type.fields()) {
				this.chi_fields.add(new MetaSetVariable(field.type()));	// field
			}
		}
	}
	
	/**
	 * @return the clz
	 */
	public JL5ClassType getClz() {
		return clz;
	}
	
	/**
	 * @return the chi_this
	 */
	public MetaSetVariable getChiThis() {
		return chi_this;
	}
	
	/**
	 * @return the chi_typeVars
	 */
	public LinkedHashSet<MetaSetVariable> getChiTypeVars() {
		return chi_typeVars;
	}
	
	/**
	 * @return the chi_fields
	 */
	public LinkedHashSet<MetaSetVariable> getChiFields() {
		return chi_fields;
	}
	
	
	public ConstraintsPair apply() {
		return null;
	}
}