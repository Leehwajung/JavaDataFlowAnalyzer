package edu.mit.string_formatter;

import java.util.Formatter;
import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name String Format
 * 
 * @description Test String Formatter
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges - Modeling of StringBuffer and StringFormatter
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager mgr = (TelephonyManager)
                                 this.getSystemService(TELEPHONY_SERVICE);
        String imei = mgr.getDeviceId();
        StringBuffer buf = new StringBuffer();
        Formatter formatter = new Formatter(buf);
        formatter.format("%s", imei);
        formatter.close();
        Log.i("DroidBench", buf.toString());
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478510752000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "H77r0iYTx2X/J9M+Wvne0E0xM/wDI7OKxCwQAAA=");
}
