package edu.mit.icc_intent_component_name;

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
    public static final long jlc$SourceLastModified$jl7 = 1478512961000L;
    public static final String jlc$ClassType$jl7 =
      ("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" + "AA==");
}
