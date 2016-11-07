package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class Activity2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        Activity1.data1 = telephonyManager.getDeviceId();
    }
    
    public Activity2() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "nfrxqveGbojT/x+/4MNI+A8AAA==");
}
