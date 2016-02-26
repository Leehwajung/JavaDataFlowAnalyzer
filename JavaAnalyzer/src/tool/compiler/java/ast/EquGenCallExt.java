package tool.compiler.java.ast;

import polyglot.ast.Call;
import polyglot.ast.Node;
import polyglot.ast.TypeNode;
import polyglot.ext.jl5.ast.JL5CallExt;
import polyglot.ext.jl5.types.JL5ProcedureInstance;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.MethodInfo;

/**
 * Call <: Expr <: Term <: Node
 * Call <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenCallExt extends EquGenExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		Call call = (Call)this.node();
		Report.report(0, "Call: " + call.name());
		
//		MethodInfo aa = new MethodInfo((JL5ProcedureInstance) call.procedureInstance());
//		v.addToSet(aa);
//		System.out.println("Call\t" + aa);
		
		JL5CallExt callext = (JL5CallExt)JL5CallExt.ext(call);
		
		
		System.out.println("call:------>" + callext.typeArgs());
//		System.out.println("call:------>" + );
		
		
		for(TypeNode tn : callext.typeArgs()) {
			System.out.println(tn);
		}
		
//		JL5ProcedureInstance ins = (JL5ProcedureInstance) call.procedureInstance();
//		System.out.println(ins.typeParams());
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGen(EquGenerator v) {
		return super.equGen(v);
	}
}