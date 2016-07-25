package tool.compiler.java.ast;

import polyglot.ast.Node;
import polyglot.ast.Stmt;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.TypeEnvironment;

/**
 * Stmt <: Term <: Node
 * @author LHJ
 */
public class EquGenStmtExt extends EquGenExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	public static final String KIND = "Statement";
	
	private TypeEnvironment typeEnv = null;
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
//		ReportUtil.enterReport(this);
//		Stmt stmt = (Stmt)this.node();
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
//		ReportUtil.leaveReport(this);
//		Stmt stmt = (Stmt)this.node();
		
		return super.equGenLeave(v);
	}
	
	@Override
	public String getKind() {
		return KIND;
	}
	
	
	/**
	 * @return the TypeEnvironment
	 */
	public final TypeEnvironment typeEnv() {
		return typeEnv;
	}
	
	/**
	 * @param n node
	 * @return the TypeEnvironment of node n
	 */
	public static final TypeEnvironment typeEnv(Stmt n) {
		return ((EquGenStmtExt)EquGenExt.ext(n)).typeEnv();
	}
	
	/**
	 * @param typeEnv the TypeEnvironment to set
	 */
	protected final void setTypeEnv(TypeEnvironment typeEnv) {
		this.typeEnv = typeEnv;
	}
}