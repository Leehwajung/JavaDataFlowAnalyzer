package tool.compiler.java.env;

import polyglot.ast.TypeNode;
import polyglot.ext.jl5.types.JL5ArrayType;
import polyglot.ext.jl5.types.JL5ClassType;
import polyglot.ext.jl5.types.JL5FieldInstance;
import polyglot.ext.jl5.types.JL5ParsedClassType;
import polyglot.ext.jl5.types.TypeVariable;
import polyglot.types.FieldInstance;
import polyglot.types.Type;
import tool.compiler.java.aos.ArrayMetaSetVariable;
import tool.compiler.java.aos.MetaSetVariable;
import tool.compiler.java.constraint.Constraint;
import tool.compiler.java.util.CollUtil;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * lam (Y1, ..., Yl, Chi_this, Chi_f1, ..., Chi_fj). env_C
 */
public class ClassConstraint implements ConstraintFunction {
	
	private JL5ClassType clz;
	private MetaSetVariable chi_this;
	private LinkedHashSet<MetaSetVariable> chi_typeVars;
	private LinkedHashMap<JL5FieldInstance, MetaSetVariable> chi_fields;
	
	private ClassConstraint outerClassConstraint = null;	// Not inheritance, but containment relationship
	private LinkedHashSet<ClassConstraint> innerClassConstraints;
	private LinkedHashSet<CodeConstraint> codeConstraints;	// MethodConstraint / InitializerConstraint
	private LinkedHashSet<Constraint> fieldConstraints;		// for Field Initialization
	
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
	
	public ClassConstraint(JL5ClassType type, Collection<MetaSetVariable> chiTypeVars, Map<JL5FieldInstance, MetaSetVariable> chiFields) {
		this(type, chiTypeVars);
		if(chiFields == null) {
			this.chi_fields = null;
		} else {
			this.chi_fields = new LinkedHashMap<>(chiFields);
		}
	}
	
	@Deprecated
	public ClassConstraint(MetaSetVariable chiThis) {
		try {
			this.clz = (JL5ClassType) chiThis.getType();
			this.chi_this = chiThis;
		} catch (ClassCastException e) {
			throw new IllegalArgumentException("The type of MetaSetVariable is NOT class type. The type is " + chiThis.getType() + ".");
		}
	}
	
	@Deprecated
	public ClassConstraint(MetaSetVariable chiThis, Collection<MetaSetVariable> chiTypeVars) {
		this(chiThis);
		if(chiTypeVars == null) {
			this.chi_typeVars = null;
		} else {
			this.chi_typeVars = new LinkedHashSet<>(chiTypeVars);
		}
	}
	
	@Deprecated
	public ClassConstraint(MetaSetVariable chiThis, Collection<MetaSetVariable> chiTypeVars, Map<JL5FieldInstance, MetaSetVariable> chiFields) {
		this(chiThis, chiTypeVars);
		if(chiFields == null) {
			this.chi_fields = null;
		} else {
			this.chi_fields = new LinkedHashMap<>(chiFields);
		}
	}
	
	/**
	 * @param type Class Type
	 */
	public ClassConstraint(JL5ClassType type, boolean autoGenerate) {
		this(type);		// this
		
		if(autoGenerate) {
			if (type instanceof JL5ParsedClassType) {
				generateTypeVars((JL5ParsedClassType) type);
			}
			
			generateFields(type);
		}
	}
	
	private void generateTypeVars(JL5ParsedClassType type) {
		List<TypeVariable> typeVars = type.typeVariables();
		
		if(!typeVars.isEmpty()) {
			this.chi_typeVars = new LinkedHashSet<>();
			
			for(TypeVariable tv : typeVars) {
				this.chi_typeVars.add(new MetaSetVariable(tv));	// type Var
			}
		} else {
			this.chi_typeVars = null;
		}
	}
	
