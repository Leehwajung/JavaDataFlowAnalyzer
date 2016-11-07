package edu.mit.to_components_share_memory;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import edu.mit.to_components_share_memory.R;

public class AnotherActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager mgr = (TelephonyManager)
                                 this.getSystemService(TELEPHONY_SERVICE);
        Singleton.v().s = mgr.getDeviceId();
    }
    
    public AnotherActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513711000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "VHvdgBAAAA==");
}
