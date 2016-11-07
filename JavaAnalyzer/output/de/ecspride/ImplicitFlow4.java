package de.ecspride;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * @testcase_name ImplicitFlow4
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description Based on an input of a password field a log message is written
 * @dataflow source -> password -> if-condition -> sink
 * @number_of_leaks 2
 * @challenges the analysis must be able to handle implicit flows,
 *  detect callbacks from layout xml file and treat the value of password fields
 as source
 */
public class ImplicitFlow4 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_flow4);
    }
    
    public void checkUsernamePassword(View view) {
        EditText editPassword = (EditText) findViewById(R.id.password);
        EditText editUsername = (EditText) findViewById(R.id.username);
        String password = editPassword.getText().toString();
        String username = editUsername.getText().toString();
        Log.i("TAG", "bevor try");
        try {
            boolean passwordCorrect = lookup(username, password);
            if (passwordCorrect) Log.i("INFO", "password correct"); else
                Log.i("INFO", "password not correct");
        }
        catch (Exception ex) { Log.i("INFO", "username not available"); }
        Log.i("TAG", "after try");
    }
    
    private boolean lookup(String username, String password) throws Exception {
        if (!username.equals("hanns"))
            throw new Exception("username not available");
        else
            if (username.equals("hanns") && !password.equals("superSecure"))
                return false; else return true;
    }
    
    public ImplicitFlow4() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "9MudP9//o7kPZLP5X4rJiWdFEgAA");
}
