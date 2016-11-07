package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;

/**
 * @testcase_name IntentSink1
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description The value of a source is stored in an intent which is set as a
 result of this activity. The activity finishes afterwards.
 * @dataflow onCreate: source -> imei -> intent -> sink
 * @number_of_leaks 1
 * @challenges the analysis must be able to track the taint in the intent and
 recognize the setResult sink. 
 */
public class IntentSink1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_sink1);
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        Intent intent = this.getIntent();
        intent.putExtra("secret", imei);
        this.setResult(RESULT_OK, intent);
        finish();
    }
    
    public IntentSink1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513240000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "8OPaD1e+M3JN1P9/AL0uCbbkDwAA");
}
