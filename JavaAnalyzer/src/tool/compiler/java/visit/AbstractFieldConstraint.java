package tool.compiler.java.visit;

import polyglot.types.ReferenceType;
import polyglot.types.Type;

public abstract class AbstractFieldConstraint extends Constraint {
	
	/* ### Abstract Fields ###
	 *  - R{…}.f
	 * ReferenceType r;		// R (C or D)
	 * FieldTable f;		// f
	 *  - T{S}
	 * Type t;				// T (C or D)
	 * SetVariable s;		// S (X or Y)
	 */
	
	/* ### Actual Fields ### */
	private FieldTable fieldTable;	// R, f
	private SetVariable setVar;		// T, S
	
	
	// constructor
	
	/**
	 * @param fieldTable
	 * @param setVar
	 */
	protected AbstractFieldConstraint(FieldTable fieldTable, SetVariable setVar) {
		super();
		this.fieldTable = fieldTable;
		this.setVar = setVar;
	}
	
	
	// getter methods
	
	/**
	 * @return	C
	 */
	public abstract Type getLeftType();	// C
	
	/**
	 * @return	D
	 */
	public abstract Type getRightType();	// D
	
	/**
	 * @return	R
	 */
	protected final ReferenceType getClassType() {	// R
		return fieldTable.getContainerType();
	}
	
	/**
	 * @return	f (Table)
	 */
	public FieldTable getFieldTable() {	// f
		return fieldTable;
	}
	
	/**
	 * @return	f (Name String)
	 */
	public String getFieldName() {	// f
		return fieldTable.getName();
	}
	
	/**
	 * @return	T
	 */
	protected final Type getSetVarType() {	// T
		return setVar.getType();
	}
	
	/**
	 * @return	S (SetVariable)
	 */
	protected final SetVariable getSetVar() {	// S
		return setVar;
	}
	
	/**
	 * @return	S (ID String)
	 */
	protected final String getSetVarID() {	// S
		return setVar.getID();
	}
}