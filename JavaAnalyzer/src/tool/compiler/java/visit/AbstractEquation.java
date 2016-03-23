package tool.compiler.java.visit;

import java.util.List;

import polyglot.ext.jl5.types.TypeVariable;
import polyglot.types.ReferenceType;
import polyglot.types.Type;

@Deprecated
public abstract class AbstractEquation implements Ops{
	
	private TypingInfo info;
	
	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return info.getName();
	}
	
	@Override
	public List<TypeVariable> getBoundVariables() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeVariable> getTypeVariables() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReferenceType getContainerType() {
		return info.getContainerType();
	}

	@Override
	public Type getType() {
		return info.getType();
	}

	@Override
	public ReferenceType getContainerBaseType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @return the info
	 */
	public TypingInfo getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	protected final void setInfo(TypingInfo info) {
		this.info = info;
	}
}