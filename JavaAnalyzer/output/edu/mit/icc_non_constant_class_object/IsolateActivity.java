package edu.mit.icc_non_constant_class_object;

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
    public static final long jlc$SourceLastModified$jl7 = 1478513034000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "H6UQAAA=");
}
