package edu.mit.icc_concat_action_string;

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
    public static final long jlc$SourceLastModified$jl7 = 1478512920000L;
    public static final String jlc$ClassType$jl7 =
      ("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" + "AA==");
}
