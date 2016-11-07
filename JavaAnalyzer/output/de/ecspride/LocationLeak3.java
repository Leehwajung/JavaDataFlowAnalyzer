package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

/**
 * @testcase_name LocationLeak3
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail steven.arzt@cased.de
 * 
 * @description This example contains a location information leakage in the
 onResume() callback method.
 *  The data source is placed into the onLocationChanged() callback method in a
 separate class
 *  which sets the data into a field of the activity. Activity and callback are
 decoupled using an
 *  interface.
 * @dataflow onLocationChanged: source -> data -> onResume -> sink 
 * @number_of_leaks 1
 * @challenges the analysis must be able to emulate the Android activity
 lifecycle correctly,
 *  integrate the callback method onLocationChanged, detect the callback methods
 as source
 *  and connect the callback class to the activity via the interface.
 */
public class LocationLeak3 extends Activity implements IDataProvider {
    private String data = "";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_handlers1);
        LocationListener locationListener = new MyLocationListener(this);
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
        this.data = data;
    }
    
    public LocationLeak3() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "nm8sviXuHv8GC9xPK0wUAAA=");
}
