package tool.compiler.java.ast;

import polyglot.ast.Instanceof;
import polyglot.ast.Node;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.AbstractObject;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.MetaSetVariable;
import tool.compiler.java.visit.ObjsSubseteqX;

/**
 * Instanceof <: Expr <: Term <: Node				<br>
 * Instanceof <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenInstanceofExt extends EquGenExprExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	private AbstractObject absObj;
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		Instanceof insof = (Instanceof) this.node();
//		Report.report(0, "[Enter] Instanceof: " + insof);
		
		absObj = new AbstractObject(insof.type());
		v.addToSet(absObj);
		
		Report.report(0, "[Enter] Instanceof: " + insof + "\n"
				+ "\t[AbstractObject] " + absObj + ")");
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		Instanceof insof = (Instanceof) this.node();
//		Report.report(0, "[Leave] Instanceof: " + insof);
		
		// instanceof
		//   1. boolean{Chi} 변수 생성
		MetaSetVariable tchi = new MetaSetVariable(insof.type());
		
		//   2. boolean{o} <: boolean{Chi} 제약식을 추가
		ObjsSubseteqX ox = new ObjsSubseteqX(absObj, tchi);
		v.getCurrMC().addMetaConstraint(ox);
		Report.report(0, "[Leave] Instanceof: " + insof + "\n"
				+ "\t[ObjsSubseteqX] " + ox);
		
		//   3. return boolean{Chi}
		setMetaSetVar(tchi);
		
		return super.equGenLeave(v);
	}
}