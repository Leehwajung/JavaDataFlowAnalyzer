package tool.compiler.java.visit;

import java.util.Collection;
import java.util.LinkedHashSet;

public class FieldEquation extends AbstractEquation {
	
	private FieldInfo fieldInfo;
	private LinkedHashSet<FieldTable> fieldTableSet;
	
	public FieldEquation(Collection<FieldTable> fieldTables) {
		super();
		if(fieldTables != null && !fieldTables.isEmpty()) {
			fieldInfo = fieldTables.iterator().next().getInfo();
		}
		this.fieldTableSet = new LinkedHashSet<>(fieldTables);
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// 형식: Γ{x:C{R}} ▷ x.f:S, ∅
		return "Γ{" + getName() + ":";
	}
	
	
	
}