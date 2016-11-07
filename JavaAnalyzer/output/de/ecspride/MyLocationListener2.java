package de.ecspride;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class MyLocationListener2 implements LocationListener {
    private IDataProvider dataProvider;
    
    public MyLocationListener2(IDataProvider provider) {
        super();
        this.dataProvider = provider;
    }
    
    @Override
    public void onLocationChanged(Location arg0) {
        dataProvider.setData("");
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
       "w38BdG/mpCgWAAA=");
}
