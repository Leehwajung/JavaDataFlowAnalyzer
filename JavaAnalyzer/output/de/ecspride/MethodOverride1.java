package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name MethodOverride1
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description This example contains a location information leakage in the
 attachBaseContext(Context base) callback method.
 * @dataflow attachBaseContext: source -> uid -> sink 
 * @number_of_leaks 1
 * @challenges the analysis must be able to detect the leak in an internal
 Android method that is overwritten.
 */
public class MethodOverride1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method_override1);
    }
    
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        TelephonyManager tManager =
          (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        String uid = tManager.getDeviceId();
        Log.d("EX", uid);
    }
    
    public MethodOverride1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "JxEAAA==");
}
