package tool.compiler.java.visit;

import tool.compiler.java.util.CollUtil;

public class FieldTable extends Table implements FieldOps {
	
	public FieldTable(AbstractObjectInfo abstractObjectInfo, FieldInfo fieldInfo) {
		super(abstractObjectInfo, fieldInfo);
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
				+ CollUtil.getStringOf(getBoundVariables(), '{', '}') + ", "
				+ containerStr + ", "
				+ getAbstractObjectInfo() + CollUtil.getStringOf(getSubstitutionTypes(), '<', '>') + ", "
				+ getName() + ") = "
				+ getSetVariable();
	}
	
	/**
	 * @see tool.compiler.java.visit.Table#getInfo()
	 */
	@Override
	public FieldInfo getInfo() {
		return (FieldInfo) super.getInfo();
	}
}