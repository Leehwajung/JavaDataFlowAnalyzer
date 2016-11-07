package edu.mit.activity_saved_state;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name Activity-Saved-State
 * 
 * @description Test of saving Activity state in Bundle
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges - Event ordering and Activity saved state
 */
public class MainActivity extends Activity {
    public static final String KEY = "DroidBench";
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            String value = savedInstanceState.getString(KEY);
            Log.i("DroidBench", value);
        }
    }
    
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        TelephonyManager mgr = (TelephonyManager)
                                 this.getSystemService(TELEPHONY_SERVICE);
        String imei = mgr.getDeviceId();
        savedInstanceState.putString(KEY, imei);
        super.onSaveInstanceState(savedInstanceState);
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478515165000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "Jhel6NxPNrx43w8W3xf1+H8BYvOgq5YTAAA=");
}
