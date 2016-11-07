package edu.mit.to_string;

import java.util.Arrays;
import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name ToString
 * 
 * @description Test underlying api calls to an objects toString() method
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges - Have to model that Array.toString invokes toString() for each
 object of array
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager mgr = (TelephonyManager)
                                 this.getSystemService(TELEPHONY_SERVICE);
        String imei = mgr.getDeviceId();
        String[] array = new String[1];
        array[1] = imei;
        String arrayToString = Arrays.toString(array);
        Log.i("DroidBench", arrayToString);
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478461667000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "P27bMjYTB+TIm/Nf3/jC+HeiS/gHXbeG4AsQAAA=");
}
