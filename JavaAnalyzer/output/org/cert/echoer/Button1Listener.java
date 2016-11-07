package org.cert.echoer;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class Button1Listener implements OnClickListener {
    private final MainActivity act;
    
    public Button1Listener(MainActivity parentActivity) {
        super();
        this.act = parentActivity;
    }
    
    @Override
    public void onClick(View arg0) {
        try {
            Log.i("In Echoer", "Echoing data back to caller using setResult()");
            this.act.setResult(0, this.act.i);
        }
        catch (Exception e) { e.printStackTrace(); }
        finally { this.act.finish(); }
    }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478511752000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVYfWwcxRWfO38bx3d2yAdp4o/g0CbQW1K+VDl82IdNnF5i" +
       "N06scm3jjHfnfBvv7S67c+eLgwNEQon6R4RaQ4ME/iuIFgWCKlArVVSmVQuI" +
       "qhItKm0lQtV/SksjkT+AqmkL783s7e7tnY36Vy3tzNzMe2/ee/Peb974wmXS" +
       "5DrkRtsyjs8aFk+xMk8dM25L8eM2c1P7MrdNUMdlWtqgrnsI5qbV7S8mPr76" +
       "WD4ZJ81Zsp6apsUp1y3TPchcyygxLUMSweyIwQouJ8nMMVqiSpHrhpLRXT6Y" +
       "IdeEWDkZyFRUUEAFBVRQhArKUEAFTOuYWSykkYOa3H2AnCSxDGm2VVSPk/5q" +
       "ITZ1aMETMyEsAAmt+HsKjBLMZYf0+bZLm2sMfvxGZen7R5I/aiCJLEno5iSq" +
       "o4ISHDbJko4CK8wwxx3SNKZlSZfJmDbJHJ0a+oLQO0u6XX3WpLzoMN9JOFm0" +
       "mSP2DDzXoaJtTlHlluObl9OZoVV+NeUMOgu2bgxslRaO4jwY2K6DYk6OqqzC" +
       "0jinmxonvVEO38aBrwEBsLYUGM9b/laNJoUJ0i3PzqDmrDLJHd2cBdImqwi7" +
       "cLJlVaHoa5uqc3SWTXOyOUo3IZeAqk04Alk42RAlE5LglLZETil0PpcP7Dl7" +
       "wtxrxoXOGlMN1L8VmHoiTAdZjjnMVJlk7NiVeYJufOVMnBAg3hAhljQ/fvDK" +
       "PTf1rLwuab5Qh2Z85hhT+bR6fqbzra3pnV9tQDVabcvV8fCrLBfhP+GtDJZt" +
       "yLyNvkRcTFUWVw7+6v6Hn2MfxEn7GGlWLaNYgDjqUq2CrRvMuY+ZzKGcaWOk" +
       "jZlaWqyPkRYYZ3STydnxXM5lfIw0GmKq2RK/wUU5EIEuaoGxbuasytimPC/G" +
       "ZZsQ0gIfucMbXPT6hzg5qRx2IdyV/Dw9VjRnM4wp97ISMyw4RMhWzbF0bZIX" +
       "Nd1S7sXxMDg8r0iNjX0YSSNq3gJaatuK66hKgeqmIkLMcmYVFaJKYZJiuMi5" +
       "Ze5GwED2FBLZ/3cNyuij5HwsBse3NQoeBuTdXsvQmDOtLhWHR668MP1m3E8m" +
       "z7uQi7BRCjdKyY1SkY1ILCbkX4sbytCAg50DiACCjp2T39539Mz2BohJe74R" +
       "jgVJldUxPB2AypiAThUim6ycm39k6qGb4yReDcaoJEy1I/sEQqgPlQPRJKwn" +
       "N3H6/Y8vPrFoBelYhe4eStRyYpZvj7rTsVSmAW4G4nf10ZenX1kciJNGgA6A" +
       "Sw6Hh0jUE92jKtsHK8iJtjSBwTnLKVADlypw187zjjUfzIhz7hTjLvBxK+bD" +
       "Jviuge+y11/C1fU2ttfKuMBDi1ghkPnOSfvpP/zmb7cId1dAPBG6FicZHwwB" +
       "BwpLCIjoCmLgkMMY0L17buJ7j18+/U0RAEBxfb0NB7BNA2DAEYKbH339gT++" +
       "d+n82/EgaDjcnMUZQ1fLvpEx4iU6Gveu178TMhJ2uyHQB4DHAPDDqBk4bBYs" +
       "Tc/pdMZgGKX/TuzY/fI/ziZlHBgwUwmjmz5fQDB/3TB5+M0jn/QIMTEVL77A" +
       "ZwGZRNP1geQhx6HHUY/yI7/d9uRr9GnAZcBCV19gAt5iXuKgUhs42RpNyP0Q" +
       "VkMguqTz4+JkFUG6S7QpdJMQQMTaLdj0uuEMqU7CUBUzrT729ofrpj782RVh" +
       "UnUZFA6I/dQelDGITV8ZxG+KwsFe6uaB7taVA99KGitXQWIWJKpw97vjDoBQ" +
       "uSp8POqmlj+9+ouNR99qIPFR0m5YVBulIhNJG6QAc/OAX2X77nuI+JvHwE8K" +
       "U0mN8TJyNvsgtHN1EBrFKibI483/GjdmTv3lnzVOEPBT5/KO8GeVC09tSd/1" +
       "geAPcAC5e8q1wAwVX8D7lecKH8W3N/8yTlqyJKl65eQUNYqYXVkoodxKjQkl" +
       "Z9V6dTkk7/5BH+e2RjEotG0UgYILAcZIjeP2COgk0Mt98LXB9zuv/3kYdGJE" +
       "DIYES79oB7D5ojiTOCcttqOXoFbgsL1uUiOS7J2e0Fe9/qWQcE4aIDBweLPE" +
       "NmxvxWZYSrmjXpDIpX5sdvh7ib9mD1xOen05DCzhQPKSsp/KyzxV0tl8agqa" +
       "gXEzDYA1V7knMSm2rVYairL2/KmlZW38md2ygOuuLrdG4DXx/O//8+vUuT+/" +
       "UeeWbuOW/WUDS4tImO9aPcz3ixI6iLXXTv19y6G78kf/h2u2N2JQVOQP9194" +
       "474b1O/GSYMfeTXFfTXTYHW8tTsMXiPmoaqo21Z91fXCBz8AUGSfrr3q6oZc" +
       "DIdfqnOloJBhr98TPfkAVyPA3FUTA2LzI2ug8Qw234DIt2SwrI1LE45egBu3" +
       "5D0KlMXu9+aeev95GS9REIoQszNL3/k0dXYpHnpmXV/z0gnzyKeWUHOddNGn" +
       "8BeD77/4oQ04gT1ATdqr9/v8gt+2MeT711JLbDH614uLP/3B4um455Ovc9JY" +
       "AjcGKXx/dQp3+Cnsu75b3BwIdKnxEnMcXWNrZH2dywHus0hdi5f05poHt3wk" +
       "qi8sJ1o3LR9+R5R2/kOuDYqiXNEwwnAZGjfbDsvpwsY2CZ626IqweeROh3pH" +
       "DoSmXNKBkq0VOvARduHlE4CBsIzDB+2KY5Ihx4gboBwLAYQHgMLJ3WvgZDVL" +
       "uIrDGBX/vKgAQFH++2Javbi878CJK7c/I6tI1aALC+KxC293WdD6INK/qrSK" +
       "rOa9O692vti2oxIinVLhILVDuvXWL9lGCjYXRdbCTza9tOfZ5UuiuvwMhF6s" +
       "XFUSAAA=");
}
