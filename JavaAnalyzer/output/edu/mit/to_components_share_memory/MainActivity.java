package edu.mit.to_components_share_memory;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import edu.mit.to_components_share_memory.R;

/**
 * @testcase_name Two-Components-Share-Memory
 * 
 * @description Test case where two activities share a singleton, and a flow is
 activited on a 
 particular ordering of the Activities
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges - Analysis has to reason about all legal interleavings of
 separate components.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Singleton.v().s = "";
    }
    
    protected void onStop() { Log.i("DroidBench", Singleton.v().s); }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513711000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "7898d83rY5dlG/UPmj66JXMRAAA=");
}
