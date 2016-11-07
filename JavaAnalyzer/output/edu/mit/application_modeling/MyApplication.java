package edu.mit.application_modeling;

import android.app.Application;

public class MyApplication extends Application {
    public String imei = "";
    
    public MyApplication() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478436311000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
