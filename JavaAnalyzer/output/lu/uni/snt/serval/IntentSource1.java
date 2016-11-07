package lu.uni.snt.serval;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * @testcase_name IntentSource1 
 * @version 0.1
 * @author Serval, SnT, University of Luxembourg
 * @author_mail li.li@uni.lu
 * 
 * @description The value of a source is stored in an intent which is a
 parameter in onActivityResult. The activity use startActivityForResult to call
 some Intent back.
 * @dataflow intent->startActivityForResult, intent->Log
 * @number_of_leaks 2
 * @challenges the analysis must be able to track the taint in the intent and
 recognize the onActivityResult(-1,-1,intent) source. 
 *
 */
public class IntentSource1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);
        Intent intent = this.getIntent();
        intent.setAction("android.intent.action.MAIN");
        this.startActivityForResult(intent, 1);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == 1) {
            Bundle b = data.getExtras();
            for (String key : b.keySet()) {
                Log.i("SnT", "dump: " + b.get(key));
            }
        }
    }
    
    public IntentSource1() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513300000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
