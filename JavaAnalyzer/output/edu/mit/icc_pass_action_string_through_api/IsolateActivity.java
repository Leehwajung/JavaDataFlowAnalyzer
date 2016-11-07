package edu.mit.icc_pass_action_string_through_api;

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
    public static final long jlc$SourceLastModified$jl7 = 1478513070000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "FK3FPzaJ38y+EAAA");
}
