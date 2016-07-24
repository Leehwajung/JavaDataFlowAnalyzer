package tool.compiler.java.ast;

import polyglot.ast.Assign;
import polyglot.ast.LocalAssign;
import polyglot.ast.Node;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.MetaSetVarGoal;
import tool.compiler.java.util.ReportUtil.MetaSetVarSource;
import tool.compiler.java.visit.AbstractObject;
import tool.compiler.java.visit.AbstractObject.Info;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.MetaSetVariable;
import tool.compiler.java.visit.ObjsSubseteqX;
import tool.compiler.java.visit.XSubseteqY;

/**
 * LocalAssign <: Assign <: Expr <: Term <: Node				<br>
 * LocalAssign <: Assign <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenLocalAssignExt extends EquGenAssignExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Local Assign";
	
	private AbstractObject absObj;
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ReportUtil.enterReport(this);
		LocalAssign lasgn = (LocalAssign) this.node();
		
		if(lasgn.operator() != Assign.ASSIGN) {
			absObj = new AbstractObject(lasgn, Info.LocalAssignOp);
			v.addToSet(absObj);
			ReportUtil.report(absObj);
		}
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		ReportUtil.leaveReport(this);
		LocalAssign lasgn = (LocalAssign) this.node();
		
		// l = e / l op= e
		//   1. l의 타입 C{Chi1}을 가져오고
		MetaSetVariable cchi1 = metaSetVar(lasgn.left());
		ReportUtil.report(cchi1, MetaSetVarSource.Lvalue, MetaSetVarGoal.Return);
		
		//   2A. l = e
		if(lasgn.operator() == Assign.ASSIGN) {
			//   2A-1. e의 타입 D{Chi2}를 가져오고
			MetaSetVariable dchi2 = metaSetVar(lasgn.right());
			ReportUtil.report(dchi2, MetaSetVarSource.Rvalue, MetaSetVarGoal.Flow);
			
			//   2A-2. D{Chi2} <: C{Chi1} 제약식을 추가
			XSubseteqY xy = new XSubseteqY(dchi2, cchi1);
			v.getCurrMC().addMetaConstraint(xy);
			ReportUtil.report(xy);
		}
		
		//   2B. l op= e	(e.g. l += e)
		else {
			//   2B-1. C{o} <: C{Chi1} 제약식을 추가
			ObjsSubseteqX ox = new ObjsSubseteqX(absObj, cchi1);
			v.getCurrMC().addMetaConstraint(ox);
			ReportUtil.report(ox);
			
			//   2B-2. TODO: lasgn.rignt()와 absObj의 관계를 표현해야 함.
		}
		
		//   3. C{Chi1}을 리턴할 타입으로 지정
		setMetaSetVar(cchi1);
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
}