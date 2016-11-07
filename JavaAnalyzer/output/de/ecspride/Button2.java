package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * @testcase_name Button2
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description Sources and sinks are called in button callbacks. There is only
 one data leak iff first button3 and then button1 is pressed!
 * @dataflow clickOnButton3: source -> imei; onClick (button1): imei -> sinks 
 * @number_of_leaks 3
 * @challenges the analysis must be able to analyze listeners, know that
 callback of button3 is ClickOnButton3 (defined in xml file)
 *  and has to handle the arbitrary order of the listener callbacks.
 */
public class Button2 extends Activity {
    private String imei = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button2);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(
                  new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SmsManager sm = SmsManager.getDefault();
                            String number = "+49 1234";
                            sm.sendTextMessage(number, null, imei, null, null);
                            Log.i("TAG", "sendIMEI: " + imei);
                            imei = null;
                        }
                    });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             imei = null;
                                             Log.i("TAG", "Button 2: " + imei);
                                         }
                                     });
    }
    
    public void clickOnButton3(View view) {
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        imei = telephonyManager.getDeviceId();
        Log.i("TAG", "Button3: " + imei);
    }
    
    public Button2() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
