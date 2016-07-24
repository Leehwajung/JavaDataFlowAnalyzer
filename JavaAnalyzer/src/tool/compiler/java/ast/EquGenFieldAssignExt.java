package tool.compiler.java.ast;

import polyglot.ast.Assign;
import polyglot.ast.Expr;
import polyglot.ast.Field;
import polyglot.ast.FieldAssign;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5FieldInstance;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.MetaSetVarGoal;
import tool.compiler.java.util.ReportUtil.MetaSetVarSource;
import tool.compiler.java.visit.AbstractObject;
import tool.compiler.java.visit.AssignField;
import tool.compiler.java.visit.AssignStaticField;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.MetaSetVariable;
import tool.compiler.java.visit.ObjsSubseteqX;
import tool.compiler.java.visit.AbstractObject.Info;

/**
 * FieldAssign <: Assign <: Expr <: Term <: Node				<br>
 * FieldAssign <: Assign <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenFieldAssignExt extends EquGenAssignExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Field Assign";
	
	private AbstractObject absObj;
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ReportUtil.enterReport(this);
		FieldAssign fasgn = (FieldAssign) this.node();
		
		if(fasgn.operator() != Assign.ASSIGN) {
			absObj = new AbstractObject(fasgn, Info.FieldAssignOp);
			v.addToSet(absObj);
			ReportUtil.report(absObj);
		}
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		ReportUtil.leaveReport(this);
		FieldAssign fasgn = (FieldAssign) this.node();
		Field lVal = fasgn.left();
		Expr rVal = fasgn.right();
		JL5FieldInstance fldIns = (JL5FieldInstance) lVal.fieldInstance();
		
		// e1.f = e2 / C.f = e2 / e1.f op= e2 / C.f op= e2
		//   1. e1.f / C.f의 타입 D{Chi2}를 가져오고
		MetaSetVariable dchi2 = EquGenExt.metaSetVar(lVal);
		ReportUtil.report(dchi2, MetaSetVarSource.Lvalue, MetaSetVarGoal.Return);
		
		//   2-1. r-value의 타입 E{Chi3}를 가져온다
		MetaSetVariable echi3;
		
		//   2-1A. e1.f = e2 / C.f = e2
		//         e2의 타입 E{Chi3}를 가져옴
		if(fasgn.operator() == Assign.ASSIGN) {
			echi3 = EquGenExt.metaSetVar(rVal);
			ReportUtil.report(echi3, MetaSetVarSource.Rvalue, MetaSetVarGoal.Flow);
		}
		
		//   2-1B. e1.f op= e2 / C.f op= e2	(e.g. e1.f += e2)
		//         e1.f = e1.f + e2 / C.f = C.f op e2로 간주하여 제약식 생성
		else {
			//   2-1Ba. e1.f의 타입을 r-value의 타입으로 가정하여,
			//          이에 대한 타입 E{Chi3}를 가져오고
			echi3 = MetaSetVariable.create(lVal.type());	// lVal.type(): e1.f의 타입
			ReportUtil.report(echi3, MetaSetVarSource.New, MetaSetVarGoal.Flow);
			
			//   2-1Bb. E{o} <: E{Chi3} 제약식을 추가
			ObjsSubseteqX ox = new ObjsSubseteqX(absObj, echi3);
			v.getCurrMC().addMetaConstraint(ox);
			ReportUtil.report(ox);
		}
		
		//   2-2A. e1.f = e2 / e1.f op= e2	(non-static)
		if(!fldIns.flags().isStatic()) {
			//   2-2Aa. e1의 타입 C{Chi1}을 가져오고
			MetaSetVariable cchi1 = EquGenExt.metaSetVar(lVal.target());
			ReportUtil.report(cchi1, MetaSetVarSource.Receiver, MetaSetVarGoal.Flow);
			
			//   2-2Ab. E{Chi3} <: C{Chi1}.f 제약식을 추가
			AssignField af = new AssignField(echi3, cchi1, fldIns);
			v.getCurrMC().addMetaConstraint(af);
			ReportUtil.report(af);
		}
		
		//   2-2B. C.f = e2 / C.f op= e2	(static)
		//       E{Chi3} <: C.f 제약식을 추가
		else {
			AssignStaticField asf = new AssignStaticField(echi3, fldIns);
			v.getCurrMC().addMetaConstraint(asf);
			ReportUtil.report(asf);
		}
		
		//   3. e1.f / C.f의 타입 D{Chi2}를 리턴할 타입으로 지정
		setMetaSetVar(dchi2);
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
}