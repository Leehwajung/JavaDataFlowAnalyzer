package edu.mit.icc_pass_action_string_through_api;

import edu.mit.icc_pass_action_string_through_api.R;
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
    public static final long jlc$SourceLastModified$jl7 = 1478513070000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "fPSd4cuis/gHEn4GvboQAAA=");
}
