package edu.mit.icc_non_constant_class_object;

import edu.mit.icc_non_constant_class_object.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;

/**
 * @testcase_name ICC-Non-Constant-Class-Object 
 * 
 * @description   Testing Intent resolution on a non-constant
 Activity.getClass() 
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges   The analysis tool has to be able to resolve an Intent of a
 non-constant Activity class 
 */
public class OutFlowActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        InFlowActivity act = new InFlowActivity();
        Intent i = new Intent(this, act.getClass());
        i.putExtra("DroidBench", imei);
        startActivity(i);
    }
    
    public OutFlowActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513034000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "YKUQAAA=");
}
