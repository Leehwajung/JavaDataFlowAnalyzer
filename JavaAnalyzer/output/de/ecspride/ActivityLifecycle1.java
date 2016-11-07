package de.ecspride;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;

/**
 * @testcase_name ActivityLifecycle1
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description The return value of source method is stored to a static variable
 in one callback method
 *  and sent to a sink in a different callback method
 * @dataflow onCreate: source -> imei -> URL; onResume: URL -> sink
 * @number_of_leaks 1
 * @challenges the analysis must be able to handle the activity lifecycle
 correctly and
 *  handle try/catch blocks
 */
public class ActivityLifecycle1 extends Activity {
    private static String URL = "http://www.google.de/search?q=";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_lifecycle1);
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        URL = URL.concat(imei);
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        try { connect(); }
        catch (Exception ex) {  }
    }
    
    private void connect() throws IOException {
        URL url = new URL(URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.connect();
    }
    
    public ActivityLifecycle1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "Xrz/uwtv8tvFfwGZxGWKRxQAAA==");
}
