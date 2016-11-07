package org.cert.WriteFile;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class Button1Listener implements OnClickListener {
    private final MainActivity act;
    
    public Button1Listener(MainActivity parentActivity) {
        super();
        this.act = parentActivity;
    }
    
    @Override
    public void onClick(View arg0) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        String curLoc = getMyLocation();
        i.putExtra("secret", curLoc);
        Log.i("Phase2_3: ",
              ("Sending implicit Intent with MIME data type text/plain: Curr" +
               "ent Location ") +
                curLoc);
        this.act.startActivityForResult(i, 0);
    }
    
    private String getMyLocation() {
        LocationManager lm =
          (LocationManager) this.act.getSystemService(Context.LOCATION_SERVICE);
        Location location =
          lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        try {
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            String curLonStr = String.valueOf(longitude);
            String curLatStr = String.valueOf(latitude);
            return "Longitude: " + curLonStr + ", Latitude: " + curLatStr;
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Couldn\'t get last known location info";
        }
    }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478512170000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "WX1LFOD/A/10v6i3EwAA");
}
