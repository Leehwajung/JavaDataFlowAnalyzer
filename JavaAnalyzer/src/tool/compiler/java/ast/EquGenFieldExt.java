package tool.compiler.java.ast;

import polyglot.ast.Field;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5FieldInstance;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.ReadField;
import tool.compiler.java.visit.ReadStaticField;
import tool.compiler.java.visit.MetaSetVariable;
import tool.compiler.java.visit.AbsObjSet;

/**
 * Field <: NamedVariable <: Variable <: Expr <: Term <: Node					<br>
 * Field <: NamedVariable <: Variable <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenFieldExt extends EquGenExprExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		Field fld = (Field)this.node();
		Report.report(0, "[Enter] Field: " + fld/*.name()*/);
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		Field fld = (Field)this.node();
		JL5FieldInstance fldIns = (JL5FieldInstance) fld.fieldInstance();
//		Report.report(0, "[Leave] Field: " + fld/*.name()*/);
		
		// e.f / C.f
		//  1. f의 타입 D를 가지오고, 새로운 집합변수 AOS2를 생성해서 D{AOS2}를 만들기
		MetaSetVariable daos2 = new MetaSetVariable(fld.type());
		
		//  2-1. e의 타입 C{AOS1}을 가져오고, C{AOS1}.f <: D{AOS2}를 제약식 집합에 추가 (non-static)
		if(!fldIns.flags().isStatic()) {
			AbsObjSet caos1 = EquGenExt.AbsObjSet(fld.target());
			ReadField rf = new ReadField(caos1, fldIns, daos2);
			v.addToSet(rf);
			Report.report(1, "[Leave] Field: " + fld + "\n\t[ReadField] " + rf);
		}
		
		//  2-2. C.f <: D{AOS2}를 제약식 집합에 추가 (static)
		else {
			ReadStaticField rsf = new ReadStaticField(fldIns, daos2);
			v.addToSet(rsf);
			Report.report(1, "[Leave] Field: " + fld + "\n\t[ReadStaticField] " + rsf);
		}
		
		//  3. D{AOS2}를 e.f의 타입으로 리턴
		setAbsObjSet(daos2);
		
		return super.equGenLeave(v);
	}
}