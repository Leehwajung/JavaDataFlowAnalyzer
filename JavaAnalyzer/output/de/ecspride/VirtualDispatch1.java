package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;

/**
 * @testcase_name VirtualDispatch1
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description This example contains a leakage of the imei in the clickButton()
 callback.
 *  The data source is placed into the onCreate() callback method in this class.
 The data sink is placed in the
 *  logData() method of the DataLeak class.
 * @dataflow onCreate: source -> data -> onClick -> DataLeak:logData -> sink 
 * @number_of_leaks 1
 * @challenges the analysis must be able to handle invoke-virtual statements.
 Additionally the clickButton() 
 * callback must be correctly considered as a callback.  
 */
public class VirtualDispatch1 extends Activity {
    private String imei;
    private int counter = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virtual_dispatch1);
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        imei = telephonyManager.getDeviceId();
    }
    
    public void clickButton(View view) {
        ++counter;
        NoDataLeak data = null;
        if (counter % 2 == 0) data = new NoDataLeak("no leak"); else
            data = new DataLeak(imei);
        data.logData();
    }
    
    public VirtualDispatch1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "PGpEZsMTAAA=");
}
