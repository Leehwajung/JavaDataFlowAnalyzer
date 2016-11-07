package edu.mit.icc_pass_action_string_through_api;

import java.util.LinkedList;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;

/**
 * @testcase_name ICC-Pass-Action-String-Through-API 
 * 
 * @description  Testing Intent resolution of a string that has been passed
 through a list
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges   The analysis tool has to be able to track a string through the
 list, then resolve Intent's action and follow the Intent to the Activity to be
 activated
 */
public class OutFlowActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        List<String> list = new LinkedList<String>();
        list.add("edu.mit.icc_action_string_operations.ACTION");
        String action = list.get(0);
        Intent i = new Intent(action);
        i.putExtra("DroidBench", imei);
        startActivity(i);
    }
    
    public OutFlowActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513070000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "7z381uAl0Vr8Aw7yQL6+EAAA");
}
