package edu.mit.icc_unresolvable_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class InFlowActivity2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        String imei = i.getStringExtra("DroidBench");
        Log.i("DroidBench", imei);
    }
    
    public InFlowActivity2() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513751000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "gRAAAA==");
}
