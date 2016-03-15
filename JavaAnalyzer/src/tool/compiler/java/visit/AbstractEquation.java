package tool.compiler.java.visit;

public abstract class AbstractEquation {
	private String name;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	protected final void setName(String name) {
		this.name = name;
	}
}