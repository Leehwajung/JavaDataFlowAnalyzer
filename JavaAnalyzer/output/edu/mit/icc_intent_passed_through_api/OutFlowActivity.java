package edu.mit.icc_intent_passed_through_api;

import java.util.LinkedList;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;

/**
 * @testcase_name ICC-Intent-Passed-Through-API
 * 
 * @description   Testing an Intent passed through a linked-list then used to
 start an Activity 
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges  The analysis tool has to be able to track an Intent through a
 list operation 
 */
public class OutFlowActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        Intent i = new Intent(this, InFlowActivity.class);
        i.putExtra("DroidBench", imei);
        List<Intent> iList = new LinkedList<Intent>();
        iList.add(i);
        Intent i2 = iList.get(0);
        startActivity(i2);
    }
    
    public OutFlowActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513000000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "KRqKvwGGGC60pRAAAA==");
}
