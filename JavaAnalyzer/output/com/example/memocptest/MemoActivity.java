package com.example.memocptest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MemoActivity extends Activity {
    private EditText title;
    private EditText memo;
    private Button done;
    private Button cancel;
    private boolean flag;
    private int position;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        title = (EditText) findViewById(R.id.editText1);
        memo = (EditText) findViewById(R.id.editText2);
        done = (Button) findViewById(R.id.button1);
        cancel = (Button) findViewById(R.id.button2);
        Intent intent = getIntent();
        String action = intent.getAction();
        if (action.equals("android.intent.action.CREATE")) {
            title.setText("title");
            memo.setText("Type your memo here.");
            flag = false;
        } else
            if (action.equals("android.intent.action.EDIT")) {
                Log.i("MemoActivity", intent.getStringExtra("title"));
                title.setText(intent.getStringExtra("title"));
                memo.setText(intent.getStringExtra("contents"));
                position = intent.getIntExtra("position", -1);
                flag = true;
            } else
                finish();
    }
    
    public void onClick(View v) {
        if (v == done) {
            Intent intent = new Intent();
            intent.putExtra("title", title.getText().toString());
            intent.putExtra("contents", memo.getText().toString());
            intent.putExtra("isEdited", flag);
            if (flag) intent.putExtra("position", position);
            setResult(RESULT_OK, intent);
            finish();
            Log.i("MemoActivity", intent.toString());
        } else
            if (v == cancel) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
    }
    
    public MemoActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1470575729000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
