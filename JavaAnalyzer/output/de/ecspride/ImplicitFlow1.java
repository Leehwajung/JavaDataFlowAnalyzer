package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name ImplicitFlow1
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description A value from a source gets obfuscated by two different ways and
 is then written to the log
 * @dataflow source -> userInputPassword -> if-condition -> sink
 * @number_of_leaks 2
 * @challenges the analysis must be able to handle implicit flows and
 *  treat the value of password fields as source 
 */
public class ImplicitFlow1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_flow1);
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        String obfuscatedIMEI = obfuscateIMEI(imei);
        writeToLog(obfuscatedIMEI);
        obfuscatedIMEI = copyIMEI(imei);
        writeToLog(obfuscatedIMEI);
    }
    
    private String obfuscateIMEI(String imei) {
        String result = "";
        for (char c : imei.toCharArray()) {
            switch (c) {
                case '0':
                    result += 'a';
                    break;
                case '1':
                    result += 'b';
                    break;
                case '2':
                    result += 'c';
                    break;
                case '3':
                    result += 'd';
                    break;
                case '4':
                    result += 'e';
                    break;
                case '5':
                    result += 'f';
                    break;
                case '6':
                    result += 'g';
                    break;
                case '7':
                    result += 'h';
                    break;
                case '8':
                    result += 'i';
                    break;
                case '9':
                    result += 'j';
                    break;
                default:
                    System.err.println(
                                 "Problem in obfuscateIMEI for character: " +
                                   c);
            }
        }
        return result;
    }
    
    private String copyIMEI(String imei) {
        Integer[] numbers = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
        11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46,
        47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };
        char[] imeiAsChar = imei.toCharArray();
        char[] newOldIMEI = new char[imeiAsChar.length];
        for (int i = 0; i < imeiAsChar.length; i++) {
            int tmp = numbers[(int) imeiAsChar[i]];
            newOldIMEI[i] = (char) tmp;
        }
        return new String(newOldIMEI);
    }
    
    private void writeToLog(String message) { Log.i("INFO", message); }
    
    public ImplicitFlow1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "zvx47Q/vf27+XdkP/xf4uEUM6BIAAA==");
}
