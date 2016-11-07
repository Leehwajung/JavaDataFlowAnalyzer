package de.ecspride;

import android.content.Context;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

public class ConcreteClass extends BaseClass {
    @Override
    public String foo(Context context) {
        TelephonyManager telephonyManager =
          (TelephonyManager)
            context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }
    
    @Override
    public void bar(String s) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49 1234", null, s, null, null);
    }
    
    public ConcreteClass() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "fwDHewrn/xAAAA==");
}
