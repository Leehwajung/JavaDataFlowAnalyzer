package edu.mit.clone;

import java.util.LinkedList;
import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name Clone
 * 
 * @description Tesging LinkedList.clone
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges - must model clone of list
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager mgr = (TelephonyManager)
                                 this.getSystemService(TELEPHONY_SERVICE);
        String imei = mgr.getDeviceId();
        LinkedList<String> list = new LinkedList<String>();
        list.add(imei);
        LinkedList<String> list2 = (LinkedList<String>) list.clone();
        Log.i("DroidBench", list2.get(0));
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478510346000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "hz6a88G6t0evie7gH+vuX57hDwAA");
}
