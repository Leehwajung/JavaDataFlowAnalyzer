package tool.compiler.java.visit;

import java.util.ArrayList;

/**
 * C{X}.m <: (D1{X1}, ..., Dn{Xn}) -- effect --> E{Y}
 */
public class InvokeMth extends AbstractMethodConstraint {
	
//	??? c;						// C
	SetVariable x;				// X
//	??? m;						// method name m    
	ArrayList<Object/*???*/> ds;			// D1, ... , Dn		// TODO: ArrayList의 저장 타입 정하기
	ArrayList<SetVariable> xs;	// X1, ..., Xn
	// effect
//	??? e;						// E
	SetVariable y;				// Y    
}