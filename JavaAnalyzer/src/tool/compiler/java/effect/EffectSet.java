package tool.compiler.java.effect;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

import polyglot.ext.jl5.types.JL5ClassType;
import tool.compiler.java.util.CollUtil;

public class EffectSet extends EffectSetVariable implements Iterable<EffectElem> {
	
	private LinkedHashSet<EffectElem> set;
	
	public EffectSet(EffectName type, Collection<EffectElem> elems) {
		super(type);
		// TODO: elems의 EffectName이 맞는지 확인하는 검사
		
		try {
			set = new LinkedHashSet<>(elems);
		} catch (NullPointerException e) {
			set = null;
		}
	}

	public void add(EffectElem effectClass) {
		set.add(effectClass);
	}
	
	public void addAll(Collection<EffectElem> effectClasses) {
		set.addAll(effectClasses);
	}
	
	public JL5ClassType get(int index) {
		return (JL5ClassType) set.toArray()[index];
	}
	
	public Collection<EffectElem> getAll() {
		return new LinkedHashSet<>(set);
	}
	
	public int size() {
		return set.size();
	}
	
	@Override
	public Iterator<EffectElem> iterator() {
		return set.iterator();
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		try {
			return CollUtil.getStringOf(set);
		} catch(NullPointerException e) {
			return null;
		}
	}
}