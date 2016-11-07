package edu.mit.non_sink_argument_flow;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;

/**
 * @testcase_name Non-Sink-Argument-Flow
 * 
 * @description Flow to sink is through memory reachable from receiver, but not
 through argument
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges   The analysis tool has to be able to track taint flown to sink
 through a receiver
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager mgr = (TelephonyManager)
                                 this.getSystemService(TELEPHONY_SERVICE);
        String imei = mgr.getDeviceId();
        try {
            ProcessBuilder pb = new ProcessBuilder();
            pb.command("cmd", imei);
            pb.start();
        }
        catch (Exception e) {  }
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478510665000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "g5SFWBAAAA==");
}
