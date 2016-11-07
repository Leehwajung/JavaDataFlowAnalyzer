package edu.mit.string_to_char;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name String-to-Char
 * 
 * @description Test conversion of String to char[]
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges  The analysis tool has to be able to follow taint through
 character-string conversion
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager mgr = (TelephonyManager)
                                 this.getSystemService(TELEPHONY_SERVICE);
        String imei = mgr.getDeviceId();
        char[] chars = new char[imei.length()];
        imei.getChars(0, imei.length(), chars, 0);
        String builtImei = "";
        for (int i = 0; i < chars.length; i++) builtImei += chars[i];
        Log.i("DroidBench", builtImei);
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478510829000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
