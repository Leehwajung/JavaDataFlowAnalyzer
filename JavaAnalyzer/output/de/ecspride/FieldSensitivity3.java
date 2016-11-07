package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * @testcase_name FieldSensitivity3
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description An object has two fields, the one that gets tainted is sent to a
 sink.
 * @dataflow source -> d1.secret -> sink
 * @number_of_leaks 1
 * @challenges the analysis must be able to distinguish between different fields
 of an object.
 */
public class FieldSensitivity3 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field_sensitivity3);
        Datacontainer d1 = new Datacontainer();
        d1.setDescription("abc");
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        d1.setSecret(telephonyManager.getSimSerialNumber());
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49 1234", null, d1.getSecret(), null, null);
    }
    
    public FieldSensitivity3() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "jyd9uOqdoeuiC/gHti8geAoQAAA=");
}
