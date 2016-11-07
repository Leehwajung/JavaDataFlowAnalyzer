package de.ecspride;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;

/**
 * @testcase_name ActivityCommunication1
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description A source is called in one Activity a2 and stored in a static
 field of another Activity a1. In a1 the static field is written to a sink.
 * @dataflow Activity2.onCreate: source -> Activity1.data1; Activity1.onCreate:
 data1 -> sink
 * @number_of_leaks 1
 * @challenges the analysis must be able to model the lifecycle of Activities
 and allow arbitrary execution order of the Activities 
 */
public class Activity1 extends Activity {
    public static String data1;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49", null, data1, null, null);
    }
    
    public Activity1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "B5u+d89zS2/LtvA/VP8yQBESAAA=");
}
