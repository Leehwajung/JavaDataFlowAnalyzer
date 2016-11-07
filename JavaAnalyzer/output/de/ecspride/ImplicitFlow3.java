package de.ecspride;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * @testcase_name ImplicitFlow3
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description Based on an input of a password field a log message is written
 * @dataflow source -> userInputPassword -> if-condition -> -> class
 initialization -> methodCall -> sink
 * @number_of_leaks 2
 * @challenges the analysis must be able to handle implicit flows,
 *  detect callbacks from layout xml file and treat the value of password fields
 as source
 */
public class ImplicitFlow3 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_flow3);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.LinkedList linkedList = new java.util.LinkedList();
        leakInformationBit(linkedList);
        leakInformationBit(arrayList);
        leakInformationBit(linkedList);
        Log.i("INFO", "before");
    }
    
    public void leakData(View view) {
        Log.i("INFO", "before1");
        EditText mEdit = (EditText) findViewById(R.id.password);
        String userInputPassword = mEdit.getText().toString();
        Log.i("INFO", "before2");
        Interface classTmp;
        if (userInputPassword.equals("superSecure")) classTmp = new ClassA();
        else classTmp = new ClassB();
        classTmp.leakInfo();
    }
    
    private void leakInformationBit(java.util.List list) {
        if (list instanceof java.util.ArrayList) Log.i("INFO", "0"); else
            if (list instanceof java.util.LinkedList) Log.i("INFO", "1");
    }
    
    static interface Interface {
        public void leakInfo();
        
        String jlc$CompilerVersion$jl7 = "2.7.1";
        long jlc$SourceLastModified$jl7 = 1450032968000L;
        String jlc$ClassType$jl7 =
          ("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" +
           "HAAA");
    }
    
    public class ClassA implements Interface {
        public void leakInfo() { Log.i("INFO", "password correct"); }
        
        public ClassA() { super(); }
        
        public static final String jlc$CompilerVersion$jl7 = "2.7.1";
        public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
        public static final String jlc$ClassType$jl7 =
          ("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" +
           "+IN57617c+wqO9j/AWUxlEi4DwAA");
    }
    
    public class ClassB implements Interface {
        public void leakInfo() { Log.i("INFO", "password incorrect"); }
        
        public ClassB() { super(); }
        
        public static final String jlc$CompilerVersion$jl7 = "2.7.1";
        public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
        public static final String jlc$ClassType$jl7 =
          ("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" +
           "MufcmhNjN9jB/g/bBgY7uA8AAA==");
    }
    
    public ImplicitFlow3() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "3zv4zfl3RAP8X9TwnSjZEgAA");
}
