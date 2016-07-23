package tool.compiler.java.ast;

import polyglot.ast.ArrayAccessAssign;
import polyglot.ast.Assign;
import polyglot.ast.Node;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.AbstractObject;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.MetaSetVariable;
import tool.compiler.java.visit.ObjsSubseteqX;
import tool.compiler.java.visit.XSubseteqY;
import tool.compiler.java.visit.AbstractObject.Info;

/**
 * ArrayAccessAssign <: Assign <: Expr <: Term <: Node				<br>
 * ArrayAccessAssign <: Assign <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenArrayAccessAssignExt extends EquGenAssignExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	private AbstractObject absObj;
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ArrayAccessAssign aasgn = (ArrayAccessAssign) this.node();
		Report.report(2, "[Enter] Array Access Assign: " + aasgn);
		
		if(aasgn.operator() != Assign.ASSIGN) {
			absObj = new AbstractObject(aasgn, Info.ArrayAccessAssignOp);
			v.addToSet(absObj);
			Report.report(3, "\t[AbstractObject] "  + absObj + " ( " + absObj.getType() + " )");
		}
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		ArrayAccessAssign aasgn = (ArrayAccessAssign) this.node();
		Report.report(2, "[Leave] Array Access Assign: " + aasgn);
		
		// a[i] = e / a[i] op= e
		//   1. a[i]의 타입 C{Chi1}을 가져오고
		MetaSetVariable cchi1 = metaSetVar(aasgn.left());
		Report.report(3, "\t[MetaSetVariable] " + cchi1 + " (For return: From array access)");
		
		//   2A. a[i] = e
		if(aasgn.operator() == Assign.ASSIGN) {
			//   2A-1. e의 타입 D{Chi2}를 가져오고
			MetaSetVariable dchi2 = metaSetVar(aasgn.right());
			
			//   2A-2. D{Chi2} <: C{Chi1} 제약식을 추가
			XSubseteqY xy = new XSubseteqY(dchi2, cchi1);
			v.getCurrMC().addMetaConstraint(xy);
			Report.report(3, "\t[XSubseteqY] " + xy);
		}
		
		//   2B. a[i] op= e	(e.g. a[i] += e)
		else {
			//   2B-1. C{o} <: C{Chi1} 제약식을 추가
			ObjsSubseteqX ox = new ObjsSubseteqX(absObj, cchi1);
			v.getCurrMC().addMetaConstraint(ox);
			Report.report(3, "\t[ObjsSubseteqX] " + ox);
			
			//   2B-2. TODO: aasgn.rignt()와 absObj의 관계를 표현해야 함.
		}
		
		//   3. C{Chi1}을 리턴할 타입으로 지정
		setMetaSetVar(cchi1);
		
		return super.equGenLeave(v);
	}
}