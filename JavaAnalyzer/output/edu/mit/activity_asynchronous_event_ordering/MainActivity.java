package edu.mit.activity_asynchronous_event_ordering;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name Activity-Asynchronous-Event-Ordering
 * 
 * @description Account for the asynchronous event firing of onLowMemory
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges - The analysis must account for all legal ordering of asynch
 events with respect
 * to the activity life cycle
 */
public class MainActivity extends Activity {
    String imei = "";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    protected void onStop() { Log.i("DroidBench", imei); }
    
    protected void onResume() {
        TelephonyManager mgr = (TelephonyManager)
                                 this.getSystemService(TELEPHONY_SERVICE);
        imei = mgr.getDeviceId();
    }
    
    public void onLowMemory() { imei = ""; }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478515225000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAANVYbWwcRxmeW387Ts6+fOImjhO7ofngFhcaqXIpca524/Qc" +
       "W7nEiKPpZbw7Z2+yt7vZnTufXVzaiCqhP6II3DSgxr9SAVHaVFUrkFCRUQVt" +
       "VYRUVPEl0SL+UCgRzY+GCkPDO7Pfe+erI35x0s7szcz7zvv5zDt79TpqsEy0" +
       "29DVmUlVp0lSpskT6j1JOmMQK3kwfc8YNi0ip1RsWUdgLCdtfzF+c+n8VLuA" +
       "GrNoLdY0nWKq6Jp1mFi6WiJyGsX90UGVFCyK2tMncAmLRaqoYlqxaH8arQqQ" +
       "UtSbdkUQQQQRRBC5COKAvwqIVhOtWEgxCqxR6xR6DMXSqNGQmHgUbQszMbCJ" +
       "Cw6bMa4BcGhm/8dBKU5cNlG3p7utc4XCT+8W5595pP2lOhTPoriiZZg4EghB" +
       "YZMsaiuQwgQxrQFZJnIWdWiEyBliKlhVZrncWZSwlEkN06JJPCOxwaJBTL6n" +
       "b7k2ielmFiWqm556eYWosvuvIa/iSdB1g6+rreEQGwcFWxUQzMxjibgk9ScV" +
       "TaZoa5TC07H3IVgApE0FQqd0b6t6DcMASti+U7E2KWaoqWiTsLRBL8IuFHUu" +
       "y5TZ2sDSSTxJchRtiq4bs6dgVQs3BCOhaH10GecEXuqMeCngn+uH7jv3qHZA" +
       "E7jMMpFUJn8zEHVFiA6TPDGJJhGbsG1X+gLe8OpZASFYvD6y2F7zo6/f2Len" +
       "a/ENe80dVdaMTpwgEs1JlyfWvL05tfPeOiZGs6FbCnN+SHMe/mPOTH/ZgMzb" +
       "4HFkk0l3cvHwL776+BXygYBah1GjpKvFAsRRh6QXDEUl5oNEIyamRB5GLUST" +
       "U3x+GDXBe1rRiD06ms9bhA6jepUPNer8P5goDyyYiZrgXdHyuvtuYDrF38sG" +
       "QqgJHtQGTwdCsSWnv0nRFfGoBeEuTk3jE0VtMk2I+AApEVUHJ0K2yqauyBla" +
       "lBVdfIC97weDT0HS54k0I6lEHLBmYMDUNb1oDZaIRkdNmbCo6hOxYYiWKYkF" +
       "rGgiDzoiF8WCQkUsUaWk0JkcDlDnCCPP6Q69OAJkA87CJCM3/q+kLTPbt0/H" +
       "YhAWm6OgpEI+H9BVoM1J88X9gzdeyL0leEnqeI2ie0GEJIiQXIkIyaAIKBbj" +
       "O69jotjBCKF0EkAJ4LptZ+bYweNnt9dBFhjT9RAMbKm4/KmR8mFsmIO1BLmE" +
       "Fi9OPzH+jc8LSAjDPxMfhloZ+RgDbQ+ce6NpX41v/Mz7N69dmNN9AAidJw4u" +
       "VVIyXNkeNbSpS2BDk/jsd3XjV3KvzvUKqB7ACgCagtkY9nVF9wjhS7+L1UyX" +
       "BlA4r5sFrLIpF2BbKThm2h/hEbCGNQk7GJg/IgJymP9Sxrj0u1/99Qvcku6J" +
       "EA+csRlC+wMoxJjFOd50+O49YhIC6/54cew7T18/8zXuW1jRU23DXtamAH3A" +
       "O2DBJ9849fv33r38juDHA4VjuDihKlKZ69JxC34xeD5hD4MSNsB6OFBSDox1" +
       "ezhmsJ13+LIBoqmAqiw4eo9qBV1W8gqeUAkLxn/H7+x75e/n2m13qzDiRsue" +
       "T2fgj39mP3r8rUf+2cXZxCR2ovr285fZML3W5zxgmniGyVF+4tdbvvs6vgSA" +
       "DyBrKbOE4ybi9kDcgSK3xS7eJiNzfazZagVjPJxGgconJ51/58PV4x/+9AaX" +
       "Nlw6Bf0+go1+O4psL8Bmu5HTwB+h0+3Z7FqDtevKIMPGaNYfwNYUMPvi4qGH" +
       "29XFJdg2C9tKUFRYHAHLoVByVjc0/eFnr204/nYdEoZQq6pjeQjzhEMtEOnE" +
       "mgIAKxtf3of4b7oZmnZuD1RhITuKNnlYs3N5rBli5ZGfrpv+NapOnP7zxxWW" +
       "4ihTpSqI0GfFq892pu7/gNP76c6ou8qVyAylpE9795XCR8L2xp8LqCmL2iWn" +
       "Th3HapFlWhZqM8stXqGWDc2H6yy7qOj34GxzFGoC20aBxj8R4J2tZu+tkajg" +
       "Vl4PTwKioc/pu4NREUP8ZR8n6eZtD2t2OB4Ks6p3WVRhRaHMKBCFE6yHuwCP" +
       "G6Zm0i4nbahj7d2sGbBZ760WJ+Xq0sTY62d9kfiv0alZPnL6fwRECkQXYvG/" +
       "ZbnykpfGl0/PL8ijz/XZRWAiXLINwo3k+d/855fJi396s8qJ3EJ143MqKzkC" +
       "e9bDlruWj+gRXob7YfX66b91Hrl/6vhtHJxbIwpFWf5w5OqbD+6Qvi2gOi/I" +
       "Ki4IYaL+cGi1mgRuNNqRUIBt8Vywhpl2rx1kwrTTjwYDzHd7pT/BboapU8gB" +
       "IkcibbXD65DTD0bd6sNtzIEPJ/A6sF3vJXUrub+oySrhMhyrAdKYNeMUNeta" +
       "yiRwUtWGojFTgeJLKTkXDHEu8d7JZ99/3o6bKO5EFpOz80/dSp6bFwJXtp6K" +
       "W1OQxr62cTlXs+YuFsnbau3CKYb+cm3uJz+YOyM4Oo5CfpbALH4GfiWcgW1e" +
       "BnqmTPg5PFoipqnIpEbSVsI7H8iEg+UOeOB8qks4fcNKg4W9ZqtECWNSb/fC" +
       "0vJREvR3qcYcbyCjG3UtA0nN/uV9m52qgVorUn8LPF0gser0x5ZRnzVWpbKM" +
       "5GGnz6xM2dM15r7Jmjke+IeJVbSzPqDuY/+DuqtcdXtA/g67r7tVQ92Hwuq2" +
       "OiSfOP3HK1P3XI2586z5FkWrdC2tT4+Qgm7ORDR+6nY0LlPUFrxdsRpyU8WH" +
       "JvvjiPTCQrx548LR3/ILhvcBowXq93xRVYOneeC90TBJXuHCt9hnu8G7Zyja" +
       "czuXQLgqrWQZ1/CCvcX3KGpytqCoDtrg5CUYgkn2umC4cLHORV64Myddm5Rj" +
       "4VPYs3Ti0ywdOLh7QmDMv/i5J17R/uaXk64tHDz06I29z9m3JUnFs7OMS3Ma" +
       "Ndl3Mu/U3LYsN5dX44GdS2tebLnTBc/QbS0i29bq15HBgkH5BWL2xxtfvu/7" +
       "C+/yW9R/Aa7bhy6KFQAA");
}
