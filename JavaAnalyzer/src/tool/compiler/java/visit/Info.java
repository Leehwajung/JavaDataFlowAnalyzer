package tool.compiler.java.visit;

import polyglot.types.Type;

public interface Info {
	public Type getType();
	public Type getBaseType();
}