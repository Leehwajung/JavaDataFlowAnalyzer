package tool.compiler.java.ast;

import polyglot.ast.Call;
import polyglot.ast.Node;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;

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
		Report.report(0, "Call: " + call/*.name()*/);
		
		// TODO: 제네릭 메서드의 타입 파라메터 얻기
		// 16-02-26까지 시도된 방법----------
//		JL5CallExt callext = (JL5CallExt)JL5CallExt.ext(call);
//		
//		// 1
//		System.out.println("call:------>" + callext.typeArgs());
//		
//		// 2
//		for(TypeNode tn : callext.typeArgs()) {
//			System.out.println(tn);
//		}
//		
//		// 3
//		JL5ProcedureInstance ins = (JL5ProcedureInstance) call.procedureInstance();
//		System.out.println(ins.typeParams());
		// -------------------------------------------
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGen(EquGenerator v) {
		return super.equGen(v);
	}
}