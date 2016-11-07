package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

/**
 * @testcase_name FactoryMethods1
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail steven.arzt@cased.de
 * 
 * @description This example obtains a LocationManager from a factory method
 contained
 * 	in the Android operating system, reads out the location, and leaks it.
 * @dataflow onCreate: source -> data -> sink 
 * @number_of_leaks 2
 * @challenges The analysis must be able to handle factory methods contained in
 * 	the operating system.
 */
public class FactoryMethods1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_handlers1);
        Criteria crit = new Criteria();
        crit.setAccuracy(Criteria.ACCURACY_FINE);
        LocationManager locationManager =
          (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location data =
          locationManager.getLastKnownLocation(
                            locationManager.getBestProvider(crit, true));
        Log.d("Latitude", "Latitude: " + data.getLatitude());
        Log.d("Longtitude", "Longtitude: " + data.getLongitude());
    }
    
    public FactoryMethods1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478510480000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "B9wPAAA=");
}
