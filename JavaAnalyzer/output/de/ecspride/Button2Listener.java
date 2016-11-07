package de.ecspride;

import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class Button2Listener implements OnClickListener {
    private final MainActivity act;
    
    public Button2Listener(MainActivity parentActivity) {
        super();
        this.act = parentActivity;
    }
    
    @Override
    public void onClick(View arg0) {
        Log.i("TAG", "Button2 - IMEI: " + act.imei);
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49", null, act.imei, null, null);
    }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVYfWwcxRWfW38bx3d2yEdD4o/g0CbALRAoqkwp9hETp5fY" +
       "jRO3XGmcud0538Z7u8vu3PlscAuRUKL+EaHW0CCB4Y+gtigQVBW1UkXlqmoB" +
       "UVWlQvRDKlRtpdLSSOQP6Efapu/N7u3XnV31r1ra2bnZ9968N/N7v3nj8xdJ" +
       "i2OT6y1TX5jVTZ5mVZ4+od+W5gsWc9IHsrdNUtthakanjnMExmaUnS8mP7z8" +
       "aDElkdYc2UgNw+SUa6bhHGaOqVeYmiXJYHSfzkoOJ6nsCVqhcplrupzVHD6c" +
       "JVeFVDkZytZckMEFGVyQhQvySCAFShuYUS5lUIMa3LmffJEksqTVUtA9Tgaj" +
       "Rixq05JnZlJEABba8fc0BCWUqzYZ8GN3Y64L+LHr5eWvHUt9q4kkcySpGVPo" +
       "jgJOcJgkR7pKrJRntjOiqkzNkR6DMXWK2RrVtUXhd470OtqsQXnZZv4i4WDZ" +
       "YraYM1i5LgVjs8sKN20/vILGdLX2q6Wg01mIdXMQqxvhGI5DgJ0aOGYXqMJq" +
       "Ks1zmqFy0h/X8GMc+jQIgGpbifGi6U/VbFAYIL3u3unUmJWnuK0ZsyDaYpZh" +
       "Fk62rWkU19qiyhydZTOcbI3LTbqfQKpDLASqcLIpLiYswS5ti+1SaH8uHrrj" +
       "zAPGfkMSPqtM0dH/dlDqiykdZgVmM0NhrmLXnuzjdPPLpyVCQHhTTNiV+c6D" +
       "l+66oW/1VVfmmgYyE/kTTOEzyrl89xvbM7s/0YRutFumo+HmRyIX8J/0vgxX" +
       "Lci8zb5F/JiufVw9/ON7H3qOvSeRznHSqph6uQQ46lHMkqXpzL6HGcymnKnj" +
       "pIMZakZ8Hydt0M9qBnNHJwoFh/Fx0qyLoVZT/IYlKoAJXKI26GtGwaz1LcqL" +
       "ol+1CCFt8JDb4WmH52fe+xlOHpSPOgB3uThPT5SN2Sxj8t2swnQTNlH+rGnP" +
       "ObDrTD6AmLnbNjV1FFa8KMO2aJbDbrRsE9dLzlBdzwMGHHm0zLlp7JUdW5FV" +
       "BoKOZWvQccdvQbrAcNOIQuv/PH8V1yc1n0jA1m2PE4cO8+43dZXZM8pyeXTf" +
       "pRdmXpf8RPJWlpNrVJauTZKOTUISCWH7apzMhQRs6BxQAwh07Z76woHjp3c2" +
       "ARat+WbYDhSV1+buTEAm44IyFUA0WT07//D0l26SiBQlYXQQhjpRfRKp06fI" +
       "oXjyNbKbPPXuhxceXzKDNIywuscO9ZqY3TvjS2mbClOBLwPzewboSzMvLw1J" +
       "pBkoA2iSU4A1MFBffI5Ilg/XGBNjaYGAC6Zdojp+qtFcJy/a5nwwIva4W/R7" +
       "PNiTLfB0wXonvTfBrxstbK92MYGbFotCMPInp6ynfvnTP+0Vy10j72ToOJxi" +
       "fDhEGGgsKaihJ8DAEZsxkPvN2cmvPnbx1OcFAEDi2kYTDmGbAaKALYRlfuTV" +
       "+3/1ztvn3pQC0HA4Mct5XVOqfpAJ4mU8BEeueO+/h4KE2a4L/AHC0SGJEDVD" +
       "R42SqWoFjeZ1hij9Z3LXzS/95UzKxYEOIzUY3fDfDQTjHxklD71+7K99wkxC" +
       "wQMvWLNAzGXRjYHlEdumC+hH9eGf73jiFfoU8DFwoKMtMkFrCS9x0KlNwM7h" +
       "ZDwIkBoBsxWNL4hdlYXYHtGmcYmEMhHf9mLT74SzI5qAocplRnn0zfc3TL//" +
       "/UsinGjpEwbDQWoNu/jDZqAK5rfEqWA/dYogd+vqoftS+uplsJgDiwqc986E" +
       "DeRTjUDHk25p+/UPfrj5+BtNRBojnbpJ1TEqspB0APyZUwTeqlqfuouIv3kE" +
       "fUqESuqCd1Gz1Seg3WsT0BhWLkEOb/3HhJ4/+bu/1S2CoJ4GB3ZMPyeff3Jb" +
       "5s73hH7AAajdV60nZKjyAt1bnit9IO1s/ZFE2nIkpXgl5DTVy5hZOSibnFpd" +
       "CWVm5Hu0BHLP+2Gf47bH+Sc0bZx9goMA+iiN/c4Y4SDHkAF4OuH5wHv/IUw4" +
       "CSI6I0JlULRD2HxU7InESRvguQL1AYfpNYPqsUTv9oz+3nu/FTLOSRMAA7s3" +
       "ubyG7a3YjLpWbm8EEvfTIDa7/LnEX6tHoU977yfCpBIGkpeQg9RQ8dROVzQ2" +
       "n56GZmjCyABZzdXOSEyKHWuVg6KUPXdyeUWdePZmt2jrjZZY++AG8fxb//pJ" +
       "+uxvX2twOndw07pRx4IiBvM9a8P8oCibA6y9cvLP247cWTz+Pxyx/bGA4ia/" +
       "efD8a/dcp3xFIk0+8uoK+qjScBRvnTaDG4hxJIK6HdFjrh8e+JFY9N5K/THX" +
       "EHIJ7H6swXGCRvLe+774zge8GiPlnjoMiMmPrcPGeWw+B8g3XbCsz0uTtlaC" +
       "07biXQTkpd535p5893kXL3ESigmz08tfvpI+syyFrlbX1t1uwjru9Uq4ucFd" +
       "oivwl4Dn3/hgDDiAb6CajFfjD/hFvmUh5AfXc0tMMfbHC0vf+8bSKclbk89w" +
       "0lyBZQxS+N5oCnf5Kewvfa84OZDo0hMVZuOxuE7WNzgc4DyL1bR4QG+tu2S7" +
       "F0PlhZVk+5aVo78QZZ1/eeuAgqhQ1vUwXYb6rZbNCpqIscMlT0u8ypxcFTrP" +
       "OWmvdYWf3JUCFyVVmFqwamGnQmELfq8mQunv0ZtYwt51WDCqEq7PEIHi3xG1" +
       "9C67/5CYUS6sHDj0wKWPP+vWh4pOFxfF9RVu426p6lPE4JrWarZa9+++3P1i" +
       "x64aALpdh4PEDfnW37gY21eyuCifFr+75dt3fH3lbVE3/gc5c2r1JxIAAA==");
}
