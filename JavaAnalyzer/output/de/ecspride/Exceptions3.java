package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * @testcase_name Exceptions3
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail steven.arzt@cased.de
 * 
 * @description tainted data is created, but the exception handler which would
 send it out is never invoked
 * @dataflow source -> imei -> /
 * @number_of_leaks 0
 * @challenges the analysis must precisely model which exceptions can occur and
 which ones can't
 */
public class Exceptions3 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exceptions3);
        String imei = "";
        try {
            TelephonyManager telephonyManager =
              (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            imei = telephonyManager.getDeviceId();
            int[] arr = new int[42];
            if (arr[32] > 0) imei = "";
        }
        catch (RuntimeException ex) {
            SmsManager sm = SmsManager.getDefault();
            sm.sendTextMessage("+49 1234", null, imei, null, null);
        }
    }
    
    public Exceptions3() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "wZui/v8DXDlwJcoPAAA=");
}
