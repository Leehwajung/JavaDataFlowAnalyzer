package de.ecspride;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * @testcase_name ImplicitFlow2
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description Based on an input of a password field a log message is written
 * @dataflow source -> userInputPassword -> if-condition -> sink
 * @number_of_leaks 2
 * @challenges the analysis must be able to handle implicit flows,
 *  detect callbacks from layout xml file and treat the value of password fields
 as source
 */
public class ImplicitFlow2 extends Activity {
    private boolean passwordCorrect = false;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_flow2);
    }
    
    public void checkPassword(View view) {
        EditText mEdit = (EditText) findViewById(R.id.password);
        String userInputPassword = mEdit.getText().toString();
        if (userInputPassword.equals("superSecure")) passwordCorrect = true;
        if (passwordCorrect) Log.i("INFO", "Password is correct"); else
            Log.i("INFO", "Password is not correct");
    }
    
    public ImplicitFlow2() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "5v8BAaT9XwoTAAA=");
}
