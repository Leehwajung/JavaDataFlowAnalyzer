package tool.compiler.java.ast;

import polyglot.ast.Expr;
import polyglot.ast.New;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5ConstructorInstance;
import polyglot.ext.jl5.types.JL5ProcedureInstance;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.MetaSetVarGoal;
import tool.compiler.java.util.ReportUtil.MetaSetVarSource;
import tool.compiler.java.visit.AbstractObject;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.InvokeMth;
import tool.compiler.java.visit.MetaSetVariable;
import tool.compiler.java.visit.MethodCallInfo;
import tool.compiler.java.visit.ObjsSubseteqX;

import java.util.ArrayList;

/**
 * New <: Expr <: Term <: Node					<br>
 * New <: Expr <: Receiver <: Prefix <: Node	<br>
 * New <: ProcedureCall <: Term <: Node
 * @author LHJ
 */
public class EquGenNewExt extends EquGenExprExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "New";
	
	private AbstractObject absObj;
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ReportUtil.enterReport(this);
		New nw = (New) this.node();
		
		absObj = new AbstractObject(nw);
		v.addToSet(absObj);
		ReportUtil.report(absObj);
		
		// (호출) 메서드 인포 생성
		MethodCallInfo mtdInfo = new MethodCallInfo((JL5ProcedureInstance) nw.procedureInstance());
		v.addToSet(mtdInfo);
		ReportUtil.report(mtdInfo);
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		ReportUtil.leaveReport(this);
		New nw = (New) this.node();
		JL5ConstructorInstance ctorIns = (JL5ConstructorInstance) nw.constructorInstance();
		
		// new C(e1, ..., en)
		//   1. C<T1,...,Tn>{Chi} 변수 생성
		MetaSetVariable ctschi = new MetaSetVariable(ctorIns.container());
		ReportUtil.report(ctschi, MetaSetVarSource.New, MetaSetVarGoal.Return);
		
		//   2-1. C<T1,...,Tn>{o} <: C<T1,...,Tn>{Chi} 제약식을 추가
		ObjsSubseteqX ox = new ObjsSubseteqX(absObj, ctschi);
		v.getCurrMC().addMetaConstraint(ox);
		ReportUtil.report(ox);
		
		//   2-2a. e1~en의 타입 Ci{Chii}를 가져온 다음
		ArrayList<MetaSetVariable> cschis = new ArrayList<>();
		MetaSetVariable cichii;
		for(Expr ei: nw.arguments()) {
			cichii = EquGenExt.metaSetVar(ei);
			cschis.add(cichii);
			ReportUtil.report(cichii, MetaSetVarSource.Argument, MetaSetVarGoal.Flow);
		}
		
		//   2-2b. C<T1,...,Tn>{Chi}.C <: (C1{Chi1}, ... , Cn{Chin}) -> D{Chi} 제약식을 추가
		InvokeMth im = new InvokeMth(ctschi, ctorIns, cschis, null);
		v.getCurrMC().addMetaConstraint(im);
		ReportUtil.report(im);
		
		//  3. return C<T1,...,Tn>{Chi}
		setMetaSetVar(ctschi);
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
}