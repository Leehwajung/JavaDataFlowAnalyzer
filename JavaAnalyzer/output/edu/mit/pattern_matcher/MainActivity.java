package edu.mit.pattern_matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name PatternMatcher
 * 
 * @description Test common usage of pattern and matcher in Java
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges - flows through multiple object allocated in API code
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager mgr = (TelephonyManager)
                                 this.getSystemService(TELEPHONY_SERVICE);
        String imei = mgr.getDeviceId();
        Pattern p = Pattern.compile("(.*)");
        Matcher matcher = p.matcher(imei);
        if (matcher.matches()) {
            String match = matcher.group(1);
            Log.i("DroidBench", match);
        }
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478510790000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAM1XW2wUVRg+u73X0m0LtIhACxS0BXcEBWOKCpSWFreXtEBi" +
       "VZbTmbPdKbMzw5mz7VKsAomB+ECIFMRE+gTxEm4xEk0MpkYjIMaIId4SwTfx" +
       "QqQv+ICK/zkzuzM7bTG+ucmemTnz3y/f+efEDZRnUbTENLQdfZrBwiTFwv3a" +
       "ijDbYRIrvCGyohNTiyiNGrasjbAXlRecCd26fSBeFkT5PWg61nWDYaYautVF" +
       "LEMbIEoEhdzdJo0kLIbKIv14AEtJpmpSRLVYQwTd42FlqDaSNkECEyQwQRIm" +
       "SGtcKmCaRvRkopFzYJ1Z29ELKBBB+abMzWNofrYQE1OccMR0Cg9AQiF/3gxO" +
       "CeYURTUZ322fJzh8aIk08uqWsndyUKgHhVS9m5sjgxEMlPSgkgRJ9BJqrVEU" +
       "ovSgcp0QpZtQFWvqkLC7B1VYap+OWZKSTJD4ZtIkVOh0I1cic99oUmYGzbgX" +
       "U4mmpJ/yYhruA18rXV9tD5v5PjhYrIJhNIZlkmbJ3abqCkPVfo6Mj7VPAQGw" +
       "FiQIixsZVbk6hg1UYedOw3qf1M2oqvcBaZ6RBC0MzZ5SKI+1ieVtuI9EGZrl" +
       "p+u0XwFVkQgEZ2Fopp9MSIIszfZlyZOfG+2r9u/UW/SgsFkhssbtLwSmeT6m" +
       "LhIjlOgysRlL6iOHceW5fUGEgHimj9imee/58dVL541dsGnum4Smo7efyCwq" +
       "H+stvTynse6xHG5GoWlYKk9+luei/DudNw0pEzqvMiORvwynX451ffr0rrfJ" +
       "r0FU3IryZUNLJqCOymUjYaoaoeuJTihmRGlFRURXGsX7VlQA9xFVJ/ZuRyxm" +
       "EdaKcjWxlW+IZwhRDETwEBXAvarHjPS9iVlc3KdMhFAB/FEJ/KcjFPjSuV5i" +
       "6KC0yYJyl+KDuD+p90UIkdaRAaIZkEToVoUaqtLNkopqSOv4/VoIeFyyLdY2" +
       "8Eqyi6gTM6ggvQ0zOQ6PyyRsmpJFZSmBVV0SJUeUpJRQeSML0miC04KWNqBY" +
       "IzN1QGU7wpzS/H+aleLRLBsMBCDRc/wwo0GHthiaQmhUHkmubRo/Fb0UzLSd" +
       "kwcARtAWBm1hn7awVxsKBISSGVyrXUlQB9sAUQBrS+q6n9uwdd+CHChhczAX" +
       "MslJpakhv9HFoFaBtDI0Aho7Mrh784sPBVEwG7u5pbBVzNk7OeJmkLXW37OT" +
       "yQ3tvX7r9OFhw+3erMPAAZWJnBwUFvhjSg0ZwkWJK76+Bp+NnhuuDaJcQBpA" +
       "VwZh48A1z68jCxwa0kDLfckDh2MGTWCNv0qjYzGLU2PQ3RHJLuVLhZ13ng+f" +
       "gQKjH+82j377xc8Pi0im4TzkOSC7CWvwQAgXFhJgUe6mdyMlBOh+ONJ58NCN" +
       "vc+I3ALFwskU1vK1EaADsgMRfOnC9u+uXT12JejWA4MzNNmrqXJK+FJ+B34B" +
       "+P/N/xwH+Aa/wmnQ6GBQTQaETK55sWsbwJEGkMiLo3aTnjAUNabiXo3wYvwz" +
       "tGjZ2d/2l9np1mAnXS1L/12Au3/vWrTr0pY/5gkxAZkfh278XDIbY6e7ktdQ" +
       "indwO1K7v5r72nl8FNAaENJSh4gAPSTigUQCJRGLerGGfe+W8aXa8tZ4dht5" +
       "xpaofODKzWmbb344LqzNnnu8eW/DZoNdRXYWQNkS5CwcfH9PX/nb6SZfZ6TA" +
       "hip/17dgKw7CHhlrf7ZMG7sNantArQwTgdVBAXBSWaXkUOcVfP/Rx5VbL+eg" +
       "YDMq1gysNGPRcKgIKp1YccCqlPnkaiR+g4WwlIl4oAkRsqtolvMkHmrEupAv" +
       "i+2a47f3pzKeil++4+FnzvUTj6fZMimaO9VEIKaZY3tGRpWO48vsc7si+5Rt" +
       "giHy5Nd/fR4+8uPFSSC3iBnmgxo/PDw6OWbWT42ZbWJycnHn/J5fZm98Ir71" +
       "P8Bltc8hv8i32k5cXL9YfiWIcjJIOWGmy2Zq8LoGSimBIVTnQeI7xaLY5mZS" +
       "UMpDuxL+VQgFH3WuIW+x2bg2eT4hbiY1GDQeUdy0inRNc2SVOtc8f1rdJgs4" +
       "webPMxkqx/bJHTas8NqkrmhE2NB+l9bs4st6hgoNvZESwCdIXN1dvm+oCqer" +
       "OuDMhNJwxbVtr18/adeNf4D0EZN9Iy/fCe8fCXqm7IUTBl0vjz1pCzun8eUB" +
       "Xsnz76ZFcDT/dHr4gzeH9wYdH1czlDsAYREBWM6XFjvkK53+LMn0ZyaUFaLj" +
       "+RQf7hgglKoKyWLJaunJmpqhEu/MwZF11oRvJ3vel0+NhgqrRjd9I47dzExe" +
       "BKdaLKlpnpL0lme+SUlMFQ4W2ThoigvAe9UUUxAAqG9H2N1rM8YYjMQ2I0M5" +
       "sHpfqrAFL/ltv5kO0ox0vcHUF057mgpMxLPl9kE/dQT9cLUwqwTFp2m6z5P2" +
       "x2lUPj26oX3n+Mrj9mQAH7VDQ+JTBr7M7PkjgxXzp5SWlpXfUne79EzRonTJ" +
       "ZE0mPtuqJz96mxImE4fl0PtV7656Y/SqmBj+Af9fm68zEAAA");
}
