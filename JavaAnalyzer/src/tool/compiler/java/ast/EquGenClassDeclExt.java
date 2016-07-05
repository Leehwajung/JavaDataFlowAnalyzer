package tool.compiler.java.ast;

import java.util.ArrayList;

import polyglot.ast.ClassDecl;
import polyglot.ast.Field;
import polyglot.ast.Node;
import polyglot.ext.jl5.types.JL5ClassType;
import polyglot.ext.jl5.types.JL5FieldInstance;
import polyglot.ext.jl5.types.JL5ParsedClassType;
import polyglot.main.Report;
import polyglot.types.FieldInstance;
import polyglot.util.SerialVersionUID;
import tool.compiler.java.visit.ClassConstraint;
import tool.compiler.java.visit.EquGenerator;
import tool.compiler.java.visit.MetaSetVariable;

/**
 * ClassDecl <: ClassMember <: Term <: Node	<br>
 * ClassDecl <: CodeNode <: Term <: Node
 */
public class EquGenClassDeclExt extends EquGenExt {
	private static final long serialVersionUID = SerialVersionUID.generate();
	private ClassConstraint cc;
	
	@Override
	public EquGenerator equGenEnter(EquGenerator v) {
		ClassDecl clzDecl = (ClassDecl)this.node();
		JL5ParsedClassType classType = (JL5ParsedClassType) clzDecl.type();
		Report.report(0, "[Enter] Class Declaration: " + clzDecl/*.name()*/);
		
		System.out.println(clzDecl.type().fields());
		
//		ArrayList<MetaSetVariable> chiFields = new ArrayList<>();
//		for(FieldInstance field : classType.fields()) {
//			chiFields.add(new MetaSetVariable(field.type()));
//		}
		
		cc = new ClassConstraint(classType, true);
		v.addToSet(cc);
		
		return super.equGenEnter(v);
	}
	
	@Override
	public Node equGenLeave(EquGenerator v) {
		ClassDecl clzDecl = (ClassDecl)this.node();
		Report.report(0, "[Leave] Class Declaration: " + clzDecl/*.name()*/);
		
		return super.equGenLeave(v);
	}	
}