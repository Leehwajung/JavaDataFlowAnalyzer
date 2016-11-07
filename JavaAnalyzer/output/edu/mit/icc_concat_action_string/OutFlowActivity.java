package edu.mit.icc_concat_action_string;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;

/**
 * @testcase_name ICC-Concat-Action-String
 * 
 * @description   Testing if string concatenation can be analyzed in the
 Intent.ACTION field
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges   The analysis tool needs to be able to analyze constant string
 with concatenation operation and able to resolve the Intent for the resulted
 string and follow tainted data to the next Activity
 */
public class OutFlowActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        Intent i = new Intent("edu.mit.icc_concat_action_string" + ".ACTION");
        i.putExtra("DroidBench", imei);
        startActivity(i);
    }
    
    public OutFlowActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478512920000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "jIwQAAA=");
}
