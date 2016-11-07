package edu.mit.dynamic_dispatch;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name Dynamic-Dispatch
 * 
 * @description Testing dispatching of overiding methods
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges The analysis tool has to be able to differentiate the base and
 the derived class objects
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        B.mgr = (TelephonyManager)
                  this.getSystemService(Activity.TELEPHONY_SERVICE);
        Test test1 = new Test();
        Test test2 = new Test();
        A b = new B();
        A c = new C();
        SmsManager smsmanager = SmsManager.getDefault();
        smsmanager.sendTextMessage("+49 1234", null, test1.method(b), null,
                                   null);
        Log.i("DroidBench", test2.method(c));
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478510910000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAM1Xa2wURRyfu75r6bXlKQItUFAe3goKxhSVUh4tHrShQGJV" +
       "junuXG/K3u4yO9dei1UwMRA/EKIFMZF+gvgIrxiJJgZTY8IjoAmE+EoEv4kP" +
       "EvoFP6Dif2b3bve2LcZvXnKzu7P/9+M3/z1+CxXZDC2yTL2vSzd5lGR4tFtf" +
       "FuV9FrGj62PL2jCzidakY9veDHtxdc7pyJ27B5JVYVTcgSZiwzA55tQ07E3E" +
       "NvUeosVQxNtdo5OUzVFVrBv3YCXNqa7EqM0bYugBHytH9bGsCQqYoIAJijRB" +
       "afSogGkCMdKpJsGBDW7vRK+gUAwVW6owj6PZ+UIszHDKFdMmPQAJpeJ5Kzgl" +
       "mTMM1eV8d3we5fDBRcrg29uqPipAkQ4UoUa7MEcFIzgo6UAVKZLqJMxu1DSi" +
       "daBqgxCtnTCKddov7e5ANTbtMjBPM5ILkthMW4RJnV7kKlThG0ur3GQ59xKU" +
       "6Fr2qSih4y7wdYrnq+PhWrEPDpZTMIwlsEqyLIU7qKFxVBvkyPlY/xwQAGtJ" +
       "ivCkmVNVaGDYQDVO7nRsdCntnFGjC0iLzDRo4Wj6uEJFrC2s7sBdJM7RtCBd" +
       "m/MKqMpkIAQLR5ODZFISZGl6IEu+/NzauGL/LqPZCEubNaLqwv5SYJoVYNpE" +
       "EoQRQyUOY8XC2CE85ey+MEJAPDlA7NB88vLIysWzhi84NA+NQdPa2U1UHleP" +
       "dlZemdG04KkCYUapZdpUJD/Pc1n+be6bhowFnTclJ1G8jGZfDm869/zuD8lv" +
       "YVTegopVU0+noI6qVTNlUZ2wdcQgDHOitaAyYmhN8n0LKoH7GDWIs9uaSNiE" +
       "t6BCXW4Vm/IZQpQAESJEJXBPjYSZvbcwT8r7jIUQKoE/qoB/NUKhq+71K472" +
       "K1tsKHcl2Yu700ZXjBBlNekhuglJhG7VmEm1dp7WqKmsFverIOBJxbFYXy8q" +
       "aStlPI311dQGjWpyqYItS7GZqqQwNRRZbERLKynKFa0PapCqcc2lVTYASaPK" +
       "aQ/lfVFBav3vLMqIGFb1hkKQ3hlBcNGhL5tNXSMsrg6mV60ZORm/FM41mxt9" +
       "juaBuiioiwbVRf3qUCgktUwSap0CgvTvACABiK1Y0P7S+u375hRA5Vq9hZBA" +
       "QaqMj/RNHvS0SIBVof7R8OHePVtffSyMwvmQLUyFrXLB3iaANgeo9cFWHUtu" +
       "ZO/NO6cODZhe0+adAS6WjOYUWDAnGFRmqhAvRjzxC+vwmfjZgfowKgSAAVDl" +
       "EDaBV7OCOvIwoSGLr8KXInA4YbIU1sWrLCiW8yQze70dme1KsdQ4iRf5CBgo" +
       "ofnpduvId1//8riMZBbFI75zsZ3wBh9yCGERiRHVXno3M0KA7sfDbW8dvLX3" +
       "BZlboJg7lsJ6sTYBYkB2IIKvX9j5/Y3rR6+FvXrgcHSmO3WqZqQv1ffgF4L/" +
       "3+Iv2l9siCscAk0u9NTlsMcSmud7tgEK6YCEojjqtxgpU6MJijt1Iorxz8i8" +
       "JWd+31/lpFuHnWy1LP53Ad7+g6vQ7kvb/pglxYRUcQp68fPIHGid6EluZAz3" +
       "CTsye67OfOc8PgIgDcBo034isQ7JeCCZQEXGYqFco4F3S8RSa/trPL+NfNNK" +
       "XD1w7faErbc/H5HW5o87/rxvwFaDU0VOFkDZIuQuAnNHslfxdqIl1kkZsGFq" +
       "sOubsZ0EYU8Mb3yxSh++C2o7QK0Kg4DdygBxMnml5FIXlfzwxZdTtl8pQOG1" +
       "qFw3sbYWy4ZDZVDpxE4CWGWsZ1ci+esthaVKxgONipBTRdPcJ/lQJ9e5Ypnv" +
       "1Jy4fTiT81T+il0PL7vXcz5P82UyNHO8QUAOMUdfGxzSWo8tcY7rmvzDdQ3M" +
       "jie++ety9PBPF8fA3DJuWo/q4uDw6RSYuXB8zNwgByYPd86/9uv0zc8kt/8H" +
       "uKwNOBQU+cGG4xfXzVffDKOCHFKOGuXymRr8roFSRmD2NESQxE65LLaZuRRU" +
       "itAuh/9EhMJPuteIv9gcXBs7nxA3i5kcGo9oXlpluia4sirda1EwrV6Thdxg" +
       "i+fJHFVj59SOmnZ0VdrQdCJt2Hif1twklnUclZpGEyOAT5C4Bff5rGEUjlfa" +
       "446CykDNjR3v3jzh1E1wbgwQk32Db9yL7h8M+4bruaPmWz+PM2BLOyeI5RFR" +
       "ybPvp0VyrP351MBn7w/sDbs+ruSosAfCIgOwVCzNTsiXu/1ZkevPXChrZMeL" +
       "4T3a2kMYoxrJY8lr6bGamqMK/8whkHXaqE8mZ8xXTw5FSqcObflWHru5UbwM" +
       "TrVEWtd9Jekvz2KLkQSVDpY5OGjJC8D7tPHGIPiiDG5Jyzsd1gSHWdhh5agA" +
       "Vv9LClvwUtx2W9kwTcpWHEx+0ayvmdBoRFvqHPXjxzAIWHPzilB+k2Y7Pe18" +
       "lcbVU0PrN+4aWX7MmQ3ga7a/X37DwCeZM4Hk0GL2uNKysoqbF9ytPF02L1s0" +
       "ebNJwLbasQ/fNSmLy+Oy/9OpH694b+i6nBn+AZeCP98sEAAA");
}

class Test {
    public String method(A a) { return a.f(); }
    
    public Test() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478510910000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}

class A {
    public String f() { return "untainted"; }
    
    public A() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478510910000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "WpMm5ZA//sGC99a/OXGDl7u/AX+iUCTcDgAA");
}

class B extends A {
    public static TelephonyManager mgr;
    
    public String f() { return mgr.getDeviceId(); }
    
    public B() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478510910000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}

class C extends A {
    public String f() { return "not tainted"; }
    
    public C() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478510910000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "HPzHLsx7f92b47d44fsLdoRsouYOAAA=");
}
