package edu.mit.icc_unresolvable_intent;

import edu.mit.icc_unresolvable_intent.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class InFlowActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = getIntent();
        String imei = i.getStringExtra("DroidBench");
        Log.i("DroidBench", imei);
    }
    
    public InFlowActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513751000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAANVXW2wVRRiec3o9tXDachWBcikoqLuCl8TUC7RSWjzQhgKJ" +
       "9XKY7s7pmbJnd5mdbQ/VKpoYiA+EaFVMtE8QlSgQI9HEYGo0omKMGuMt8fLm" +
       "lcS+6APe/pndc/bSFuKjm+zs7sz89///5t+XzqMqh6GrbcvYN2BYXCFFrgwa" +
       "Nyp8n00cZUvmxh7MHKK3G9hxdsBcVltxKv37hcP5hiSq7kNzsGlaHHNqmc52" +
       "4ljGENEzKB3MbjJIweGoITOIh7DqcmqoGerw1gy6LETKUUumpIIKKqiggipV" +
       "UDcGu4BoFjHdQrugwCZ39qIHUSKDqm1NqMfR8igTGzNc8Nn0SAuAQ6343gVG" +
       "SeIiQ8vKtns2TzH4yavVsafva3ilAqX7UJqavUIdDZTgIKQP1RdIoZ8wZ6Ou" +
       "E70PNZqE6L2EUWzQEal3H2py6ICJuctI2Uli0rUJkzIDz9VrwjbmatxiZfNy" +
       "lBh66asqZ+ABsHV+YKtnYYeYBwPrKCjGclgjJZLKPdTUOWqOU5RtbLkTNgBp" +
       "TYHwvFUWVWlimEBNXuwMbA6ovZxRcwC2VlkuSOFo0YxMha9trO3BAyTL0cL4" +
       "vh5vCXalpCMECUfz4tskJ4jSoliUQvE5v+2WQ/ebnWZS6qwTzRD61wLR0hjR" +
       "dpIjjJga8Qjr12aewvPPHEwiBJvnxTZ7e157YHLDNUsn3vP2XDHNnu7+QaLx" +
       "rHa0f/Yni9vX3Fwh1Ki1LYeK4Ecsl+nf46+0Fm2ovPlljmJRKS1ObH/3rv3H" +
       "yS9JVNeFqjXLcAuQR42aVbCpQdhmYhKGOdG7UIqYertc70I18J6hJvFmu3M5" +
       "h/AuVGnIqWpLfoOLcsBCuKgG3qmZs0rvNuZ5+V60EUI1cKN6uFNwf+w/z3F0" +
       "XN3pQLqr+WE86JoDGULUO8gQMSwIIlSrziyq93JXp5Z6h3hvA4fn1S6RlO2g" +
       "vmUSk8NLwTWpJutD3WkyWQC43yBin8nXqdi2VYdpagFTU5X5R3RXLVCuUk3L" +
       "uiGKLJUkIKHDsIY3apwOUb5PETT2/0rbovB9w3AiAWmxOA5KBtRzp2XohGW1" +
       "Mbdt0+SJ7LlkuUj9qHGkgFwF5CozyFWiclEiIcXNFfK9DIT82QNIBBhdv6b3" +
       "3i27D66ogNS3hysh+mKrOvNR0R5gV5dEaA0KCE0cGX5410PXJVEyivlCZ5iq" +
       "E+Q9AqnLiNwSr/Xp+KYP/Pj7yadGraDqI4eID0ZTKQWYrIh7l1kaOI6RgP3a" +
       "Zfh09sxoSxJVAkIBKnMIrQC8pXEZEVBpLQG0sKUKDM5ZrIANsVRC1TqeZ9Zw" +
       "MCPDPlsMTV4GiHjEFJTYfmuv/dyXH/10vfRk6RhIhw7WXsJbQ9AjmKUlyDQG" +
       "4d3BCIF93xzpeeLJ8wfulrGFHSunE9giRlEFEB3w4KPv7f3qu2+PfpYM8oHD" +
       "2ev2G1QrSlsa/4ErAfff4hb4ISbEE06Rdh+7lpXByxaSVwe6AYwZAKUiOVp2" +
       "mgVLpzkqclck45/pVetO/3qowQu3ATOlbLnm0gyC+cvb0P5z9/2xVLJJaOIY" +
       "DfwXbPOweU7AeSNjeJ/Qo/jwp0ueOYufA5QHZHXoCJFgiaQ/kAygKn2xVo5K" +
       "bG2dGJqdcI5HyyjU7mS1w5/9NmvXb29OSm2j/VI47lux3eplkRcFEHYt8gcB" +
       "2pOlp1idY4txbhF0WBCv+k7s5IHZDRPb7mkwJi6A2D4Qq0En4XQzgJ5iJJX8" +
       "3VU1X7/19vzdn1SgZAeqMyysd2BZcCgFmU6cPKBW0b59A5LXcC0MDdIfaIqH" +
       "vCxa6H/Jj2VyXCmG1V7Oidcri2VL5VXtW/iB/3wnZGmUJ0NLZuokZBd09JGx" +
       "cb372DrvvG+Kns6boPl8+fO/PlSOfP/+NOCb4pZ9rSFOl5BMgZlrZ8bMrbLj" +
       "CnDn7CM/L9pxW373f4DL5phBcZYvbn3p/c2rtceTqKKMlFN6wShRa9g0EMoI" +
       "NK+mcJKYqZPJtqQcgsuEa6/3uoXEev9ZF042D9emjyf4zWYWh8IjehDWhOBZ" +
       "5/NK+U8UD2tQZAnf2eJ7HkeN2DvaFctR2lxTN4jUYdtFSnO7GDZzVGuZ7YwA" +
       "PkHg1lzkv4hROGfpkN9LqqNN3+159seXvbyJN56xzeTg2GP/KIfGkqHufOWU" +
       "BjlM43XoUs9ZYrhKZPLyi0mRFB0/nBx944XRA0nfxg0cVQ6BW6QD1ouh03P5" +
       "TX591pfrs+zKJlnxovtXuocIY1QnEZJISU9X1BzNjnYdAlsXTvnr8v4UtBPj" +
       "6doF4zu/kAdvuZtPwbmWcw0jlJThBK22GclRaWLKQ0JbPgDgmy/REXG0YIYV" +
       "aUm/xyjHobn2GHFUAWN4kcIULIrXQbvktrmlDITeUClZXkxMRbj13tE/s0/j" +
       "ALYykpTyJ7dU+a73m5vVTo5v2Xb/5E3HvF4Bfo9HRuRPEfzjeR1JGT2Wz8it" +
       "xKu6c82F2adSq0pJFOlVYro1T38YbyrYXB6fI68vePWW58e/lT3EvygIx0R9" + "EAAA");
}
