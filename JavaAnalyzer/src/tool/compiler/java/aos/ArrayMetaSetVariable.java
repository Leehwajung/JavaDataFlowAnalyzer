package tool.compiler.java.aos;

import polyglot.ext.jl5.types.JL5ArrayType;

public class ArrayMetaSetVariable extends MetaSetVariable {
	
	private MetaSetVariable base;
	private MetaSetVariable length;
	
	public ArrayMetaSetVariable(JL5ArrayType type) {
		super(type);
		this.base = MetaSetVariable.create(type.base());
		this.length = new MetaSetVariable(type.lengthField().type());
	}
	
	public MetaSetVariable base() {
		return base;
	}
	
	public MetaSetVariable length() {
		return length;
	}
	
	public MetaSetVariable ultimateBase() {
		if (base() instanceof ArrayMetaSetVariable) {
			return ((ArrayMetaSetVariable)base()).ultimateBase();
		}
		
		return base();
	}
}