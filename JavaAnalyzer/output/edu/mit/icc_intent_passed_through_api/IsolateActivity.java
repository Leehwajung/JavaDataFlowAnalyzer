package edu.mit.icc_intent_passed_through_api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class IsolateActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        String imei = i.getStringExtra("DroidBench");
        Log.i("DroidBench", imei);
    }
    
    public IsolateActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513000000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "8TdWhzYHpRAAAA==");
}
