package edu.mit.array_copy;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name ArrayCopy
 * 
 * @description Testing System.arraycopy()
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges - The analysis tool must have a model for System.arraycopy()
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager mgr = (TelephonyManager)
                                 this.getSystemService(TELEPHONY_SERVICE);
        String imei = mgr.getDeviceId();
        String[] array = new String[1];
        array[0] = imei;
        String[] arraycopy = new String[1];
        System.arraycopy(array, 0, arraycopy, 0, 1);
        Log.i("DroidBench", arraycopy[0]);
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478461466000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAM1XW2wUVRg+u73XwvbCTQTKpaAtuGNRSExRaZdLi9tLWiCx" +
       "KsvpzNnutLMzw5mz7bZYBRID8YEQLYiJ9AmiEm5RiCYGU2MiEIwJhniLgm/i" +
       "hQRe8AEV/3Nmdmd22mJ8c5I5M3POf/77/51/TtxEBRZFy01DG+rVDBYmaRbu" +
       "01aF2ZBJrPCm6KoOTC2iRDRsWZthLiYvPhO6c/dAojyICrtRFdZ1g2GmGrrV" +
       "SSxDGyBKFIXc2fUaSVoMlUf78ACWUkzVpKhqsYYoesCzlaGaaEYFCVSQQAVJ" +
       "qCA1ulSwaRrRU8kI34F1Zu1AL6NAFBWaMlePoUW5TExMcdJh0yEsAA7F/Hsr" +
       "GCU2pylamLXdtnmCwQeXS6Nvbit/Pw+FulFI1bu4OjIowUBINypLkmQPoVaj" +
       "ohClG1XohChdhKpYU4eF3t2o0lJ7dcxSlGSdxCdTJqFCpuu5MpnbRlMyM2jW" +
       "vLhKNCXzVRDXcC/YOsu11bZwA58HA0tVUIzGsUwyW/L7VV1hqNq/I2tjzbNA" +
       "AFuLkoQljKyofB3DBKq0Y6dhvVfqYlTVe4G0wEiBFIbmTsmU+9rEcj/uJTGG" +
       "5vjpOuwloCoRjuBbGJrpJxOcIEpzfVHyxOdm25r9O/VmPSh0Voiscf2LYdMC" +
       "36ZOEieU6DKxN5bVRQ/hWef3BREC4pk+Ypvmw5dur12xYPyiTfPQJDTtPX1E" +
       "ZjH5aM/0K/MitU/mcTWKTcNSefBzLBfp3+GsNKRNqLxZWY58MZxZHO/8/Lld" +
       "x8lvQVTaggplQ0slIY8qZCNpqhqhG4lOKGZEaUElRFciYr0FFcF7VNWJPdse" +
       "j1uEtaB8TUwVGuIbXBQHFtxFRfCu6nEj825ilhDvaRMhVAQ3KoO7HKHAgPPc" +
       "wdCr0hYL0l1KDOK+lN4bJURaRwaIZkAQoVoVaqhKF0spqiGt4+9N4PCE1Egp" +
       "HrIauX4Ws+zPiGEO1UvYNCWLylISq7okMo0oKSmpMglzopgMVFIrLDbKTB1Q" +
       "2VCYE5n/F0XS3GPlg4EABHOeH0o0qMJmQ1MIjcmjqab1t0/FLgezpeX4GioT" +
       "BIVBUNgVFPYKQoGA4D+DC7QTBcLcT4QNZbVdL27avm9xHmSoOZgPgeKk0tSI" +
       "HnEhpkUAqQx5jsYPD+7e+spjQRTMhWauJEyV8u0dHFCzwFnjL8nJ+Ib23rhz" +
       "+tCI4RZnDtY7mDFxJ6/5xX53UkMGT1Hisq9biM/Fzo/UBFE+AAmAJwO3cVxa" +
       "4JeRU/sNGRzlthSAwXGDJrHGlzLgV8oS1Bh0Z0Scp/Oh0g45j4dPQQHBT3WZ" +
       "R7798pfHhSczaB3ynH9dhDV4EIIzCwksqHDDu5kSAnQ/Hu544+DNvc+L2ALF" +
       "kskE1vAxAsgA0QEPvnpxx3fXrx29GnTzgcERmerRVDktbKm4B1cA7r/5zcuc" +
       "T/AngH3EgZiFWYwxueRlrm6ANhogHk+Omi160lDUuIp7NMKT8c/Q0vpzv+8v" +
       "t8OtwUwmW1b8OwN3/sEmtOvytj8WCDYBmZ92rv9cMhtCq1zOopq5HundX81/" +
       "6wI+AmAMAGipw0RgGhL+QCKAkvBFnRjDvrV6PlRb3hzPLSNPVxKTD1y9NW3r" +
       "rU9uC21z2xpv3Fux2WBnkR0FELYcOQPH1oOZJ1+tMvk4Iw06zPZXfTO2EsDs" +
       "ifG2F8q18bsgthvEynDgW+0UsCadk0oOdUHR959+Nmv7lTwU3IBKNQMrG7Ao" +
       "OFQCmU6sBMBU2nxmLRLXYLGtDPgDTfCQnUVznC/xsVCMS/iwzM45/vpwOmup" +
       "uAodC03n2eexNJcnRfOnOvBFs3J0z+iY0n6s3j6WK3MP0fXQI578+q8vwod/" +
       "ujQJ2pYww3xU4yeFRybHzLqpMbNVNEYu7lzY8+vczU8ntv8HuKz2GeRn+V7r" +
       "iUsbl8mvB1FeFikntGy5mxq8poFQSqDH1LmT+EypSLb52RBM565dDXcVmPuD" +
       "8zzrTTYb1yaPJ/jNpAaDwiOKG1YRrmkOrw+c53F/WN0iCzjO5t8zGarA9jEd" +
       "NqxwU0pXNCJ0aLtPaXbyYSNDxYYeoQTwCQJXe5/fF6rCwaoOOC2fNFJ5vf/t" +
       "GyftvPH3hz5ism/0tXvh/aNBTxO9ZEIf691jN9JCz2l8eIRn8qL7SRE7Nvx8" +
       "euTjd0f2Bh0b1zKUPwBuEQ5YyYdm2+Wrnfosy9Zn1pWVouJ5kx5uHyCUqgrJ" +
       "2ZJT0pMVNUNl3p6DI+ucCb9GdjsvnxoLFc8e2/KNOHazLXcJnGrxlKZ5UtKb" +
       "noUmJXFVGFhi46ApHgDvlRMbIIZK3Q+hbY9NHmfQ59rkDOXB6F1UYQoW+Wuf" +
       "mXHNjEyWQYcXztiXDkxEsZX28T613/wgtSQn8cT/Zqa6U/YfZ0w+Pbapbeft" +
       "1cfsfgD+VIeHxf8J/G7ZXUcWIRZNyS3Dq7C59u70MyVLM4mS04/4dKue/MBd" +
       "nzSZOCKHP5p9ds07Y9dEn/APGyyOyggQAAA=");
}
