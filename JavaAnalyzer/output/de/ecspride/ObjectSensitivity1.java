package de.ecspride;

import java.util.LinkedList;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * @testcase_name ObjectSensitivity1
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description Two lists are created, a tainted value is added to one of them
 while a constant string is added to the other one.
 *  The first element of the list with the untainted object is sent to a sink.
 * @dataflow -
 * @number_of_leaks 0
 * @challenges the analysis must be able to distinguish between two objects of
 the same type that are initialized by the same constructor.
 */
public class ObjectSensitivity1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_sensitivity1);
        LinkedList<String> list1 = new LinkedList<String>();
        LinkedList<String> list2 = new LinkedList<String>();
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        list1.add(telephonyManager.getSimSerialNumber());
        list2.add("123");
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49 1234", null, list2.get(0), null, null);
    }
    
    public ObjectSensitivity1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "rH177KoYA/4BWOgkohAQAAA=");
}
