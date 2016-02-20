package tool.compiler.java.ast;

import polyglot.ast.Ext;
import polyglot.ast.ExtFactory;

public final class EquGenExtFactory_c extends EquGenAbstractExtFactory_c {
	
	public EquGenExtFactory_c() {
		super();
	}

	public EquGenExtFactory_c(ExtFactory nextExtFactory) {
		super(nextExtFactory);
	}
	
	@Override
	protected Ext extNodeImpl() {
		return new EquGenExt();
	}
	

    // TODO: Override factory methods for new extension nodes in the current
    // extension.
	
	@Override
	protected Ext extClassDeclImpl() {
		return new EquGenClassDeclExt();
	}
}
