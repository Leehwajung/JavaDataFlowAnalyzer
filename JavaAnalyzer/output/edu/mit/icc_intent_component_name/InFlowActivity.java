package edu.mit.icc_intent_component_name;

import edu.mit.icc_intent_component_name.R;
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
    public static final long jlc$SourceLastModified$jl7 = 1478512961000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "RY0QAAA=");
}
