package tool.compiler.java.ast;

import polyglot.ast.New;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5ConstructorInstance;
import polyglot.ext.jl5.types.JL5ProcedureInstance;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.AbstractObjectInfo;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.MethodCallInfo;
import tool.compiler.java.visit.ObjsSubseteqX;
import tool.compiler.java.visit.TypedSetVariable;

/**
 * New <: Expr <: Term <: Node					<br>
 * New <: Expr <: Receiver <: Prefix <: Node	<br>
 * New <: ProcedureCall <: Term <: Node
 * @author LHJ
 */
public class EquGenNewExt extends EquGenExprExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	private AbstractObjectInfo absObjInfo;
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		New nw = (New) this.node();
		Report.report(0, "New: " + nw);
		JL5ConstructorInstance ctorIns = (JL5ConstructorInstance) nw.constructorInstance();
		
		absObjInfo = new AbstractObjectInfo(ctorIns);
		v.addToSet(absObjInfo);
		
		// (호출) 메서드 인포 생성
		MethodCallInfo mtdInfo = new MethodCallInfo((JL5ProcedureInstance) nw.procedureInstance());
		v.addToSet(mtdInfo);
		
		Report.report(0, "New: " + absObjInfo + ": " + mtdInfo);

		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		New nw = (New) this.node();
		JL5ConstructorInstance ctorIns = (JL5ConstructorInstance) nw.constructorInstance();
		
		// C<T1,...,Tn>{o} <: C<T1,...,Tn>{X}
		//  1. C<T1,...,Tn>{X} 변수 생성
		TypedSetVariable ctsx = new TypedSetVariable(ctorIns.container());
		
		//  2. C<T1,...,Tn>{o} <: C<T1,...,Tn>{X}
		ObjsSubseteqX o = new ObjsSubseteqX(absObjInfo, ctsx);
		v.addToSet(o);
		
		//  3. return C<T1,...,Tn>{X}
		setTypedSetVar(ctsx);
		
		return super.equGenLeave(v);
	}
}