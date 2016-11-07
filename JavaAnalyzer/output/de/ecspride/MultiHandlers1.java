package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
 * @dataflow onLocationChanged: source -> data -> / 
 * @number_of_leaks 0
 * @challenges the analysis must be able to correctly associate callback
 handlers
 * 	with the respective activities
 */
public class MultiHandlers1 extends Activity implements IDataProvider {
    private String data = "";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_handlers1);
        LocationListener locationListener = new MyLocationListener2(this);
        LocationManager locationManager =
          (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                                               5000, 10, locationListener);
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Location", "Location: " + data);
        Intent intent = new Intent(this, MyLocationListener2.class);
        startActivity(intent);
    }
    
    @Override
    public void setData(String data) {
        this.data = data;
    }
    
    public MultiHandlers1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "Ft8Ul49/A8171LVSFAAA");
}
