package tool.compiler.java.visit;

import polyglot.types.Type;

public class SetVariable {
	
	private String kind = "X";
	private Type type;
	private long id;
	private static long idGen = 1;
	
	/**
	 * 
	 */
	public SetVariable(Type type) {
		this.type = type;
		
		if(!type.isVoid()) {
			generateID();
		}
	}
	
	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * @return the ID
	 */
	public String getID() {
		if(!type.isVoid()) {
			return kind + id;
		} else {
			return null;
		}
	}
	
	/**
	 * generate ID
	 */
	protected void generateID() {
		id = idGen++;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = type + "{";
		if(!type.isVoid()) {
			result += getID();
		} 
		return result + "}";
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}