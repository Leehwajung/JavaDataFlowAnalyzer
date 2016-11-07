package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

/**
 * @testcase_name LocationLeak2
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description This example contains a location information leakage in the
 onResume() callback method.
 *  The data source is placed into the onLocationChanged() callback method,
 especially the parameter "loc".
 *  In contrast to LocationLeak1 the activity implements the Listener directly
 (no inner class).
 * @dataflow onLocationChanged: source -> latitude, longtitude; onResume:
 latitude -> sink, longtitude -> sink 
 * @number_of_leaks 2
 * @challenges the analysis must be able to emulate the Android activity
 lifecycle correctly,
 *  integrate the callback method onLocationChanged and detect the callback
 methods as source.
 */
public class LocationLeak2 extends Activity implements LocationListener {
    private String latitude = "";
    private String longtitude = "";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_leak2);
        LocationManager locationManager =
          (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                                               5000, 10, this);
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Latitude", "Latitude: " + latitude);
        Log.d("Longtitude", "Longtitude: " + longtitude);
    }
    
    @Override
    public void onLocationChanged(Location loc) {
        double lat = loc.getLatitude();
        double lon = loc.getLongitude();
        this.latitude = Double.toString(lat);
        this.longtitude = Double.toString(lon);
    }
    
    @Override
    public void onProviderDisabled(String provider) {
        
    }
    
    @Override
    public void onProviderEnabled(String provider) {
        
    }
    
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        
    }
    
    public LocationLeak2() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "+P3HfwG0RntK0BgAAA==");
}
