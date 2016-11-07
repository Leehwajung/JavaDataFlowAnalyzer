package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @testcase_name UnreachableCode
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description A method that is never called contains a dataflow from source to
 sink
 * @dataflow no
 * @number_of_leaks 0
 * @challenges the analysis has to discover that the unit is not called
 */
public class UnreachableCode extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unreachable_code);
    }
    
    private void unreachable() {
        TelephonyManager tm =
          (TelephonyManager)
            getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);
        String deviceid = tm.getDeviceId();
        Log.i("INFO", deviceid);
    }
    
    public UnreachableCode() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAM1XaWwVRRyf93qXwmsLFOQ+CsrhW0EhMUWFPo4WH7ShHLEo" +
       "7XR3Xt+2+3aX2Xnto1gFEoX4gRAth4k2mmA8whUj0cRgakwEgjHBEK9E9Jt4" +
       "kMAX/ICK/5k937YF/eYmO7M785///M/f/OfEdVRkUbTINLRdnZrB4iTH4l3a" +
       "sjjbZRIrvj65rBlTiygJDVvWZhhrk+ecid26fShdGUXFrWg81nWDYaYaurWJ" +
       "WIbWQ5QkivmjazSSsRiqTHbhHixlmapJSdVidUk0JrCUodqkK4IEIkgggiRE" +
       "kFb5VLBoLNGzmQRfgXVm7UTPoUgSFZsyF4+h2flMTExxxmHTLDQADqX8fyso" +
       "JRbnKJrl6W7rPEzhw4ukgaM7Kt8vQLFWFFP1Fi6ODEIw2KQVVWRIpoNQa5Wi" +
       "EKUVVemEKC2EqlhT+4TcrajaUjt1zLKUeEbig1mTULGnb7kKmetGszIzqKde" +
       "SiWa4v4VpTTcCbrW+LraGq7l46BguQqC0RSWibuksFvVFYZmhld4OtY+CQSw" +
       "tCRDWNrwtirUMQygatt3GtY7pRZGVb0TSIuMLOzC0JRRmXJbm1juxp2kjaHJ" +
       "YbpmewqoyoQh+BKGJobJBCfw0pSQlwL+ub5xxcHdeoMeFTIrRNa4/KWwaEZo" +
       "0SaSIpToMrEXVixMHsE15w5EEQLiiSFim+bDZ2+uXDxj6IJNM3UEmqaOLiKz" +
       "Nvl4x7jL0xILHi3gYpSahqVy5+dpLsK/2Zmpy5mQeTUeRz4ZdyeHNn3+1J73" +
       "yG9RVN6IimVDy2YgjqpkI2OqGqHriE4oZkRpRGVEVxJivhGVwHdS1Yk92pRK" +
       "WYQ1okJNDBUb4h9MlAIW3EQl8K3qKcP9NjFLi++ciRAqgRdVwDseoWi7029n" +
       "6EVpiwXhLqV7cVdW70wSIq0mPUQzwInSNoN2W+B1Iq3nMbOaGqpSDxZPS+AW" +
       "1bTIgyY1uL0kWwVNkG3RKcFyGndoJGEoRLKoLEFHZMukKnyE5uM8Hs3/jSQ5" +
       "brPK3kgE3DktDCYaSNBgaAqhbfJAtn7NzVNtl6JecjnWZmgq8HI3iYc2QZGI" +
       "4D2Bb2aHCTi5G+ACgLRiQcsz69sPzCmA+DR7C8FNnFQaHc8TPsA0ChiVIcrR" +
       "0LHevVuffyiKovnAzAWEoXK+vJnDqQebteGEHIlvbP+1W6eP9Bt+auYhvYMY" +
       "w1fyjJ8TNiU1ZKIAhvrsF87CZ9vO9ddGUSHACEAnwxDqgEozwnvkZX6di6Jc" +
       "lyJQOGXQDNb4lAt95SxNjV5/RPh4HG+qbXdzf4QEFAD8WIv5+rdf/vKwsKSL" +
       "1bHA6ddCWF0AHzizmECCKt+9mykhQPfDseZXDl/fv134FijmjrRhLW8TgAvg" +
       "HbDgCxd2fvfj1eNXon48MDggsx2aKueELlV34InA+zd/eZLzAd4D1CccgJnl" +
       "IYzJd57vywZYo0HW8OCo3aJnDEVNqTxSeTD+GZu35OzvByttd2sw4kbL4nsz" +
       "8Mfvq0d7Lu34Y4ZgE5H5WefbzyezAXS8z3kVpXgXlyO396vpr57HrwMUA/xZ" +
       "ah8RiIaEPZBwoCRssVC08dDcEt7MtIIxnp9GgZqkTT505cbYrTc+uSmkzS9q" +
       "gn7fgM06O4psL8BmYt+4g6z73J7Pjjd5OyEHMkwKZ30DttLA7JGhjU9XakO3" +
       "YdtW2FaG495qooAzubxQcqiLSr7/9LOa9ssFKLoWlWsGVtZikXCoDCKdWGmA" +
       "qJz5xEoknt5SaCqFPdAwC9lRNNn5Ez+zRDuXN/PtmOOf9+c8TcVT7GjY6vSb" +
       "A5rm86Ro+mjHvShVju8bGFSa3lpiH8rV+UfoGqgQT3791xfxYz9dHAFpy5hh" +
       "PqjxYyKwZxS2XDg6Zm4QZZGPO+f3/Tpl8+Pp9v8AlzNDCoVZvrvhxMV18+WX" +
       "o6jAQ8phBVv+orqgarApJVBh6txIfKRcBNt0zwXjuGmXw1sD6l50+jeDwWbj" +
       "2sj+BLvBcckg8Yjiu1W4a6zD6w2nPxp2q59kEeeA4v8TGarCusKP5bhhxeuz" +
       "uqIRIcPGu6TmJt6sY6jU0BNwSDICjltwl8sLVTMAsz1OwSf1V//Y/dq1k3bc" +
       "hKvDEDE5MPDSnfjBgWighJ47rIoNrrHLaCHnWN48wCN59t12ESvW/ny6/+N3" +
       "+vdHHR1XMlTYA2YRBljKmwbb5Mud/Kzw8tMzZbXIeF6ix5t6COVlRN6SvJQe" +
       "IanFwGrPsWP44HR4pyFU0Of06X8fLCVQyPSAd/xQKeAcyx1OnU7fPnqoBJ2e" +
       "vstcF28wQ2OyftHEh7b51uvIjW6K4egGqB2qv/gpM3nYJdG+2MinBmOlkwa3" +
       "fCNKEO/yUQYnfCqraYH0DKZqsUlJShXyl9lngim6naBHoBCEMHc/hZymTcUY" +
       "iiqCVdZ0/T/BTSVsmvFVcDz2qGxXLjIcqpfaNcw9LBJA4rl52SWu1C6EZe1L" +
       "dZt8enD9xt03l79lFz1wGe/rE1cwuFHapZUHg7NH5ebyKm5YcHvcmbJ5bjbk" +
       "FV0h2WaOXFWsyZhM1AF9H036YMXbg1dFMfQPXJCtHusQAAA=");
}
