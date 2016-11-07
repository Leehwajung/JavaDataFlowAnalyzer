package edu.mit.icc_action_string_operations;

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
    public static final long jlc$SourceLastModified$jl7 = 1478512841000L;
    public static final String jlc$ClassType$jl7 =
      ("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" + "EAAA");
}
