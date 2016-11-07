package de.ecspride;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Button1Listener implements OnClickListener {
    private final MainActivity act;
    
    public Button1Listener(MainActivity parentActivity) {
        super();
        this.act = parentActivity;
    }
    
    @Override
    public void onClick(View arg0) {
        TelephonyManager telephonyManager =
          (TelephonyManager) act.getSystemService(Context.TELEPHONY_SERVICE);
        act.imei = telephonyManager.getDeviceId();
        Button button2 = (Button) act.findViewById(R.id.button2);
        button2.setOnClickListener(new Button2Listener(act));
        Log.i("TAG", "button1");
    }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" + "AA==");
}
