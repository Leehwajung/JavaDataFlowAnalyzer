package tool.compiler.java.table;

import java.util.List;
import java.util.Map;

import polyglot.ext.jl5.types.TypeVariable;
import polyglot.types.ReferenceType;
import polyglot.types.Type;
import tool.compiler.java.aos.TypedSetVariable;
import tool.compiler.java.effect.EffectName;

public interface MethodOps extends TypingOps {
	public List<TypeVariable> getTypeParams();
	public List<? extends Type> getFormalTypes();
	public List<? extends ReferenceType> getMethodSubstitutionTypes();
	public Map<EffectName, TypedSetVariable> getEffects();
	public TypedSetVariable getEffect(EffectName type);
	public boolean isConstructor();
	public boolean isNormalMethod();
	public boolean isGenericMethod();
}
