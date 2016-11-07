package edu.mit.icc_componentname_class_constant;

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
    public static final long jlc$SourceLastModified$jl7 = 1478512878000L;
    public static final String jlc$ClassType$jl7 =
      ("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" + "EAAA");
}
