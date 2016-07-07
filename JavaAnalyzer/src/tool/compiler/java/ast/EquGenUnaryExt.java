package tool.compiler.java.ast;

import polyglot.ast.Node;
import polyglot.ast.Unary;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.AbstractObject;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.MetaSetVariable;
import tool.compiler.java.visit.ObjsSubseteqX;

/**
 * Unary <: Expr <: Term <: Node				<br>
 * Unary <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenUnaryExt extends EquGenExprExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	private AbstractObject absObj;
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		Unary unary = (Unary) this.node();
		Report.report(0, "[Enter] Unary: " + unary);
		
		absObj = new AbstractObject(unary.type());
		v.addToSet(absObj);
		
		Report.report(0, "[Enter] Unary: " + unary + "\n"
				+ "\t[AbstractObject] " + absObj + " (" + unary.getClass().getInterfaces()[0].getSimpleName() + ")");
		
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		Unary unary = (Unary) this.node();
		Report.report(0, "[Leave] Unary: " + unary);
		
		// +e / -e / ++e / --e / e++ / e-- / !e / ~e
		//   1. T{Chi} 변수 생성
		MetaSetVariable tchi = new MetaSetVariable(unary.type());
		
		//   2. T{o} <: T{Chi} 제약식을 추가
		ObjsSubseteqX ox = new ObjsSubseteqX(absObj, tchi);
		v.getCurrMC().addMetaConstraint(ox);
		Report.report(0, "[Leave] Unary: " + unary + "\n"
				+ "\t[ObjsSubseteqX] " + ox);
		
		//   3. return T{Chi}
		setMetaSetVar(tchi);
		
		return super.equGenLeave(v);
	}
}