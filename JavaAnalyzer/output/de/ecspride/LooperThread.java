package de.ecspride;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class LooperThread extends Thread {
    public static Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.obj != null && msg.obj instanceof String)
                Log.d("DroidBench", (String) msg.obj);
        }
    };
    public boolean ready = false;
    
    public void run() {
        Looper.prepare();
        ready = true;
        Looper.loop();
    }
    
    public LooperThread() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "2Sv5375i6PQG5+MK6ZTLqaf9/tt1FLunvmIpoVhCn7TP54zfPxzTpwnvz9mr" +
       "B+mQa5QBiqf9uk+d73hv6on3n5M1XTIiE5vZqYWHP86dXlAilfSOZcVslEZW" +
       "08Llq7C5EXN829VOERT9f7o4//L35k9KqTrideF++Ox57lf//nnu7B/erFNY" +
       "pMdt22TUSngufxXPyaUubA4H9ha/Zt+R3/T74xF7R4CBoFpbVirLhUrnTiws" +
       "6oNP7VZ81B3lgEW2c4uJJVuEFdYzu1Z23yHxVRIm+usn/rJp5M7Ssf+hlNma" +
       "kDPJ8plD59+8e6f2HYU0BGm/7HspTtQbT/Y2l8EHnjUSS/kt8czokE/qFb9/" +
       "IZoZoe8STgmSAEl+4PffTzql/j03eZU18ZkE0NfgVqTpvuhHK3ZHOWmcBlgI" +
       "g6l4LRiI3SCctEcLXLzGNy770JYfh9qFxUzLhsWjvxY1XvAB1wolVLFimlFA" +
       "jYybHZcVDaFIq4RXR3TTnFwXKbM5aakNhZAVuWuWE0UXrOacGhJmxZWKN0BO" +
       "Cl1NxcM9MEXHtUwRyZAdsbgWf0nUYrAi/5QY0y4uHjz8wOXbn5IVpWbSuTnx" +
       "CQtf5LJuDeJ424rcaryaD/RcWf186w21nItVtAnZttYv2faXHS6KrLmXNvzw" +
       "jqcX3xWV5n8BRZeexisSAAA=");
}
