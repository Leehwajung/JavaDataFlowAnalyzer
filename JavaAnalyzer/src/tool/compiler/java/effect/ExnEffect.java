package tool.compiler.java.effect;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

import polyglot.ext.jl5.types.JL5ClassType;

/**
 * Exception Effect
 */
public class ExnEffect implements Effect, Iterable<JL5ClassType> {
	
	private LinkedHashSet<JL5ClassType> Exceptions;
	
	public ExnEffect() {
		Exceptions = new LinkedHashSet<>();
	}

	public void add(JL5ClassType exceptionClass) {
		Exceptions.add(exceptionClass);
	}
	
	public void addAll(Collection<JL5ClassType> exceptionClasses) {
		Exceptions.addAll(exceptionClasses);
	}
	
	public JL5ClassType get(int index) {
		return (JL5ClassType) Exceptions.toArray()[index];
	}
	
	public Collection<JL5ClassType> getAll() {
		return new LinkedHashSet<>(Exceptions);
	}
	
	@Override
	public EffectName getType() {
		return EffectName.ExnEff;
	}

	@Override
	public Iterator<JL5ClassType> iterator() {
		return Exceptions.iterator();
	}
}