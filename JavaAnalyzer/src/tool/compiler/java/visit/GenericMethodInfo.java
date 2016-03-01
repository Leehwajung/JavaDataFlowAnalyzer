package tool.compiler.java.visit;

import polyglot.ast.TypeNode;
import polyglot.ext.jl5.types.JL5ConstructorInstance;
import polyglot.ext.jl5.types.JL5MethodInstance;
import polyglot.ext.jl5.types.JL5ProcedureInstance;
import polyglot.ext.jl5.types.TypeVariable;
import polyglot.types.ReferenceType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GenericMethodInfo extends MethodInfo {
	
	private JL5ProcedureInstance origProcIns;
	private List<ReferenceType> actualTypeArgs;
	private Map<TypeVariable, ReferenceType> substitutions;
	
	public GenericMethodInfo(JL5ProcedureInstance procedureInstance, List<TypeNode> typeArgs) {
		super(procedureInstance);
		setOrigTypeInstance();
		setSubstitutions();
		if(typeArgs != null) {	// 명시적 타입 변수 전달
			setMethodSubstitutionTypes(typeArgs);
		} else {						// TODO: 암시적 타입 변수 전달
			setMethodSubstitutionTypes();
		}
	}
	
	@Override
	public List<TypeVariable> getTypeParams() {
		return origProcIns.typeParams();
	}
	
	/**
	 * @return the substitutions
	 */
	public Map<TypeVariable, ReferenceType> getSubstitutions() {
		return substitutions;
	}
	
	/**
	 * 	set substitutions
	 */
	/*
	 * 	TODO: 암시적으로 타입 변수를 전달한 경우에 대하여도 대응하기.
	 * (현재 명시적으로 타입 변수를 전달한 경우에 대하여만 대응하도록 구현됨.)
	 */
	private void setSubstitutions() {
		try {
			Iterator<ReferenceType> typeArgsIterator = actualTypeArgs.iterator();	// NullPointerException 발생 가능 (actualTypeArgs)
			List<TypeVariable> typeParams = origProcIns.typeParams();	// NullPointerException 발생 가능 (origProcIns);
			substitutions = new LinkedHashMap<>();
			
			for(TypeVariable typeVar : typeParams) {			// NullPointerException 발생 가능 (typeParams)
				if(typeArgsIterator.hasNext()) {
					substitutions.put(typeVar, typeArgsIterator.next());
				} else {
					substitutions = null;	// TODO: 선언된 메서드의 타입 파라메터와 전달된 타입 파라메터 개수 차이 문제 (대응 필요?)
													// 이 문제가 발생한다는 것은 이 클래스의 객체 생성할 때 파라메터 전달에 이미 문제가 있었다는 것을 암시.
				}
			}
		} catch (NullPointerException e) {
			substitutions = null;
		}
	}
	
	/**
	 * @return the actual type arguments
	 */
	@Override
	public List<ReferenceType> getMethodSubstitutionTypes() {
		return actualTypeArgs;
	}
	
	/**
	 * set actual type arguments from list of explicit type arguments
	 * @param typeArgs	A list of type arg nodes
	 */
	protected final void setMethodSubstitutionTypes(List<TypeNode> typeArgs) {
		actualTypeArgs = new ArrayList<>(typeArgs.size());
		for (TypeNode tn : typeArgs) {
			actualTypeArgs.add((ReferenceType) tn.type());
		}
	}
	
	/**
	 * set actual type arguments
	 */
	protected final void setMethodSubstitutionTypes() {
		actualTypeArgs = null;	// TODO: 암시적 타입 변수 전달인 경우 대응 (좌측 코드는 임시)
	}

	/**
	 * @return the original ProcedureInstance
	 */
	public JL5ProcedureInstance getOrigTypeInstance() {
		return origProcIns;
	}
	
	/**
	 * set original procedure instance
	 */
	private void setOrigTypeInstance() {
		if(isNormalMethod()) {
			origProcIns = (JL5MethodInstance) ((JL5MethodInstance)getTypeInstance()).orig();
		} else if(isConstructor()) {
			origProcIns = (JL5ConstructorInstance) ((JL5ConstructorInstance)getTypeInstance()).orig();
		} else {		// 발생하지 않는 경우임.
			origProcIns = null;
		}
	}
}