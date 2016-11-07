package de.ecspride;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class MyLocationListener implements LocationListener {
    private IDataProvider dataProvider;
    
    public MyLocationListener(IDataProvider provider) {
        super();
        this.dataProvider = provider;
    }
    
    @Override
    public void onLocationChanged(Location arg0) {
        dataProvider.setData("Longitude: " + arg0.getLongitude() +
                               ", Latitude: " + arg0.getLatitude());
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
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "9CIWAAA=");
}
