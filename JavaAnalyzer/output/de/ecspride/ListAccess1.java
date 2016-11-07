package de.ecspride;

import java.util.LinkedList;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * @testcase_name ListAccess1
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description a list is created which is filled with untainted and tainted
 (deviceId source) data.
 *   The untainted data of a constant list position is retrieved and sent via
 sms.
 * @dataflow -
 * @number_of_leaks 0
 * @challenges the analysis must distinguish between different list positions to
 recognize that the tainted
 *  data does not get leaked. 
 */
public class ListAccess1 extends Activity {
    List<String> listData;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_access1);
        listData = new LinkedList<String>();
        listData.add("not tainted");
        listData.add(
                   ((TelephonyManager)
                      getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId(
                                                                     ));
        listData.add("neutral text");
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49 1234", null, listData.get(0), null, null);
    }
    
    public ListAccess1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAM1YfWwUxxWfO38b4/MHYIeCMWBoccJtIYWqMk05H3YwPbDF" +
       "GVe5tjnGu3P22nu7y+6cfTg4DUgRqAqUNoZQifgvojYRCVFU1EpVIkdRG2ia" +
       "SqmiNlQqqfpPSVKk8EfSqrRJ38x+r++ctn/1pJ2dm5n35s37+M17e/k2qjIN" +
       "dK+uKUfHFI3GSZHGJ5QdcXpUJ2Z8X2rHEDZMIiUVbJrDMJYVN7wY+/ju2fGm" +
       "KKrOoFasqhrFVNZU8yAxNWWKSCkU80b7FJI3KWpKTeApLBSorAgp2aQ9KbTM" +
       "R0pRV8oRQQARBBBB4CIICW8VEC0naiGfZBRYpeYR9CiKpFC1LjLxKFofZKJj" +
       "A+dtNkP8BMChlv0fgUNx4qKBOt2zW2dedOBz9wpzTz3c9FIFimVQTFbTTBwR" +
       "hKCwSQY15El+lBhmQpKIlEHNKiFSmhgyVuQZLncGtZjymIppwSCukthgQScG" +
       "39PTXIPIzmYURKoZ7vFyMlEk519VTsFjcNZV3lmtE/azcThgvQyCGTksEoek" +
       "clJWJYrWhSncM3Z9HRYAaU2e0HHN3apSxTCAWizbKVgdE9LUkNUxWFqlFWAX" +
       "ilaXZcp0rWNxEo+RLEXt4XVD1hSsquOKYCQUrQwv45zASqtDVvLZ5/aBXWce" +
       "UfeqUS6zRESFyV8LRB0hooMkRwyiisQibOhOncerXj4VRQgWrwwtttb89Nid" +
       "3fd1LFyz1nyuxJrB0Qki0qx4abTxrTXJLV+pYGLU6popM+MHTs7df8ie6Snq" +
       "EHmrXI5sMu5MLhz85UOPPUc+iKL6AVQtakohD37ULGp5XVaI8SBRiYEpkQZQ" +
       "HVGlJJ8fQDXQT8kqsUYHczmT0AFUqfChao3/BxXlgAVTUQ30ZTWnOX0d03He" +
       "L+oIoRp4UAM87QhVJOz3LoqOC4dMcHdhfBpPFNSxFCHCHjJFFA2MKHxDMyZN" +
       "sDoR9jGf2WNostQLGh8XwCyybpKtuqExfQkJw8BHzQQT2KQmB4WECD5rbhNM" +
       "QxQkAhSmbsjQ8c3FmSvq/w9CFJmmmqYjETDimjCEKLD5Xk2RiJEV5wq9fXde" +
       "yL4RdUPK1jFFbRKJOxvEfRugSITzXcE2shwDzDpJuJgNW9Lf3nf41IYK8Eh9" +
       "uhIMw5YK5RE86UHKAAdOEfwaLVyYPj7ynS9GUTQIxUw4GKpn5EMMQF2g7AqH" +
       "YCm+sZO3Pr5yflbzgjGA7TZGLKZkMb4hrEZDE4kEqOmx7+7EV7Mvz3ZFUSUA" +
       "B4AlxeDcgEMd4T0Csd7j4CY7SxUcOKcZeaywKQfs6um4oU17I9y+jaxpsUzN" +
       "7BESkEPuV9P60+/85r37uSYddI757rs0oT0+RGDMYjz2mz3zDhuEwLo/Xhh6" +
       "8tztk9/ktoUVG0tt2MXaJCABWAc0+Pi1IzfevXnp7ajnDxSuxMKoIotFfpbm" +
       "T+EXgecT9rCwZgPsDeCetCGl08UUne282ZMN0EWBYGHO0XVIzWuSnJPxqEKY" +
       "M/4ztmnb1b+eabLMrcCI4y33fTYDb/yeXvTYGw//rYOziYjsdvP05y2zILPV" +
       "48zjl8lRPP7btT98HT8N4AuAZ8ozhGMY4vpA3IAC10U3b+OhuW2sWWf6fTwY" +
       "Rr4sJCueffvD5SMfvnKHSxtMY/x234/1HsuLLCvAZt3IbhiWZp03m23VWbui" +
       "CDK0haN+LzbHgdmXFg58q0lZuAvbZmBbDhWDBmBMMeBK9uqqmj+8+tqqw29V" +
       "oGg/qlc0LPVjHnCoDjydmOMAT0X9a7sR/03XQtPE9YEWacjyonYXa7aUx5p+" +
       "lqp44dr+j0Fl9MSf/75IUxxlStzQIfqMcPni6uQDH3B6L9wZdUdxMe5CWufR" +
       "bn8u/1F0Q/Uvoqgmg5pEO2ccwUqBRVoG8iTTSSQhrwzMB3Me64LvceFsTRhq" +
       "fNuGgcbDe+iz1axfH/KKCNNyGzz3gDcU7feo3ysiiHd2c5JO3m5kzWbbQkFW" +
       "EYdFCVYU1bIo3YMpBkt2l7dkujBqUl+WdVqef/NXH8WOW4lQ0AV4om2Thulu" +
       "vFOxfRnt+h6Hx8pRbHIV1IKeTLaSos7ySTvnZcXQMg/JUGkkWxGsMOK8JtB1" +
       "SzcrKWr0h5WFUylQwfrPUEFWHMhn01dvnNzJnTA2JQOME2nYriKCUOXd0j2B" +
       "yqKkkrLirSunr61/f6SVp4yWPphY9wPMsfeX7eiM8OiM2tG3qYzAtkQcWbPi" +
       "sYufvPne7M3rFaga7jbmuNiAdBHy0Xi5SsvPoGsYenuAChy60aKGvJ+b1TZf" +
       "izvqXtMUbS3HmxWS4duc1SqKNk2MXq2gSjymgwFTX9B1/yx3hIb/2REehUvp" +
       "P9Cde3Rk/1q4x1vuwwAh3gc1qH8SMrnWZCqRTmeHHxrqy44kDg4kelN93MN0" +
       "mIz0OT7Y5DGxUKVYYsaqsQKoi+wUhLXbWZOwZneWwu9iaZSIsO7nPajgv2r7" +
       "Duqx3zt8UBHYHxxvbbkSjJePl07MzUuDz2yz8KElWNYwjT3/u3/9On7hT9dL" +
       "5MF1VNO3Kix/D900S+DTfl6qenD/+on3Vw8/MH74v0ho14UOFGb57P7L1x/c" +
       "LP4giipc8F9URAeJekIeDEFRMNThAPCvdU3QyFS7E541oPpX7Pd5P/B7Zl9s" +
       "T9Ab1DEUvIhInlm5uZbbvM7Z7yfCZvXSoIitbNsPm7EqsXoprpnxXgg8hXAZ" +
       "ikskT8dYcwQuFk1NGgQyyKVThCFDzkMiPGUX4cJsy7uTF289b/lNOB8ILSan" +
       "5r77afzMXNT3WWPjoi8Lfhrr0waXczlrvlAMYH6JXThF/1+uzP78x7Mno/YZ" +
       "JyiqnAK1eBFoBCOwwY1AV5UtvmCfIgYr8pYI2hJpF0XLfEUhS33bF32rsr6v" +
       "iC/Mx2rb5g/9ntdF7jeQOig7cgVF8Schvn61bpCczM9XZ6UkOn+dho19lSlY" +
       "1ulyGZ+wVp2lKCpxVt/XnSOvcLwH63o8ATn7lEyPFiNBJHFV2LIEiIXBZ2PZ" +
       "u3R/wfq2lxWvzO878Midnc9YlRjA/syMfVnVWPWeG/nry3JzeFXv3XK38cW6" +
       "TY4DBCrBkGzrSpc6fXmd8uJk5mdtP9n1o/mbvEL7N6ZbWaJyFQAA");
}
