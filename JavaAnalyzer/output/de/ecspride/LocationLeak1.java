package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

/**
 * @testcase_name LocationLeak1
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description This example contains a location information leakage in the
 onResume() callback method.
 *  The data source is placed into the onLocationChanged() callback method,
 especially the parameter "loc".
 * @dataflow onLocationChanged: source -> latitude, longtitude; onResume:
 latitude -> sink, longtitude -> sink 
 * @number_of_leaks 2
 * @challenges the analysis must be able to emulate the Android activity
 lifecycle correctly,
 *  integrate the callback method onLocationChanged and detect the callback
 methods as source.
 */
public class LocationLeak1 extends Activity {
    private String latitude = "";
    private String longtitude = "";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_leak1);
        LocationManager locationManager =
          (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new MyLocationListener();
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                                               5000, 10, locationListener);
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Latitude", "Latitude: " + latitude);
        Log.d("Longtitude", "Longtitude: " + longtitude);
    }
    
    private class MyLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location loc) {
            double lat = loc.getLatitude();
            double lon = loc.getLongitude();
            latitude = Double.toString(lat);
            longtitude = Double.toString(lon);
        }
        
        @Override
        public void onProviderDisabled(String provider) {
            
        }
        
        @Override
        public void onProviderEnabled(String provider) {
            
        }
        
        @Override
        public void onStatusChanged(String provider, int status,
                                    Bundle extras) {
            
        }
        
        public MyLocationListener() { super(); }
        
        public static final String jlc$CompilerVersion$jl7 = "2.7.1";
        public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
        public static final String jlc$ClassType$jl7 =
          ("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" +
           "hf8AX9QGYwwUAAA=");
    }
    
    public LocationLeak1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
