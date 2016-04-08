package tool.compiler.java.ast;

import polyglot.ast.Field;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5FieldInstance;
import polyglot.main.Report;
import polyglot.types.Type;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.TypedSetVariable;

/**
 * Field <: NamedVariable <: Variable <: Expr <: Term <: Node					<br>
 * Field <: NamedVariable <: Variable <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenFieldExt extends EquGenExprExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		Field fld = (Field)this.node();
//		Type rValType = fld.right().type();
		
		
		
		Report.report(0, "Field: " + fld/*.name()*/);
		
		
		setVar(fld.fieldInstance().container());
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGen(EquGenerator v) {
		return super.equGen(v);
	}
}