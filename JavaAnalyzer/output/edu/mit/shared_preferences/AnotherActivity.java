package edu.mit.shared_preferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class AnotherActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences settings =
          getSharedPreferences(MainActivity.PREFS_NAME, 0);
        String imei = settings.getString("imei", "");
        Log.i("DroidBench", imei);
    }
    
    public AnotherActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513675000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
