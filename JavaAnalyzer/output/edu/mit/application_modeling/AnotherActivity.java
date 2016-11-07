package edu.mit.application_modeling;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class AnotherActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("DroidBench", ((MyApplication) getApplication()).imei);
    }
    
    public AnotherActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478436311000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAM1XaWwUVRx/u71rYdtSDpGbgnI4IygkpqiUcrS40IYCiVVZ" +
       "XmfedqfMzgxv3rZLsRxGA/EDIVoQE+kn8ApXjEQTgqnxAIIxwRCvRPCbeDSB" +
       "L/gBFf/vzbU73WL85iTzZua9//vf/9/7z4lhVGJTtMAy9R1duskkkmVSt75E" +
       "YjssYktr40vaMLWJ2qRj294Icwll1pnY7TsHU9VRVNqBxmHDMBlmmmnYG4ht" +
       "6j1EjaNYMLtKJ2mboep4N+7BcoZpuhzXbNYQR/flbGWoPu6pIIMKMqggCxXk" +
       "xoAKNo0hRibdxHdgg9nb0S4UiaNSS+HqMTQzn4mFKU67bNqEBcChnH9vBqPE" +
       "5ixFM3zbHZtHGHxogTzw+pbq94tQrAPFNKOdq6OAEgyEdKCqNEl3Emo3qipR" +
       "O1CNQYjaTqiGda1P6N2Bam2ty8AsQ4nvJD6ZsQgVMgPPVSncNppRmEl985Ia" +
       "0VXvqySp4y6wdUJgq2Phaj4PBlZqoBhNYoV4W4q3aYbK0PTwDt/G+qeBALaW" +
       "pQlLmb6oYgPDBKp1Yqdjo0tuZ1QzuoC0xMyAFIYmj8qU+9rCyjbcRRIMTQrT" +
       "tTlLQFUhHMG3MDQ+TCY4QZQmh6KUE5/h9csO7DSajajQWSWKzvUvh03TQps2" +
       "kCShxFCIs7FqfvwwnnB+fxQhIB4fInZoPnzh1vKF04YuOjQPFKBp7ewmCkso" +
       "xzrHXpnSNO/xIq5GuWXaGg9+nuUi/dvclYasBZU3wefIFyVvcWjDF8/seY/8" +
       "FkWVLahUMfVMGvKoRjHTlqYTuoYYhGJG1BZUQQy1Say3oDJ4j2sGcWZbk0mb" +
       "sBZUrIupUlN8g4uSwIK7qAzeNSNpeu8WZinxnrUQQmVwoyr35SX3uZuho/Im" +
       "G9JdTvXi7ozRFSdEXkl6iG5CEKFaVWpqajvLqJopr+TvK8DhKX/BIoqW1BS5" +
       "0bJ0TRH1sc5UCajYtUjGliXbVJHTWDNkkXREzchpjfEVjzyRdumBp8lShDYq" +
       "TOvR2A6J77D+7wpmuYereyMRCP6UMPToULXNpq4SmlAGMitW3TqVuBz1S9GN" +
       "DUMLQaoEUqVCUqWQVBSJCGF1XLqTZZAj2wBtAIer5rU/v3br/llFkN5WbzFE" +
       "mJPKox8HTQE+tQgUVqBI0NCR3r2bdz8SRdF8XOcaw1Ql397G0dhH3fpwPRfi" +
       "G9t34/bpw/1mUNl5B4ULOCN3csCYFfYtNRVwGyUB+/kz8NnE+f76KCoGFALk" +
       "ZRBWDmrTwjLygKPBA2FuSwkYnDRpGut8yUPOSpaiZm8wI4I+lg+1Tvx5PEIK" +
       "Cvx+ot06+t1XvzwqPOlBfSzn8GwnrCEHXjizmACSmiC8GykhQPfjkbbXDg3v" +
       "e1bEFihmFxJYz8cmgBWIDnjw5Yvbv79+7djVaJAPDM7XTCekWVbYUnMXrgjc" +
       "f/ObYwSf4E84KZpcfJrhA5TFJc8NdAOo0gEueXLUbzIgZ6HYcKdOeDL+GZuz" +
       "6OzvB6qdcOsw42XLwn9nEMzfvwLtubzlj2mCTUThR2Xgv4DMwd9xAedGSvEO" +
       "rkd279dT37iAjwKSA3raWh8RgIiEP5AIoCx8MV+MUmhtER+m27k5nl9GOS1N" +
       "Qjl49eaYzTc/viW0ze+JcuO+DlsNThY5UQBhQq7kAvNb3pOvjrP4WJcFHSaG" +
       "q74Z2ylg9tjQ+ueq9aE7ILYDxCrQLditFIAnm5dKLnVJ2Q+ffDph65UiFF2N" +
       "KnUTq6uxKDhUAZlO7BRgVtZ6ajkSV285DNXCH2iEh5wsmuR+iY8ZYpzNh7lO" +
       "zvHXB7O+peIqdS3c5T6zOZbm86Ro6mjdguh0jr04MKi2Hl/knOm1+SfwKmgw" +
       "T37z15fSkZ8uFYDeCmZaD+v8OMmRyTFz/uiYuU50VQHuXHjx18kbn0xt/Q9w" +
       "OT1kUJjlu+tOXFozV3k1iop8pBzR7+Vvasg1DYRSAg2qwZ3EZyqFe6f6IRjL" +
       "XbsU7kq4h93n57nJ5uBa4XiC3yxqMig8ogZhFeEa4/L6zH2eC4c1KLKI62z+" +
       "PZ6hGuwc2ZJpSysyhqoTocP6e5TmBj6sYajcNJooAXyCwM27x78P1eCU1Xrc" +
       "flHur72+7c0bJ528CTeXIWKyf+CVu9KBgWhOBz57RBOcu8fpwoWeY/jwEM/k" +
       "mfeSInas/vl0/7l3+vdFXRuXM1TcA24RDljMh2bH5Uvd+qzy69N3Za2oeN7h" +
       "S609hFJNJXlb8kq6UFEDWIXaDg6uk0b8Wjm/A8qpwVj5xMFN34qT12/ZK+Bg" +
       "S2Z0PScrczO01KIkqQkbKxwotMQDEH7KvRoihuoKTQsjOh0WSQa9s8OCoSIY" +
       "cxc1mIJF/tpteR6r85IPWEuezdnISHBb7Jz6o7szjF2z8/JR/MN6RZ9x/mIT" +
       "yunBtet33lp63GkT4O+3r0/888AvnNOM+MAxc1RuHq/S5nl3xp6pmOPlT16b" +
       "EtJteuFzeFXaYuLk7Pto4gfL3h68JtqHfwCD+xaOXBAAAA==");
}
