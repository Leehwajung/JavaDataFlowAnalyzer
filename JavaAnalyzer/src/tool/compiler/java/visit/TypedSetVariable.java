package tool.compiler.java.visit;

import java.util.Collection;

import polyglot.types.Type;

public class TypedSetVariable extends TypedVariable implements ProgramPointSet {
	
	private static long idGen = 1;
	
	/**
	 * @param type
	 */
	public TypedSetVariable(Type type) {
		setType(type);
		
		if(type != null && !type.isVoid()) {
			generateID();
		}
	}
	
	/**
	 * @param subSetVars
	 */
	public TypedSetVariable(Collection<TypedSetVariable> subSetVars) {
		this(inferTypeFromSubSetVars(subSetVars));
	}
	
	protected static final Type inferTypeFromSubSetVars(Collection<TypedSetVariable> subSetVars) {
		
		
		return null;
	}
	
	/**
	 * @see tool.compiler.java.visit.TypedVariable#kind()
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