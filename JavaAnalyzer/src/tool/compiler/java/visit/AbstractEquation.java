package tool.compiler.java.visit;

public abstract class AbstractEquation {
	
	private TypingInfo info;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return info.getName();
	}
	
	/**
	 * @return the info
	 */
	public TypingInfo getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	protected final void setInfo(TypingInfo info) {
		this.info = info;
	}
	
	
}