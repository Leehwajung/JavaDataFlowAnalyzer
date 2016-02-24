package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5ConstructorInstance;

public class AbstractObjectInfo extends InfoVariable {
	
	private JL5ConstructorInstance ctorIns;
	
	/**
	 * @param ctorIns
	 */
	public AbstractObjectInfo(JL5ConstructorInstance constructorInstance) {
		setType(constructorInstance.container());
		this.ctorIns = constructorInstance;
	}

	private static long idGen = 1;
	
	@Override
	protected String kind() {
		return "o";
	}

	@Override
	protected long generateIDNum() {
		return idGen++;
	}
	
}