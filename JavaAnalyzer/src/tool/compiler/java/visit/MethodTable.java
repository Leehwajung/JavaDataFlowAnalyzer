package tool.compiler.java.visit;

import polyglot.ext.jl5.types.TypeVariable;
import polyglot.types.Type;
import tool.compiler.java.util.CollUtil;

import java.util.LinkedList;
import java.util.List;

public class MethodTable extends Table implements MethodOps {
	
	private LinkedList<SetVariable> formalList;
	
	public MethodTable(AbstractObjectInfo abstractObjectInfo, MethodInfo info) {
		super(abstractObjectInfo, info);
		generateFormalList();
	}
	
	@Override
	public List<TypeVariable> getTypeParams() {
		return getInfo().getTypeParams();
	}
	
	@Override
	public List<? extends Type> getFormalTypes() {
		return getInfo().getFormalTypes();
	}
	
	public List<SetVariable> getFormalSetVariables() {
		return formalList;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result =  "M("
				+ CollUtil.getStringOf(getBoundVariables(), '{', '}') + ", "
				+ getContainerType();
		
		if(getTypeVariables().isEmpty()) {
			result += "<>";
		}
		
		result += ", "
				+ getAbstractObjectInfo() + CollUtil.getStringOf(getSubstitutionTypes(), '<', '>') + ", "
				+ getName() + CollUtil.getStringOf(getTypeParams(), '<', '>') + ") = "
				+ CollUtil.getStringOf(getFormalSetVariables(), '(', ')');
		
		if(isNormalMethod()) {
			result += " -> " + getSetVariable();
		}
		
		return result;
	}
	
	/**
	 * @see tool.compiler.java.visit.Table#getInfo()
	 */
	@Override
	public MethodInfo getInfo() {
		return (MethodInfo) super.getInfo();
	}
	
	@Override
	public boolean isConstructor() {
		return getInfo().isConstructor();
	}
	
	@Override
	public boolean isNormalMethod() {
		return getInfo().isNormalMethod();
	}
	
	private void generateFormalList() {
		if(formalList == null) {
			formalList = new LinkedList<SetVariable>();
		} else {
			formalList.clear();
		}
		
		for(Type type: getFormalTypes()) {
			formalList.add(new SetVariable(type));
		}
	}
}