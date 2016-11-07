package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;

/**
 * @testcase_name IntentSink2
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description A callback method is called via user interaction. It starts a
 new Activity based on user input and
 *  leaks a tainted value. 
 * @dataflow startIntent: source -> deviceId -> intent -> sink
 * @number_of_leaks 1
 * @challenges the analysis must be able to parse the layout xml file correctly,
 *  track the taint in the intent and recognize the startActivity sink. 
 */
public class IntentSink2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_sink2);
    }
    
    public void startIntent(View view) {
        EditText appName = (EditText) findViewById(R.id.name);
        TelephonyManager tm = (TelephonyManager)
                                getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = tm.getDeviceId();
        Intent intent = new Intent();
        intent.setClassName(this, appName.getText().toString());
        intent.putExtra("id", deviceId);
        startActivity(intent);
    }
    
    public IntentSink2() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAM1XaWwVVRS+73WvhdeWpYgChVaUqm8ElcQUFShLWx+0Uiix" +
       "LuV25r6+aefNDHfuax/VuiUG9AchWhUT6S+IS1SM0WhiNDUmLtGYaIxb4vLP" +
       "lUT+6A/czrmzvmmL8Z+TzJ2Ze88596zfPfPcGVLhcHK5bRmHhg1LpFlRpEeM" +
       "a9PikM2cdHfm2l7KHaZ1GNRx9sLcoLrmxdRv547l6pOkcoAsoqZpCSp0y3T2" +
       "MMcyxpiWIalwdrvB8o4g9ZkROkaVgtANJaM7oj1DLoiwCtKa8VVQQAUFVFCk" +
       "CsqWkAqYFjCzkO9ADmoK5yC5myQypNJWUT1BVpcKsSmneU9Mr7QAJFTjdz8Y" +
       "JZmLnDQHtrs2zzL40cuVqcfvqH+pjKQGSEo3+1AdFZQQsMkAqcuz/BDjzhZN" +
       "Y9oAaTAZ0/oY16mhT0i9B0ijow+bVBQ4C5yEkwWbcbln6Lk6FW3jBVVYPDAv" +
       "qzND878qsgYdBluXhra6Fu7AeTCwVgfFeJaqzGcpH9VNTZBVcY7AxtabgABY" +
       "q/JM5Kxgq3KTwgRpdGNnUHNY6RNcN4eBtMIqwC6CLJ9XKPrapuooHWaDgiyL" +
       "0/W6S0BVIx2BLIIsiZNJSRCl5bEoReJzZvemo3eanWZS6qwx1UD9q4FpZYxp" +
       "D8syzkyVuYx1bZnH6NI3jiQJAeIlMWKX5tW7zm6+YuXMey7NRXPQ9AyNMFUM" +
       "qieHFn58cce668pQjWrbcnQMfonlMv17vZX2og2VtzSQiItpf3Fmzzu33Pss" +
       "+zlJartIpWoZhTzkUYNq5W3dYHwnMxmngmldpIaZWodc7yJV8J7RTebO9mSz" +
       "DhNdpNyQU5WW/AYXZUEEuqgK3nUza/nvNhU5+V60CSFVcJM6uJsIKev3njcL" +
       "clTZ50C6K7lxOlIwhzOMKdvYGDMsCKKy3+KjDkSdKd2YM9u4pWtbweM5BcKi" +
       "2w670uYW+kvpwiztAHssk5kCXvIFU1dlwcg1U/Tp5ugGxeGqojFgd2yuw0tk" +
       "LY15af/vNCqiD+vHEwkI78VxcDFAk07L0BgfVKcKW7effWHwg2RQbJ73BWnS" +
       "WNrfIB3ZgCQSUu5i3MhNGQj4KEAHgGrdur7buw8cWVMGuWqPl0PIkFSZH9s7" +
       "QrDpkpCqQsaTmePj9/Xfc1WSJEtBGpWDqVpk70VoDSC0NV6cc8lNHf7ht9OP" +
       "TVphmZagvoceszmx+tfE3cgtlWmAp6H4tmb6yuAbk61JUg6QAjAqKKQ9INTK" +
       "+B4lKNDuIyraUgEGZy2epwYu+TBYK3LcGg9nZHwX4tDohhrjEVNQgvH1ffaJ" +
       "Lz768WrpSR+3U5GTsI+J9ghWoLCURIWGMLx7OWNA9/Xx3kcePXP4VhlboGiZ" +
       "a8NWHDGDITrgwQfeO/jlt9+c/DQZ5oOAw7IwZOhqUdrS8DdcCbj/whsLHifw" +
       "CbDf4YFNc4A2Nu68NtQNcMeAysHkaN1n5i1Nz+p0yGCYjH+kLln/yi9H691w" +
       "GzDjZ8sV/y4gnL9wK7n3gzt+XynFJFQ890L/hWQumC4KJW/hnB5CPYr3fbLi" +
       "iXfpCYBlgEJHn2AS3Yj0B5EBVKQv2uSYjq2tx2GVE83x0jKK9CeD6rFPf13Q" +
       "/+ubZ6W2pQ1ONO67qN3uZpEbBdisjXgDoqzwn7i6yMZxcRF0aIpXfSd1ciDs" +
       "mpndt9UbM+dg2wHYVoWj3+nhgDHFklTyqCuqvnrr7aUHPi4jyR2k1rCotoPK" +
       "giM1kOnMyQE8Fe0bNxN5jVfDUC/9QWZ5yM2iZd6X/GiWYwsOa92cw9dLi4Gl" +
       "8qr0LOz1nt0RS0tlcrJivqNfti0n75+a1npOrXcP6MbS43Q7dIvPf/bnh+nj" +
       "370/B8rWCMu+0sCjIrJnErZsmx8zd8kWKcSdd+//afneG3IH/gNcrooZFBf5" +
       "zK7n3t+5Vn04ScoCpJzVvJUytUdNg005g27TRCfhTK1MthVBCBaiazfCvRxc" +
       "/7r3fCSabC6uzR1P8BscmQIKj2lhWGW4FniyHvaeD8bDGhZZwjug8HuJIA3U" +
       "1PBoTltOemvB1Awmddh9ntLcg8NOQaots4MzwCcI3Lrz/MhwPQ8wO+Y1f8pk" +
       "47ejT/7wvJs38U4xRsyOTD30d/roVDLSTrfM6mijPG5LLfVcgMNlmMmrz7eL" +
       "5Njx/enJ15+ePJz0bNwsSPkYuEU6YAMOna7LN3r1WRfUZ+DKRlnx2K6ne8YY" +
       "xxaihKWkpOcoajmxLQgsEpMWuJshyNx77p8nWXDYFLAmiNdHIku/9+z97zkx" +
       "prPxdD8McqvseXJiBAcqyAVQFly4jRNO7Q8dOFSc3xuzAQ5ERdovPGSWzfpf" +
       "dP9x1BemU9VN0/s+lx1I8B9SAwd8tmAYkeqMVmqlzVlWl7rXuEeCLR8HYeNI" +
       "DwhZ7r9KHW2XSgiS1KSogu17bbHvNWrb6S1wOo7p4lAxMRupN7gtzL94IwLE" +
       "LSXFJf+ufQQruP/Xg+rp6e7dd57deMrteeC/fGJC/o3Bz6XbWQUouHpeab6s" +
       "ys515xa+WHOJXwwlPVdMt1VzNxXb87aQbcDEa00vb3pq+hvZC/0DqkLXAPYQ" + "AAA=");
}
