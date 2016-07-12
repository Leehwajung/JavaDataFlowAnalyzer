package tool.compiler.java.ast;

import polyglot.ast.Block;
import polyglot.ast.Node;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;

/**
 * Block <: CompoundStmt <: Stmt <: Term <: Node
 * @author LHJ
 */
public class EquGenBlockExt extends EquGenStmtExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		Block blk = (Block)this.node();
		Report.report(2, "[Enter] Block: " + blk);
		
		// 로컬 환경 구성
		v.getLocalEnv().push();
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		Block blk = (Block)this.node();
		
		// 로컬 환경 해제
		v.getLocalEnv().pop();
		
		Report.report(2, "[Leave] Block: " + blk);
		return super.equGenLeave(v);
	}
}