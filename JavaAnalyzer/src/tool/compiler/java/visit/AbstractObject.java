package tool.compiler.java.visit;

import polyglot.ast.Expr;
import polyglot.ast.Lit;
import polyglot.ast.New;
import polyglot.ast.Term;
import polyglot.ast.TypeNode;
import polyglot.ext.jl5.types.JL5ConstructorInstance;
import polyglot.ext.jl5.types.JL5Subst;
import polyglot.ext.jl5.types.JL5SubstClassType;
import polyglot.types.ReferenceType;
import polyglot.types.Type;

import java.util.Collection;

public class AbstractObject extends AbsObjSet {
	
	public static final String KIND = "o";
	@Deprecated
	private JL5ConstructorInstance ctorIns;
	private Term term;		// Expr or TypeNode
	private static long idGen = 1;
	
	/**
	 * @param JL5 Constructor Instance
	 */
	@Deprecated
	public AbstractObject(JL5ConstructorInstance constructorInstance) {
		setType(constructorInstance.container());
		generateID();
		this.ctorIns = constructorInstance;
	}
	
	public AbstractObject(New newNode) {
		this((Expr)newNode);
	}
	
	public AbstractObject(Lit litNode) {
		this((Expr)litNode);
	}
	
	private AbstractObject(Expr expr) {
		this.term = expr;
		setType(expr.type());
		generateID();
	}
	
	public AbstractObject(TypeNode typeNode) {
		this.term = typeNode;
		setType(typeNode.type());
		generateID();
	}
	
	/**
	 * @param type
	 */
	public AbstractObject(Type type) {
		setType(type);
		generateID();
		this.ctorIns = null;
	}
	
	/**
	 * @return	타입 파라메터로 전달한 클래스 타입의 컬렉션
	 */
	public Collection<ReferenceType> getSubstitutionTypes() {
		try {
			return getSubstitutions().substitutions().values();
		} catch (NullPointerException e) {	// getSubstitutions()이 null인 경우 무시
			return null;
		}
	}
	
	/**
	 * @return	타입 파라메터의 맵
	 */
	public JL5Subst getSubstitutions() {
		if(getType() instanceof JL5SubstClassType) {
			return (JL5Subst) ((JL5SubstClassType)getType()).subst();
		}
		return null;
	}
	
	/**
	 * @return	JL5 Constructor Instance
	 */
	@Deprecated
	public JL5ConstructorInstance getInstance() {
		return ctorIns;
	}
	
	public boolean isObject() {
		return term instanceof New;	// TODO: TypeNode를 반영하여 수정 필요
	}
	
	public boolean isLit() {
		return term instanceof Lit;	// TODO: TypeNode를 반영하여 수정 필요
	}
	
	/**
	 * 식별 문자열 설정
	 */
	@Override
	public String kind() {
		return KIND;
	}
	
	/**
	 * 아이디 번호 생성
	 */
	@Override
	protected long generateIDNum() {
		return idGen++;
	}
}