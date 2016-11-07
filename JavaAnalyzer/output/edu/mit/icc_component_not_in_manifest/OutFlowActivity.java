package edu.mit.icc_component_not_in_manifest;

import edu.mit.icc_component_not_in_manifest.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;

/**
 * @testcase_name ICC-Component-Not-in-Manifest
 * 
 * @description Testing if Activity not in the Manifest is also analyzed.
 * @dataflow 
 * @number_of_leaks 0 
 * @challenges The analysis must recognize that activity is not startable if it
 is not in the AndroidManifest.xml 
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
        startActivity(i);
    }
    
    public OutFlowActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513160000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "X5ANxd+uQGB+pxAAAA==");
}
