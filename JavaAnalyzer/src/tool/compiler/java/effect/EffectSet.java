package tool.compiler.java.effect;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;

import polyglot.ext.jl5.types.JL5ClassType;
import tool.compiler.java.util.CollUtil;

public class EffectSet extends EffectSetVariable implements Iterable<EffectElem> {
	
	private LinkedHashSet<EffectElem> set;
	
	public EffectSet(Collection<? extends EffectElem> elems) {
		super(inferType(elems));
		this.set = new LinkedHashSet<>(elems);
	}
	
	public <N extends EffectElem> EffectSet(N elem) {
		super(elem.getEffectType());
		this.set = new LinkedHashSet<>();
		this.set.add(elem);
	}
	
	private static final EffectName inferType(Collection<? extends EffectElem> elems) {
		try {
			Iterator<? extends EffectElem> iterator = elems.iterator();	// NullPointerException
			EffectName type = iterator.next().getEffectType();					// NoSuchElementException
			while (iterator.hasNext()) {
				if (!type.equals(iterator.next().getEffectType())) {
					throw new IllegalArgumentException("Elems' effect types are not matched."); 
				}
			}
			return type;
		} catch (NoSuchElementException e) {
			throw new IllegalArgumentException("The size of 'elems' must be one or more."); 
		} catch (NullPointerException e) {
			throw new IllegalArgumentException("The 'elems' must be NOT null."); 
		}
	}
	
	public void add(EffectElem effectClass) {
		set.add(effectClass);
	}
	
	public void addAll(Collection<? extends EffectElem> effectClasses) {
		set.addAll(effectClasses);
	}
	
	public JL5ClassType get(int index) {
		return (JL5ClassType) set.toArray()[index];
	}
	
	public Collection<? extends EffectElem> getAll() {
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
			return CollUtil.getStringOf(set, '{', '}');
		} catch(NullPointerException e) {
			return null;
		}
	}
}