package de.ecspride;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * @testcase_name LogNoLeak
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description An untainted value is written to the log
 * @dataflow -
 * @number_of_leaks 0
 * @challenges the analysis has to be aware that no tainted value can reach the
 sink
 */
public class LogNoLeak extends Activity {
    private String notTainted = "";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_no_leak);
        notTainted = "not tainted";
    }
    
    public void onPause() { Log.i("TAG", notTainted); }
    
    public LogNoLeak() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
