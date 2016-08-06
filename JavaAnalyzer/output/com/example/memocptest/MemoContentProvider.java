package com.example.memocptest;

import com.example.memocpcontracttest.*;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MemoContentProvider extends ContentProvider {
    static final int ALL_MEMOS = 1;
    static final int ALL_TITLES = 2;
    static final int ONE_MEMO = 3;
    static final UriMatcher Matcher;
    
    static {
        Matcher = new UriMatcher(UriMatcher.NO_MATCH);
        Matcher.addURI(MemoContract.AUTHORITY, MemoDBHelper.tableName,
                       ALL_MEMOS);
        Matcher.addURI(MemoContract.AUTHORITY, MemoDBHelper.tableName + "/" +
                       MemoContract.MEMO_TITLE, ALL_TITLES);
        Matcher.addURI(MemoContract.AUTHORITY, MemoDBHelper.tableName + "/#",
                       ONE_MEMO);
    }
    
    SQLiteDatabase db;
    
    @Override
    public boolean onCreate() {
        MemoDBHelper memoDbHelper = new MemoDBHelper(getContext(), null, 1);
        db = memoDbHelper.getWritableDatabase();
        return true;
    }
    
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        int code = Matcher.match(uri);
        Cursor cursor;
        switch (code) {
            case ALL_MEMOS:
                cursor = db.rawQuery("SELECT * FROM " + MemoDBHelper.tableName,
                                     null);
                break;
            case ALL_TITLES:
                cursor = db.rawQuery("SELECT " + MemoDBHelper.colID + ", " +
                                     MemoDBHelper.colTitle + " FROM " +
                                     MemoDBHelper.tableName, null);
                break;
            case ONE_MEMO:
                String id = uri.getPathSegments().get(1);
                cursor = db.rawQuery("SELECT * FROM " + MemoDBHelper.tableName +
                                     " WHERE " + MemoDBHelper.colID + " = " +
                                     id, null);
                break;
            default:
                cursor = null;
        }
        return cursor;
    }
    
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int code = Matcher.match(uri);
        switch (code) {
            case ALL_MEMOS:
                long row = db.insert(MemoDBHelper.tableName, null, values);
                if (row > 0) {
                    Uri notiuri =
                      ContentUris.withAppendedId(MemoContract.CONTENT_URI, row);
                    getContext().getContentResolver().notifyChange(notiuri,
                                                                   null);
                    return notiuri;
                }
                break;
            default:
        }
        return null;
    }
    
    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int code = Matcher.match(uri);
        int count = 0;
        switch (code) {
            case ONE_MEMO:
                String where =
                  MemoDBHelper.colID +
                " = " +
                uri.getPathSegments().get(1) +
                (selection == null || selection.length() == 0
                   ? ""
                   : " AND " + selection);
                count = db.update(MemoDBHelper.tableName, values, where,
                                  selectionArgs);
                break;
            default:
        }
        return count;
    }
    
    @Override
    public int delete(Uri uri, String selection,
                      String[] selectionArgs) {
        int code = Matcher.match(uri);
        int count = 0;
        switch (code) {
            case ALL_MEMOS:
                count = db.delete(MemoDBHelper.tableName, selection,
                                  selectionArgs);
                break;
            case ONE_MEMO:
                String where =
                  MemoDBHelper.colID +
                " = " +
                uri.getPathSegments().get(1) +
                (selection == null || selection.length() == 0
                   ? ""
                   : " AND " + selection);
                count = db.delete(MemoDBHelper.tableName, where, selectionArgs);
                break;
            default:
        }
        return count;
    }
    
    @Override
    public String getType(Uri uri) {
        int code = Matcher.match(uri);
        switch (code) {
            case ALL_MEMOS:
                return "vnd.memocptest.cursor.item/memos";
            case ALL_TITLES:
                return "vnd.memocptest.cursor.item/titles";
            case ONE_MEMO:
                return "vnd.memocptest.cursor.item/memo";
            default:
        }
        return null;
    }
    
    public MemoContentProvider() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1470575729000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "UucIEpZVheKR0P5m3nxIajB9jQofUzkl3WlKyiczxcRiC5enAAC8UODbD7A4" +
       "DgmwiHKZahTofiJFkBzmHXmNNz9VYMiPsXgCZtiQpPpGW+vpWZthOKkb1jUw" +
       "x59v5sUfbN47EaTBez5SCw8kYmX7LPrIRJEGmTxk0dH8SON34umAbY0Gb6Jj" +
       "3ZLxI5rBpfllAROfxeIURKSkwEJjDmtuyNM3wJBfIKRil0W3TdSQyGSzRZP5" +
       "DVnMuRRzbbE440Qmn/b1AhY7j8VrYLGkBgHI477Lsdi5G2AxmZBJhy36rYla" +
       "DJnst+jj+S1WxLkUpS3mMtaFAsa6iMXbYKwolWmWsf7w0RmLZwT18OyErazO" +
       "olUTNRYyKTZp9fv5jeVzuBzg8/yzgImuYvFXSKPilNnJ4mHHRn/7H9ooBdtJ" +
       "jot0vC6ckfXnnvmHlHh0PFA+fXzVa2aGYf9pVBEh5bGkLLsvblz1Uk2nMYmr" +
       "V2Fe42hIfHDSqc99wQ+HaecFBff5zSGljExyDQE7WTV3pwpGiqATVis1Gxmb" +
       "8iCjrXbKl3l4SZu89lonQtd5pzkjteN/pNoniqT5V+qAeGx8Rdfmy7cfMu++" +
       "RVnYtAm5lEMWZt6wp08lc/Jys3mVLl94dfJzFfPsE1TG3btHtqbcl8vtCY3x" +
       "6+BNL0z/3p1Pj7/Bb7z+AzJj8UnhHgAA");
}
