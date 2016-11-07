package de.ecspride;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class MyLocationListener1 implements LocationListener {
    private IDataProvider dataProvider;
    
    public MyLocationListener1(IDataProvider provider) {
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
      ("H4sIAAAAAAAAAM1YfWwcxRWfO387TvwR4oSQOLZxKAnkNinQqnJKiS82djjH" +
       "buyE4hYu490538Z7u8vunH02uIVA5Yg/orQ1aSoR/5WogAJBVVFBCOSqIgFR" +
       "VaJC/ZIKbaWqtCES/qOAmrbpe7O7t3t7d6ZVWqkn7czc7Htv3nvz3m/e7LnL" +
       "pMq2yC2moc1MaAaPsRyPHdHuiPEZk9mxfYk7hqllMyWuUdsehbmk3PlC40dX" +
       "TqSboqR6jKylum5wylVDtw8w29CmmJIgjf5sr8YyNidNiSN0ikpZrmpSQrV5" +
       "d4KsCrBy0pXwVJBABQlUkIQK0h6fCphWMz2biSMH1bn9IPk6iSRItSmjepx0" +
       "FAoxqUUzrphhYQFIqMX/h8AowZyzSHvedsfmIoOfvEVa+O4DTT+oII1jpFHV" +
       "R1AdGZTgsMgYaciwzDiz7D2KwpQx0qwzpowwS6WaOiv0HiMttjqhU561WN5J" +
       "OJk1mSXW9D3XIKNtVlbmhpU3L6UyTfH+VaU0OgG2tvq2Ohb24TwYWK+CYlaK" +
       "ysxjqZxUdYWTLWGOvI1d9wABsNZkGE8b+aUqdQoTpMXZO43qE9IIt1R9Akir" +
       "jCyswsnGskLR1yaVJ+kES3KyIUw37LwCqjrhCGThZF2YTEiCXdoY2qXA/lze" +
       "v/v4Q3q/HhU6K0zWUP9aYGoLMR1gKWYxXWYOY8P2xEna+uqxKCFAvC5E7ND8" +
       "6OHlu25tW3rDobmhBM3Q+BEm86R8ZnzN25vi275QgWrUmoat4uYXWC7Cf9h9" +
       "050zIfNa8xLxZcx7uXTgwn2PPMsuRUn9AKmWDS2bgThqlo2MqWrMupvpzKKc" +
       "KQOkjulKXLwfIDUwTqg6c2aHUimb8QFSqYmpakP8BxelQAS6qAbGqp4yvLFJ" +
       "eVqMcyYhpAYestsdvOz2j3MyLx20Idyl9DQ9ktUnEoxJe9kU0wzYROlew5q0" +
       "YdeZtA9jZq9lqEoPeDwtwbaops12mJaB/pLiVNPGIQZsaTCrcbWf6goYZu+S" +
       "bEuWFAb0tmmpMBicSRiySCQEDjR8VwwD0vz/USWHXmuajkRgQzeF4UQDFfoN" +
       "TWFWUl7I9vQuP598K5pPL9ffkJ0Ki3kLxUosRCIRIf86XNAJFtjqSQANoGjY" +
       "NnL/vsPHOisgSs3pStgoJJXKo3rch5kBAaYyxDpZOjX96KFv7IySaCE8o5Iw" +
       "VY/swwiqefDsCqdlKbmN8+9/dP7knOEnaAHeu7hRzIl53xl2p2XITAEk9cVv" +
       "b6cvJl+d64qSSgATAFBOIeABm9rCaxTkf7eHpWhLFRicMqwM1fCVB4D1PG0Z" +
       "0/6M2Oc1YtwMPq7FDLkBnlXwXHX7D/DtWhPb65y4wE0LWSGw+osj5ulf/ezP" +
       "twl3e7DeGDgoRxjvDkAJCmsUoNHsx8CoxRjQ/fbU8HeevDz/VREAQHFjqQW7" +
       "sI0DhMAWgpu/+caDv37v3TPvRP2g4XCWZsc1Vc7ljYwQN/XRuEtu/8eAkbDa" +
       "Tb4+AEUa5BRGTddBPWMoakql4xrDKP1749ZdL35wvMmJAw1mvDC69dMF+PPX" +
       "95BH3nrg4zYhJiLjUej7zCdz8HWtL3mPZdEZ1CP36M83f+8iPQ1IDehoq7NM" +
       "AF7ETRxUah0n1wcTcmAv5RRibwr+WGJbJUG3XbQx9JHgJuLdbdhssYPpUZiB" +
       "gaImKZ9458PVhz58bVnYU1gVBaNhkJrdTgBi054D8evDWNBP7TTQ3b60/2tN" +
       "2tIVkDgGEmUoBewhCzUviB2XuqrmNz/+SevhtytItI/UawZV+qhIQ1IH8c/s" +
       "NIBXzvzSXUT8pjHqm4SppMh4J2w25BFoW3kE6sOixk/iDX8b0saP/uGTIicI" +
       "7Clxlof4x6RzT22M33lJ8PsggNxtuWJUhgLQ5/3ss5m/RjurX4+SmjHSJLvV" +
       "5SGqZTG1xqCisr2SEyrQgveF1ZFTCnTnQW5TGIACy4bhxz8NYIzUOK4PIU4d" +
       "ernLHfze7S8EESdCxGCPYOkQbRc2n/ESvAYCegpKh1CG17rCXnf71wJCOWlQ" +
       "AuGPczsdZMP2dmx6HHGfLxUlzqsObLbmFxW/ahdaHnP7uSCsBCPJTckOOJnx" +
       "GI9p7ukYCx+TmBWby5WKosw9c3RhURk6u8sp6FoKy69euF0894t//DR26ndv" +
       "ljij67hh7tCwwghoVwlLbi8f54OipPaD7eLRv2wcvTN9+D84ZLeEDAqLfGbw" +
       "3Jt33yR/O0oq8qFXVOwXMnUXBly9xeB2oo8WhN3mwoNuh7OjkWm3P1B80JWO" +
       "ORzeXOJAQSFfdvt7wjvvA2sYlsvGgFDi/hVgmWJzLyfNEC8uTzwNecuUlaFq" +
       "2FIzcAJPudcGaa7lvcmn3n/OiaAwLoWI2bGFJ67Gji9EAxexG4vuQkEe5zIm" +
       "FF7tOO0q/CLw/BMftAYnsAf0ibs3gvb8lcA0MQk6VlJLLNH3p/Nzrzw9Nx91" +
       "vTPMSeUUONZP6q8UJnVDPqnzm9EiDhPEvtjQFLPwqFwBB4rPCzExWhhnO+Fp" +
       "JSTa7vSRT641zlDIx26//G/HWZNvmnPpFWvnVgivh7GBsrPF0D2o3KvaWLso" +
       "+CblO9Yu61ic1q/ZhRI8m8CF825/+FpdiEKSbn/fp7oQ/86IdY6t4K4nsDkq" +
       "stFzV69eyluP/Y+91Q9PJyEVNU4fvXit3kIhF9x+qby3KoSUCuEtMSljM+EI" +
       "VDmpUN1PXBCNzR7qGXasJ4v3U6HZyRX8exqbE1BDGuKLVdZ2sS7k3W/9F72b" +
       "42Rtiasr1uEbir6yOV+G5OcXG2vXLx78pbi95b/e1MG9J5XVtGBRFBhXmxZL" +
       "qcLMOqdEMkV3lpNVgbKdk1pvKHQ941A9zUlUEaKeMUuku1PF5SKBM94NHOGw" +
       "lhVKnUKW4DUMDxXxPdI7w7POF8mkfH5x3/6Hlj931rkGyhqdnUUptQlS49xI" +
       "83VAR1lpnqzq/m1X1rxQt9XD9DWOwn4QB3TbUvrO1Zsxubglzb60/oe7v7/4" +
       "rrge/guVSTvrKBYAAA==");
}
