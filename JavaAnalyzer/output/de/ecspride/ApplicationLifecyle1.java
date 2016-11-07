package de.ecspride;

import android.app.Application;
import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * @testcase_name ApplicationLifecycle1
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description A secret value is obtained when the application is launched and
 leaked when
 * 	the main activity is resumed.
 * @dataflow source -> Application.onCreate() -> imei -> Activity.onResume() ->
 sink
 * @number_of_leaks 1
 * @challenges Correct handling of the Application object in the component
 lifecycle
 */
public class ApplicationLifecyle1 extends Application {
    public static String imei;
    
    @Override
    public void onCreate() {
        super.onCreate();
        TelephonyManager tm = (TelephonyManager)
                                getSystemService(Context.TELEPHONY_SERVICE);
        imei = tm.getDeviceId();
    }
    
    public ApplicationLifecyle1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "mOh+xv/f9t/LH5/6RLSAfwCnu9Qu+BEAAA==");
}
