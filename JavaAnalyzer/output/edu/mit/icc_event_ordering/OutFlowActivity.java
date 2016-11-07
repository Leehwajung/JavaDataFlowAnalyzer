package edu.mit.icc_event_ordering;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * @testcase_name ICC-Event-Ordering
 * 
 * @description   Testing if information leak due to repeating of the same event
 squence multiple times can be detected 
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges  The analysis tool has to be able to take into account different
 runs of the app.  In this case, the end of one run is the source and the
 benning of the next run is the sink. 
 */
public class OutFlowActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent("edu.mit.icc_event_ordering.ACTION");
        startActivity(i);
    }
    
    public OutFlowActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513201000L;
    public static final String jlc$ClassType$jl7 =
      ("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" + "AAA=");
}
