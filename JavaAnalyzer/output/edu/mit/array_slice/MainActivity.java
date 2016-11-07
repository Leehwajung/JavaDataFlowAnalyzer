package edu.mit.array_slice;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name ArraySlice 
 * 
 * @description Testing whether an element in a multidimensional array is
 tracked
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges The analysis tool has to be able to track an element within a
 multidimensional array
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager mgr = (TelephonyManager)
                                 this.getSystemService(TELEPHONY_SERVICE);
        String imei = mgr.getDeviceId();
        String[][] array = new String[1][1];
        array[0][0] = imei;
        String[] slice = array[0];
        Log.i("DroidBench", slice[0]);
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478461723000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
