package edu.mit.event_ordering;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name Event-Ordering
 * 
 * @description Test case for considering all possible event orderings for event
 * There is a leak when onLowMemory is called twice without a call to
 onContentChanged()
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges -
 */
public class MainActivity extends Activity {
    String imei = "";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    @Override
    public void onLowMemory() {
        Log.i("DroidBench", imei);
        TelephonyManager mgr = (TelephonyManager)
                                 this.getSystemService(TELEPHONY_SERVICE);
        imei = mgr.getDeviceId();
    }
    
    @Override
    public void onContentChanged() {
        imei = "";
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478515314000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "bxQAAA==");
}
