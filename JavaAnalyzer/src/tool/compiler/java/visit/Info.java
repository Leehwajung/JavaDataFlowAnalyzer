package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5ClassType;
import polyglot.ext.jl5.types.JL5SubstClassType;
import polyglot.ext.jl5.types.TypeVariable;
import polyglot.types.MemberInstance;
import polyglot.types.ReferenceType;
import polyglot.types.Type;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public abstract class Info {
	
	private static JL5ClassType currClass;
	private static Set<TypeVariable> currSubstTypes;
	
	private SetVariable setVar;
	public abstract ReferenceType getContainerType();
	public abstract Type getType();
	public abstract String getName();
	protected abstract void setInstance(MemberInstance memberInstance);
	
	protected Info(MemberInstance memberInstance) {
		setInstance(memberInstance);
		generateSetVariable();
	}
	
	protected void generateSetVariable() {
		setVar = new SetVariable(getType());
	}
	
	public SetVariable getSetVariable() {
		return setVar;
	}
	
	public static void setCurrentClass(JL5ClassType classType) {
		currClass = classType;
		
	}
}