	private void generateFields(JL5ClassType type) {
		List<? extends FieldInstance> fields = type.fields();
		
		if(!fields.isEmpty()) {
			this.chi_fields = new LinkedHashMap<>();
			for(FieldInstance field : fields) {
				Type fieldType = field.type();
				MetaSetVariable fieldMSV;
				if(!(fieldType instanceof JL5ArrayType)) {	// For Scalar Type Field
					fieldMSV = new MetaSetVariable(fieldType);
				} else {									// For Array Type Field
					fieldMSV = new ArrayMetaSetVariable((JL5ArrayType) fieldType);
				}
				this.chi_fields.put((JL5FieldInstance)field, fieldMSV);	// field
			}
		} else {
			this.chi_fields = null;
		}
	}
	
	
//	public ConstraintsPair apply() {
//		return null;
//	}
	
	
	/**
	 * @return the class
	 */
	public JL5ClassType getClassType() {
		return clz;
	}
	
	/**
	 * @return the chi_this
	 */
	public MetaSetVariable getThis() {
		return chi_this;
	}
	
	/**
	 * @return the chi_this
	 */
	public MetaSetVariable getThis(TypeNode qualifier) {
		if(qualifier == null) {
			return getThis();
		}
		if(qualifier.type().equals(chi_this.getType())) {
			return chi_this;
		} else {
			return outerClassConstraint.getThis(qualifier);
		}
	}
	
	/**
	 * @return the chi_this
	 */
	public MetaSetVariable getSuper() {
		return chi_this;
	}
	
	/**
	 * TODO: 미완성, spuer에 대하여 대응 필요
	 * @param qualifier
	 * @return
	 */
	public MetaSetVariable getSuper(TypeNode qualifier) {
		if(qualifier == null) {
			return getSuper();
		}
		if(qualifier.type().equals(chi_this.getType())) {
			return chi_this;
		} else {
			return outerClassConstraint.getSuper(qualifier);
		}
	}
	
	/**
	 * @return the chi_typeVars
	 */
	public LinkedHashSet<MetaSetVariable> getTypeVars() {
		return chi_typeVars;
	}
	
	/**
	 * @param chi_typeVars the chi_typeVars to set
	 */
	public void setTypeVars(Collection<MetaSetVariable> chi_typeVars) {
		if(this.chi_typeVars == null) {
			this.chi_typeVars = new LinkedHashSet<>(chi_typeVars);
		} else {
			this.chi_typeVars.clear();
			this.chi_typeVars.addAll(chi_typeVars);
		}
	}
	
	/**
	 * @param chi_typeVars the chi_typeVars to add
	 */
	public void addTypeVars(Collection<MetaSetVariable> chi_typeVars) {
		if(this.chi_typeVars == null) {
			this.chi_typeVars = new LinkedHashSet<>(chi_typeVars);
		} else {
			this.chi_typeVars.addAll(chi_typeVars);
		}
	}
	
	/**
	 * @param chi_typeVar
	 */
	public void addTypeVar(MetaSetVariable chi_typeVar) {
		try {
			this.chi_typeVars.add(chi_typeVar);
		} catch (NullPointerException e) {
			this.chi_typeVars = new LinkedHashSet<>();
			this.chi_typeVars.add(chi_typeVar);
		}
	}
	
	/**
	 * @return the chi_fields
	 */
	public LinkedHashSet<MetaSetVariable> getFields() {
		return new LinkedHashSet<>(chi_fields.values());
	}
	
	/**
	 * @return the chi_fields
	 */
	public LinkedHashMap<JL5FieldInstance, MetaSetVariable> getFieldMap() {
		return new LinkedHashMap<>(chi_fields);
	}
	
	/**
	 * @return the chi_fields
	 */
	public MetaSetVariable getField(JL5FieldInstance field) {
		return chi_fields.get(field);
	}
	
	/**
	 * @return the chi_fields
	 */
	public JL5FieldInstance getField(MetaSetVariable chi_field) {
		if(chi_fields.containsValue(chi_field)) {
			for(Entry<JL5FieldInstance, MetaSetVariable> entry : chi_fields.entrySet()) {
				if(entry.getValue() == chi_field) {
					return entry.getKey();
				}
			}
			return null;
		} else {
			return null;
		}
	}
	
