package tool.compiler.java.ast.stmt;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

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
		EffectSetVariable exnEffect = null;
		LinkedHashMap<EffectSetVariable, EffectSetVarSource> exnEffMapForReport = new LinkedHashMap<>();
		int size = 0;
		for (Stmt subStmt : block.statements()) {
			EffectSetVariable currExn = EquGenStmtExt.exceptionEffect(subStmt);
			if (currExn != null) {
				size++;
				exnEffMapForReport.put(currExn, EffectSetVarSource.SubStatement);
				if (size == 1) {
					exnEffect = currExn;
				} else {
					exnEffect = new  EffectUnion(exnEffect, currExn);
					exnEffMapForReport.put(exnEffect, EffectSetVarSource.New);
				}
			}
		}
		report(exnEffMapForReport);
		setExceptionEffect(exnEffect);
		
		// 로컬 환경 해제
		LocalEnvironment localEnv = v.peekTypeEnv().pop();
		setLocalEnv(localEnv);
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
	
	
	
	/**
	 * Report Exception Effects
	 * @param reportMap
	 */
	private static final void report(LinkedHashMap<EffectSetVariable, EffectSetVarSource> exnEffMapForReport) {
		if (exnEffMapForReport.size() > 0) {
			LinkedList<Entry<EffectSetVariable, EffectSetVarSource>> exnEffListForReport = new LinkedList<>(exnEffMapForReport.entrySet());
			Entry<EffectSetVariable, EffectSetVarSource> exnEffForReport = exnEffListForReport.removeLast();
			for (Entry<EffectSetVariable, EffectSetVarSource> exnEffFlowForReport : exnEffListForReport) {
				ReportUtil.report(exnEffFlowForReport.getKey(), exnEffFlowForReport.getValue(), EffectSetVarGoal.Flow);
			}
			ReportUtil.report(exnEffForReport.getKey(), exnEffForReport.getValue(), EffectSetVarGoal.Return);
		}
	}
}