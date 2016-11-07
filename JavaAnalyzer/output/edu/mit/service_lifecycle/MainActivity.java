package edu.mit.service_lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * @testcase_name Service-Lifecycle
 * 
 * @description Test accurate modeling of Service object allocation and
 lifecycle
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges - Same service object is used for each startService ->
 onStartCommand call.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this, MyService.class);
        startService(i);
        Intent i2 = new Intent(this, MyService.class);
        startService(i2);
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478515404000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "ffw2p0wmDsyBj6Z8sPLtkatiavgHGBPRZC8QAAA=");
}
