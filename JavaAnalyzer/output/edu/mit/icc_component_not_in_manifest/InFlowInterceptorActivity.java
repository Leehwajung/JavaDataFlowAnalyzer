package edu.mit.icc_component_not_in_manifest;

import android.app.Activity;
import android.os.Bundle;

public class InFlowInterceptorActivity extends Activity {
    InFlowActivity inflow;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflow = new InFlowActivity();
        inflow.setIntent(getIntent());
        inflow.onCreate(savedInstanceState);
    }
    
    public InFlowInterceptorActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513160000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "NPK2/xIAAA==");
}
