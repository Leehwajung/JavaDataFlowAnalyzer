package edu.mit.icc_componentname_class_constant;

import edu.mit.icc_componentname_class_constant.R;
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
    public static final long jlc$SourceLastModified$jl7 = 1478512878000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "H4/xQGqwEAAA");
}
