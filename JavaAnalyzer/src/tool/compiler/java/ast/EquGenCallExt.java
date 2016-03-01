package tool.compiler.java.ast;

import polyglot.ast.Call;
import polyglot.ast.Expr;
import polyglot.ast.Local;
import polyglot.ast.Node;
import polyglot.ast.TypeNode;
import polyglot.ext.jl5.ast.JL5CallExt;
import polyglot.ext.jl5.ast.JL5ProcedureCallExt;
import polyglot.ext.jl5.ast.ParamTypeNode;
import polyglot.ext.jl5.types.JL5ClassType;
import polyglot.ext.jl5.types.JL5ConstructorInstance;
import polyglot.ext.jl5.types.JL5LocalInstance;
import polyglot.ext.jl5.types.JL5MethodInstance;
import polyglot.ext.jl5.types.JL5ParsedClassType;
import polyglot.ext.jl5.types.JL5ProcedureInstance;
import polyglot.ext.jl5.types.JL5SubstClassType;
import polyglot.ext.jl5.types.TypeVariable;
import polyglot.ext.jl7.ast.JL7ProcedureCallExt;
import polyglot.main.Report;
import polyglot.types.SemanticException;
import polyglot.types.Type;
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
		
		try{
			JL5CallExt callext = (JL5CallExt)JL5CallExt.ext(call);
			
//			for(Expr qq: call.arguments()) {
//				try {
//					Local aa = (Local) qq;
//					System.out.println(aa.localInstance().orig().declaration());
////					System.out.println("#aaa:   " + call.name() + "   :   " + aa.type() + "   :   " + aa.type().getClass());
//
////					// System.out.println(qq.type());
////
////					try {
////						System.out.println("#bbb:   " + ((JL5ParsedClassType) aa.type()).erasureSubst());
////					} catch (ClassCastException e) {
////						try {
////							System.out.println("#bbb:   " + ((JL5SubstClassType) aa.type()).subst().substitutions());
////						} catch (ClassCastException y) {
////
////						}
////					}
//
//				} catch (Exception e) {
//					System.out.println(qq.getClass());
//				}
//			}
			
//			System.out.println(((JL5MethodInstance)call.methodInstance().orig()).typeParams());
//			
//			for(TypeVariable aa: ((JL5MethodInstance)call.methodInstance().orig()).typeParams()) {
//				System.out.println(aa.getClass());
//			}
			
//			System.out.println(call.methodInstance().formalTypes());
//			
//			for(Type aa:call.methodInstance().formalTypes()) {
//				System.out.println(((JL5ClassType)aa));
//				
//			}
//			
//			ParamTypeNode aaaa;
			
//			aaaa.
			
//			System.out.println("#aaa" + call.arguments());
//			System.out.println("#aaa" + call);
//			System.out.println("#aaa" + call);
//			System.out.println("#aaa" + call);
//			System.out.println("#aaa" + call);
//			System.out.println("#aaa" + call);
//			System.out.println("#aaa" + call);
//			System.out.println("#aaa" + call);
//			System.out.println("#aaa" + call);
//			System.out.println("#aaa" + call);
//			System.out.println("#aaa" + call);
//			System.out.println("#aaa" + call);
//			System.out.println("#aaa" + call);
//			System.out.println("#aaa" + call);
//			System.out.println("#aaa" + call);
//			System.out.println("#aaa" + call);
//			System.out.println("#aaa" + call);
			
			
//		try {
//			System.out.println("call:------>" + callext.findTargetType());
//		} catch (SemanticException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
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
		
//		JL5MethodInstance ins = (JL5MethodInstance) call.methodInstance();
//		JL5ProcedureInstance ins = (JL5ProcedureInstance) call.procedureInstance();
		System.out.println("###########111" + call.name());
		System.out.println("###########222" + callext.node().procedureInstance());
		JL5ProcedureInstance ins = (JL5ProcedureInstance) callext.node().procedureInstance();
		
		System.out.println("" + ins.typeParams());
		
//		System.out.println("^^^^^^^^^" + ins.subst().substitutions());
		System.out.println("^^^^^^^^^333" + callext.typeArgs());
		
		
		JL5MethodInstance ins2 = (JL5MethodInstance) call.methodInstance();
		System.out.println("QQQQQQQQQQQQQ444   " + ins2.signature());
		System.out.println("QQQQQQQQQQQQQ555   " + ((JL5MethodInstance)call.methodInstance().orig()).erasureSubst());
//		try{
//			System.out.println("###########" + ins.);
//		System.out.println("###########" + ins.erasureSubst().substitutions());
	} catch (NullPointerException ignored) {} 
		catch (ClassCastException e){
	}
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGen(EquGenerator v) {
		return super.equGen(v);
	}
}