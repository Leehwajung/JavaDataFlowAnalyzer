package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * @testcase_name FieldSensitivity1
 * @version 0.2
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description An object has two fields, one of them gets a tainted value, the
 other one is sent to a sink.
 * @dataflow -
 * @number_of_leaks 0
 * @challenges the analysis must be able to distinguish between different fields
 of an object.
 */
public class FieldSensitivity1 extends Activity {
    private Datacontainer d1;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field_sensitivity1);
        d1 = setTaint(d1);
        sendTaint();
    }
    
    private Datacontainer setTaint(Datacontainer data) {
        data = new Datacontainer();
        data.setDescription("abc");
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        data.setSecret(telephonyManager.getSimSerialNumber());
        return data;
    }
    
    private void sendTaint() {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49 1234", null, d1.getDescription(), null, null);
    }
    
    public FieldSensitivity1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
