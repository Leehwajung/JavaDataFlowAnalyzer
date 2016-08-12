package tool.compiler.java.ast.stmt;

import java.util.ArrayList;

import polyglot.ast.Block;
import polyglot.ast.Node;
import polyglot.ast.Stmt;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.effect.EffectSetVariable;
import tool.compiler.java.effect.EffectUnion;
import tool.compiler.java.env.LocalEnvironment;
import tool.compiler.java.util.ReportUtil;
import tool.compiler.java.util.ReportUtil.EffectSetVarGoal;
import tool.compiler.java.util.ReportUtil.EffectSetVarSource;
import tool.compiler.java.visit.EquGenerator;

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
		
		// 하위의 Effects 찾기
		ArrayList<EffectSetVariable> exns = new ArrayList<>();
		for (Stmt subStmt : block.statements()) {
			EffectSetVariable currExn = EquGenStmtExt.exceptionEffect(subStmt);
			if (currExn != null) {
				exns.add(currExn);
			}
		}
		if (!exns.isEmpty()) {
			EffectSetVarSource src_ExnEffect;
			if (exns.size() > 1) {
				src_ExnEffect = EffectSetVarSource.New;
				ReportUtil.report(exns, EffectSetVarSource.SubStatement, EffectSetVarGoal.Flow);
			} else {
				src_ExnEffect = EffectSetVarSource.SubStatement;
			}
			EffectSetVariable exnEffect = EffectUnion.unionize(exns);
			ReportUtil.report(exnEffect, src_ExnEffect, EffectSetVarGoal.Return);
			setExceptionEffect(exnEffect);
		}
		
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