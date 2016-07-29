package tool.compiler.java.constraint;

import java.util.ArrayList;
import java.util.Collection;

import tool.compiler.java.aos.AbsObjSet;
import tool.compiler.java.aos.TypedSetVariable;

/**
 * base constraint interface
 */
public interface Constraint {
	public Constraint substitute(Collection<TypedSetVariable> tsvs);
	public int absObjSetSize();
	public int substitutableSize();
	public ArrayList<? extends AbsObjSet> getAllAbsObjSets();
	public boolean contains(AbsObjSet aos);
	public String getKind();
}