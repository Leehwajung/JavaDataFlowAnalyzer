package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * @testcase_name AnnonymousClass1
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description Registers a callback handler for location updates in an
 anonymous
 *  inner class. The incoming location data from the source are stored in static
 fields which are leaked to the log.
 * @dataflow onLocationChanged -> latitude, longitude -> Log
 * @number_of_leaks 2
 * @challenges the analysis must handle callbacks, anonymous inner classes and
 static fields.
 */
public class AnnonymousClass1 extends Activity {
    private static double latitude;
    private static double longitude;
    private LocationManager locationManager;
    LocationListener locationListener = new LocationListener() {
        @Override
        public void onStatusChanged(String provider, int status,
                                    Bundle extras) {
            
        }
        
        @Override
        public void onProviderEnabled(String provider) {
            
        }
        
        @Override
        public void onProviderDisabled(String provider) {
            
        }
        
        @Override
        public void onLocationChanged(Location location) {
            Toast.makeText(getApplicationContext(), "aa",
                           Toast.LENGTH_LONG).show();
            latitude = location.getLatitude();
            longitude = location.getLongitude();
        }
    };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annonymous_class1);
        locationManager = (LocationManager)
                            getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                                               5000, 10, locationListener);
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LOG", "Latitude: " + latitude + "Longtitude: " + longitude);
    }
    
    public AnnonymousClass1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
