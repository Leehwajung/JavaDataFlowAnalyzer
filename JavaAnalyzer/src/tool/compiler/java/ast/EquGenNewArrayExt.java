package tool.compiler.java.ast;

import java.util.Collection;

import polyglot.ast.ArrayInit;
import polyglot.ast.NewArray;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5ArrayType;
import polyglot.main.Report;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.util.EquGenUtil;
import tool.compiler.java.visit.AbstractObject;
import tool.compiler.java.visit.ArrayMetaSetVariable;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.ObjsSubseteqX;
import tool.compiler.java.visit.XSubseteqY;

/**
 * NewArray <: Expr <: Term <: Node					<br>
 * NewArray <: Expr <: Receiver <: Prefix <: Node
 * @author LHJ
 */
public class EquGenNewArrayExt extends EquGenExprExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	
	private AbstractObject absObj;
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		NewArray nwArr = (NewArray) this.node();
		Report.report(2, "[Enter] New Array: " + nwArr);
		
		absObj = new AbstractObject(nwArr);
		v.addToSet(absObj);
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		NewArray nwArr = (NewArray) this.node();
		Report.report(2, "[Leave] New Array: " + nwArr);
		
		// new C[n] || new C[]{e1, ... , en}
		//   1. C[]{Chi1} 변수 생성 (NewArray의 타입에 대한 MSV)
		ArrayMetaSetVariable cchi1 = new ArrayMetaSetVariable((JL5ArrayType) nwArr.type());
		
		//   2-1. C[]{o} <: C[]{Chi1} 제약식을 추가
		ObjsSubseteqX ox = new ObjsSubseteqX(absObj, cchi1);
		v.getCurrMC().addMetaConstraint(ox);
		Report.report(3, "\t[ObjsSubseteqX] " + ox);
		
		//   2-2. 초기화를 포함하는지 확인 후 ( new C[]{e1, ... , en} )
		ArrayInit es = nwArr.init();
		if(es != null) {
			//   2-2a. {e1, ... , en}의 타입 D[]{Chi2}을 가져온 다음 (ArrayInit의 타입에 대한 MSV)
			ArrayMetaSetVariable dchi2 = (ArrayMetaSetVariable) metaSetVar(es);
			
			//   2-2b. D[]{Chi2} <: C[]{Chi1} 제약식을 추가 (Top Level) 
			XSubseteqY xy = new XSubseteqY(dchi2, cchi1);
			v.getCurrMC().addMetaConstraint(xy);
			Report.report(3, "\t[XSubseteqY] " + xy);
			
			//   2-2c. D[]{Chi2} <: C[]{Chi1}의 하위 레벨 제약식을 집합에 추가
			//         (Top Level 아래의 MetaSetVariable의 데이터 플로우)
			Collection<XSubseteqY> xys = EquGenUtil.constrain(
					(ArrayMetaSetVariable) dchi2, 
					(ArrayMetaSetVariable) cchi1);
			v.getCurrMC().addMetaConstraints(xys);
		}
		
		//   3. return C[]{Chi1}
		setMetaSetVar(cchi1);
		Report.report(3, "\t[MetaSetVariable] " + cchi1 + " (new)");
		
		return super.equGenLeave(v);
	}
}