package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5ParsedClassType;
import polyglot.ext.jl5.types.JL5SubstClassType;
import polyglot.ext.jl5.types.TypeVariable;
import polyglot.types.ClassType;
import polyglot.types.MemberInstance;
import polyglot.types.ReferenceType;
import polyglot.types.Type;

import java.util.LinkedList;
import java.util.List;

public abstract class TypingInfo implements Info, Ops {
	
//	private static JL5ClassType currClass;
//	private static Set<TypeVariable> currSubstTypes;
	
	private ReferenceType container;
	
	protected TypingInfo(MemberInstance memberInstance) {
		setTypeInstance(memberInstance);
		setContainerType(memberInstance.container());
	}
	
	/**
	 * get Delta
	 * @return
	 */
	@Override
	public List<TypeVariable> getBoundVariables() {
		try {
			return getBoundVariables((JL5ParsedClassType)container, new LinkedList<TypeVariable>());
		} catch (ClassCastException e) {	// 무시 가능 (println() 메서드 호출은 확인용)
//			System.err.println("getBoundVariables(): ClassCastException: " + container.getClass());
			return null;
		}
	}
	
	/**
	 * get Delta
	 * @param classType
	 * @param boundVariables
	 * @return
	 */
	private List<TypeVariable> getBoundVariables(JL5ParsedClassType classType, List<TypeVariable> boundVariables) {
		ClassType outer = classType.outer();
		List<TypeVariable> result;
		if(outer != null && outer instanceof JL5ParsedClassType) {
			result = getBoundVariables((JL5ParsedClassType) outer, boundVariables);
		} else {
			result = boundVariables;
		}
		boundVariables.addAll(classType.typeVariables());
		return result;
	}
	
	/**
	 * get Type Variables
	 * @return
	 */
	@Override
	public List<TypeVariable> getTypeVariables() {
		try {
			return ((JL5ParsedClassType) container).typeVariables();
		} catch (ClassCastException e) {	// 무시 가능 (println() 메서드 호출은 확인용)
//			System.err.println("getTypeVariables(): ClassCastException: " + container.getClass());
			return null;
		}
	}
	
	/**
	 * get Class
	 * @return
	 */
	@Override
	public ReferenceType getContainerType() {
		return container;
	}
	
	@Override
	public ReferenceType getContainerBaseType() {
		if(container instanceof JL5SubstClassType) {
			return ((JL5SubstClassType)container).base();
		}
		return getContainerType();
	}
	
	/**
	 * @param Container Type
	 */
	private void setContainerType(ReferenceType containerType) {
		this.container = containerType;
	}
	
	@Override
	public Type getBaseType() {
		Type type = getType();
		if(type != null && type instanceof JL5SubstClassType) {
			return ((JL5SubstClassType)type).base();
		}
		return type;
	}
	
	/**
	 * @return the Instance
	 */
	public abstract MemberInstance getTypeInstance();

	/**
	 * @param Instance the Instance to set
	 */
	protected abstract void setTypeInstance(MemberInstance memberInstance);

	

	

	

	
	
	
	
	
//	protected class TypeVariableList extends ExtCollection<TypeVariable> {
//		
//		public TypeVariableList(ArrayList<TypeVariable> typeVariableList) {
//			super(typeVariableList);
//		}
//		
//		@Override
//		public String toString() {
//			return "{" + super.toString() + "}";
//		}
//	}
	
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