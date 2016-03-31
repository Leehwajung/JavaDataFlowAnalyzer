package tool.compiler.java.visit;

import tool.compiler.java.util.CollUtil;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * { context1, ..., contextk } \subseteq X
 */
public class ObjsSubseteqX extends Constraint {
	
	// fields
	
	private ArrayList<AbstractObjectInfo> objs;	// { context1, ..., contextk }
	private TypedSetVariable x;						// X
	
	
	// constructor
	
	/**
	 * { context1, ..., contextk } \subseteq X
	 * @param objs	set objects	{ context1, ..., contextk }
	 * @param x		set X
	 */
	public ObjsSubseteqX(Collection<AbstractObjectInfo> objs, TypedSetVariable x) {
		super();
		try{
			this.objs = new ArrayList<>(objs);
		} catch (NullPointerException e) {
			this.objs = new ArrayList<>();
		}
		this.x = x;
	}
	
	/**
	 * { context1, ..., contextk } \subseteq X
	 * @param objs	set objects	{ context1, ..., contextk }
	 * @param x		set X
	 */
	public ObjsSubseteqX(AbstractObjectInfo[] objs, TypedSetVariable x) {
		this(Arrays.asList(objs), x);
	}
	
	
	// getter methods
	
	/**
	 * @return Objs	{ context1, ..., contextk }
	 */
	public List<AbstractObjectInfo> getObjs() {
		return new ArrayList<AbstractObjectInfo>(objs);
	}
	
	/**
	 * @param i	index
	 * @return Obj	( contexti )
	 */
	public AbstractObjectInfo getObj(int i) {
		return objs.get(i);
	}
	
	/**
	 * @return the X
	 */
	public TypedSetVariable getX() {
		return x;
	}
	
	
	/**
	 * Form:	{ context1, ..., contextk } \subseteq X
	 */
	@Override
	public String toString() {
		return CollUtil.getStringOf(objs, '{', '}') + " \\subseteq " + getX();
	}
}