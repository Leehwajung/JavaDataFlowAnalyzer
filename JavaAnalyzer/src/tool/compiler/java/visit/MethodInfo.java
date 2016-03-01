package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5ConstructorInstance;
import polyglot.ext.jl5.types.JL5MethodInstance;
import polyglot.ext.jl5.types.JL5ProcedureInstance;
import polyglot.ext.jl5.types.TypeVariable;
import polyglot.types.MemberInstance;
import polyglot.types.ReferenceType;
import polyglot.types.Type;
import tool.compiler.java.util.CollUtil;

import java.util.List;

public class MethodInfo extends TypingInfo implements MethodOps {
	
	private JL5ProcedureInstance procIns;
	
	/**
	 * @param procedureInstance
	 */
	public MethodInfo(JL5ProcedureInstance procedureInstance) {
		super(procedureInstance);
	}
	
	@Override
	public List<TypeVariable> getBoundVariables() {
		List<TypeVariable> result = super.getBoundVariables();
		result.addAll(getTypeParams());
		return result;
	}
	
	@Override
	public List<TypeVariable> getTypeParams() {
		return procIns.typeParams();
	}
	
	@Override
	public String getName() {
		return isNormalMethod() ? ((JL5MethodInstance)procIns).name() : procIns.container().toString();
	}
	
	@Override
	public List<? extends ReferenceType> getMethodSubstitutionTypes() {
		return getTypeParams();
	}
	
	@Override
	public List<? extends Type> getFormalTypes() {
		return procIns.formalTypes();
	}
	
	@Override
	public Type getType() {
		return isNormalMethod() ? ((JL5MethodInstance)procIns).returnType() : null;
//		return isNormalMethod() ? ((JL5MethodInstance)procIns).returnType() : new JL5PrimitiveType_c(procIns.container().typeSystem(), PrimitiveType.VOID);
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result =  "MI("
				+ CollUtil.getStringOf(getBoundVariables(), '{', '}') + ", "
				+ getContainerType();
		
		if(getTypeVariables().isEmpty()) {
			result += "<>";
		}
		
		result += ", "
				+ getName() + CollUtil.getStringOf(getMethodSubstitutionTypes(), '<', '>') + ") = "
				+ CollUtil.getStringOf(getFormalTypes(), '(', ')');
		
		if(isNormalMethod()) {
			result += " -> " + getType();
		}
		
		return result;
	}
	
	/**
	 * @return the ProcedureInstance
	 */
	@Override
	public JL5ProcedureInstance getTypeInstance() {
		return procIns;
	}
	
	/**
	 * @param ProcedureInstance the ProcedureInstance to set
	 */
	@Override
	protected void setTypeInstance(MemberInstance procedureInstance) {
		this.procIns = (JL5ProcedureInstance) procedureInstance;	// ClassCastingException이 발생하는 경우가 없음.
	}
	
	@Override
	public boolean isConstructor() {
		return procIns instanceof JL5ConstructorInstance;
	}
	
	@Override
	public boolean isNormalMethod() {
		return procIns instanceof JL5MethodInstance;
	}
}