package tool.compiler.java.ast;

import polyglot.ast.Field;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5FieldInstance;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.ReadField;
import tool.compiler.java.visit.TypedSetVariable;

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
		Report.report(0, "Field: " + fld/*.name()*/);
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		System.out.println("!!setVar!!	" + typedSetVar());
		Field fld = (Field)this.node();
		
		// e.f
		//  1. e의 타입 C{X1}을 가져오기
		TypedSetVariable cx1 = EquGenExt.typedSetVar(fld.target());
		
		//  2. f의 타입 D를 가지오고, 새로운 집합변수 X2를 생성해서 D{X2}를 만들기
		TypedSetVariable dx2 = new TypedSetVariable(fld.type());
		
		//  3. C{X1}.f <: D{X2}를 제약식 집합에 추가
		ReadField rf = new ReadField(cx1, (JL5FieldInstance) fld.fieldInstance(), dx2);
		v.addToSet(rf);
		
		//  4. D{X2}를 e.f의 타입으로 리턴
		setTypedSetVar(dx2);
		
		
//		JL5FieldInstance ins = (JL5FieldInstance) fld.fieldInstance();
//		if(ins.flags().isStatic()) {
//			v.addToSet(new ReadStaticField(ins, new TypedSetVariable(fld.type())));
//		} else {
//			v.addToSet(new ReadField(typedSetVar(), ins, new TypedSetVariable(fld.type())));
//		}
		
		return super.equGenLeave(v);
	}
}