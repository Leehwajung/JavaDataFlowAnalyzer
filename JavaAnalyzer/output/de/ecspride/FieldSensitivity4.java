package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * @testcase_name FieldSensitivity4
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description An object is created. It has a field with a default value which
 is sent to a sink. Afterwards a tainted 
 *  value is written to the field. 
 * @dataflow -
 * @number_of_leaks 0
 * @challenges the analysis has to consider the order of the statements for
 tainted fields.
 */
public class FieldSensitivity4 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field_sensitivity4);
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        Datacontainer data1 = new Datacontainer();
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49 1234", null, data1.value, null, null);
        data1.value = imei;
    }
    
    class Datacontainer {
        String value = "android";
        
        public Datacontainer() { super(); }
        
        public static final String jlc$CompilerVersion$jl7 = "2.7.1";
        public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
        public static final String jlc$ClassType$jl7 =
          ("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");
    }
    
    public FieldSensitivity4() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "cM07QzdEF/APh9cshwoQAAA=");
}
