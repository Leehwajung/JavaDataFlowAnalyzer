package tool.compiler.java.ast;

import polyglot.ast.Assign;
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
 * Assign <: Expr <: Term <: Node				<br>
 * Assign <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenAssignExt extends EquGenExprExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGen(EquGenerator v) {
		Assign asgn = (Assign) this.node();
		Report.report(0, "Assign: " + asgn);
		System.out.println(asgn);
		
		Expr lVal = asgn.left();
		Expr rVal = asgn.right();
		if(rVal instanceof Field) {
			JL5FieldInstance rValIns = (JL5FieldInstance) ((Field)rVal).fieldInstance();
			if(rValIns.flags().isStatic()) {
				v.addToSet(new ReadStaticField(rValIns, setVar(lVal)));
			} else {
				v.addToSet(new ReadField(setVar(rVal), rValIns, setVar(lVal)));
			}
		}
		
		return super.equGen(v);
	}
	
	@Override
	protected TypedSetVariable setVarImpl() {
		Expr lVal = ((Assign) this.node()).left();
		return setVar(lVal);
	}
}