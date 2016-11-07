package de.ecspride;

import android.telephony.TelephonyManager;

public abstract class General {
    TelephonyManager man;
    
    public abstract String getInfo();
    
    public General() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "tE55ETD8/rR3l705co1XQv8CCocryfAQAAA=");
}
