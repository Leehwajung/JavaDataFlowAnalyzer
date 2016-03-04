package tool.compiler.java.ast;

import polyglot.ast.New;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5ConstructorInstance;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.AbstractObjectInfo;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.GenericMethodInfo;
import tool.compiler.java.visit.MethodInfo;

/**
 * New <: Expr <: Term <: Node
 * New <: Expr <: Receiver <: Prefix <: Node
 * New <: ProcedureCall <: Term <: Node
 * @author LHJ
 */
public class EquGenNewExt extends EquGenExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		New nw = (New) this.node();
//		Report.report(0, "New: " + nw);
		
		JL5ConstructorInstance ctorIns = (JL5ConstructorInstance) nw.constructorInstance();
		
		// 추상 객체 인포 생성
		AbstractObjectInfo absObjInfo = new AbstractObjectInfo(ctorIns);
		v.addToAbsObjSet(absObjInfo);
		
		// 메서드 인포 생성 (생성자)
		MethodInfo mtdInfo = null;
		if(MethodInfo.isGenericMethod(ctorIns)) {	// 제네릭 메서드인 경우
			mtdInfo = new GenericMethodInfo(ctorIns);
		} else {														// 일반 메서드인 경우
			mtdInfo = new MethodInfo(ctorIns);
		}
		v.addToCallSet(mtdInfo);
		
		Report.report(0, "New: " + absObjInfo + " & " + mtdInfo);
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGen(EquGenerator v) {
		return super.equGen(v);
	}
}