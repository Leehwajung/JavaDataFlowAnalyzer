package tool.compiler.java.ast;

import java.util.List;
import java.util.Map;

import polyglot.ast.Call;
import polyglot.ast.Node;
import polyglot.ast.TypeNode;
import polyglot.ext.jl5.ast.JL5CallExt;
import polyglot.ext.jl5.types.JL5MethodInstance;
import polyglot.ext.jl5.types.JL5ProcedureInstance;
import polyglot.ext.jl5.types.JL5Subst;
import polyglot.ext.jl5.types.JL5TypeSystem;
import polyglot.ext.jl5.types.TypeVariable;
import polyglot.ext.jl5.types.inference.InferenceSolver;
import polyglot.ext.jl5.types.inference.InferenceSolver_c;
import polyglot.ext.jl7.types.JL7TypeSystem;
import polyglot.main.Report;
import polyglot.types.ReferenceType;
import polyglot.types.Type;
import polyglot.types.TypeSystem;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.GenericMethodInfo;

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
		JL5MethodInstance procIns = (JL5MethodInstance) call.methodInstance();
		JL5MethodInstance orig = (JL5MethodInstance) procIns.orig();
		
		JL5Subst inferTypeArgs = inferTypeArgs(orig, procIns.formalTypes(), procIns.returnType(), (JL5TypeSystem) v.typeSystem());
		JL5Subst erasureSubst = orig.erasureSubst();
		
		System.out.println(inferTypeArgs);
		System.out.println(erasureSubst);
		
		JL5CallExt callext = (JL5CallExt)JL5CallExt.ext(call);
		
		Report.report(0, "Call: " + call/*.name()*/);
		
		
		List<TypeNode> typeArgs = callext.typeArgs();
		System.out.println("call:------>" + typeArgs);
		
		// TODO: 암시적 타입 변수 전달 대응
		if(typeArgs != null/* && !typeArgs.isEmpty()*/) {	// 명시적 타입 변수 전달일 경우에만 typeArgs가 비어있지 않음.
			GenericMethodInfo mtdInfo = new GenericMethodInfo(procIns, typeArgs);
			v.addToList(mtdInfo);
			Report.report(0, "Call: " + call/*.name()*/ + ": " + mtdInfo);
			
//			System.out.println("AAAA  "+procIns.container().methods().contains(orig));
			
			
//			procIns.
			
		} else {
			Report.report(0, "Call: " + call/*.name()*/);
		}
		
		
		// TODO: 제네릭 메서드의 타입 파라메터 얻기
		// 16-02-26까지 시도된 방법----------
//		JL5CallExt callext = (JL5CallExt)JL5CallExt.ext(call);
//		
//		// 1
//		System.out.println("call:------>" + callext.typeArgs());
//		
//		// 2
//		for(TypeNode tn : callext.typeArgs()) {
////			System.out.println(((CanonicalTypeNode)tn).);
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
	
	protected JL5Subst inferTypeArgs(JL5ProcedureInstance pi, List<? extends Type> argTypes,
			Type expectedReturnType, JL5TypeSystem ts) {
		InferenceSolver s = inferenceSolver(pi, argTypes, ts);
		Map<TypeVariable, ReferenceType> m = s.solve(expectedReturnType);
		if (m == null)
			return null;
		JL5Subst subst = (JL5Subst) ts.subst(m);
		return subst;
	}
	
	protected InferenceSolver inferenceSolver(JL5ProcedureInstance pi, List<? extends Type> argTypes,
			JL5TypeSystem ts) {
		return new InferenceSolver_c(pi, argTypes, ts);
	}
}