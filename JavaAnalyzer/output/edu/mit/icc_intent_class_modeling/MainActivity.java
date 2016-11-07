package edu.mit.icc_intent_class_modeling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name Intent-Class-Modeling
 * 
 * @description Test if analysis links setter / getter of action field of
 Intent.
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges - Analysis must have a model of Intent implementation to  setter
 / getter of 
 * Intent fields
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager mgr = (TelephonyManager)
                                 this.getSystemService(TELEPHONY_SERVICE);
        String imei = mgr.getDeviceId();
        Intent i = new Intent();
        i.setAction(imei);
        Log.i("DroidBench", i.getAction());
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478461157000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
