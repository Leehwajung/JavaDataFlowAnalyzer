package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5ConstructorInstance;
import polyglot.ext.jl5.types.JL5MethodInstance;
import polyglot.ext.jl5.types.JL5PrimitiveType_c;
import polyglot.ext.jl5.types.JL5ProcedureInstance;
import polyglot.ext.jl5.types.TypeVariable;
import polyglot.types.MemberInstance;
import polyglot.types.PrimitiveType;
import polyglot.types.Type;
import tool.compiler.java.util.ExtCollection;

import java.util.ArrayList;
import java.util.List;

public class MethodInfo extends TypingInfo{
	
	private JL5ProcedureInstance procIns;
	private SetVariableList formalList;
	private AbstractObjectInfoSet absObjInfoSet;
	
	/**
	 * @param fieldInstance
	 */
	public MethodInfo(JL5ProcedureInstance procedureInstance) {
		super(procedureInstance);
		generateFormalList();
	}
	
	@Override
	protected void setInstance(MemberInstance memberInstance) {
		this.procIns = (JL5ProcedureInstance) memberInstance;
	}
	
	public boolean isConstructor() {
		return procIns instanceof JL5ConstructorInstance;
	}
	
	public boolean isNormalMethod() {
		return procIns instanceof JL5MethodInstance;
	}
	
	@Override
	public Type getType() {
//		return isNormalMethod() ? ((JL5MethodInstance)procIns).returnType() : new JL5PrimitiveType_c(procIns.container().typeSystem(), PrimitiveType.VOID);
		return isNormalMethod() ? ((JL5MethodInstance)procIns).returnType() : null;
	}
	
	@Override
	public String getName() {
		return isNormalMethod() ? ((JL5MethodInstance)procIns).name() : procIns.container().toString();
	}
	
	public ArrayList<SetVariable> getFormalList() {
		return (ArrayList<SetVariable>) formalList.getCollection();
	}
	
	private void generateFormalList() {
		if(formalList == null) {
			formalList = new SetVariableList(new ArrayList<SetVariable>());
		} else if(!formalList.isNull()) {
			formalList.setCollection(new ArrayList<SetVariable>());
		} else {
			formalList.getCollection().clear();
		}
		
		for(Type type: procIns.formalTypes()) {
			formalList.getCollection().add(new SetVariable(type));
		}
	}
	
	public List<TypeVariable> getTypeParams() {
		return procIns.typeParams();
	}
	
	@Override
	public List<TypeVariable> getBoundVariables() {
		List<TypeVariable> result = super.getBoundVariables();
		result.addAll(getTypeParams());
		return result;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String containerStr = getContainerType().toString();
		if(getTypeVariables().isEmpty()) {
				containerStr += "<>";
		}
		
		String result =  "M("
				+ getBoundVariables() + ", "
				+ containerStr + ", "
				+ absObjInfoSet + ", "
				+ getName() + ") = "
				+ formalList;
		
		if(isNormalMethod()) {
			result += " -> " + getSetVariable();
		}
		
		return result;
	}
	
	private class SetVariableList extends ExtCollection<SetVariable> {
		
		public SetVariableList(ArrayList<SetVariable> setVariableList) {
			super(setVariableList);
		}

		@Override
		public String toString() {
			return "(" + super.toString() + ")";
		}
	}
}