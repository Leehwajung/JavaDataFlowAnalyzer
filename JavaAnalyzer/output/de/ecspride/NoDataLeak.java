package de.ecspride;

import android.util.Log;

public class NoDataLeak {
    private final String data;
    
    public NoDataLeak(String data) {
        super();
        this.data = data;
    }
    
    public String getData() { return data; }
    
    public void logData() { Log.i("LOG", data); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "Jqqy6ZdW/HbbU3MfiXL0G1s/RqKFEgAA");
}
