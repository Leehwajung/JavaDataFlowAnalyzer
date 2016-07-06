package tool.compiler.java.visit;

import java.util.ArrayList;
import java.util.Collection;

/**
 * base constraint interface
 */
public interface Constraint {
	public Constraint subst(Collection<TypedSetVariable> tsvs);
	public ArrayList<AbsObjSet> getAllAbsObjSet();
	public boolean contains(AbsObjSet aos);
}