package de.ecspride;

import java.util.HashMap;
import java.util.Map;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * @testcase_name HashMapAccess1
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail steven.arzt@cased.de
 * 
 * @description A hash map is filled with both tainted and untainted data. The
 untainted
 * 	data is then read out and sent via SMS.
 * @dataflow -
 * @number_of_leaks 0
 * @challenges the analysis must distinguish between different hash map entries
 to recognize that the tainted
 *  data does not get leaked. 
 */
public class HashMapAccess1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hash_map_access1);
        Map<String,String> hashMap = new HashMap<String,String>();
        hashMap.put(
                  "tainted",
                  ((TelephonyManager)
                     getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId(
                                                                    ));
        hashMap.put("untainted", "Hello World");
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49 1234", null, hashMap.get("untainted"), null,
                            null);
    }
    
    public HashMapAccess1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "cl20AP8AfRBAn+IPAAA=");
}