	/**
	 * @param chi_fields the chi_fields to set
	 */
	@Deprecated
	public void setFields(Map<JL5FieldInstance, MetaSetVariable> chi_fields) {
		if(this.chi_fields == null) {
			this.chi_fields = new LinkedHashMap<>(chi_fields);
		} else {
			this.chi_fields.clear();
			this.chi_fields.putAll(chi_fields);
		}
	}
	
	/**
	 * @param chi_fields the chi_fields to add
	 */
	@Deprecated
	public void addFields(Map<JL5FieldInstance, MetaSetVariable> chi_fields) {
		if(this.chi_fields == null) {
			this.chi_fields = new LinkedHashMap<>(chi_fields);
		} else {
			this.chi_fields.putAll(chi_fields);
		}
	}
	
	/**
	 * @param field
	 * @param chi_field
	 */
	@Deprecated
	public void addField(JL5FieldInstance field, MetaSetVariable chi_field) {
		try {
			this.chi_fields.put(field, chi_field);
		} catch (NullPointerException e) {
			this.chi_fields = new LinkedHashMap<>();
			this.chi_fields.put(field, chi_field);
		}
	}
	
	
	/**
	 * @return the outerClassConstraint
	 */
	public ClassConstraint getOuter() {
		return outerClassConstraint;
	}
	
	/**
	 * @param outerClassConstraint the outerClassConstraint to set
	 */
	public void setOuter(ClassConstraint outerClassConstraint) {
		this.outerClassConstraint = outerClassConstraint;
	}
	
	/**
	 * @return innerClassConstraints
	 */
	public LinkedHashSet<ClassConstraint> getInners() {
		try {
			return new LinkedHashSet<>(innerClassConstraints);
		} catch (NullPointerException e) {
			return null;
		}
	}
	
	/**
	 * @param innerClassConstraints innerClassConstraints to set
	 */
	public void setInners(Collection<ClassConstraint> innerClassConstraints) {
		if(innerClassConstraints != null) {
			if(this.innerClassConstraints == null) {
				this.innerClassConstraints = new LinkedHashSet<>(innerClassConstraints);
			} else {
				this.innerClassConstraints.clear();
				this.innerClassConstraints.addAll(innerClassConstraints);
			}
		} else {
			this.fieldConstraints = null;
		}
	}
	
	/**
	 * @param innerClassConstraints innerClassConstraints to add
	 */
	public void addInners(Collection<ClassConstraint> innerClassConstraints) {
		if(innerClassConstraints != null) {
			if(this.innerClassConstraints == null) {
				this.innerClassConstraints = new LinkedHashSet<>(innerClassConstraints);
			} else {
				this.innerClassConstraints.addAll(innerClassConstraints);
			}
		}
	}
	
	/**
	 * @param innerClassConstraint the innerClassConstraint to add
	 */
	public void addInner(ClassConstraint innerClassConstraint) {
		if(innerClassConstraint != null) {
			try {
				this.innerClassConstraints.add(innerClassConstraint);
			} catch (NullPointerException e) {
				this.innerClassConstraints = new LinkedHashSet<>();
				this.innerClassConstraints.add(innerClassConstraint);
			}
		}
	}
	
	/**
	 * @return MethodConstraints and/or InitializerConstraints
	 */
	public LinkedHashSet<? extends CodeConstraint> getCodeConstraints() {
		try {
			return new LinkedHashSet<>(codeConstraints);
		} catch (NullPointerException e) {
			return null;
		}
	}
	
	/**
	 * @param codeConstraints MethodConstraints and/or InitializerConstraints to set
	 */
	public void setCodeConstraints(Collection<? extends CodeConstraint> codeConstraints) {
		if(codeConstraints != null) {
			if(this.codeConstraints == null) {
				this.codeConstraints = new LinkedHashSet<>(codeConstraints);
			} else {
				this.codeConstraints.clear();
				this.codeConstraints.addAll(codeConstraints);
			}
		} else {
			this.codeConstraints = null;
		}
	}
	
	/**
	 * @param codeConstraints MethodConstraints and/or InitializerConstraints to add
	 */
	public void addCodeConstraints(Collection<? extends CodeConstraint> codeConstraints) {
		if(codeConstraints != null) {
			if(this.codeConstraints == null) {
				this.codeConstraints = new LinkedHashSet<>(codeConstraints);
			} else {
				this.codeConstraints.addAll(codeConstraints);
			}
		}
	}
	
