package edu.mit.icc_intent_passed_through_api;

import edu.mit.icc_intent_passed_through_api.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class InFlowActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = getIntent();
        String imei = i.getStringExtra("DroidBench");
        Log.i("DroidBench", imei);
    }
    
    public InFlowActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513000000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "9BN/A7Nhnh+hEAAA");
}
