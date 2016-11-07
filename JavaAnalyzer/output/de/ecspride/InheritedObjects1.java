package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * @testcase_name InheritedObjects1
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description Based on a condition a variable is initialized. It has a method
 which either returns a constant string or a tainted value.
 *  The return value is sent by sms.
 * @dataflow VarA.getInfo(): source (gets returned) -> sink
 * @number_of_leaks 1
 * @challenges the analysis must be able to decide on the subtype of a variable
 based on a condition.
 */
public class InheritedObjects1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inherited_objects1);
        int a = 45 + 1;
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        General g;
        if (a == 46) {
            g = new VarA();
            g.man = telephonyManager;
        } else {
            g = new VarB();
            g.man = telephonyManager;
        }
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49 1234", null, g.getInfo(), null, null);
    }
    
    public InheritedObjects1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "DXD443kfbnhn/IaYAv4Btmt9CAoQAAA=");
}
