package org.cert.sendsms;

import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class Button1Listener implements OnClickListener {
    private final MainActivity act;
    
    public Button1Listener(MainActivity parentActivity) {
        super();
        this.act = parentActivity;
    }
    
    @Override
    public void onClick(View arg0) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        TelephonyManager tManager =
          (TelephonyManager)
            this.act.getSystemService(Context.TELEPHONY_SERVICE);
        String uid = tManager.getDeviceId();
        i.putExtra("secret", uid);
        Log.i("SendSMS: ",
              ("Sending implicit Intent with MIME data type text/plain: Devi" +
               "ceId ") +
                uid);
        this.act.startActivityForResult(i, 0);
    }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478512102000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "XNRZiz/e8tJtP1x5XxSY/wGoWsnNcRIAAA==");
}
