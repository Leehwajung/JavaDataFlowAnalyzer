package tool.compiler.java.ast.stmt;

import polyglot.ast.Block;
import polyglot.ast.Node;
import polyglot.ast.Stmt;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.effect.EffectSetVariable;
import tool.compiler.java.env.LocalEnvironment;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.EffectSetVarSource;
import tool.compiler.java.visit.EquGenerator;

import java.util.LinkedHashMap;

/**
 * Block <: CompoundStmt <: Stmt <: Term <: Node
 * @author LHJ
 */
public class EquGenBlockExt extends EquGenStmtExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Block";
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ReportUtil.enterReport(this);
//		Block block = (Block) this.node();
		
		// 로컬 환경 구성
		v.peekTypeEnv().push();
		
		return super.equGenEnter(v);
	}
	 
	@Override
	public Node equGenLeave(EquGenerator v) {
		ReportUtil.leaveReport(this);
		Block block = (Block) this.node();
		
		// { stmt1 ... stmtn }
		LinkedHashMap<EffectSetVariable, EffectSetVarSource> x_effs = new LinkedHashMap<>();
		
		//   1. stmt1, ... , stmtn를 분석해서 나오는 exn effects인 X_eff1, ... , X_effn를 찾아,
		for (Stmt subStmt : block.statements()) {
			EffectSetVariable x_effi = EquGenStmtExt.exceptionEffect(subStmt);
			if (x_effi != null) {
				x_effs.put(x_effi, EffectSetVarSource.SubStatement);
			}
		}
		
		//   2. X_eff1 ∪ ... ∪ X_effn를 구하고, 이를 리턴한다.
		setExceptionEffect(x_effs);
		
		// 로컬 환경 해제
		LocalEnvironment localEnv = v.peekTypeEnv().pop();
		setLocalEnv(localEnv);
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
}