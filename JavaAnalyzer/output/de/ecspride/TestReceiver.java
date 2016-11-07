package de.ecspride;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * @testcase_name BroadcastReceiverLifecycle1
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description The return value of source method is stored to a variable and
 sent to a sink in a condition branch
 * @dataflow source -> imei -> sink
 * @number_of_leaks 1
 * @challenges the analysis must be able to handle the broadcast receiver
 lifecycle correctly and
 *  evaluate the condition. 
 */
public class TestReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String imei =
          ((TelephonyManager)
             context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        int i = 2 + 3;
        if (i == 5) {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage("+49 1234", null, imei, null, null);
        }
    }
    
    public TestReceiver() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "vnr78+PnRLPwN8vlmeEWEAAA");
}
