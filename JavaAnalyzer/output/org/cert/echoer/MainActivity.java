package org.cert.echoer;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;

public class MainActivity extends Activity {
    Intent i;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new Button1Listener(this));
        getDataFromIntent();
    }
    
    protected void onResume() {
        super.onResume();
        getDataFromIntent();
    }
    
    private void getDataFromIntent() {
        try {
            i = getIntent();
            String action = i.getAction();
            if (action.equals(Intent.ACTION_SEND)) {
                Bundle extras = i.getExtras();
                Log.i("Data recieved in Echoer: ", extras.getString("secret"));
            } else
                if (action.equals(Intent.ACTION_VIEW)) {
                    Uri uri = i.getData();
                    Log.i("URI recieved in Echoer: ", uri.toString());
                }
        }
        catch (Exception e) { e.printStackTrace(); }
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478511752000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "w+Etvlbir96tHd50+9cCWgUCjGAKbFiqzBMl6oVT8wvK2BPbnWKsPVw6DcHL" +
       "4Olf/fvnyfNvvlTl3m3ihvlBDSuFwJ61sGXf0kE9KsphP7JeOPWXzoM7c4dv" +
       "4O7cGDlQVOR3Ri++dM8W+ZE4qSnHWUWhHmbqD0dXs8XgZaEfDMXYhrIL0OLk" +
       "NsdzsQm33xaMMd/tlf4Eu5mWwSENmFKqjFuU1ef23VG3+ogbcxHEDb82L/wM" +
       "O7m7oCsaEzrcuwxOU2wmOWk09EGLwWW1PBqNW2oe7tyiW+hLc+1vHH3sraed" +
       "uIlCT4SYnZn/wnvJs/PxwNOpp+L1EuRxnk9CzxXYfAAjuXu5XQTH8J8uzf3w" +
       "23On4+4ZxzipLYJZ/Az8WDgDW8oZWDZlu4B/RKvkWJFZlqqwZZK2EuHFxEQ4" +
       "WDrh6yAkPur2O683WHCYrhIlKORut7996SgJ+ru4zJpoTBEL8HAuOImQ8a12" +
       "bBncupYBEDlJN3xdoOs33P7z158tDaalFiE8I1ZodCWdcfuT12eFB5dZ+xw2" +
       "c5BMWcb3UE6HLSPvw3jAHPf/D+YQZD3w7QCs5G5PbyQebolYosEV8nG3P3Dj" +
       "qFFU2QzgqF4Qmz+8jI3OYfNFTlZ5qDFmCrhGZsEgu+mKXRa8N20YGqO6b7wv" +
       "LZmBOK3dUK6VOGkJPvawpO2o+PHJ+cFEfmYh0bhu4dCvxXun/KNGEzwnMgVN" +
       "CxYXgXG9abGMKo7e5JQapui+DvVp5NkJLwVnINT8mkP3TUwqlw7ACLvg8rc4" +
       "qYFlHD5pem5Z7bkF3tNJ72ilWPhiL9uz/VrBGKgFekL4Ln7M8y7RgvNz3pR8" +
       "aWHf/hNX7nzCeYPJGp2dRSmNKdLgvPTKF3H3ktI8WfV7t15d+WzTzR4eh96A" +
       "Ed02Vn/kDOVNLp4lsz9Y9727nlx4XbzN/gvF5tROZRUAAA==");
}
