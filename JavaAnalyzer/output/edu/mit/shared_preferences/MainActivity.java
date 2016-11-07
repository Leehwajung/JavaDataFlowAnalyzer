package edu.mit.shared_preferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.TelephonyManager;

/**
 * @testcase_name SharedPreferences
 * 
 * @description Test modeling of SharedPreferences
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges - Modeling of SharedPreferences
 */
public class MainActivity extends Activity {
    public static final String PREFS_NAME = "MyPrefsFile";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager mgr = (TelephonyManager)
                                 this.getSystemService(TELEPHONY_SERVICE);
        String imei = mgr.getDeviceId();
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("imei", imei);
        editor.commit();
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513675000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "/Jan5z8Sreb/AHYwjXeNEgAA");
}
