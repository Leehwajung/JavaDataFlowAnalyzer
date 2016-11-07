package edu.mit.icc_component_not_in_manifest;

import edu.mit.icc_component_not_in_manifest.R;
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
    public static final long jlc$SourceLastModified$jl7 = 1478513160000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "IPuJvwHJQgxdoxAAAA==");
}
