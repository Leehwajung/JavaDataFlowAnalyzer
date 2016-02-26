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



//private JL5ProcedureInstance procIns;
//private SetVariableList formalList;
//
//
//
//
//
///**
// * @param fieldInstance
// */
//public MethodInfo(JL5ProcedureInstance procedureInstance) {
//	super(procedureInstance);
//	generateFormalList();
//}
//
//@Override
//protected void setInstance(MemberInstance memberInstance) {
//	this.procIns = (JL5ProcedureInstance) memberInstance;
//}
//
//public boolean isConstructor() {
//	return procIns instanceof JL5ConstructorInstance;
//}
//
//public boolean isNormalMethod() {
//	return procIns instanceof JL5MethodInstance;
//}
//
//@Override
//public Type getType() {
////	return isNormalMethod() ? ((JL5MethodInstance)procIns).returnType() : new JL5PrimitiveType_c(procIns.container().typeSystem(), PrimitiveType.VOID);
//	return isNormalMethod() ? ((JL5MethodInstance)procIns).returnType() : null;
//}
//
//@Override
//public String getName() {
//	return isNormalMethod() ? ((JL5MethodInstance)procIns).name() : procIns.container().toString();
//}
//
//public ArrayList<SetVariable> getFormalList() {
//	return (ArrayList<SetVariable>) formalList.getCollection();
//}
//
//private void generateFormalList() {
//	if(formalList == null) {
//		formalList = new SetVariableList(new ArrayList<SetVariable>());
//	} else if(!formalList.isNull()) {
//		formalList.setCollection(new ArrayList<SetVariable>());
//	} else {
//		formalList.getCollection().clear();
//	}
//	
//	for(Type type: procIns.formalTypes()) {
//		formalList.getCollection().add(new SetVariable(type));
//	}
//}
//
//public List<TypeVariable> getTypeParams() {
//	return procIns.typeParams();
//}
//
//@Override
//public List<TypeVariable> getBoundVariables() {
//	List<TypeVariable> result = super.getBoundVariables();
//	result.addAll(getTypeParams());
//	return result;
//}
//
///**
// * @see java.lang.Object#toString()
// */
//@Override
//public String toString() {
//	String containerStr = getContainerType().toString();
//	if(getTypeVariables().isEmpty()) {
//			containerStr += "<>";
//	}
//	
//	String result =  "M("
//			+ "{" + CollUtil.toString(getBoundVariables()) + "}, "
//			+ containerStr + ", "
//			+ getName() + ") = "
//			+ formalList;
//	
//	if(isNormalMethod()) {
//		result += " -> " + getFormalList();
//	}
//	
//	return result;
//}
//
//private class SetVariableList extends ExtCollection<SetVariable> {
//	
//	public SetVariableList(ArrayList<SetVariable> setVariableList) {
//		super(setVariableList);
//	}
//
//	@Override
//	public String toString() {
//		return "(" + super.toString() + ")";
//	}
//}