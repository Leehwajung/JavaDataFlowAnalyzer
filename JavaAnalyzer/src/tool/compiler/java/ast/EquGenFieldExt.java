package tool.compiler.java.ast;

import polyglot.ast.Expr;
import polyglot.ast.Field;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5FieldInstance;
import polyglot.main.Report;
import polyglot.types.Type;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.ReadField;
import tool.compiler.java.visit.ReadStaticField;
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
		System.out.println("DECL:::   " + fld.fieldInstance().declaration());
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGen(EquGenerator v) {
		System.out.println("!!setVar!!	" + setVar());
		Field fld = (Field)this.node();
		
		JL5FieldInstance ins = (JL5FieldInstance) fld.fieldInstance();
		if(ins.flags().isStatic()) {
			v.addToSet(new ReadStaticField(ins, new TypedSetVariable(fld.type())));
		} else {
			v.addToSet(new ReadField(setVar(), ins, new TypedSetVariable(fld.type())));
		}
		
		return super.equGen(v);
	}
	
	@Override
	protected TypedSetVariable setVarImpl() {
		Field fld = (Field)this.node();
		return new TypedSetVariable(fld.fieldInstance().container());
	}
}