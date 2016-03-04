package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5Subst;
import polyglot.ext.jl5.types.TypeVariable;
import polyglot.types.ReferenceType;
import polyglot.types.Type;
import tool.compiler.java.util.CollUtil;

import java.util.LinkedList;
import java.util.List;

public class MethodTable extends AbstractTable implements MethodOps {
	
	private LinkedList<SetVariable> formalList;
	
	public MethodTable(AbstractObjectInfo abstractObjectInfo, MethodInfo info) {
		super(abstractObjectInfo, info);
		generateFormalList();
	}
	
	@Override
	public List<TypeVariable> getTypeParams() {
		return getInfo().getTypeParams();
	}
	
	public JL5Subst getMethodSubstitutions() {
		if(getInfo() instanceof GenericMethodInfo) {
			return ((GenericMethodInfo)getInfo()).getSubstitutions();
		}
		return null;
	}
	
	@Override
	public List<? extends ReferenceType> getMethodSubstitutionTypes() {
		return getInfo().getMethodSubstitutionTypes();
	}
	
	@Override
	public List<? extends Type> getFormalTypes() {
		return getInfo().getFormalTypes();
	}
	
	public List<SetVariable> getFormalSetVariables() {
		return formalList;
	}
	
	/**
	 * @see tool.compiler.java.visit.AbstractTable#getInfo()
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
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result =  "M("
				+ CollUtil.getStringOf(getBoundVariables(), '{', '}') + ", "
				+ getContainerBaseType();
		
		if(getTypeVariables().isEmpty()) {
			result += "<>";
		}
		
		result += ", "
				+ getAbstractObjectInfo() + CollUtil.getStringOf(getContainerSubstitutionTypes(), '<', '>') + ", "
				+ getName() + CollUtil.getStringOf(getMethodSubstitutionTypes(), '<', '>') + ") = "
				+ CollUtil.getStringOf(getFormalSetVariables(), '(', ')');
		
		if(isNormalMethod()) {
			result += " -> " + getSetVariable();
		}
		
		return result;
	}
}