	/**
	 * @param codeConstraint MethodConstraint or InitializerConstraint to add
	 */
	public void addCodeConstraint(CodeConstraint codeConstraint) {
		if(codeConstraint != null) {
			try {
				this.codeConstraints.add(codeConstraint);
			} catch (NullPointerException e) {
				this.codeConstraints = new LinkedHashSet<>();
				this.codeConstraints.add(codeConstraint);
			}
		}
	}
	
	/**
	 * @return fieldConstraints
	 */
	@Override
	public LinkedHashSet<Constraint> getMetaConstraints() {
		try {
			return new LinkedHashSet<>(fieldConstraints);
		} catch (NullPointerException e) {
			return null;
		}
	}
	
	/**
	 * @param fieldConstraints fieldConstraints to set
	 */
	@Override
	public void setMetaConstraints(Collection<? extends Constraint> fieldConstraints) {
		if(fieldConstraints != null) {
			if(this.fieldConstraints == null) {
				this.fieldConstraints = new LinkedHashSet<>(fieldConstraints);
			} else {
				this.fieldConstraints.clear();
				this.fieldConstraints.addAll(fieldConstraints);
			}
		} else {
			this.fieldConstraints = null;
		}
	}
	
	/**
	 * @param fieldConstraints fieldConstraints to add
	 */
	@Override
	public void addMetaConstraints(Collection<? extends Constraint> fieldConstraints) {
		if(fieldConstraints != null) {
			if(this.fieldConstraints == null) {
				this.fieldConstraints = new LinkedHashSet<>(fieldConstraints);
			} else {
				this.fieldConstraints.addAll(fieldConstraints);
			}
		}
	}
	
	/**
	 * @param fieldConstraint the fieldConstraint to add
	 */
	@Override
	public void addMetaConstraint(Constraint fieldConstraint) {
		if(fieldConstraint != null) {
			try {
				this.fieldConstraints.add(fieldConstraint);
			} catch (NullPointerException e) {
				this.fieldConstraints = new LinkedHashSet<>();
				this.fieldConstraints.add(fieldConstraint);
			}
		}
	}
	
	@Override
	public String getKind() {
		return this.getClass().getSimpleName();
	}
	
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result =  "CC " + clz + ": λ(";
		result += (chi_typeVars != null && !chi_typeVars.isEmpty()) ? (CollUtil.getStringOf(chi_typeVars) + ", ") : "";
		result += chi_this;
		result += (chi_fields != null && !chi_fields.isEmpty()) ? (", " + CollUtil.getStringOf(chi_fields.values())) : "";
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
		result = prime * result + ((clz == null) ? 0 : clz.hashCode());
		result = prime * result + ((chi_this == null) ? 0 : chi_this.hashCode());
		result = prime * result + ((chi_typeVars == null) ? 0 : chi_typeVars.hashCode());
		result = prime * result + ((chi_fields == null) ? 0 : chi_fields.hashCode());
		result = prime * result + ((fieldConstraints == null) ? 0 : fieldConstraints.hashCode());
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
		ClassConstraint other = (ClassConstraint) obj;
		if (clz == null) {
			if (other.clz != null) {
				return false;
			}
		} else if (!clz.equals(other.clz)) {
			return false;
		}
		if (chi_this == null) {
			if (other.chi_this != null) {
				return false;
			}
		} else if (!chi_this.equals(other.chi_this)) {
			return false;
		}
		if (chi_typeVars == null) {
			if (other.chi_typeVars != null) {
				return false;
			}
		} else if (!chi_typeVars.equals(other.chi_typeVars)) {
			return false;
		}
		if (chi_fields == null) {
			if (other.chi_fields != null) {
				return false;
			}
		} else if (!chi_fields.equals(other.chi_fields)) {
			return false;
		}
		if (fieldConstraints == null) {
			if (other.fieldConstraints != null) {
				return false;
			}
		} else if (!fieldConstraints.equals(other.fieldConstraints)) {
			return false;
		}
		return true;
	}
}