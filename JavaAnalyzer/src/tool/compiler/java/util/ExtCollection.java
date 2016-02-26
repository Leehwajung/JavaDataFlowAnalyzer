package tool.compiler.java.util;

import java.util.Collection;
import java.util.Iterator;

@Deprecated
public class ExtCollection<E> {

	private Collection<E> collection;
	
	/**
	 * @param collection
	 */
	public ExtCollection(Collection<E> collection) {
		this.collection = collection;
	}

	/**
	 * @return the collection
	 */
	public Collection<E> getCollection() {
		return collection;
	}
	
	/**
	 * @param collection the collection to set
	 */
	public void setCollection(Collection<E> collection) {
		this.collection = collection;
	}
	
	public boolean isNull() {
		return collection == null;
	}
	
	public boolean isEmpty() {
		return collection.isEmpty();
	}
	
	// String conversion
	
	/**
	 * Returns a string representation of this list. The string
	 * representation consists of a list of the list elements in the
	 * order they are returned by its iterator. Adjacent elements are
	 * separated by the characters <tt>", "</tt> (comma and space).
	 * Elements are converted to strings as by {@link String#valueOf(Object)}.
	 *
	 * @return a string representation of this list
	 */
	@Override
	public String toString() {
		Iterator<?> it = collection.iterator();
		
		if (!it.hasNext())
			return "";
		
		StringBuilder sb = new StringBuilder();
		for (;;) {
			sb.append(it.next());
			if (!it.hasNext())
				return sb.toString();
			sb.append(',').append(' ');
		}
	}
}