package tool.compiler.java.visit;

import java.util.List;
import java.util.Map.Entry;

import polyglot.ext.jl5.types.JL5ClassType;
import polyglot.ext.jl5.types.JL5FieldInstance;
import polyglot.ext.jl5.types.JL5ReferenceType;
import polyglot.ext.jl5.types.JL5SubstClassType;
import polyglot.ext.jl5.types.TypeVariable;
import polyglot.ext.param.types.Subst;
import polyglot.types.MemberInstance;
import polyglot.types.ReferenceType;
import polyglot.types.Type;

public class FieldInfo extends Info {
	
	private JL5FieldInstance fldIns;
	private AbstractObjectInfoSet absObjInfoSet;
	
	/**
	 * @param fieldInstance
	 */
	public FieldInfo(JL5FieldInstance fieldInstance) {
		super(fieldInstance);
	}
	
	@Override
	protected void setInstance(MemberInstance memberInstance) {
		fldIns = (JL5FieldInstance) memberInstance;
	}
	
	@Override
	public ReferenceType getContainerType() {
		return fldIns.container();
	}
	
	@Override
	public Type getType() {
		return fldIns.type();
	}
	
//	@Override
//	public List<TypeVariable> getBoundVariables() {
//
//		return ;
//	}
	
	@Override
	public String getName() {
		return fldIns.name();
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "F("
				+ getContainerType() + ", "
				+ absObjInfoSet + ", "
				+ getName() + ") = "
				+ getSetVariable();
	}
}