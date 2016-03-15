package tool.compiler.java.visit;

import java.util.LinkedHashSet;

public class FieldEquation extends AbstractEquation {
	
	private LinkedHashSet<FieldTable> fieldTableSet;
	
	/**
	 */
	public FieldEquation() {
		this.fieldTableSet = new LinkedHashSet<>();
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// 형식: Γ{x:C{R}} ▷ x.f : S, ∅
		return "Γ{" + getName() + ":";
	}
}