package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5FieldInstance;
import polyglot.ext.jl5.types.JL5ParsedClassType;
import polyglot.ext.jl5.types.TypeVariable;
import polyglot.types.MemberInstance;
import polyglot.types.Type;

import java.util.List;

public class FieldInfo extends TypingInfo {
	
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
	public Type getType() {
		return fldIns.type();
	}
	
	@Override
	public String getName() {
		return fldIns.name();
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
		
		return "F("
				+ getBoundVariables() + ", "
				+ containerStr + ", "
				+ absObjInfoSet + ", "
				+ getName() + ") = "
				+ getSetVariable();
	}
}