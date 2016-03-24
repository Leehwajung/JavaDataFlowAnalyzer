package tool.compiler.java.visit;

import polyglot.types.ReferenceType;
import polyglot.types.Type;

public abstract class AbstractReadField extends Constraint {
	
	/* Abstract */
//	ReferenceType c;	// C
//	FieldTable f;		// f
//	Type d;				// D
//	SetVariable R;		// R
	
	
	private FieldTable fieldTable;		// C, f
	private SetVariable rightSetVar;	// D, R
	
	
	// constructor
	
	/**
	 * @param fieldTable
	 * @param rightSetVar
	 */
	protected AbstractReadField(FieldTable fieldTable, SetVariable rightSetVar) {
		super();
		this.fieldTable = fieldTable;
		this.rightSetVar = rightSetVar;
	}
	
	
	// getter methods
	
	/**
	 * @return	C
	 */
	public ReferenceType getLeftType(){	// C
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
	 * @return	D
	 */
	public Type getRrightType() {	// D
		return rightSetVar.getType();
	}
	
	/**
	 * @return	rightSetVar (SetVariable)
	 */
	protected SetVariable getRightSetVar() {	// R
		return rightSetVar;
	}
	
	/**
	 * @return	rightSetVar (ID String)
	 */
	protected String getRightSetVarID() {		// R
		return rightSetVar.getID();
	}
}