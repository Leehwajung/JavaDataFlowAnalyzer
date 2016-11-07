package edu.mit.icc_broadcast_programmatic_intentfilter;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name ICC-Broadcast-Programmatic-IntentFilter
 * 
 * @description   Testing BroadcastReceiver through programmatic setting up of
 IntentFilter 
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges    The analysis tool has to be able to recognize a broadcast
 receiver and models its IntentFilter
 */
public class BroadcastTest extends Activity {
    private static String ACTION =
      "edu.mit.icc_broadcast_programmatic_intentfilter.action";
    
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BroadcastReceiver receiver = new BroadcastReceiver() {
            public void onReceive(Context c, Intent i) {
                String taint = i.getStringExtra("imei");
                if (taint != null) Log.i("DroidBench", taint);
            }
        };
        this.registerReceiver(receiver, new IntentFilter(ACTION));
    }
    
    public void onDestroy() {
        TelephonyManager mgr = (TelephonyManager)
                                 getSystemService(TELEPHONY_SERVICE);
        String imei = mgr.getDeviceId();
        Intent intent = new Intent(ACTION);
        intent.putExtra("imei", imei);
        sendBroadcast(intent);
        super.onDestroy();
    }
    
    public BroadcastTest() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "YMERsjyc/u76b93/tbk3ZY38P7JJnAmWEwAA");
}
