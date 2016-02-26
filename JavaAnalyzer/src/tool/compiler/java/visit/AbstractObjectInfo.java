package tool.compiler.java.visit;

import java.util.Collection;
import java.util.Map;

import polyglot.ext.jl5.types.JL5ConstructorInstance;
import polyglot.ext.jl5.types.JL5SubstClassType;
import polyglot.ext.jl5.types.TypeVariable;
import polyglot.types.ReferenceType;

public class AbstractObjectInfo extends InfoVariable {
	
	private JL5ConstructorInstance ctorIns;
	private static long idGen = 1;
	
	/**
	 * @param ctorIns
	 */
	public AbstractObjectInfo(JL5ConstructorInstance constructorInstance) {
		
		setType(constructorInstance.container());
		generateID();
		this.ctorIns = constructorInstance;
	}
	
	@Override
	protected String kind() {
		return "o";
	}

	@Override
	protected long generateIDNum() {
		return idGen++;
	}
	
	public Collection<ReferenceType> getSubstitutionTypes() {
		try {
			return getSubstitutions().values();
		} catch (NullPointerException e) {
			return null;
		}
	}
	
	public Map<TypeVariable, ReferenceType> getSubstitutions() {
		if(getType() instanceof JL5SubstClassType) {
			return ((JL5SubstClassType)getType()).subst().substitutions();
		}
		return null;
	}
	
	public JL5ConstructorInstance getInstance() {
		return ctorIns;
	}
}