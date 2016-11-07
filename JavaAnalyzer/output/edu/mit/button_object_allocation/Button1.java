package edu.mit.button_object_allocation;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * @testcase_name Button-Object-Allocation
 * 
 * @description Test correct modeling of button object maintained by the runtime
 and delivered to onClick events.
 *  handler is defined via XML.
 * @number_of_leaks 1
 * @challenges Must correctly model that a Button is represented by a single
 object in the runtime, and that object 
 * is delivered to multiple calls of onClick
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
        Log.i("DroidBench", ((Button) view).getHint().toString());
        ((Button) view).setHint(imei);
    }
    
    public Button1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478487580000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "ssScfXH9T+754cIbss7+Hw044EBTEwAA");
}
