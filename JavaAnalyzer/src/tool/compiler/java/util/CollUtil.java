package tool.compiler.java.util;

import java.util.Collection;
import java.util.Iterator;

public class CollUtil {
	
	// String conversion
	
	/**
	 * Returns a string representation of the collection. The string
	 * representation consists of a list of the collection's elements in the
	 * order they are returned by its iterator. Adjacent elements are
	 * separated by the characters <tt>", "</tt> (comma and space).
	 * Elements are converted to strings as by {@link String#valueOf(Object)}.
	 *
	 * @return a string representation of collection
	 */
	public static <E> String getStringOf(Collection<E> collection) {
		Iterator<E> it = collection.iterator();
		if (!it.hasNext())
			return "";
		
		StringBuilder sb = new StringBuilder();
		for (;;) {
			E e = it.next();
			sb.append(e == collection ? "(this Collection)" : e);
			if (!it.hasNext())
				return sb.toString();
			sb.append(',').append(' ');
		}
	}
	
	/**
	 * Returns a string representation of the collection. The string
	 * representation consists of a list of the collection's elements in the
	 * order they are returned by its iterator, enclosed in set brackets (
	 * <tt>e.g., "[]"</tt>). Adjacent elements are separated by the characters
	 * <tt>", "</tt> (comma and space). Elements are converted to strings as by
	 * {@link String#valueOf(Object)}.
	 *
	 * @return a string representation of collection
	 */
	public static <E> String getStringOf(Collection<E> collection, char leftBracket, char rightBracket) {
		try {
			Iterator<E> it = collection.iterator();
			if (!it.hasNext())
				return String.valueOf(leftBracket) + rightBracket;
			
			StringBuilder sb = new StringBuilder();
			sb.append(leftBracket);
			for (;;) {
				E e = it.next();
				sb.append(e == collection ? "(this Collection)" : e);
				if (!it.hasNext())
					return sb.append(rightBracket).toString();
				sb.append(',').append(' ');
			}
		} catch (NullPointerException e) {
			return String.valueOf(leftBracket) + rightBracket;
		}
	}
	
	/**
	 * Returns a string representation of the collection. The string
	 * representation consists of a list of the collection's elements in the
	 * order they are returned by its iterator. Adjacent elements are
	 * separated by the characters <tt>"\n "</tt> (new line).
	 * Elements are converted to strings as by {@link String#valueOf(Object)}.
	 *
	 * @return a string representation of collection
	 */
	public static <E> String getNLStringOf(Collection<E> collection) {
		Iterator<E> it = collection.iterator();
		if (!it.hasNext())
			return "";
		
		StringBuilder sb = new StringBuilder();
		for (;;) {
			E e = it.next();
			sb.append(e == collection ? "(this Collection)" : e);
			if (!it.hasNext())
				return sb.toString();
			sb.append('\n');
		}
	}
}