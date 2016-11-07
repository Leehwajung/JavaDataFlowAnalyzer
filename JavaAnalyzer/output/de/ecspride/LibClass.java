package de.ecspride;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * THIS IS NOT A TEST CASE ON ITS OWN. IT IS A PART OF LIBRARY2.
 * @author Steven Arzt
 */
public class LibClass {
    public String getIMEI(Context context) {
        TelephonyManager telephonyManager =
          (TelephonyManager)
            context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }
    
    public LibClass() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVXX2wURRifu/4vhbsWaBGBFigYCtxaFBJTVKAU2nqlDQWU" +
       "ChzT3bm7bfd2l9k5ei2gYGLgiRAFxAf6BDEaBGIk+oKpIREQo8EQFRPQxBcV" +
       "SagP+ID/vpndvb3btqJPbrKzuzPf98339/fNnrmLiiyKFpuGNpjQDBYhGRbp" +
       "05ZH2KBJrEh7dHkXphZRmjVsWZtgLibPOx+6/+BIMhxExT1oKtZ1g2GmGrq1" +
       "kViGtpsoURTyZls0krIYCkf78G4spZmqSVHVYk1RNCmHlaH6qKuCBCpIoIIk" +
       "VJBWe1TANJno6VQz58A6s3ahl1AgiopNmavH0Nx8ISamOOWI6RIWgIRS/r0F" +
       "jBLMGYrqsrbbNo8x+Nhi6egbO8LvFaBQDwqpejdXRwYlGGzSgypSJNVLqLVa" +
       "UYjSgyp1QpRuQlWsqUNC7x5UZakJHbM0JVkn8cm0SajY0/Nchcxto2mZGTRr" +
       "XlwlmuJ+FcU1nABbqz1bbQvX8XkwsFwFxWgcy8RlKexXdYWhWj9H1sb654AA" +
       "WEtShCWN7FaFOoYJVGXHTsN6QupmVNUTQFpkpGEXhmZOKJT72sRyP06QGEMz" +
       "/HRd9hJQlQlHcBaGpvvJhCSI0kxflHLic3fDysN79FY9KHRWiKxx/UuBaY6P" +
       "aSOJE0p0mdiMFQ3R47j64qEgQkA83Uds03ywd3TVkjkjV2yaR8eh6eztIzKL" +
       "yad6p1yf1bzoqQKuRqlpWCoPfp7lIv27nJWmjAmVV52VyBcj7uLIxk+27n+H" +
       "3Ami8jZULBtaOgV5VCkbKVPVCF1PdEIxI0obKiO60izW21AJvEdVndiznfG4" +
       "RVgbKtTEVLEhvsFFcRDBXVQC76oeN9x3E7OkeM+YCKESuFEF3JPg/sJ5fsrQ" +
       "XmmzBekuJQdwX1pPRAmR1pLdRDMgiNLzBu23IOpEauc5s5YaqrIGPJ6UICyq" +
       "aZGlJjW4v6CuFb7YbRJZjasyoEIvxXSwUbKoLCkE6C2TqvACCyLYEZ6F5v+8" +
       "f4b7JzwQCEDoZvmBQ4N9Ww1NITQmH02vaRk9G7sWzBaS41mGpikk4kqPuNJR" +
       "ICCETuO72LkAkewHTAC0rFjUvb1956F5BZCE5kAhxIGTShODdrOHIm0CK2VI" +
       "ZTRyYuDAlpcfD6JgPvpyzWCqnLN3cczMYmO9v+rGkxs6+OP9c8f3GV795cG5" +
       "AwtjOXlZz/P7kBoyUQAoPfENdfhC7OK++iAqBKwAfGQY8hmgZ45/j7zybnKh" +
       "kttSBAbHDZrCGl9y8a2cJakx4M2I4E7hQ5UdZx4Pn4ICZZ/uNk9+8/lPTwhP" +
       "uoAcymlx3YQ15YAAFxYS5V7phXcTJQTobp3oev3Y3YMvitgCxfzxNqznYzMU" +
       "P0QHPPjqlV03v7t96kbQywcGXTDdq6lyRthS+RdcAbj/5DevZD7Bn4DnzQ6K" +
       "1GVhxOQ7L/R0A0DRoEh4ctRv1lOGAiWCezXCk/H30ILGC78cDtvh1mDGzZYl" +
       "DxfgzT+yBu2/tuO3OUJMQOYNzfOfR2aj5FRP8mpK8SDXI3Pgy9lvXsYnAW8B" +
       "4yx1iAjYQsIfSARQEr5oEGPEt9bIh1orN8fzyyjn4BGTj9y4N3nLvY9Ghbb5" +
       "J5fcuHdgs8nOIjsKsFk1cgYOnzfdJ1+davJxWgZ0qPFXfSu2kiDsyZEN28La" +
       "yAPYtge2laGnW50UACaTl0oOdVHJtx9fqt55vQAF16FyzcDKOiwKDpVBphMr" +
       "CdiUMZ9dhcQ1UApDWPgDjfGQnUUznC/xUSfG+XxYaOccf30sk7VUXMWOhVed" +
       "56UcS/NlUjR7op4uziOnXjk6rHSebrQ7b1V+n2yBY+C7X/3xWeTE91fHgdgy" +
       "ZphLNd4VcvbkmNkwMWZ2iLOPhzuXX/l55qZnkjv/A1zW+gzyi3y748zV9Qvl" +
       "14KoIIuUY05l+UxNuabBppTAMVLnTuIz5SLZZmdDEHKTbTLcvzrPO7nJZuOa" +
       "iCcfVmZZA8jp+ZzlB+d5yx89r5YCjk/593SGarDdTyMcoInOIs75WGwY/Yc6" +
       "7OLDeoZKEnBW6WhpcwWGRXrzQ2fEPnSKhWV8aLVzbsW/y2SGSt0my6Fkxpjj" +
       "vn1Elc8Oh0prhjd/LfpM9hhZBjAeT2taTgxy41FsUhJXhSFlduGb4rGVoUk5" +
       "bR50cF+Fgi/YVNsYCipC1HZzHLvtk2UmMLYWl9lN6iFuyCm1+Xl5L36M3BxN" +
       "279GMfnccPuGPaMrTttdDX6phobEQRr+C+zemc3zuRNKc2UVty56MOV82YKg" +
       "E+W8rurTrXb8ttGSMpkA+qEPa95f+dbwbdHt/gab+PHusQ4AAA==");
}
