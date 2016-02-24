package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5ParsedClassType;
import polyglot.ext.jl5.types.TypeVariable;
import polyglot.types.MemberInstance;
import polyglot.types.ReferenceType;
import tool.compiler.java.util.ExtCollection;

import java.util.ArrayList;
import java.util.List;

public abstract class TypingInfo implements Info {
	
//	private static JL5ClassType currClass;
//	private static Set<TypeVariable> currSubstTypes;
	
	private SetVariable setVar;
	private ReferenceType container;
	
	public abstract String getName();
	protected abstract void setInstance(MemberInstance memberInstance);
	
	protected TypingInfo(MemberInstance memberInstance) {
		setInstance(memberInstance);
		if(getType() != null) {
			generateSetVariable();
		}
		setContainerType(memberInstance.container());
	}
	
	public void setContainerType(ReferenceType containerType) {
		this.container = containerType;
	}
	
	public ReferenceType getContainerType() {
		return container;
	}
	
	protected void generateSetVariable() {
		setVar = new SetVariable(getType());
	}
	
	public SetVariable getSetVariable() {
		return setVar;
	}
	
	public List<TypeVariable> getTypeVariables() {
		return ((JL5ParsedClassType) container).typeVariables();
		// TODO: ClassCastException 처리할 것. (나오는 경우는 확인하지 못했음)
	}
	
	public List<TypeVariable> getBoundVariables() {
		return getBoundVariablesSubMethod((JL5ParsedClassType)container, new ArrayList<TypeVariable>());
	}
	
	private List<TypeVariable> getBoundVariablesSubMethod(JL5ParsedClassType classType, List<TypeVariable> boundVariables) {
		boundVariables.addAll(classType.typeVariables());
		if(classType.outer() != null) {
			return getBoundVariablesSubMethod((JL5ParsedClassType) classType.outer(), boundVariables);
		}
		return boundVariables;
	}
	
	protected class TypeVariableList extends ExtCollection<TypeVariable> {
		
		public TypeVariableList(ArrayList<TypeVariable> typeVariableList) {
			super(typeVariableList);
		}
		
		@Override
		public String toString() {
			return "{" + super.toString() + "}";
		}
	}
	
//	public static void setCurrentClass(JL5ClassType classType) {
//		currClass = classType;
//		
//	}
//	
//	public static List<TypeVariable> getSubstTypes() {
//		/* Substitution Class Type */
//		if (currClass instanceof JL5SubstClassType) { // 제네릭 클래스인 경우
////			addToUsedClasses(((JL5SubstClassType) classType).base()); // Base
////			for (Entry<TypeVariable, ReferenceType> substType 
////					: ((JL5SubstClassType) classType).subst().substitutions().entrySet()) {
////				addToUsedClasses((JL5ClassType) substType.getValue()); // Substitutions
////			}
//			
//			currSubstTypes = ((JL5SubstClassType) currClass).subst().substitutions().keySet();
//		}
//		
////		/* Class Type */
////		else { // (제네릭이 아닌) 일반 클래스인 경우
////			addToUsedClasses(classType);
////		}
//	}
	

}