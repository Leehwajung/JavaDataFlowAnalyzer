package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Toast;

/**
 * @testcase_name Button4
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail steven.arzut@cased.de
 * 
 * @description The sink is called after the user clicks a button. The button
 *  handler is defined via XML using an include directive.
 * @dataflow OnCreate: source -> imei; sendMessage: imei -> sink
 * @number_of_leaks 1
 * @challenges the analysis must analyze the layout xml file and correctly
 handle include directives
 */
public class Button4 extends Activity {
    private static String imei = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button1);
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        imei = telephonyManager.getDeviceId();
    }
    
    public void sendMessage(View view) {
        Toast.makeText(this, imei, Toast.LENGTH_LONG).show();
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49", null, imei, null, null);
    }
    
    public Button4() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVYb2wcxRWfW/93nNzZSZzUTZzENikJcNtQiFSZ0jhHTJye" +
       "YxM7plwpl/HunG/jvd1ldu58ceqWRKKJ+iFCYCCo4E9BLSgQhAhUQiAjxD9R" +
       "VQpC/ScVqn4pLY1EPgBV05a+mf2/ZxvxqSfdzNzsvDdv3vu937y985dRg03R" +
       "dZapH5vSTZYmVZY+qt+cZscsYqcPZG8exdQmakbHtj0Oc3ml57nkZ1cfKKYk" +
       "1JhDa7FhmAwzzTTsQ8Q29QpRsygZzO7TSclmKJU9iitYLjNNl7OazfqzaFVI" +
       "lKG+rGeCDCbIYIIsTJAHglUgtJoY5VKGS2CD2feiH6NEFjVaCjePoW1RJRam" +
       "uOSqGRUnAA3N/PcEHEoIVyna6p/dOXPNgR++Tp5/9J7U83UomUNJzRjj5ihg" +
       "BINNcqitREqThNoDqkrUHGo3CFHHCNWwrs0Ku3Oow9amDMzKlPhO4pNli1Cx" +
       "Z+C5NoWfjZYVZlL/eAWN6Kr3q6Gg4yk4a2dwVueEg3weDtiqgWG0gBXiidRP" +
       "a4bK0Ja4hH/Gvu/BAhBtKhFWNP2t6g0ME6jDiZ2OjSl5jFHNmIKlDWYZdmGo" +
       "a1ml3NcWVqbxFMkztDG+btR5BKtahCO4CEPr48uEJohSVyxKofhcPnjLmePG" +
       "fkMSNqtE0bn9zSDUHRM6RAqEEkMhjmDbzuwjuPOV0xJCsHh9bLGz5qUfXdlz" +
       "fffi286ary+xZmTyKFFYXjk3uebSpsyOb9dxM5ot09Z48CMnF/AfdZ/0Vy3I" +
       "vE5fI3+Y9h4uHnrzrvueJh9LqHUINSqmXi4BjtoVs2RpOqG3E4NQzIg6hFqI" +
       "oWbE8yHUBOOsZhBndqRQsAkbQvW6mGo0xW9wUQFUcBc1wVgzCqY3tjArinHV" +
       "Qgg1wRe1wbcTobr1bp9iiMmHbYC7XJzBR8vGVJYQ+TZSIboJQZTvNOm0DVEn" +
       "8gGOmduoqal7weNFGcKiWTa5waIm95ecwbo+CRiw5b1lxkzjJtmmiqwSWGhb" +
       "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");
}
