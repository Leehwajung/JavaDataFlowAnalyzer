package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name InactiveActivity
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description A value from a source is written to the log but the activity is
 not active
 * @dataflow -
 * @number_of_leaks 0
 * @challenges the analysis has to be aware that the activity is set to inactive
 in manifest file
 */
public class InactiveActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inactive);
        TelephonyManager mTelephonyMgr =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = mTelephonyMgr.getDeviceId();
        Log.i("INFO", imei);
    }
    
    public InactiveActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "vD96XTQB/wBMnPPU8A8AAA==");
}
