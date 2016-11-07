package edu.mit.service_lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MyService extends Service {
    private String value = "";
    
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("DroidBench", value);
        TelephonyManager mgr = (TelephonyManager)
                                 this.getSystemService(TELEPHONY_SERVICE);
        value = mgr.getDeviceId();
        return Service.START_NOT_STICKY;
    }
    
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    
    public MyService() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478515404000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "ndjsdnjftFTIVOsohsPrAp3EX8oN+xfd/hchnUKBRjAVNtSrCkVFe+7k/II6" +
       "8tgOp3brjFZae+Eh8dRv/v1a9uzvXl3iGm7lpvU5HQuJkMwkiNxeP7gPiOo5" +
       "iLCXT/553fgtpaP/wx26MXagOMsnDpx/9batyveTpMGPt5q6Pko0EI2yNKPw" +
       "EDHGI7G2wXdBBk27wQm6xBa3Xx2OtcDtvdjkohGVdkk63b4t7r0AYBuETRu8" +
       "+OqWnWIti2lMDZ4dFt3yeDLKNKiVtCm3opfmOt8//sgHTzkej4NHbDM9Pf/d" +
       "T7Nn5pOhN1JfzTMlTOO8k4QFVmDzWYzBTctJERRDf7ww97PH504l3dtklJMG" +
       "eKThcEJM3LnM1SPS7OucrDTx4ck43MdlsJQgDpLvG8skXw1bMTHu+60LJ9fC" +
       "1w0RPuL2w3VcfrUU9oMAmexy+y/XD4JEwOUuIYctYwthMoj4lGnsAbt6kdPp" +
       "RY5pZ4dxgbLAMuWoZdp8yyR88gDYRqYoY5pKl0GyJa4/QAu/NMcCZE3NLwrO" +
       "K1h5eiHTsnrh8FuiOvVfqq1Q/BUruh6+CkLjlMVoURPnb3UuBkt0JzhZW/et" +
       "wElHzZxQ/D6H+AG4ElxiCEZow4vfgSlYxOEpy7NSl2dkeB5l3cNWE1FA9o3e" +
       "ebVwDGF4XyS7xW82HvhVnF9tCsqFhf0H771802NODa3o8uwscmnJkWanUvcB" +
       "dFNdbh6v1L5tV1Y+07rFy8ZIDR/TbePSReressVFWTn709XP3fzjhfdEbf1f" +
       "jaY7vEwTAAA=");
}
