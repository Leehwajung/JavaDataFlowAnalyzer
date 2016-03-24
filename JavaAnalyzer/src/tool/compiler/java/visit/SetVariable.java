package tool.compiler.java.visit;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import polyglot.types.Type;

public class SetVariable extends InfoVariable implements ProgramPointSet {
	
	@Deprecated
	private LinkedHashSet<SetVariable> subSetVars = null;
	
	private static long idGen = 1;
	
	/**
	 * @param type
	 */
	public SetVariable(Type type) {
		setType(type);
		
		if(type != null && !type.isVoid()) {
			generateID();
		}
	}
	
	/**
	 * @param subSetVars
	 */
	@Deprecated
	public SetVariable(Collection<SetVariable> subSetVars) {
		this(inferTypeFromSubSetVars(subSetVars));
		setSubSetVars(subSetVars);
	}
	
	@Deprecated
	protected static final Type inferTypeFromSubSetVars(Collection<SetVariable> subSetVars) {
		
		
		return null;
	}
	
	/**
	 * @see tool.compiler.java.visit.InfoVariable#kind()
	 */
	@Override
	protected String kind() {
		return "X";
	}
	
	/**
	 * @return the ID
	 */
	public String getID() {
		if(!getType().isVoid()) {
			return super.getID();
		} else {
			return null;
		}
	}
	
	/**
	 * generate ID Number
	 */
	@Override
	protected long generateIDNum() {
		return idGen++;
	}
	
	/**
	 * @return the subSetVars
	 */
	@Deprecated
	public Set<SetVariable> getSubSetVars() {
		return subSetVars;
	}

	/**
	 * @param subSetVars the subSetVars to set
	 */
	@Deprecated
	protected final void setSubSetVars(Collection<SetVariable> subSetVars) {
		this.subSetVars = new LinkedHashSet<>(subSetVars);
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = getType() + "{";
		if(!getType().isVoid()) {
			result += super.toString();
		} 
		return result + "}";
	}
}