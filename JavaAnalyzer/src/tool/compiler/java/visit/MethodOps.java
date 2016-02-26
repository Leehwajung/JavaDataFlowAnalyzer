package tool.compiler.java.visit;

import java.util.List;

import polyglot.ext.jl5.types.TypeVariable;
import polyglot.types.Type;

public interface MethodOps extends Ops {
	public List<TypeVariable> getTypeParams();
	public List<? extends Type> getFormalTypes();
	public boolean isConstructor();
	public boolean isNormalMethod();
}
