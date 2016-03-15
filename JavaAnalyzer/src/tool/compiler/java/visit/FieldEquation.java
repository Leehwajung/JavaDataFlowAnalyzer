package tool.compiler.java.visit;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class FieldEquation extends AbstractEquation {
	
	private LinkedHashSet<FieldTable> fieldTableSet;
	private LinkedList<AbstractObjectInfo> absObjInfoList;
	private LinkedList<SetVariable> setVarList;
	
	public FieldEquation(FieldInfo fieldInfo, Collection<FieldTable> fieldTables) {
		this(fieldInfo, fieldTables, true);
	}
	
	public FieldEquation(FieldInfo fieldInfo, Collection<FieldTable> fieldTables, boolean argCheck) {
		super();
		if(argCheck) {
			checkArguments(fieldInfo, fieldTables);
		}
		setInfo(fieldInfo);
		this.fieldTableSet = new LinkedHashSet<>(fieldTables);
	}
	
	public FieldEquation(Collection<FieldTable> fieldTables) {
		this(fieldTables, true);
	}
	
	public FieldEquation(Collection<FieldTable> fieldTables, boolean argCheck) {
		this(!fieldTables.isEmpty() ? fieldTables.iterator().next().getInfo() : null, fieldTables, argCheck);
	}
	
	/**
	 * @see tool.compiler.java.visit.AbstractEquation#getInfo()
	 */
	@Override
	public FieldInfo getInfo() {
		return (FieldInfo) super.getInfo();
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// 형식: Γ{x:C{R}} ▷ x.f:S, ∅
		return "Γ{" + getName() + ":";
	}
	
	public static final void checkArguments(FieldInfo fieldInfo, Collection<FieldTable> fieldTables) {
		if(!fieldTables.isEmpty()) {					// fieldTables가 null이면 NullPointerException 발생
			for(FieldTable ft: fieldTables) {
				if(!fieldInfo.equals(ft.getInfo())) {	// fieldInfo가 null이면 NullPointerException 발생
					throw new IllegalArgumentException("Missmatch among Info objects.");
				}
			}
		} else {	// fieldTables가 비어있는 경우
			throw new IllegalArgumentException("'fieldTables' is empty.");
		}
	}
	
	public static final void checkArguments(Collection<FieldTable> fieldTables) {
		checkArguments(!fieldTables.isEmpty() ? fieldTables.iterator().next().getInfo() : null, fieldTables);
				// fieldTables가 null이면 NullPointerException 발생
	}
	
}