package tool.compiler.java.visit;

import polyglot.ext.jl5.types.JL5ConstructorInstance;
import polyglot.ext.jl5.types.JL5MethodInstance;
import polyglot.ext.jl5.types.JL5ProcedureInstance;
import tool.compiler.java.util.CollUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * lam (Chi1, ..., Chin, Chi_ret). Constraint Set
 */
public class MethodConstraint implements ConstraintFunction {
	
	private JL5ProcedureInstance method;
	private ArrayList<MetaSetVariable> chi_formals;
	private ArrayList<MetaSetVariable> chi_locals;
	private MetaSetVariable chi_ret;
	private LinkedHashSet<Constraint> metaConstraints;
	
	/**
	 * @param 
	 */
	public MethodConstraint(JL5ProcedureInstance m) {
		this.method = m;
	}
	
	public MethodConstraint(JL5ProcedureInstance m, Collection<MetaSetVariable> chiFormals) {
		this(m);
		this.chi_formals = new ArrayList<>(chiFormals);
	}
	
	public MethodConstraint(JL5ProcedureInstance m, Collection<MetaSetVariable> chiFormals, MetaSetVariable chiReturn) {
		this(m, chiFormals);
		this.chi_ret = chiReturn;
	}
	
	public MethodConstraint(JL5ProcedureInstance m, Collection<MetaSetVariable> chiFormals, Collection<MetaSetVariable> chiLocals, MetaSetVariable chiReturn) {
		this(m, chiFormals, chiReturn);
		this.chi_locals = new ArrayList<>(chiLocals);
	}
	
	
	public Collection<Constraint> apply(Collection<TypedSetVariable> XFormals, TypedSetVariable XRet) {
		LinkedHashSet<Constraint> substConstraints = new LinkedHashSet<>();
//		ArrayList<XSubseteqY> cs1 = new ArrayList<>();
//		
//		if(chi_formals != null && XFormals != null) {
//			if(chi_formals.size() != XFormals.size()) {
//				throw new IllegalArgumentException("XFormals size must be " + chi_formals.size() + ".");
//			}
//			Iterator<TypedSetVariable> iterator = XFormals.iterator();
//			for(MetaSetVariable msvFormal : chi_formals) {
//				TypedSetVariable tsvFormal = new TypedSetVariable(msvFormal.getType());
//				cs1.add(new XSubseteqY(tsvFormal, iterator.next()));
//			}
//		}
//		
//		ArrayList<Constraint> cs2 = new ArrayList<>();
//		for(Constraint metaCon : metaConstraints) {
//			ArrayList<TypedSetVariable> substs = new ArrayList<>();
//			for(AbsObjSet aos : metaCon.getAllAbsObjSet()) {
//				if(aos instanceof MetaSetVariable) {
//					int pos = chi_formals.indexOf(aos);
//					if(pos != -1) {
//						substs.add((TypedSetVariable) cs1.get(pos).getX());
//					}
//				}
//			}
//		}
		
		
		
		/////////////////////////////////////////////////////////////////////
//		for(Constraint metaCon : metaConstraints) {
//			ArrayList<TypedSetVariable> tsvs = new ArrayList<>();
//			int i = 0;
//			for(AbsObjSet absObj : metaCon.getAllAbsObjSet()) {
//				if(absObj instanceof MetaSetVariable) {
//					if(chi_formals != null && XFormals != null) {
//						int pos = chi_formals.indexOf(absObj);
//						if(pos != -1) {
//							TypedSetVariable tsv = XFormals.get(pos);
//							tsvs.add(tsv);
//						}
//					}
//				}
//				i++;
//			}
//			
//		}
		
		
		
//		if(chi_formals != null && XFormals != null) {
//			ArrayList<TypedSetVariable> XFormalsArr = new ArrayList<>(XFormals);
//			ArrayList<MetaSetVariable> ChiFormalsArr = new ArrayList<>(chi_formals);
//			
//			for(Constraint metaCon : metaConstraints) {
//				ArrayList<AbsObjSet> abss = metaCon.getAllAbsObjSet();
//				ArrayList<TypedSetVariable> tsvs = new ArrayList<>();
//				for(AbsObjSet abs : abss) {
//					if(abs instanceof MetaSetVariable) {
//						TypedSetVariable tsv;
//						
//						int index = ChiFormalsArr.indexOf(abs);
//						if(index != -1) {					// Formals
//							tsv = XFormalsArr.get(index);
//						} else if (chi_ret != null && chi_ret.equals(abs)) {	// Return
//							tsv = XRet;
//						} else {							// Locals
//							tsv = new TypedSetVariable(abs.getType());
//						}
//						tsvs.add(tsv);
//					}
//				}
//				substConstraints.add(metaCon.subst(tsvs));
//			}
//		} else {
//			for(Constraint metaCon : metaConstraints) {
//				ArrayList<AbsObjSet> abss = metaCon.getAllAbsObjSet();
//				ArrayList<TypedSetVariable> tsvs = new ArrayList<>();
//				for(AbsObjSet abs : abss) {
//					if(abs instanceof MetaSetVariable) {
//						tsvs.add(new TypedSetVariable(abs.getType()));
//					}
//				}
//				substConstraints.add(metaCon.subst(tsvs));
//			}
//		}
		
		return substConstraints;
	}
	
	
	/**
	 * @return the method
	 */
	public JL5ProcedureInstance getMethod() {
		return method;
	}
	
	/**
	 * @return the chi_formals
	 */
	public LinkedHashSet<MetaSetVariable> getChiFormals() {
		return new LinkedHashSet<>(chi_formals);
	}
	
