package tool.compiler.java.ast;

import polyglot.ast.Lit;
import polyglot.ast.Node;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.AbstractObject;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.MetaSetVariable;
import tool.compiler.java.visit.ObjsSubseteqX;

/**
 * Lit <: Expr <: Term <: Node					<br>
 * Lit <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenLitExt extends EquGenExprExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	private AbstractObject absObj;
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		Lit lit = (Lit) this.node();
//		Report.report(0, "[Enter] Literal: " + lit);
		
		absObj = new AbstractObject(lit.type());
		v.addToSet(absObj);
		
		Report.report(0, "[Enter] Literal: " + lit + "\n"
				+ "\t[AbstractObject] " + absObj + " (" + lit.getClass().getInterfaces()[0].getSimpleName() + ")");
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		Lit lit = (Lit) this.node();
//		Report.report(0, "[Leave] Literal: " + lit);
		
		// T{o} <: T{Chi}
		//  1. T{Chi} 변수 생성
		MetaSetVariable tchi = new MetaSetVariable(lit.type());
		
		//  2. T{o} <: T{Chi}
		ObjsSubseteqX ox = new ObjsSubseteqX(absObj, tchi);
		v.getCurrMC().addMetaConstraint(ox);
		Report.report(0, "[Leave] Literal: " + lit + "\n"
				+ "\t[ObjsSubseteqX] " + ox);
		
		//  3. return T{Chi}
		setMetaSetVar(tchi);
		
		return super.equGenLeave(v);
	}
}