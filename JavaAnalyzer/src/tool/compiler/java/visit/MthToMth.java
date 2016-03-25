package tool.compiler.java.visit;

import java.util.ArrayList;

/**
 * (C1{X1}, ..., Cn{Xn}) -- effect1 --> E1{X} 
 * 	<: (D1{Y1}, ..., Dn{Ym}) -- effect2 --> E2{Y}<br>
 * 	(Not mandatory)
 */
public class MthToMth extends AbstractMethodConstraint {
	
	ArrayList<Object/*???*/> cs;			// C1, ... , Cn		// TODO: ArrayList의 저장 타입 정하기
	ArrayList<SetVariable> xs;	// X1, ..., Xn
	// effect1
//	??? e1;						// E1
	SetVariable x;				// X
	
	ArrayList<Object/*???*/> ds;			// D1, ... , Dn		// TODO: ArrayList의 저장 타입 정하기
	ArrayList<SetVariable> ys;	// Y1, ..., Yn
	// effect2
//	??? e2;						// E2
	SetVariable y;				// Y
}