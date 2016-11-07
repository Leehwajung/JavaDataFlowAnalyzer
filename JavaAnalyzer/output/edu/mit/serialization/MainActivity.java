package edu.mit.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name Serialization
 * 
 * @description Test serialization end to end flow.
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges - must model serialization
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager mgr = (TelephonyManager)
                                 this.getSystemService(TELEPHONY_SERVICE);
        String imei = mgr.getDeviceId();
        S s1 = new S(imei);
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(s1);
            oos.close();
            byte[] bytes = out.toByteArray();
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            ObjectInputStream iis = new ObjectInputStream(in);
            S s2 = (S) iis.readObject();
            iis.close();
            Log.i("DroidBench", s2.toString());
        }
        catch (Exception e) {  }
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478510562000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "wx/XfLj6nbGrolv4Bw+2YswZEAAA");
}

class S implements Serializable {
    private static final long serialVersionUID = -1155152173616606359L;
    private String message;
    
    public S(String message) {
        super();
        this.message = message;
    }
    
    public String toString() { return message; }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478510562000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
