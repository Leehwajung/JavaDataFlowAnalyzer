package edu.mit.icc_action_string_operations;

import edu.mit.icc_action_string_operations.R;
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
    public static final long jlc$SourceLastModified$jl7 = 1478512841000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "cpwQAAA=");
}
