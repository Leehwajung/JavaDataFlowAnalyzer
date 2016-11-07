package edu.mit.icc_event_ordering;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class IsolateActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        String imei = i.getStringExtra("DroidBench");
        Log.i("DroidBench", imei);
    }
    
    public IsolateActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513201000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAANVXe2wURRifu75L4dryFHlTUAreWhASU1SgFFo82qYFEqty" +
       "THfnetvu7S6zc9ejWAUTA/EPQrQgJtLEBOIjvGIkmhhMjYlAMCYY4isR/E98" +
       "kNB/8A9U/GZ293Zvr8X4p5fc7O7M933zPX/zzalbqMSiaLlpaHt6NYNFSZZF" +
       "+7TVUbbHJFZ0S2x1B6YWUZo0bFnbYC4uLzoXuXP3cLI6jEq70VSs6wbDTDV0" +
       "q5NYhpYhSgxFvNlmjaQshqpjfTiDpTRTNSmmWqwxhib5WBmqi7kqSKCCBCpI" +
       "QgVpvUcFTJOJnk41cQ6sM2s3ehGFYqjUlLl6DC3MF2JiilOOmA5hAUgo5987" +
       "wCjBnKVoQc522+YCg48sl4bf2Fn9QRGKdKOIqndxdWRQgsEm3agqRVI9hFrr" +
       "FYUo3ahGJ0TpIlTFmjoo9O5GtZbaq2OWpiTnJD6ZNgkVe3qeq5K5bTQtM4Pm" +
       "zEuoRFPcr5KEhnvB1hmerbaFm/g8GFipgmI0gWXishT3q7rC0PwgR87GuqeB" +
       "AFjLUoQljdxWxTqGCVRrx07Deq/Uxaiq9wJpiZGGXRiaPaFQ7msTy/24l8QZ" +
       "mhWk67CXgKpCOIKzMDQ9SCYkQZRmB6Lki8+ttrWH9uoteljorBBZ4/qXA9O8" +
       "AFMnSRBKdJnYjFX1saN4xoWDYYSAeHqA2Kb56IWxdSvmjV6yaR4ch6a9p4/I" +
       "LC6f6JlydU7TsseLuBrlpmGpPPh5lov073BWGrMmVN6MnES+GHUXRzu/eGbf" +
       "++S3MKpsRaWyoaVTkEc1spEyVY3QzUQnFDOitKIKoitNYr0VlcF7TNWJPdue" +
       "SFiEtaJiTUyVGuIbXJQAEdxFZfCu6gnDfTcxS4r3rIkQKoM/qoL/JIRCtc5z" +
       "MkNvS9stSHcpOYD70npvjBBpI8kQzYAgQrUq1FCVLpZWVEPayN83gMOTUitP" +
       "yiZQ39CJzuAlldZVWdSH1JyBqXaqEJ5bDRI2TcmispTCqi6J1CNKWkqpTFJl" +
       "OU44cdxwqKVWqBxwxHqZqRmV7YlyevP/oGSWe7p6IBSCJJgThCANqrfF0IA9" +
       "Lg+nNzSPnYlfCedK0okRQ/WwZxT2jBbuGQ3siUIhsdU0vreda5Ap/YA5gMZV" +
       "y7qe37Lr4KIiSHJzoBhizUmliQ+FJg+lWgUWy1AqaPTYwP4dLz0aRuF8dOf6" +
       "wlQlZ+/gmJzD3rpgVY8nN3Lg5p2zR4cMr77zjgsHdgo5OWwsCnqWGjI4jRJP" +
       "fP0CfD5+YagujIoBiwB/GYSUQ9u84B558NHoQjG3pQQMThg0hTW+5OJnJUtS" +
       "Y8CbESGfwodaO/o8HgEFBYo/0WUe/+6rX1YJT7qAH/EdoV2ENfpAhguLCDip" +
       "8cK7jRICdD8e63j9yK0Dz4rYAsXi8Tas4yNPfIgOePCVS7u/v3H9xLWwlw8M" +
       "Ttl0j6bKWWFLzT34heD/N/9zpOAT/AnnRZODUgtyMGXynZd6ugFgaQCaPDnq" +
       "tuspQ1ETKu7RCE/GPyNLGs7/fqjaDrcGM262rPh3Ad78AxvQvis7/5gnxIRk" +
       "fmB6/vPIbBSe6kleTynew/XI7v967psX8XHAc8BQSx0kAhaR8AcSAZSEL+rF" +
       "GA2sNfBhvuXP8fwy8jU2cfnwtduTd9z+dExom98Z+eO+FZuNdhbZUUC+H0B1" +
       "aLX75KtTTT5Oy4IOM4NV34KtJAh7bLTtuWpt9C5s2w3bytAzWALjsnmp5FCX" +
       "lP3w2eczdl0tQuFNqFIzsLIJi4JDFZDpxEoCYmXNp9bZ+gyUw1At/IEKPGRn" +
       "0SznS3wsEONiPiy1c46/PpTNt7TUOYjcg6nUZ2m+TIrmTtQziH7nxMvDI0r7" +
       "yQb7ZK/NP4eboc08/c1fX0aP/XR5HOCtYIb5iMYPFN+eHDPrJ8bMraK38nDn" +
       "4su/zt72ZHLXf4DL+QGDgiLf23rq8ual8mthVJRDyoKuL5+p0W8abEoJtKk6" +
       "dxKfqRTJNjcXgknctavgHwFzM86zzZ9sNq6NH0/wm0kNBoVHFC+sIS6z0pG1" +
       "1XluDIbVK7KQ42z+PZ2hGmyf5lHDim5I64pGhA5t9ynNTj5sZqjc0JsoAXyC" +
       "wC27zw2IqnDGqhmna5SGam/0v3XztJ03wRYzQEwODr96L3poOOzrwxcXtMJ+" +
       "HrsXF3pO5sPDPJMX3m8XwbHp57NDn7w7dCDs2LiOoeIMuEU4YCUfWmyXr3Hq" +
       "sypXnzlX1oqK531+tD1DKFUVkseSV9LjFTWAVaDt4OA6q+CCZV8K5DMjkfKZ" +
       "I9u/FSdvrnGvgIMtkdY0X1b6M7TUpCShChsrbCg0xQMQfvbE7RAYVzgpDOix" +
       "2RMMumebnaEiGP2LKkzBIn/tM11vTXMTD1rBqGtvNlQIbCvtE39iVwZxa3Fe" +
       "LopbrFvwafseG5fPjmxp2zu25qTdIsD9d3BQ3HrgEmc3IjnQWDihNFdWacuy" +
       "u1POVSxxcyevRQnoNn/8M7g5ZTJxag5+PPPDte+MXBetwz/LtX8AXhAAAA==");
}
