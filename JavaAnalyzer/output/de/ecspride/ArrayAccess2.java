package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * @testcase_name ArrayAccess2
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description an array is created which is filled with untainted and tainted
 (deviceId source) data.
 *   The untainted data of a calculated array position is retrieved and sent via
 sms.
 * @dataflow -
 * @number_of_leaks 0
 * @challenges the analysis must distinguish between different array positions
 and has to evaluate the function to recognize that the tainted
 *  data does not get leaked. 
 */
public class ArrayAccess2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_access2);
        String[] array = new String[10];
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        array[5] = telephonyManager.getDeviceId();
        array[4] = "no taint";
        SmsManager sm = SmsManager.getDefault();
        sm.sendTextMessage("+49 1234", null, array[calculateIndex()], null,
                           null);
    }
    
    private int calculateIndex() {
        int index = 1;
        index++;
        index *= 5;
        index = index % 10;
        index += 4;
        return index;
    }
    
    public ArrayAccess2() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "9RAAAA==");
}
