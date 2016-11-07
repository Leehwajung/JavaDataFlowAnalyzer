package edu.mit.outputstream;

import java.io.ByteArrayOutputStream;
import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name OutputStream
 * 
 * @description tainted value is written to an output stream and then read back
 as a string that is leaked
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges   The analysis tool has to be able to track tainted value through
 different stream/memory operations 
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager mgr = (TelephonyManager)
                                 this.getSystemService(TELEPHONY_SERVICE);
        String imei = mgr.getDeviceId();
        byte[] bytes = imei.getBytes();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(bytes, 0, bytes.length);
        String outString = out.toString();
        Log.i("DroidBench", outString);
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478510869000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
