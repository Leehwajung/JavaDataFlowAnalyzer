package tool.compiler.java.ast;

import polyglot.ast.Node;
import polyglot.ast.NodeOps;
import polyglot.types.Type;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.TypedSetVariable;

public interface EquGenOps extends NodeOps {
	
	EquGenerator equGenEnter(EquGenerator v);
	Node equGen(EquGenerator v);
	TypedSetVariable setVar();
	
}