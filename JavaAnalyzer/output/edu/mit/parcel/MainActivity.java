package edu.mit.parcel;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * @testcase_name Parcel
 * 
 * @description Tests whether analysis has proper modeling of Parcel marshall
 and unmarshall
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges - Parcel marshall and unmarshalling
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager mgr = (TelephonyManager)
                                 this.getSystemService(TELEPHONY_SERVICE);
        writeParcel(mgr.getDeviceId());
    }
    
    public void writeParcel(String arg) {
        final Foo orig = new Foo(arg);
        final Parcel p1 = Parcel.obtain();
        final Parcel p2 = Parcel.obtain();
        final byte[] bytes;
        final Foo result;
        SmsManager sms = SmsManager.getDefault();
        try {
            p1.writeValue(orig);
            bytes = p1.marshall();
            String fromP1 = new String(bytes);
            p2.unmarshall(bytes, 0, bytes.length);
            p2.setDataPosition(0);
            result = (Foo) p2.readValue(Foo.class.getClassLoader());
        }
        finally {
            p1.recycle();
            p2.recycle();
        }
        sms.sendTextMessage("+49 1234", null, result.str, null, null);
    }
    
    protected static class Foo implements Parcelable {
        public static final Creator<Foo> CREATOR = new Creator<Foo>() {
            public Foo createFromParcel(Parcel source) {
                final Foo f = new Foo();
                f.str = (String) source.readValue(Foo.class.getClassLoader());
                return f;
            }
            
            public Foo[] newArray(int size) {
                throw new UnsupportedOperationException();
            }
        };
        public String str;
        
        public Foo() { super(); }
        
        public Foo(String s) {
            super();
            str = s;
        }
        
        public int describeContents() { return 0; }
        
        public void writeToParcel(Parcel dest, int ignored) {
            dest.writeValue(str);
        }
        
        public static final String jlc$CompilerVersion$jl7 = "2.7.1";
        public static final long jlc$SourceLastModified$jl7 = 1478460356000L;
        public static final String jlc$ClassType$jl7 =
          ("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" +
           "dgI/9Mril7b+eOY6u3r4L5L95Bd0GAAA");
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478460356000L;
    public static final String jlc$ClassType$jl7 =
      ("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" + "AA==");
}
