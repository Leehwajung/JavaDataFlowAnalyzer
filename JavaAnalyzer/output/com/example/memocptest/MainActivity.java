package com.example.memocptest;

import java.util.Calendar;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends ListActivity {
    MemoDBHelper memoDbHelper;
    SimpleCursorAdapter adapter;
    SQLiteDatabase db;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        memoDbHelper = new MemoDBHelper(this, null, 1);
        db = memoDbHelper.getWritableDatabase();
        String[] selectionArgs = { MemoDBHelper.colTitle };
        Cursor cursor = db.rawQuery("SELECT * FROM " + MemoDBHelper.tableName,
                                    null);
        adapter =
          new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1,
                                  cursor, selectionArgs,
                                  new int[] { android.R.id.text1 },
                                  CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        setListAdapter(adapter);
        getListView().setOnItemLongClickListener(ilcl);
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        memoDbHelper.close();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent();
        intent.setClassName("com.example.memocptest",
                            "com.example.memocptest.MemoActivity");
        intent.setAction("android.intent.action.CREATE");
        startActivityForResult(intent, 0);
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (data.getBooleanExtra("isEdited", true)) {
                long posId = adapter.getItemId(data.getIntExtra("position",
                                                                -1));
                db.execSQL("UPDATE " + MemoDBHelper.tableName + " SET " +
                             MemoDBHelper.colTitle + " = \'" +
                             data.getStringExtra("title") + "\', " +
                             MemoDBHelper.colContent + " = \'" +
                             data.getStringExtra("contents") + "\', " +
                             MemoDBHelper.colDate + " = \'" +
                             Calendar.getInstance().getTime().toString() +
                             "\'" + " WHERE " + MemoDBHelper.colID + " = " +
                             posId);
            } else {
                db.execSQL("INSERT INTO " + MemoDBHelper.tableName +
                             " VALUES ( NULL, " + "\'" +
                             data.getStringExtra("title") + "\', " + "\'" +
                             data.getStringExtra("contents") + "\', " + "\'" +
                             Calendar.getInstance().getTime().toString() +
                             "\' ) ");
            }
            Cursor cursor = db.rawQuery("SELECT * FROM " +
                                          MemoDBHelper.tableName,
                                        null);
            adapter.changeCursor(cursor);
            adapter.notifyDataSetChanged();
        } else
            if (resultCode == RESULT_CANCELED) {  }
    }
    
    private AdapterView.OnItemLongClickListener ilcl =
      new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view,
                                       int position, long id) {
            db.execSQL("DELETE FROM " + MemoDBHelper.tableName + " WHERE " +
                         MemoDBHelper.colID + " = " + id);
            Cursor cursor = db.rawQuery("SELECT * FROM " +
                                          MemoDBHelper.tableName,
                                        null);
            adapter.changeCursor(cursor);
            adapter.notifyDataSetChanged();
            return true;
        }
    };
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Cursor cursor = db.rawQuery("SELECT * FROM " + MemoDBHelper.tableName +
                                      " WHERE " + MemoDBHelper.colID + " = " +
                                      id,
                                    null);
        cursor.moveToFirst();
        Intent intent = new Intent();
        intent.setClassName("com.example.memocptest",
                            "com.example.memocptest.MemoActivity");
        intent.setAction("android.intent.action.EDIT");
        intent.putExtra("title", cursor.getString(1));
        intent.putExtra("contents", cursor.getString(2));
        intent.putExtra("position", position);
        startActivityForResult(intent, 0);
        super.onListItemClick(l, v, position, id);
    }
    
    public MainActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1471724817000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZfWwUxxWfO58/MdiY2FAC5sOGFJLcBpJQUacJ5oBgOLDD" +
       "GaS4Scx6d85e2Ntddufss1OnhLSCViqKGkhpQ5CigtIiAqhK2khVAlWbJhFR" +
       "JVDUtJWaRP0ntJQ2/NG0Km3T92Znb/f2PgKi1NLO7M3Me/M+f/NmfeIyqXZs" +
       "crtl6uPDusniNMfiO/R742zcok58Q/LePtl2qJrQZcfph7FBZeHppk+uPj3S" +
       "HCU1A2SGbBgmk5lmGs4W6pj6KFWTpMkfXavTjMNIc3KHPCpLWabpUlJzWFeS" +
       "TAmQMtKZ9ESQQAQJRJC4CFK3vwqIplIjm0kghWwwZxd5gkSSpMZSUDxGFhQy" +
       "sWRbzgg2fVwD4FCHv7eBUpw4Z5P5ed1dnYsUPni7dOA7jzX/qIo0DZAmzUih" +
       "OAoIwWCTAdKYoZkhajvdqkrVATLdoFRNUVuTdW2Cyz1AWhxt2JBZ1qZ5I+Fg" +
       "1qI239O3XKOCutlZhZl2Xr20RnXV+1Wd1uVh0LXN19XVcB2Og4INGghmp2WF" +
       "eiSxnZqhMjIvTJHXsXMjLADS2gxlI2Z+q5ghwwBpcX2ny8awlGK2ZgzD0moz" +
       "C7swMrssU7S1JSs75WE6yMis8Lo+dwpW1XNDIAkjreFlnBN4aXbISwH/XN58" +
       "3/7HjfVGlMusUkVH+euAqD1EtIWmqU0NhbqEjUuTz8ptr+2LEgKLW0OL3TU/" +
       "+cqVVXe0n33LXXNriTW9QzuowgaVo0PTzs9JLFlZhWLUWaajofMLNOfh3ydm" +
       "unIWZF5bniNOxr3Js1t++fDu4/RSlDT0kBrF1LMZiKPpipmxNJ3aD1KD2jKj" +
       "ag+pp4aa4PM9pBbek5pB3dHedNqhrIfEdD5UY/LfYKI0sEAT1cK7ZqRN792S" +
       "2Qh/z1mEkFp4SCM8MwiJNot+CiOmtNWBcJdGxuQdWWM4Sam0ho5S3QQnQraq" +
       "tqmpKZZVNVPaRDNmoq+fOkySLUtybEXKyJoh8XgCXSBL5YylUwlSyFQshgs3" +
       "wYJuhWmjGhuP40Lr/79lDq3QPBaJgIPmhOFBh8xab+oqtQeVA9nVa6+cHDwX" +
       "zaeLsB8jHbBZXGwW9zeLBzcjkQjf4xbc1A0AcN9OAAKAyMYlqUc3bN+3sAoi" +
       "zxqLgQNwqVQeqRM+dPRwgFQgfsnZQ2NPbvvqXVESLYRcFBSGGpC8D4EyD4id" +
       "4VQrxbdp78VPTj07afpJV4DhAguKKTGXF4ZNapsKVQEdffZL58uvDL422Rkl" +
       "MQAIAEUGZkO8aQ/vUZDTXR4+oi7VoHDatDOyjlMeqDWwEdsc80e4r6dh0+K6" +
       "Hf0REpBD65dS1vO/+dUf7+aW9FC4KXCupSjrCmQ+MmviOT7dd2+/TSms+/2h" +
       "vmcOXt77Ze5bWNFRasNObBOQ8eAdsODX39r12w/eP/pu1I8HBkdfdkjXlBzX" +
       "Zfqn8BeB5z/4YPriAPYA4gkBHfPz2GHhzot92QBFdEAyDI7OrUbGVLW0Jg/p" +
       "FIPxX02Llr3y5/3Nrrt1GPGi5Y7PZuCPf2412X3usb+3czYRBU8x337+Mhca" +
       "Z/icu21bHkc5ck9emPvdN+XnAWQB2BxtgnKsItwehDtQ4rZYytt4aG4ZNvOc" +
       "YIwXplGg2hhUnn7346nbPn79Cpe2sFwJ+n2TbHW5UeR6ATaTiGgQM+/2epyd" +
       "YWF7Sw5kmBnO+vWyMwLM7jm7+ZFm/exV2HYAtlXgIHd6bcCbXEEoidXVtb/7" +
       "2c/btp+vItF1pEE3ZXWdzBOO1EOkU2cEoCpnPbCK8L+xOmiauT1IkYXcKJrF" +
       "f8VAwCXlsWYdliR+us76Z68+tOcP/yiyFEeZEidxiH5AOnF4duL+S5zeT3ek" +
       "bs8VYzCUbz7t8uOZv0UX1rwRJbUDpFkRteE2Wc9ipg1APeR4BSPUjwXzhbWN" +
       "e5B35eFsThhqAtuGgcbHfnjH1fjeEIqKCFr5VnhaIRoeEv0XglERIfxlFSeZ" +
       "z9sObBYLDxWyingsSrBivC411wytpzqckpywtcKphGtXu2tdFMR2OTbd7q4r" +
       "yoZQV6FUc+FpA2lM0adKKLjBVRCbRLFOnKoENSO1sgr1gK/OnbJ7+MehhLRM" +
       "m8VH74mPaeowZfGUhjomsrZj2t0uVUixjdepGOQwmQkiPSX6XSUUS1VUjFOV" +
       "oGYkqg55Oi32dFJlJg/JDo07u3SN0XjqoSR0a8RoSJn+a1emHkdr4JkkpKkd" +
       "+gwhUxtKKPNI6TCEY6fWsrVROENCAVknmNWLPlqgY0zTFd3TcrmnpXCXcNE2" +
       "jY519ho9jGaSpjGcgLNtJ+I+NYrc92gFjXNlJMfX23yhiWcJhOcG0ccCQgcA" +
       "kSBkzy13C+E3qKN7DhxRe48tc+8KLYWV/Vq4uL7063+/Ez/04dslysV6Zlp3" +
       "6ljUBvasgS2XlgfhTfy25iPhm3v+NLv//pHt11HrzQspFGb5w00n3n5wsfLt" +
       "KKnK42LRPbKQqKsQDRtsChdfo78AE+fmXTANTbvCxcXoO6I/GgxG3+2lIrHe" +
       "sk0GsE1V363cXVMFr++L/ntht/oVQkRU1yI0p3uhaTrx1VlD1SmXYaJCXfEE" +
       "NlAW1JlGwqaQGJVPzz5by0CNOCruodJkywc7D198yY2b8FEZWkz3Hfjmp/H9" +
       "B6KBm31H0eU6SOPe7rmcU7H5PEbygkq7cIp1H52a/OkPJvdGhY7g+dgomMXP" +
       "QFaYgY35DMybsoWXK3i6xntHqW1rKq2QtMUVCR+w8o6d4h2gUFpVbxD9F681" +
       "WPB1LIRYDYLJStHfVT5Kgv5+psLcQWy+BZFpGmvgaLXNcRx4yjfb/rJmw+Fv" +
       "3IiB+MION6OqL4j+zPUY6LaQgWoFkx+L/vT1p9EoYDoAi5Hlm79QwXTHsHmO" +
       "kRleGvVaHL+QmBPsFvGL3dfgGBoyTZ3Khm/bwzfZtovgeQCA+Yzoj9+obZHJ" +
       "C6J/7ppt21pkWzwxuQAvV7Dvq9icBHLTEJZFshTVOYDi5Iu+KU/dPFPyPN4M" +
       "z0aoGR4WfduN5jEyaRV9Y3lTVnEuVaXiqUoz+L32Dc/ObZ6d8UpCDRbv4R0X" +
       "7xcVDH0Om9cZaTbz33q2UCersxAUnLnJNkaM3A1V3rjobxgrkclK0VfAypi4" +
       "QwozzgwVe1jRYaVXGipwxvdCyEUxHcpCLvp7Fez/ITbn4ZpuGrgXRjkvJUPm" +
       "v/A/NH8OblzBb3v4BWNW0b8W3M/hyskjTXUzj2x9j3/eyn+yrk+SunRW14N3" +
       "ycB7jWXTtMb1q3dvlhbvLkKclr7WMdLg/+ASf+SSXGJkSoAEkFS8BRf9BRIC" +
       "FuHrXy3PVbM8V8mWxf3o6ZuLFBbLeSO3fNbNJFBfdxTUTPz/N15hmnX/gzOo" +
       "nDqyYfPjV1Ycc7/DKbo8MYFc6pKk1v3aly9uF5Tl5vGqWb/k6rTT9Yu8Gqfg" +
       "O2BItnmlP3StzViMf5qaeHXmy/e9eOR9/n3uv7jsx9RYGwAA");
}
