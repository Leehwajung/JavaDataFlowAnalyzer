package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * @testcase_name ObjectSensitivity2
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description A tainted value from a source is written to a local variable and
 a field. Both are overwritten before 
 *  they are passed to a sink
 * @dataflow
 * @number_of_leaks 0
 * @challenges the analysis must be able to remove taints from variables and
 fields
 */
public class OverwiteValue extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overwite_value);
        String var;
        DataStore ds = new DataStore();
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String taintedString = telephonyManager.getDeviceId();
        var = taintedString;
        ds.field = taintedString;
        var = "abc";
        ds.field = "def";
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49", null, var, null, null);
        sms.sendTextMessage("+49", null, ds.field, null, null);
    }
    
    public OverwiteValue() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAM1Xa2wUVRS+u32Xlm0LlIfQ8igoBXYEhcQUlbZQWlxoQwFj" +
       "VcrtzN3u0NmZ4c7ddilWwcRA/EGIFsRE+gvii5dEgonB1JgIBGOCIaImgv9E" +
       "hYT+EH+g4rl3ZnZ2pi3Gf26yd2bunHPueX7nzPHbKM+iaJFpaDu7NYNFSZpF" +
       "t2vLo2ynSazoutjyNkwtojRq2LI2wV6nPPd05O69A4myMMrvQJOwrhsMM9XQ" +
       "rY3EMrReosRQxNtdo5GkxVBZbDvuxVKKqZoUUy1WF0MTslgZqom5KkigggQq" +
       "SEIFqd6jAqZSoqeSjZwD68zagV5GoRjKN2WuHkNz/EJMTHHSEdMmLAAJhfx5" +
       "CxglmNMUzc7Ybts8yuCDi6TBt7aWnclBkQ4UUfV2ro4MSjA4pAOVJEmyi1Cr" +
       "XlGI0oHKdUKUdkJVrKn9Qu8OVGGp3TpmKUoyTuKbKZNQcabnuRKZ20ZTMjNo" +
       "xry4SjTFfcqLa7gbbK30bLUtbOL7YGCxCorROJaJy5Lbo+oKQ9VBjoyNNc8A" +
       "AbAWJAlLGJmjcnUMG6jCjp2G9W6pnVFV7wbSPCMFpzA0Y1yh3NcmlntwN+lk" +
       "aFqQrs1+BVRFwhGchaEpQTIhCaI0IxClrPjc3rBy/y69WQ8LnRUia1z/QmCq" +
       "CjBtJHFCiS4Tm7GkNnYIV57fF0YIiKcEiG2acy+NrFpcNXzRpnloDJrWru1E" +
       "Zp3y0a6JV2Y2Lnwih6tRaBqWyoPvs1ykf5vzpi5tQuVVZiTyl1H35fDGL5/b" +
       "/QH5LYyKW1C+bGipJORRuWwkTVUjdC3RCcWMKC2oiOhKo3jfggrgPqbqxN5t" +
       "jcctwlpQria28g3xDC6KgwjuogK4V/W44d6bmCXEfdpECBXAH5XAfzJC4XPO" +
       "9QxDB6XNFqS7lOjD21N6d4wQaTXpJZoBQZSeNWiPBVEn0jqeM6upoSoN4PGE" +
       "BGFRTYssManB/SU18aSuBy2F+9qJzg3vVdlOadTOMsmisqQQkGGZVIWb1l5C" +
       "+1QGdaylSJSnp/l/VSzNPVrWFwpBsGcGoUYDhZoNTSG0Ux5MNawZOdl5OZwp" +
       "PScWDE1XSNQ9Iuo7AoVCQvJkfpSdQpAAPQAlALIlC9tfXLdt39wcyF2zLxdC" +
       "yEml8bG+0QOfFgGxMlQAGj7ct2fLK4+GUdgP2lw92Crm7G0cajOQWhMs1rHk" +
       "RvbevHvq0IDhla2vCzhoMpqTo8HcoCOpIRMF8NUTXzsbn+08P1ATRrkAMQCr" +
       "DEMZAGJVBc/woUKdi7DcljwwOG7QJNb4KxcWi1mCGn3ejojwRL5U2MHm8Qgo" +
       "KMD5yXbzyHdf//KY8KSL45GszthOWF0WdnBhEYES5V54N1FCgO7Hw21vHry9" +
       "93kRW6CYN9aBNXxtBMyA6IAHX7u44/sb149eDXv5wKB5pro0VU4LW8rvwy8E" +
       "/7/5nwMA3+BXaAONDvjMzqCPyU9e4OkGOKRBhfDkqNmsJw1Fjau4SyM8Gf+M" +
       "zF969tb+MjvcGuy42bL43wV4+9Mb0O7LW/+oEmJCMu+Dnv88MhtcJ3mS6ynF" +
       "O7ke6T3fzHr7Aj4CMA3QaKn9RKAdEv5AIoCS8EWtWKOBd0v5Um1l57i/jLLm" +
       "lU75wNU7pVvufDYitPUPPNlxX4/NOjuL7CjAYYuRs3DUveZe+dtJJl8np0GH" +
       "qcGqb8ZWAoQ9PrzhhTJt+B4c2wHHyjAKWK0UUCbtSyWHOq/gh8+/qNx2JQeF" +
       "m1CxZmClCYuCQ0WQ6cRKAEClzadXIfHrK4SlTPgDjfKQnUXTnCfxMFus8/iy" +
       "wM45fvtwOmOp+OU7Fn7kXD/MstQvk6JZ440CYow5+urgkNJ6bKndsCv87XUN" +
       "TI8nvv3rq+jhny6NgbNFzDCXaLxnZJ3JMbN2fMxcL0YmD3cuvPrrjE1PJbb9" +
       "B7isDhgUFPn++uOX1i6Q3wijnAxSjhrm/Ex12abBoZTA9KlzJ/GdYpFsszIh" +
       "mMhduwL+UxHKqbKv4bvZyWbj2tjxBL9B72RQeETxwirCVerI+t253gqG1Suy" +
       "kONs/jyFoXKsK7xHRw0r2pDSFY0IHTY8oDQ38mUtQ4WG3kgJ4BMEbuEDPmyo" +
       "muR93BkGpYGKGz3v3Dxh501wcgwQk32Dr9+P7h8MZ43X80ZNuNk89ogt9Czl" +
       "yyM8k+c86BTB0fTzqYFP3xvYG3ZsXMVQbi+4RThgGV+abZevcOqzJFOfGVdW" +
       "iIrn47uYHfgQ4WPxlfRYRc1QqW/o4NA6bdRXkz3pyyeHIoVThzZfE303M40X" +
       "QVuLpzQtKyez8zPfpCSuCguLbCA0xQXwfULW7AOxdW+Fll02VZyhsCJEdZuu" +
       "0ZPd/MGmGa2X7XktHRqNT8vsxj2+R4LwM8+XUuIb063blP2V2SmfGlq3YdfI" +
       "imN2p4ev0/5+8U0Cn1j2PJGp/TnjSnNl5TcvvDfxdNF8NwV8k0ZAt+qxW+ma" +
       "pMlE8+v/ZOrHK98dui4mgH8AywVuwfwPAAA=");
}
