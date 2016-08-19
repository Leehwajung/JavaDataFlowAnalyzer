package tool.compiler.java.effect;

import polyglot.ast.Call;
import polyglot.ast.Expr;
import polyglot.types.MethodInstance;
import polyglot.types.ReferenceType;
import polyglot.types.Type;
import tool.compiler.java.aos.MetaSetVariable;
import tool.compiler.java.ast.expr.EquGenExprExt;

public class ActivityEffectVariable extends EffectVariable {
	
	private static final String CONTAINER = "android.content.Activity";
	private static enum MethodName { 
		startActivity, startActivities, startActivityForResult, 
		startActivityFromChild, startActivityFromFragment, 
		startActivityIfNeeded, startNextMatchingActivity;
		
		private final int getIntentParamIndex() {
			switch (this) {
//			case startActivity:
//			case startActivities:
//			case startActivityForResult:
//			case startActivityIfNeeded:
//			case startNextMatchingActivity:
//				return 0;
			case startActivityFromChild:
			case startActivityFromFragment:
				return 1;
			default:
				return 0;
			}
		}
	};
	
	/**
	 * 
	 */
	public ActivityEffectVariable() {
		super(null);
	}
	
	protected ActivityEffectVariable(MetaSetVariable chi_intent) {
		super(EffectName.ActivityEff, chi_intent);
	}
	
	/**
	 * @param chi_effect
	 */
	public ActivityEffectVariable(Call callNode) {
		this(getIntentMetaSetVar(callNode));
	}
	

	/**
	 * Intent Param의 MetaSetVariable을 반환
	 * @param callNode
	 * @return
	 */
	private static MetaSetVariable getIntentMetaSetVar(Call callNode) {
		MethodName mthName = getMethodName(callNode);	// Check Creatable
		try {
			Expr intentExpr = callNode.arguments().get(mthName.getIntentParamIndex());
			return EquGenExprExt.metaSetVar(intentExpr);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(
					"This method is not Starting Activity");
		}
	}
	
	/**
	 * android.content.Activity로부터 상속받은 Starting Activity 메서드인지 확인하고, 
	 * 그 메서드의 이름을 반환
	 * @param callNode
	 * @return
	 */
	private static MethodName getMethodName(Call callNode) {
		MethodName mthName = MethodName.valueOf(callNode.name());	// IllegalArgumentException
		if (checkContainer(callNode.methodInstance())) {
			return mthName;
		}
		return null;
	}
	
	/**
	 * 부모 및 조상 클래스에 android.content.Activity가 있는지 확인
	 * @param mthIns
	 * @return
	 */
	private static boolean checkContainer(MethodInstance mthIns) {
		if (!mthIns.flags().isStatic()) {
			Type superType = mthIns.container();
			ReferenceType type;
			do {
				type = (ReferenceType) superType;
				if (type.toString().equals(CONTAINER)) {
					return true;
				}
				superType = type.superType();
			} while (superType != null && superType instanceof ReferenceType);
		} 
		return false;
	}
	
	/**
	 * Activity Effect를 생성할 수 있는 Call Node인지 확인
	 * @param callNode
	 * @return
	 */
	public static boolean checkCreatable(Call callNode) {
		try {
			return getMethodName(callNode) != null;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
}