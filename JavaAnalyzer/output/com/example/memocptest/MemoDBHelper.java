package com.example.memocptest;

import java.util.Calendar;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MemoDBHelper extends SQLiteOpenHelper {
    public static final String tableName = "memos";
    public static final String colID = "_id";
    public static final String colTitle = "title";
    public static final String colContent = "content";
    public static final String colDate = "date";
    
    public MemoDBHelper(Context context, CursorFactory factory, int version) {
        super(context, tableName + ".db", factory, version);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + tableName + "( " + colID +
                   " INTEGER PRIMARY KEY AUTOINCREMENT, " + colTitle +
                   " TEXT, " + colContent + " TEXT, " + colDate + " TEXT )");
        String date = Calendar.getInstance().getTime().toString();
        db.execSQL(
             "INSERT INTO " +
             tableName +
             (" VALUES ( NULL, \'Android\', \'Activity, View, Menu, Dialog." +
              "..\', ") +
             "\'" +
             date +
             "\'" +
             " ) ");
        db.execSQL(
             "INSERT INTO " + tableName +
             " VALUES ( NULL, \'Java\', \'Class, Package, Interface...\', " +
             "\'" + date + "\'" + " ) ");
    }
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        
    }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1470575729000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "uEhO/XjNqw9+d/ZdcYP+D9JjE1ofFwAA");
}
