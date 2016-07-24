package tool.compiler.java.ast;

import polyglot.ast.Node;
import polyglot.ast.Special;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.MetaSetVarGoal;
import tool.compiler.java.util.ReportUtil.MetaSetVarSource;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.MetaSetVariable;

/**
 * Special <: Expr <: Term <: Node					<br>
 * Special <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
@Deprecated
public class EquGenSpecialExt extends EquGenExprExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Special";
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ReportUtil.enterReport(this);
//		Special spc = (Special) this.node();
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		ReportUtil.leaveReport(this);
		Special spc = (Special) this.node();
		
		MetaSetVariable cchi;
		if(spc.kind() == Special.THIS) {
			cchi = v.getCurrCC().getThis();
			ReportUtil.report(cchi, MetaSetVarSource.Environment, MetaSetVarGoal.Return);
		} else {	// TODO: 이 프로그램을 위해, super의 타입은 무엇으로 봐야 하는가? (자식 클래스? 부모 클래스?)
			cchi = new MetaSetVariable(spc.type());
			ReportUtil.report(cchi, MetaSetVarSource.New, MetaSetVarGoal.Return);
		}
		
		setMetaSetVar(cchi);
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
}