package edu.mit.public_api_field;

import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name Public-API-Field
 * 
 * @description Track flows through an API field setter and a direct field
 access
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges - Must have accurate modeling for API classes that expose fields
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager mgr = (TelephonyManager)
                                 this.getSystemService(TELEPHONY_SERVICE);
        String imei = mgr.getDeviceId();
        float fx = Float.valueOf(imei.substring(0, 8));
        float fy = Float.valueOf(imei.substring(8));
        PointF point = new PointF(fx, fy);
        Log.i("DroidBench", "IMEI: " + point.x + "" + point.y);
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478461060000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
