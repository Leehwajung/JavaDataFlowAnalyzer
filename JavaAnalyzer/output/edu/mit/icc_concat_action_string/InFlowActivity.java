package edu.mit.icc_concat_action_string;

import edu.mit.icc_concat_action_string.R;
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
    public static final long jlc$SourceLastModified$jl7 = 1478512920000L;
    public static final String jlc$ClassType$jl7 =
      ("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" + "EAAA");
}
