package org.cert.sendsms;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new Button1Listener(this));
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (resultCode == 0 && requestCode == 0 && data != null) {
            if (data.hasExtra("secret")) {
                if (data.getExtras().getString("secret") != null) {
                    Log.v("In SendSMS: ", "Data recieved");
                    sendSMSMessage(data.getExtras().getString("secret"));
                } else
                    Log.i("In SendSMS: ", "Data recieved");
            }
        } else
            Log.i("In SendSMS: ", "No data recieved");
    }
    
    @SuppressLint("UnlocalizedSms") 
    protected void sendSMSMessage(String message) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("1234567890", null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent!",
                           Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Couldn\'t send SMS!",
                           Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478512102000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