	/**
	 * @param chiFormals the chi_formals to set
	 */
	public void setChiFormals(Collection<MetaSetVariable> chiFormals) {
		if(this.chi_formals == null) {
			this.chi_formals = new ArrayList<MetaSetVariable>(chiFormals);
		} else {
			this.chi_formals.clear();
			this.chi_formals.addAll(chiFormals);
		}
	}
	
	/**
	 * @param chiFormals the chi_formals to add
	 */
	public void addChiFormals(Collection<MetaSetVariable> chiFormals) {
		if(this.chi_formals == null) {
			this.chi_formals = new ArrayList<MetaSetVariable>(chiFormals);
		} else {
			this.chi_formals.addAll(chiFormals);
		}
	}
	
	/**
	 * @param chiFormal
	 */
	public void addChiFormal(MetaSetVariable chiFormal) {
		try {
			this.chi_formals.add(chiFormal);
		} catch (NullPointerException e) {
			this.chi_formals = new ArrayList<>();
			this.chi_formals.add(chiFormal);
		}
	}
	
	/**
	 * @return the chi_locals
	 */
	public LinkedHashSet<MetaSetVariable> getChiLocals() {
		return new LinkedHashSet<>(chi_locals);
	}
	
	/**
	 * @param chiLocals the chi_locals to set
	 */
	public void setChiLocals(Collection<MetaSetVariable> chiLocals) {
		if(this.chi_locals == null) {
			this.chi_locals = new ArrayList<MetaSetVariable>(chiLocals);
		} else {
			this.chi_locals.clear();
			this.chi_locals.addAll(chiLocals);
		}
	}
	
	/**
	 * @param chiLocals the chi_locals to add
	 */
	public void addChiLocals(Collection<MetaSetVariable> chiLocals) {
		if(this.chi_locals == null) {
			this.chi_locals = new ArrayList<MetaSetVariable>(chiLocals);
		} else {
			this.chi_locals.addAll(chiLocals);
		}
	}
	
	/**
	 * @param chiLocal
	 */
	public void addChiLocal(MetaSetVariable chiLocal) {
		try {
			this.chi_locals.add(chiLocal);
		} catch (NullPointerException e) {
			this.chi_locals = new ArrayList<>();
			this.chi_locals.add(chiLocal);
		}
	}
	
	/**
	 * @return the chi_ret
	 */
	public MetaSetVariable getChiRet() {
		return chi_ret;
	}
	
	/**
	 * @param chiRet the chi_ret to set
	 */
	public void setChiRet(MetaSetVariable chiRet) {
		this.chi_ret = chiRet;
	}
	
	/**
	 * @return the metaConstraints
	 */
	public LinkedHashSet<Constraint> getMetaConstraints() {
		return new LinkedHashSet<>(metaConstraints);
	}
	
	/**
	 * @param metaConstraints the metaConstraints to set
	 */
	public void setMetaConstraints(Collection<Constraint> metaConstraints) {
		if(this.metaConstraints == null) {
			this.metaConstraints = new LinkedHashSet<>(metaConstraints);
		} else {
			this.metaConstraints.clear();
			this.metaConstraints.addAll(metaConstraints);
		}
	}
	
	/**
	 * @param metaConstraints the metaConstraints to add
	 */
	public void addMetaConstraints(Collection<Constraint> metaConstraints) {
		if(this.metaConstraints == null) {
			this.metaConstraints = new LinkedHashSet<>(metaConstraints);
		} else {
			this.metaConstraints.addAll(metaConstraints);
		}
	}
	
	/**
	 * @param metaConstraint the metaConstraint to add
	 */
	public void addMetaConstraint(Constraint metaConstraint) {
		try {
			this.metaConstraints.add(metaConstraint);
		} catch (NullPointerException e) {
			this.metaConstraints = new LinkedHashSet<>();
			this.metaConstraints.add(metaConstraint);
		}
	}
	
	public boolean isConstructor() {
		return method instanceof JL5ConstructorInstance;
	}
	
	public boolean isNormal() {
		return method instanceof JL5MethodInstance;
	}
	
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result =  "MC " + method + ": λ(";
		result += chi_formals != null ? CollUtil.getStringOf(chi_formals) : "";
		result += chi_ret != null ? (chi_formals != null ? ", " : "") + chi_ret : "";
		result += ")";
		
		return result;
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + ((chi_formals == null) ? 0 : chi_formals.hashCode());
		result = prime * result + ((chi_locals == null) ? 0 : chi_locals.hashCode());
		result = prime * result + ((chi_ret == null) ? 0 : chi_ret.hashCode());
		result = prime * result + ((metaConstraints == null) ? 0 : metaConstraints.hashCode());
		
		return result;
	}
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		MethodConstraint other = (MethodConstraint) obj;
		if (method == null) {
			if (other.method != null) {
				return false;
			}
		} else if (!method.equals(other.method)) {
			return false;
		}
		if (chi_formals == null) {
			if (other.chi_formals != null) {
				return false;
			}
		} else if (!chi_formals.equals(other.chi_formals)) {
			return false;
		}
		if (chi_locals == null) {
			if (other.chi_locals != null) {
				return false;
			}
		} else if (!chi_locals.equals(other.chi_locals)) {
			return false;
		}
		if (chi_ret == null) {
			if (other.chi_ret != null) {
				return false;
			}
		} else if (!chi_ret.equals(other.chi_ret)) {
			return false;
		}
		if (metaConstraints == null) {
			if (other.metaConstraints != null) {
				return false;
			}
		} else if (!metaConstraints.equals(other.metaConstraints)) {
			return false;
		}
		return true;
	}
}