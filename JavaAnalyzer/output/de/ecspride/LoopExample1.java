package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * @testcase_name Loop1
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description tainted data is created and sent to a sink after it was
 transformed in a loop.
 * @dataflow source -> imei -> obfuscated -> sink
 * @number_of_leaks 1
 * @challenges the analysis must handle standard java constructs
 */
public class LoopExample1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop_example1);
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        String obfuscated = "";
        for (char c : imei.toCharArray()) obfuscated += c + "_";
        SmsManager sm = SmsManager.getDefault();
        sm.sendTextMessage("+49 1234", null, obfuscated, null, null);
    }
    
    public LoopExample1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "KgaAfwDKty7Bwg8AAA==");
}
