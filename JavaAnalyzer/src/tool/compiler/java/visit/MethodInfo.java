package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5ConstructorInstance;
import polyglot.ext.jl5.types.JL5MethodInstance;
import polyglot.ext.jl5.types.JL5PrimitiveType_c;
import polyglot.ext.jl5.types.JL5ProcedureInstance;
import polyglot.types.MemberInstance;
import polyglot.types.PrimitiveType;
import polyglot.types.ReferenceType;
import polyglot.types.Type;

import java.util.ArrayList;
import java.util.Iterator;

public class MethodInfo extends Info{
	
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
	public ReferenceType getContainerType() {
		return procIns.container();
	}
	
	@Override
	public Type getType() {
		return isNormalMethod() ? ((JL5MethodInstance)procIns).returnType() : new JL5PrimitiveType_c(procIns.container().typeSystem(), PrimitiveType.VOID);
	}
	
	@Override
	public String getName() {
		return isNormalMethod() ? ((JL5MethodInstance)procIns).name() : procIns.container().toString();
	}
	
	public ArrayList<SetVariable> getFormalList() {
		return formalList;
	}
	
	private void generateFormalList() {
		if(formalList == null) {
			formalList = new SetVariableList();
		} else {
			formalList.clear();
		}
		
		for(Type type: procIns.formalTypes()) {
			formalList.add(new SetVariable(type));
		}
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "M("
				+ getContainerType() + ", "
				+ absObjInfoSet + ", "
				+ getName() + ") = "
				+ formalList + " -> "
				+ getSetVariable();
	}
	
	private class SetVariableList extends ArrayList<SetVariable> {
		private static final long serialVersionUID = -3791546666769723203L;
		
		// String conversion
		
		/**
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "(" + toStringWithNoBracket() + ")";
		}
		
		/**
		 * @param list List object to represent string
		 * @return a string representation of list
		 */
		private final String toStringWithNoBracket() {
			Iterator<?> it = iterator();
			
			if (!it.hasNext())
				return "";
			
			StringBuilder sb = new StringBuilder();
			for (;;) {
				sb.append(it.next());
				if (!it.hasNext())
					return sb.toString();
				sb.append(',').append(' ');
			}
		}
	}
}