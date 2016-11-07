package edu.mit.application_modeling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;

/**
 * @testcase_name Application-Modeling
 * 
 * @description Test if modeling correctly instantiates a single application
 object from the manifest
 * and passes the object correctly to calls of getApplication()
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges The analysis tool has to be able to resolve explicit Intent
 carrying tainted sensitive information
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager mgr = (TelephonyManager)
                                 this.getSystemService(TELEPHONY_SERVICE);
        String imei = mgr.getDeviceId();
        ((MyApplication) getApplication()).imei = imei;
        Intent i = new Intent(this, AnotherActivity.class);
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478436311000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
