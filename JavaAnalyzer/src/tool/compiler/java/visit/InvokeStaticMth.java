package tool.compiler.java.visit;

import java.util.ArrayList;

/**
 * C.m <: (D1{X1}, ..., Dn{Xn}) -- effect --> E{Y}
 */
public class InvokeStaticMth extends AbstractMethodConstraint {	// 
	
//	??? c;						// C
//	??? m;						// m
	ArrayList<Object/*???*/> ds;			// D1, ... , Dn		// TODO: ArrayList의 저장 타입 정하기
	ArrayList<SetVariable> xs;	// X1, ..., Xn
	// effect
//	??? e;						// E
	SetVariable y;				// Y
}