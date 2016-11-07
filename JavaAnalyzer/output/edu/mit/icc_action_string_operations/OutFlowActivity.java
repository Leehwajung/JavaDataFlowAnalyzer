package edu.mit.icc_action_string_operations;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;

/**
 * @testcase_name ICC-Action-String-Operations
 * 
 * @description  Testing substring operation and explicit intent resolution
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges   The analysis tool has to be able to evaluate substring
 operation and track tainted value through another Activity.
 */
public class OutFlowActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        Intent i = new Intent(
          "ignore.edu.mit.icc_action_string_operations.ACTION".substring(7));
        i.putExtra("DroidBench", imei);
        startActivity(i);
    }
    
    public OutFlowActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478512841000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "hEegEAAA");
}
