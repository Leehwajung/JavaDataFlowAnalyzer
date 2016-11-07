package edu.mit.icc_intent_component_name;

import edu.mit.icc_intent_component_name.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.content.ComponentName;

/**
 * @testcase_name ICC-Intent-Component-Name 
 * 
 * @description   Testing the intent resolution of component name 
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges The analysis tool must be able to resolve Intent's component from
 a component name and follow the taint to another Activity. 
 */
public class OutFlowActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        ComponentName cn = new ComponentName(
          this, "edu.mit.icc_intent_component_name.InFlowActivity");
        Intent i = new Intent();
        i.setComponent(cn);
        i.putExtra("DroidBench", imei);
        startActivity(i);
    }
    
    public OutFlowActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478512961000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "XaqREAAA");
}
