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
		} catch (ClassCastException e) {	// 무시 가능
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
	 * @return	타입 변수 리스트
	 */
	@Override
	public List<TypeVariable> getTypeVariables() {
		try {
			return ((JL5ParsedClassType) container).typeVariables();
		} catch (ClassCastException e) {	// 무시 가능
//			System.err.println("getTypeVariables(): ClassCastException: " + container.getClass());
			return null;
		}
	}
	
	/**
	 * get Class
	 * @return	포함되어 있는 클래스의 타입
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
	 * @param containerType
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
}