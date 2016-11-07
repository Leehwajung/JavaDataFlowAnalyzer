package org.cert.WriteFile;

import java.io.FileOutputStream;
import org.cert.WriteFile.Button1Listener;
import org.cert.WriteFile.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;

/**
 * @testcase_name StartActivityForResult1
 * @version 0.1
 * @author Contributed by the DidFail project 
 * @author_mail (Maintainer) steven.arzt@cased.de
 * 
 * @description Reads the user's geographical location (via GPS) and leaks
 * 		it to the file system, and passes it to another activity using
 * 		startActivityForResult which writes it to a file.
 * @dataflow getLastKnownLocation -> startActivityForResult
 * 		-> onActivityResult -> FileOutputStream
 * @number_of_leaks 1
 * @challenges Inter-component communication using startActivityForResult
 * 		must be handled correctly
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new Button1Listener(this));
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (resultCode == 0 && requestCode == 0 && data != null) {
            if (data.hasExtra("secret")) {
                if (data.getExtras().getString("secret") != null) {
                    String filename = "sinkFile.txt";
                    String sinkData = data.getExtras().getString("secret");
                    FileOutputStream outputStream;
                    try {
                        outputStream = openFileOutput(filename,
                                                      Context.MODE_PRIVATE);
                        outputStream.write(sinkData.getBytes());
                        outputStream.close();
                        Log.i(filename, sinkData);
                    }
                    catch (Exception e) { e.printStackTrace(); }
                } else
                    Log.i("In WriteFile: ", "Data recieved");
            }
        } else
            Log.i("Back in WriteFile: ", "No data recieved");
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478512170000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "KfESAAA=");
}
