package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * @testcase_name ArrayAccess1
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description an array is created which is filled with untainted and tainted
 (deviceId source) data.
 *  The untainted data of a constant array position is retrieved and sent via
 sms.
 * @dataflow -
 * @number_of_leaks 0
 * @challenges the analysis must distinguish between different array positions
 to recognize that the tainted
 *  data does not get leaked. 
 */
public class ArrayAccess1 extends Activity {
    public static String[] arrayData;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_access1);
        arrayData = (new String[3]);
        arrayData[0] = "element 1 is tainted:";
        arrayData[1] =
          ((TelephonyManager)
             getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        arrayData[2] = "neutral text";
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49 1234", null, arrayData[2], null, null);
    }
    
    public ArrayAccess1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAM1YfWwcRxWfO387ds52aicNiePYTiBOe0sKjYRc2jiXuLG5" +
       "xFacpGCgznh3zrf23u5md86+uLgfqVAi/ghV65a0av1XykeVJhWiAgkVGSFo" +
       "q6JKrSq+JBrgHwohUvIHBRGgvDf7vXc+xH+ctLOzM++9efM+fvPmLl0ndbZF" +
       "dpuGdnpGM3ialXh6Vrs7zU+bzE6PZu8ep5bNlIxGbfsYjE3Jva+kPrz1RL4t" +
       "SeonyQaq6wanXDV0+yizDW2eKVmSCkYPaqxgc9KWnaXzVCpyVZOyqs0Hs2Rd" +
       "iJWT/qynggQqSKCCJFSQhgIqYGplerGQQQ6qc/sUeZgksqTelFE9TrZHhZjU" +
       "ogVXzLjYAUhoxO8TsCnBXLJIj793Z89lG356t7T8jQfbvltDUpMkpeoTqI4M" +
       "SnBYZJK0FFhhmln2kKIwZZK064wpE8xSqaYuCr0nSYetzuiUFy3mGwkHiyaz" +
       "xJqB5Vpk3JtVlLlh+dvLqUxTvK+6nEZnYK9dwV6dHQ7jOGywWQXFrByVmcdS" +
       "O6fqCifb4hz+Hvs/BwTA2lBgPG/4S9XqFAZIh+M7jeoz0gS3VH0GSOuMIqzC" +
       "yeY1haKtTSrP0Rk2xcmmON24MwVUTcIQyMJJZ5xMSAIvbY55KeSf60fuOf+Q" +
       "fkhPCp0VJmuofyMwdceYjrIcs5guM4exZSD7DO167VySECDujBE7NN//ys19" +
       "d3SvvuHQfKwCzdj0LJP5lHxxev07WzK7PlODajSahq2i8yM7F+E/7s4MlkzI" +
       "vC5fIk6mvcnVoz/7wqMvsWtJ0jxC6mVDKxYgjtplo2CqGrPuZzqzKGfKCGli" +
       "upIR8yOkAfpZVWfO6FguZzM+Qmo1MVRviG8wUQ5EoIkaoK/qOcPrm5TnRb9k" +
       "EkIa4CEt8HQSUtPmvtdx8rh03IZwl/ILdLaoz2QZkw6weaYZ4ETpAcOas8Hr" +
       "TBrFmDlgGaqyHyyel8AtqmmzO03LQHtJQ5ZFT9tDqLDNbedzSIagtfdItiVL" +
       "CgMW27RU6IQn0xiM5v+HGiW0VttCIgGO3BKHEQ2WP2RoCrOm5OXi/oM3L0+9" +
       "lfTTyrUzhIfC0t4K6fAKJJEQgm/DlZzoAN/OMaFpy66JL4+ePNdbA2FpLtSC" +
       "d5BUWhvGMwGujAj0lCG4yeqFhcdOPPLJJElG8Ri1g6FmZB9HFPXRsj+eh5Xk" +
       "ps5+8OGVZ5aMICMjAO8CRTknJnpv3I6WITMFoDMQP9BDX516bak/SWoBPQAx" +
       "OYUIBzDqjq8RSfhBDzxxL3Ww4ZxhFaiGUx7iNfO8ZSwEI8LB67HpcHyN/ogp" +
       "KHD3sxPmC796+0+fEpb0IDoVOvQmGB8MwQIKSwkAaA/ce8xiDOh+e2H8qaev" +
       "n/2i8C1Q9FVasB/bDMABeAcs+NU3Tv366vsX30sG8cDhXCxOa6pcEntp/wh+" +
       "CXj+jQ/mNg7gGxA+4+JKjw8sJq68M9ANIEaDfMHg6D+uFwxFzal0WmMYjP9M" +
       "7djz6l/Otznu1mDEi5Y7/ruAYPz2/eTRtx78W7cQk5DxiAvsF5A5uLkhkCyS" +
       "BvUoPfbu1mdfpy8AAgPq2eoiE0BGhD2IcKAkbDEg2nRsbg822+xwjEfTKFSK" +
       "TMlPvHej9cSNH90U2kZrmbDfD1Nz0Ikixwuw2G7iNgiokvfG2Q0mtreVQIeN" +
       "8aw/RO08CPv06pEvtWmrt2DZSVhWQMWYBSBTioSSS13X8Jsf/6Tr5Ds1JDlM" +
       "mjWDKsNUJBxpgkhndh7wqWTet4+I30IjNG3CHqTMQk4UbfKxZtfaWDOM9UqQ" +
       "rpv+MaZNn/nD38ssJVCmwjEd45+ULj2/OXPvNcEfpDtyd5fKgRdqu4D3rpcK" +
       "f0321v80SRomSZvsFo4nqFbETJuEYsn2qkkoLiPz0cLHOeUHfTjbEoea0LJx" +
       "oAkAH/pIjf3mWFSk0Mq98HRBNEy4733hqEgQ0dknWHpE24fNTuGTJHY/Dklv" +
       "i/K05AtOoOD1rsD73PddIcGcNFFMoQOUU3DsjrUdKzLNqYtWvtn39iMrfb8X" +
       "cdio2rD9IWumQqEW4rlx6eq1d1u3Xha4XTtNbccQ8Qq3vICN1KXCbi1Ru3W6" +
       "2xquZDdB2gl3EJEe6M20U8b6MZ5woxq/B7EZ9Yx9pLqx63KqTjWh0SfA9BrT" +
       "Z3i+enKMW2oBjoB5twaVljquzj3/wctOfRnPhBgxO7f8tY/S55eToaq+r6yw" +
       "DvM4lb1QsFVoidiyvdoqgmP4j1eWfvjtpbOOVh3RGvUgXMFe/sW/fp6+8Ls3" +
       "KxQ0NeA+/BgxS76Bk47VPE9sCDyR0Qyd4TngzTnljmqk/TsUTJbKXGWRgbVt" +
       "fFiES4ACr5/58+Zj9+ZP/g91zraYjeIiv3P40pv375SfTJIaHxPKLlhRpsEo" +
       "EjRbDG6E+rEIHmx1ok/Yr3LoJUToOSFX5TDLV5mbxQZCp05G4zu+qkJeKBGn" +
       "9sFWAMeQ44+9lQ4OZ6oHm5yfpOJX7x51ze67NpSkocOFYIhuXeu6J8Lz4pnl" +
       "FWXsxT1JV8PPA4Rxw7xTwwtA5JzCPvXVQBQke+G5HZZ/zn1bYawINlpueFgE" +
       "bg0cjgGmBPAqVG51ZZ1y3/n41gYqYg2EezvVFbydpA07vb+oKxDrOPNwFX+c" +
       "wWaBk0ZDz1gMijVBNeGmN74e4KR2HoQGHitFPdbie8xXpCPIybF5ZuF1pIqT" +
       "K9QHnLSEry9YpG0q+2vF+TtAvrySaty4cvyXzkngXdmboEDOFTUtfFyG+vWm" +
       "xXKqMEGTc3ia4vV1TtaFLlFgGK8rlDzvUD3JSVIRop4yfazxjE9NMz0E1eW8" +
       "yk+XEtFg9G3YUSXq4/HbFwEn8UeUByRF56+oKfnKyuiRh27ufdG5M8gaXVxE" +
       "KY1w3jk3Ex+Mtq8pzZNVf2jXrfWvNO3wMiJyZ4nptq1yUX6wYHJRRi/+YOP3" +
       "7vnWyvviLvEfIhChHCEUAAA=");
}
