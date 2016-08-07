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
    public static final long jlc$SourceLastModified$jl7 = 1470575729000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZfWwUxxWfO58/MdiYYLuED4MNKSS5LSShqkwTzAHBcGCH" +
       "M0h1Psx6d85e2Ntddufsw9QpIa2glYqiBhLSAlIVUNqIQBQlKlKVFNSmSURU" +
       "iQg1baUmUf8JLaUNfzStStv0vdnZ2729j4AotbQzezPz3rzP37xZn7xCqh2b" +
       "3GmZ+q4R3WRxmmPx7fp9cbbLok58ffK+ftl2qJrQZccZgLEhZcHLTZ9ee2q0" +
       "OUpqBskM2TBMJjPNNJzN1DH1MaomSZM/ukanGYeR5uR2eUyWskzTpaTmsO4k" +
       "mRIgZaQr6YkggQgSiCBxEaQefxUQTaVGNpNACtlgzk7yOIkkSY2loHiMzC9k" +
       "Ysm2nBFs+rkGwKEOf28FpThxziYded1dnYsUPnSndPDZx5pfqSJNg6RJM1Io" +
       "jgJCMNhkkDRmaGaY2k6PqlJ1kEw3KFVT1NZkXZvgcg+SFkcbMWSWtWneSDiY" +
       "tajN9/Qt16igbnZWYaadVy+tUV31flWndXkEdG31dXU1XIvjoGCDBoLZaVmh" +
       "Hklsh2aojMwLU+R17NoAC4C0NkPZqJnfKmbIMEBaXN/psjEipZitGSOwtNrM" +
       "wi6MzCrLFG1tycoOeYQOMdIeXtfvTsGqem4IJGFkZngZ5wRemhXyUsA/Vzat" +
       "OLDbWGdEucwqVXSUvw6I5oaINtM0tamhUJewcUnyGbn19f1RQmDxzNBid81P" +
       "vn515V1zz77trrm9xJq+4e1UYUPK8eFpF2YnFn+lCsWos0xHQ+cXaM7Dv1/M" +
       "dOcsyLzWPEecjHuTZzf/8mt7XqSXo6Shl9Qopp7NQBxNV8yMpenUfpAa1JYZ" +
       "VXtJPTXUBJ/vJbXwntQM6o72pdMOZb0kpvOhGpP/BhOlgQWaqBbeNSNteu+W" +
       "zEb5e84ihNTCQxrhmUFItFn0UxgxpS0OhLs0Oi5vzxojSUql1XSM6iY4EbJV" +
       "tU1NTbGsqpnSRpoxE/0D1GGSbFmSYytSRtYMiccT6AJZKmcsnUqQQqZiMVy4" +
       "ERb0KEwb09iuOC60/v9b5tAKzeORCDhodhgedMisdaauUntIOZhdtebqqaHz" +
       "0Xy6CPsx0gmbxcVmcX+zeHAzEonwPW7DTd0AAPftACAAiGxcnHp0/bb9C6og" +
       "8qzxGDgAl0rlkTrhQ0cvB0gF4pecPTz+xNZvfClKooWQi4LCUAOS9yNQ5gGx" +
       "K5xqpfg27bv06elnJk0/6QowXGBBMSXm8oKwSW1ToSqgo89+SYf82tDrk11R" +
       "EgOAAFBkYDbEm7nhPQpyutvDR9SlGhROm3ZG1nHKA7UGNmqb4/4I9/U0bFpc" +
       "t6M/QgJyaP1qyjr6m1/98R5uSQ+FmwLnWoqy7kDmI7MmnuPTffcO2JTCut8f" +
       "7n/60JV9D3PfworOUht2YZuAjAfvgAW/9fbO3374wfGLUT8eGBx92WFdU3Jc" +
       "l+mfwV8Env/gg+mLA9gDiCcEdHTkscPCnRf5sgGK6IBkGBxdW4yMqWppTR7W" +
       "KQbjv5oWLn3tzweaXXfrMOJFy12fz8Af/8Iqsuf8Y3+fy9lEFDzFfPv5y1xo" +
       "nOFz7rFteRfKkXvivTnPvSUfBZAFYHO0CcqxinB7EO5AidtiCW/jobml2Mxz" +
       "gjFemEaBamNIeeriJ1O3fvLGVS5tYbkS9PtG2ep2o8j1AmwmEdEgZt7j9Tg7" +
       "w8L2thzI0BbO+nWyMwrM7j276ZFm/ew12HYQtlXgIHf6bMCbXEEoidXVtb87" +
       "9/PWbReqSHQtadBNWV0r84Qj9RDp1BkFqMpZD6wk/G+8Dppmbg9SZCE3itr5" +
       "rxgIuLg81qzFksRP1/Z/9unDe//wjyJLcZQpcRKH6Aelk0dmJe6/zOn9dEfq" +
       "ubliDIbyzadd9mLmb9EFNW9GSe0gaVZEbbhV1rOYaYNQDzlewQj1Y8F8YW3j" +
       "HuTdeTibHYaawLZhoPGxH95xNb43hKIigla+HZ6ZEA0Pif7LwaiIEP6ykpN0" +
       "8LYTm0XCQ4WsIh6LEqwYr0vN1cPrqA6nJCecWeFUwrWr3LUuCmK7DJsed9fl" +
       "ZUOou1CqOfC0gjSm6FMlFFzvKohNolgnTlWCmpFaWYV6wFfnbtk9/ONQQlqm" +
       "zeJj98bHNXWEsnhKQx0TWdsx7R6XKqTYhhtUDHKYtIFIT4p+ZwnFUhUV41Ql" +
       "qBmJqsOeTos8nVSZycOyQ+POTl1jNJ56KAndajEaUmbg+pWpx9EaeCYJaeqA" +
       "PkPI1MYSyjxSOgzh2Km1bG0MzpBQQNYJZlNEHyvQMabpiu5puczTUrhLuGir" +
       "Rse7+oxeRjNJ0xhJwNm2A3GfGkXue7SCxrkykuPrHb7QxLMEwnOD6INCBwCR" +
       "IGTPKXcL4Teo43sPHlP7Tix17wothZX9Gri4vvTrf78bP/zROyXKxXpmWnfr" +
       "WNQG9qyBLZeUB+GN/LbmI+Fbe/80a+D+0W03UOvNCykUZvnjjSffeXCR8r0o" +
       "qcrjYtE9spCouxANG2wKF19joAAT5+RdMA1Nu9zFxei7oj8eDEbf7aUisd6y" +
       "TQawTVXfrdxdUwWv50X//bBb/QohIqprEZrTvdA0nfiqrKHqlMswUaGueBwb" +
       "KAvqTCNhU0iMyqdnv61loEYcE/dQabLlwx1HLr3kxk34qAwtpvsPfuez+IGD" +
       "0cDNvrPoch2kcW/3XM6p2HwRI3l+pV04xdqPT0/+9EeT+6JCR/B8bAzM4mcg" +
       "K8zAxnwG5k3ZwssVPF3jfWPUtjWVVkja4oqED1h5x07xDlAoreDQdfsV1xss" +
       "+DoeQqwGwaRb9MvKR0nQ309XmDuEzXchMk1jNRyttrkLB570zXagrNlw+Ns3" +
       "YyC+sNPNqOqLoj93Iwa6I2SgWsHkjOhfufE0GgNMB2AxsnzzH1Yw3QlsfsDI" +
       "DC+N+iyOX0jMCfaI+MXum3AMDZumTmXDt+2RW2zbhfA8AMB8TvQnb9a2yOR5" +
       "0R+9btvOLLItnphcgFcr2PcMNqeA3DSEZZEsRXUOoDj5gm/K07fOlDyPN8Gz" +
       "AWqGh0XffrN5jEzaRD+tvCmrOJeqUvFUpRn8XvumZ+dWz854JaEGi/fyjov3" +
       "iwqGPo/NG4w0m/lvPZupk9VZCAp+dottvB6ePVDl7Rb9TWMlMukWfQWsjIk7" +
       "pDBjW6jYw4oOK73SUIEzvhdCLorpUBZy0d+vYP+PsLkA13TTwL0wynkpGTL/" +
       "e/9D8+fgxhX8todfMNqL/rXgfg5XTh1rqms7tuV9/nkr/8m6Pknq0lldD94l" +
       "A+81lk3TGtev3r1ZWry7BHFa+lrHSIP/g0v8sUtymZEpARJAUvEWXPQXSAhY" +
       "hK9/tTxXtXuuki2L+9HTNxcpLJbzRm75vJtJoL7uLKiZ+P9vvMI06/4HZ0g5" +
       "fWz9pt1Xl59wv8MpujwxgVzqkqTW/dqXL27nl+Xm8apZt/jatJfrF3o1TsF3" +
       "wJBs80p/6FqTsRj/NDVxpu3VFS8c+4B/n/svHDnjh1gbAAA=");
}
