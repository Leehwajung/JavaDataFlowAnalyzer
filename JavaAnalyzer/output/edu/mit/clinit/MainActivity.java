package edu.mit.clinit;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name Clinit
 * 
 * @description Clinit (static initializer test)
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges - The order of execution of static initializers is not defined in
 Java.  This 
 * test stresses a particular order to link a flow.
 */
public class MainActivity extends Activity {
    public static MainActivity v;
    public String s;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        v = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s = "";
        Test t = new Test();
        Log.i("DroidBench", s);
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478510706000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAM1YbWwcRxmeW3+7js++JE5IE8dJ3ECSctu0NBJyKXGucWNz" +
       "ia04CXBALuPdOd8mc7vb3Tn77GJIIlUJ/IgqcEuQWv9KBVRpUyECSFWREYK2" +
       "KkIqqvioRFvxh0IJan5QEKGUd2b2+86u+IelnZmbeeed9/OZd3z1BmpxHbTH" +
       "tujcNLVYltRY9jS9N8vmbOJmx/L3TmDHJXqOYtc9BnNFbftz6fduPVruUVBr" +
       "Aa3FpmkxzAzLdI8S16IzRM+jdDh7kJKKy1BP/jSewWqVGVTNGy4byqPbIlsZ" +
       "Gsz7IqggggoiqEIEdTikgk1riFmt5PgObDL3IfQVlMqjVlvj4jG0Lc7Exg6u" +
       "eGwmhAbAoZ3/PgFKic01Bw0Eukud6xR+bI+6+K2TPd9vQukCShvmJBdHAyEY" +
       "HFJAXRVSmSKOO6zrRC+gXpMQfZI4BqbGvJC7gDKuMW1iVnVIYCQ+WbWJI84M" +
       "Ldelcd2cqsYsJ1CvZBCq+79aShRPg659oa5SwxE+Dwp2GiCYU8Ia8bc0nzFM" +
       "naGtyR2BjoOfAQLY2lYhrGwFRzWbGCZQRvqOYnNanWSOYU4DaYtVhVMY2rQi" +
       "U25rG2tn8DQpMrQxSTchl4CqQxiCb2FofZJMcAIvbUp4KeKfG0fuu/SwechU" +
       "hMw60SiXvx029Sc2HSUl4hBTI3Jj1+7847jvhYsKQkC8PkEsaX705Zv77+xf" +
       "fknS3N6AZnzqNNFYUbsy1f3q5tyuTzZxMdptyzW482Oai/Cf8FaGajZkXl/A" +
       "kS9m/cXlo7/4/NmnyTsK6hxFrZpFqxWIo17NqtgGJc6DxCQOZkQfRR3E1HNi" +
       "fRS1wThvmETOjpdKLmGjqJmKqVZL/AYTlYAFN1EbjA2zZPljG7OyGNdshFAb" +
       "fKgLvl6EUs97/Q8Z+pp63IVwV8uz+HTVnM4Toj5AZgi1wImQrbpjGfokq+qG" +
       "pT7AxwfA4GVVSkzHeCTJBBo1QdMgSe5RsW2rrqOpFWyYqog4olfVisFUDRSA" +
       "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" +
       "0c3/eMMP7vvO0huirP0vu9Qed7sSAAA=");
}

class Test {
    static {
        TelephonyManager mgr =
          (TelephonyManager)
            MainActivity.v.getSystemService(Activity.TELEPHONY_SERVICE);
        MainActivity.v.s = mgr.getDeviceId();
    }
    
    public Test() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478510706000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "BY4AqoHVDAAA");
}
