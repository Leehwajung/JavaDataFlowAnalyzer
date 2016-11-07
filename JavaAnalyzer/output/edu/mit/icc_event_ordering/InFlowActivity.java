package edu.mit.icc_event_ordering;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

public class InFlowActivity extends Activity {
    private static final String PREFS_NAME = "prefs";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String imei = settings.getString("imei", "");
        Log.i("DroidBench", imei);
        writePreferences();
    }
    
    private void writePreferences() {
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("imei", imei);
        editor.commit();
    }
    
    public InFlowActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513201000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "/SeVEwAA");
}
