package edu.mit.icc_component_not_in_manifest;

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
    public static final long jlc$SourceLastModified$jl7 = 1478513160000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "ZUPxNzwwOtqnEAAA");
}
