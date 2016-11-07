package edu.mit.icc_unresolvable_intent;

import java.util.Random;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;

/**
 * @testcase_name ICC-Unresolvable-Intent
 * 
 * @description An intent is created with a random selection of 2 constant
 strings to start an Activity.
 * @dataflow source -> sink
 * @number_of_leaks 2 
 * @challenges   The analysis tool has to be able to identify unresolvable
 Intent and not associate the unresolved Intent with any Activity 
 */
public class OutFlowActivity extends Activity {
    private static Random rnd = new Random(System.currentTimeMillis());
    
    String randomString() {
        if (rnd.nextBoolean()) return "edu.mit.icc_unresolvable_intent.ACTION";
        else return "edu.mit.icc_unresolvable_intent.EDIT";
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        Intent i = new Intent(randomString());
        i.putExtra("DroidBench", imei);
        startActivity(i);
    }
    
    public OutFlowActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513751000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
