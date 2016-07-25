package tool.compiler.java.visit;

import java.util.HashMap;

import polyglot.ext.jl5.types.JL5LocalInstance;

public class TypeEnvironment {
	private HashMap<JL5LocalInstance, MetaSetVariable> env;
	
	public TypeEnvironment() {
		env = new HashMap<>();
	}
	
	public void put(JL5LocalInstance x, MetaSetVariable tsv) {
		env.put(x, tsv);
	}
	
	public MetaSetVariable get(JL5LocalInstance x) {
		return env.get(x);
	}

}
