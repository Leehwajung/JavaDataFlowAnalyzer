package edu.mit.icc_componentname_class_constant;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;

/**
 * @testcase_name ICC-ComponentName-Class-Constant
 * 
 * @description Testing the component resolution throught Activity's classname
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges   The analysis tool has to be able to resolve component from a
 name and track it through startActivity
 */
public class OutFlowActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager telephonyManager =
          (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        ComponentName comp = new ComponentName(getPackageName(),
                                               InFlowActivity.class.getName());
        Intent i = new Intent().setComponent(comp);
        i.putExtra("DroidBench", imei);
        startActivity(i);
    }
    
    public OutFlowActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478512878000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAANVXW2wVRRiec3qvhdOWq8ilQEFu7goIYgoKFEqLB9pQILEq" +
       "h+nunJ4te3aX2dn2UCy3xEB8IEQLYiJ9gqCGW4wEE4OpMREIxgRDvCWCb+KF" +
       "BF7wARX/md09e862BX10k53dnfn/f/7rN/+euo2KbIrmWqa+o0M3mUQyTOrU" +
       "F0lsh0VsaW18UQumNlHrdWzbG2EuoUw7F7t3/1CqMoqK29AobBgmw0wzDXsD" +
       "sU29i6hxFAtmV+skbTNUGe/EXVh2mKbLcc1mdXH0WA4rQ7VxXwUZVJBBBVmo" +
       "IK8IqIBpBDGcdD3nwAazt6NdKBJHxZbC1WNoar4QC1Oc9sS0CAtAQin/3gxG" +
       "CeYMRTVZ212bBxl8eK7c9/aWyg8LUKwNxTSjlaujgBIMNmlDFWmSbifUXqGq" +
       "RG1DVQYhaiuhGta1HqF3G6q2tQ4DM4eSrJP4pGMRKvYMPFehcNuoozCTZs1L" +
       "akRX/a+ipI47wNaxga2uhQ18Hgws10AxmsQK8VkKt2mGytCUMEfWxtoXgQBY" +
       "S9KEpczsVoUGhglU7cZOx0aH3MqoZnQAaZHpwC4MTRhWKPe1hZVtuIMkGBof" +
       "pmtxl4CqTDiCszA0JkwmJEGUJoSilBOf2+uXHtxpNBpRobNKFJ3rXwpMk0NM" +
       "G0iSUGIoxGWsmBM/gsdePBBFCIjHhIhdmguv3V0+b/LAZZfmiSFomts7icIS" +
       "yvH2kdcm1s9+roCrUWqZtsaDn2e5SP8Wb6UuY0Hljc1K5IuSvziw4YuX9nxA" +
       "foui8iZUrJi6k4Y8qlLMtKXphK4hBqGYEbUJlRFDrRfrTagE3uOaQdzZ5mTS" +
       "JqwJFepiqtgU3+CiJIjgLiqBd81Imv67hVlKvGcshFAJ3KgC7mqEosu85xKG" +
       "LsibbEh3OdWNOx2jI06IvIp0Ed2EIEK1qtTU1FbmqJopr+LvK8HhKbmJJ2U9" +
       "qG8axGDwknYMTRH1Ia9QmNalsR15swtlbFmyTRU5jTVDFilIVEdOa0zWFCWh" +
       "+LJ4kiYEACQUDxjkZoc16Ga3L1ji3Nb/V/UMj0pldyQCCTMxDFc6VHqjqauE" +
       "JpQ+Z+Xqu2cSV6PZ8vXiydAS0EACDaRHaSCFNECRiNh4NNfEzVLIsW2AVoDj" +
       "FbNbX1279cC0AigPq7sQsoSTysMfJ/UBvjWJ/RTYHw0c7d67effTURTNPxe4" +
       "9jBVztlbOJpnUbs2jAdDyY3tv3Xv7JFeM0CGvIPGA6zBnBxwpoX9TE0FXEhJ" +
       "IH5ODT6fuNhbG0WFgGLgPwbh5qA4ObxHHvDU+SDObSkCg5MmTWOdL/nIW85S" +
       "1OwOZkQCjORDtZsLPB4hBQX+L2u1jn331S8LhSf9oyKWc/i2ElaXA09cWEwA" +
       "UVUQ3o2UEKD78WjLW4dv739ZxBYopg+1YS0feXFAdMCDr1/e/v3NG8evR4N8" +
       "YHA+O+26pmSELVUP4IrA/Te/OcbwCf6Ek6bew7eaLMBZfOeZgW4AdTrALU+O" +
       "2k1G2lS1pIbbdcKT8c/YjPnnfz9Y6YZbhxk/W+Y9WkAw//hKtOfqlj8mCzER" +
       "hR+1gf8CMhe/RwWSV1CKd3A9Mnu/nvTOJXwMTgJAX1vrIQJQkfAHEgGUhS/m" +
       "iFEKrc3nwxQ7N8fzyyinJUooh67fGbH5zqd3hbb5PVVu3Ndhq87NIjcKsJnY" +
       "V/KAPeE/+eooi4+jM6DDuHDVN2I7BcKeGVj/SqU+cB+2bYNtFeg27GYKIJTJ" +
       "SyWPuqjkh88+H7v1WgGKNqBy3cRqAxYFh8og04mdAvzKWC8sR+LqLoWhUvgD" +
       "DfKQm0XjvS/xUSPG6XyY6eYcf30yk7VUXMWehc96z/k5lubLpGjScN2G6JSO" +
       "7+vrV5tPzHd7gur8E3w1NKinv/nrS+noT1eGgOEyZlpP6fzQydmTY+ac4TFz" +
       "nejKAty5tO/XCRufT239D3A5JWRQWOT7605dWTNTeTOKCrJIOahfzGeqyzUN" +
       "NqUEGlyDO4nPlItkm5QNwUju2sVwjwHXn/Seu3OTzcW1oeMJfrOoyaDwiBqE" +
       "VYRrhCdrl/d0wmENiiziOZt/j2GoCrsnvmTa0krHUHUidFj/kNLcwIc1DJWa" +
       "Rj0lgE8QuNkP+XeiGpy4WpfXb8q91Te3vXvrtJs34eY0REwO9L3xQDrYF83p" +
       "4KcPaqJzedwuXug5gg+zeCZPfdgugqPh57O9n7zXuz/q2bicocIucItwwAI+" +
       "NLouX+zVZ0W2PrOurBYVz/8QpOYuQqmmkjyWvJIeqqgBrEJtBwfX8YN+zdzf" +
       "CeVMf6x0XP+mb8XJm235y+BgSzq6npOVuRlabFGS1ISNZS4UWuIBCD/r3zZH" +
       "DNU8ikQY1+6KTjLoyV3RDBXAmLuowRQs8tdOy/fkaD8poYWUfF9kIoNBb4Hb" +
       "DQzv5jCmTc/LU/Fv7IOB4/4dJ5Sz/WvX77y7+ITbPoBdPT3iXwp+Dd0mJQso" +
       "U4eV5ssqbpx9f+S5shl+XuW1LyHdpgx9Pq9OW0ycqD0fj/to6cn+G6Kt+Aev" +
       "daZctBAAAA==");
}
