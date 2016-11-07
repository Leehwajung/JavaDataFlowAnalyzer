package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

/**
 * @testcase_name MultiHandlers1
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail steven.arzt@cased.de
 * 
 * @description This example two activities that share the same callback class.
 However, none
 * 	of them actually leaks the data
 * @dataflow onLocationChanged: source -> / 
 * @number_of_leaks 0
 * @challenges the analysis must be able to correctly associate callback
 handlers
 * 	with the respective activities
 */
public class MultiHandlers2 extends Activity implements IDataProvider {
    private String data = "";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_handlers1);
        LocationListener locationListener = new MyLocationListener1(this);
        LocationManager locationManager =
          (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                                               5000, 10, locationListener);
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Location", "Location: " + data);
    }
    
    @Override
    public void setData(String data) {
        
    }
    
    public MultiHandlers2() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "3pFvzb8tLh//BlafyQ9SFAAA");
}
