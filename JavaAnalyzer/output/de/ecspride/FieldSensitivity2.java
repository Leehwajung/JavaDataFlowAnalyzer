package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * @testcase_name FieldSensitivity2
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description An object has two fields, one of them gets a tainted value, the
 other one is sent to a sink.
 *  This is an easier version of FieldSensitivity1.
 * @dataflow -
 * @number_of_leaks 0
 * @challenges the analysis must be able to distinguish between different fields
 of an object.
 */
public class FieldSensitivity2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field_sensitivity2);
        Datacontainer d1 = new Datacontainer();
        d1.setDescription("abc");
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        d1.setSecret(telephonyManager.getSimSerialNumber());
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49 1234", null, d1.getDescription(), null, null);
    }
    
    public FieldSensitivity2() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "v7/qrZGrogv4By0bYU4KEAAA");
}
