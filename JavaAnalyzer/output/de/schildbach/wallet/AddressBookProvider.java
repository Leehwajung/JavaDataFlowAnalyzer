package de.
  schildbach.
  wallet;

import java.util.List;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

/**
 * @author Andreas Schildbach
 */
public class AddressBookProvider extends ContentProvider {
    private static final String DATABASE_TABLE = "address_book";
    public static final String KEY_ROWID = "_id";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_LABEL = "label";
    public static final String SELECTION_QUERY = "q";
    public static final String SELECTION_IN = "in";
    public static final String SELECTION_NOTIN = "notin";
    
    public static Uri contentUri(final String packageName) {
        return Uri.parse("content://" + packageName + '.' + DATABASE_TABLE);
    }
    
    public static String resolveLabel(final Context context,
                                      final String address) {
        String label = null;
        final Uri uri =
          contentUri(context.getPackageName()).buildUpon().appendPath(address).
          build();
        final Cursor cursor =
          context.getContentResolver().query(uri, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst())
                label =
                  cursor.getString(
                           cursor.getColumnIndexOrThrow(
                                    AddressBookProvider.KEY_LABEL));
            cursor.close();
        }
        return label;
    }
    
    private Helper helper;
    
    @Override
    public boolean onCreate() {
        helper = new Helper(getContext());
        return true;
    }
    
    @Override
    public String getType(final Uri uri) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Uri insert(final Uri uri, final ContentValues values) {
        if (uri.getPathSegments().size() != 1)
            throw new IllegalArgumentException(uri.toString());
        final String address = uri.getLastPathSegment();
        values.put(KEY_ADDRESS, address);
        long rowId =
          helper.getWritableDatabase().insertOrThrow(DATABASE_TABLE, null,
                                                     values);
        final Uri rowUri =
          contentUri(getContext().getPackageName()).buildUpon().appendPath(
                                                                  address).
          appendPath(Long.toString(rowId)).build();
        getContext().getContentResolver().notifyChange(rowUri, null);
        return rowUri;
    }
    
    @Override
    public int update(final Uri uri, final ContentValues values,
                      final String selection,
                      final String[] selectionArgs) {
        if (uri.getPathSegments().size() != 1)
            throw new IllegalArgumentException(uri.toString());
        final String address = uri.getLastPathSegment();
        final int count =
          helper.getWritableDatabase().update(DATABASE_TABLE, values,
                                              KEY_ADDRESS + "=?",
                                              new String[] { address });
        if (count > 0)
            getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
    
    @Override
    public int delete(final Uri uri, final String selection,
                      final String[] selectionArgs) {
        final List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() != 1)
            throw new IllegalArgumentException(uri.toString());
        final String address = uri.getLastPathSegment();
        final int count =
          helper.getWritableDatabase().delete(DATABASE_TABLE, KEY_ADDRESS +
                                              "=?", new String[] { address });
        if (count > 0)
            getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
    
    @Override
    public Cursor query(final Uri uri, final String[] projection,
                        final String originalSelection,
                        final String[] originalSelectionArgs,
                        final String sortOrder) {
        final SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(DATABASE_TABLE);
        final List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() > 1)
            throw new IllegalArgumentException(uri.toString());
        String selection = null;
        String[] selectionArgs = null;
        if (pathSegments.size() == 1) {
            final String address = uri.getLastPathSegment();
            qb.appendWhere(KEY_ADDRESS + "=");
            qb.appendWhereEscapeString(address);
        } else
            if (SELECTION_IN.equals(originalSelection)) {
                final String[] addresses =
                  originalSelectionArgs[0].trim().split(",");
                qb.appendWhere(KEY_ADDRESS + " IN (");
                appendAddresses(qb, addresses);
                qb.appendWhere(")");
            } else
                if (SELECTION_NOTIN.equals(originalSelection)) {
                    final String[] addresses =
                      originalSelectionArgs[0].trim().split(",");
                    qb.appendWhere(KEY_ADDRESS + " NOT IN (");
                    appendAddresses(qb, addresses);
                    qb.appendWhere(")");
                } else
                    if (SELECTION_QUERY.equals(originalSelection)) {
                        final String query = '%' +
                        originalSelectionArgs[0].trim() + '%';
                        selection = KEY_ADDRESS + " LIKE ? OR " + KEY_LABEL +
                                    " LIKE ?";
                        selectionArgs = (new String[] { query, query });
                    }
        final Cursor cursor =
          qb.query(helper.getReadableDatabase(), projection, selection,
                   selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }
    
    private static void appendAddresses(final SQLiteQueryBuilder qb,
                                        final String[] addresses) {
        for (final String address : addresses) {
            qb.appendWhereEscapeString(address.trim());
            if (!address.equals(addresses[addresses.length - 1]))
                qb.appendWhere(",");
        }
    }
    
    private static class Helper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "address_book";
        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_CREATE = "CREATE TABLE " +
        DATABASE_TABLE + " (" + KEY_ROWID +
        " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_ADDRESS +
        " TEXT NOT NULL, " + KEY_LABEL + " TEXT NULL);";
        
        public Helper(final Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        
        @Override
        public void onCreate(final SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }
        
        @Override
        public void onUpgrade(final SQLiteDatabase db,
                              final int oldVersion,
                              final int newVersion) {
            db.beginTransaction();
            try {
                for (int v = oldVersion; v < newVersion; v++) upgrade(db, v);
                db.setTransactionSuccessful();
            }
            finally {
                db.endTransaction();
            }
        }
        
        private void upgrade(final SQLiteDatabase db, final int oldVersion) {
            if (oldVersion == 1) {
                
            } else {
                throw new UnsupportedOperationException("old=" + oldVersion);
            }
        }
        
        public static final String jlc$CompilerVersion$jl7 = "2.7.0";
        public static final long jlc$SourceLastModified$jl7 = 1470349343000L;
        public static final String jlc$ClassType$jl7 =
          ("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" +
           "diwXWGCNQMZklFJKyDA9897sx7zqu2yIW+6HH9e2fvBx7gboM2rWb/ThzTJm" +
           "5TuhvAj9YauNuvEmABHchM07JDsKlwgbjnEGHbzuZNVHzROiqE7TpUlIFCDs" +
           "DZ62UpBKUrDsC/9Wa6+I1ba79qRoweZYJtYdG4pnB2L98VL4NHNPY4aJmGmh" +
           "iYWsvp1V3eYen6joWZu8et8C5Rz0H7DavFdvGxX5jgmI1DGit7z1jVPvHzry" +
           "ySAL9JpJdmTgDS7JBgosOX/g9PEVN8xc/DIHQgYBjGmqgtVYt5dVW1jVV8ZS" +
           "TDrZau/xWKrZttT2+OBQIjUwf5CkdSkPyD9pJaTRAy1v7jn59tNmsumPCB8x" +
           "OTrz4AeRYzNBV4q/Zk6W7V5jpvnc5RaYSn0AvwCUf7PCtGMDrAW/77FyzbCd" +
           "bGoaA6WO+cTiW/T+4cyBH3/7wBFTjRZvhhuHB9zTv/rXK5ETF8+XSZqq4PXi" +
           "86P0dfpRB5RX4AqbgPY8jH3dHz8TPYPxWCYehpNKxsPuYAqvy0piODGQiW+J" +
           "D4bTg4n+2OCO8Lb4jnBsOJNKDMDC/vhAZmNpUTgTvycTHkhBGU4mN4ZlPEpk" +
           "axAG1nexTcX/2c+Y9LNW+6DHz0K2n5m6sOFtPruReexWLC9T0JHJESdQSoLY" +
           "A+DPVnvRnR84lwJiHrKi0luNe8epwzOzYurJW4PWZQqPw1rrCe29XDZUjpt+" +
           "/k51EP7c4XfaM3eN776OvHaVT0g/y+/0nz6/Za3w1SCqsvF+zgvau6jLi/KN" +
           "OoEnv5LxYP0Kb24ZhXIBoRsXmW3bpbm5ZdmD4gC2rkwOx5i8Y7W/95+Rk834" +
           "MqG1pUxIxBSPYgMeLntliZLI0GeS0Gy2RrlE982TGB1mVZGielXp0QlgBqfi" +
           "ELnTFHYXRdWTsJPjpvu8btpku6ktXYsD56lJouvwZprHs+dmLXyg4DX8Tiiv" +
           "g+GfsNr0hzU8Y5Ky2kRlw1c5sX+QVffyiu/48DyGPc6qr1DUoCrD2piORe5S" +
           "X3CseKyiFdnwlz6MvRrZYBwK+FX7D6x2//XYq9dnrwaLybTVGpXtFXRw6aBj" +
           "qm/OY6onWPU1SH0KZQ118lq3iSffBWwyH+clX1z33z7qAcDa5nxZNL+GCc/M" +
           "huqXzQ7/mr9n7S9WDfASzBVk2Z0ouvq1mk5yElexwUwbNd6cpmhJOaFAdLPD" +
           "Rf+uSXwGkjkPMUWNzh835XMUBU3jfU+zlZ8fJlIaUUxrFQPeO8G2fsu1rO+6" +
           "RtZ48J9/zC1hdcH8nJsVzsxuHdh/5eNPmi9sQcbT04xLfRLVmY99G+87KnIr" +
           "8artW3914bMNN5UupoWmwI5zu2RbVf45G89rlD9Ap3+07PubvjX7Bk84/wMQ" +
           "Dos4ZRcAAA==");
    }
    
    
    public AddressBookProvider() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1470349343000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVaC2wcxRmeO78dJ3Yc8iCNkxA7ITHpHW+pNVBs5xLbHLZj" +
       "O6EYymW9O2dvsre72d2zL4HwKoioqiiCACkPQ0tSmjSQUMqjrUBpq/JQKloQ" +
       "LQUJ6EuClgYRVQ0tKaX/PzN7u7f3yAuopZ1/b3bm///vn3/++WfGew6SCtsi" +
       "Z5iGtmlUM5wIzTiR9dp5EWeTSe1IT/y8fsmyqdKpSbY9BHUJedG++sNHbhtr" +
       "CJPKYTJD0nXDkRzV0O0BahvaOFXipN6rjWk0ZTukIb5eGpeiaUfVonHVdtri" +
       "ZIqvq0Na4q4KUVAhCipEmQrRdq8VdJpK9XSqE3tIumNvJNeSUJxUmjKq55DT" +
       "cpmYkiWlBJt+hgA4VOPvtQCKdc5YZGEWO8ecB/jOM6Lb7r6q4YdlpH6Y1Kv6" +
       "IKojgxIOCBkmdSmaGqGW3a4oVBkm03VKlUFqqZKmbmZ6D5NGWx3VJSdt0ayR" +
       "sDJtUovJ9CxXJyM2Ky07hpWFl1Sppri/KpKaNApYZ3lYOcKVWA8Aa1VQzEpK" +
       "MnW7lG9QdcUhC4I9shhbLoEG0LUqRZ0xIyuqXJeggjTysdMkfTQ66FiqPgpN" +
       "K4w0SHHI3KJM0damJG+QRmnCIXOC7fr5J2hVwwyBXRwyM9iMcYJRmhsYJd/4" +
       "HOy94Nar9S49zHRWqKyh/tXQaX6g0wBNUovqMuUd61rjd0mzntkaJgQazww0" +
       "5m2euubQxcvn73+Bt/lCgTZ9I+up7CTkHSPTXp7XuexLZahGtWnYKg5+DnLm" +
       "/v3iS1vGhJk3K8sRP0bcj/sHnrv8+t30vTCp7SaVsqGlU+BH02UjZaoatVZR" +
       "nVqSQ5VuUkN1pZN97yZV8B5Xdcpr+5JJmzrdpFxjVZUG+w0mSgILNFEVvKt6" +
       "0nDfTckZY+8ZkxBSBQ+pg2cRAQ8SNOkQM7rGBnePjk1I69P6aJzS6Ao6TjUD" +
       "BhFmq2IZqjLopBXViHaojmyo+mWSplEnOsGJbclRhUZteUzVlBFJHnM/wASC" +
       "CWJ3GMaGfssYVxVqRdDzzP+DzAzaoWEiFIIhmhcMEBrMrS5Dg7YJeVu6I3bo" +
       "0cSBcHbCCAs6ZKlCI57ECJcYKSCRhEJM0CkomfsBjOIGiAcQKeuWDX6tZ93W" +
       "RWXggOZEOYwDNo0WD9idXgTpZnFSBjcm+7dP3LD2ujPDJJwbeVFbqKrF7v0Y" +
       "L7NxsSU44wrxrb/l3cN779pieHMvJ5SLkJDfE6f0oqBdLUOmCgRJj33rQumJ" +
       "xDNbWsKkHOIExEZHAl+GsDM/KCNnare5YRKxVADgpGGlJA0/ubGt1hmzjAmv" +
       "hg34NCwa+djjeAQUZBH2wkHz/t+/9NdzmCXdYFzvW94GqdPmCwDIrJ5N9ene" +
       "8A5ZlEK7N7f333HnwVuuYGMLLZoLCWzBshMmPowOWPDmFza+/vZbO14Ne/7g" +
       "wAqYHtFUOcOwTP8E/kLw/BcfnMVYgRRieaeIIAuzIcREyUs83SCYaBDQ0Dla" +
       "1ugpQ1GTqjSiUXTG/9QvPuuJv9/awIdbgxrXW5YfnYFXf2oHuf7AVR/OZ2xC" +
       "Mi5mnv28ZjxCzvA4t1uWtAn1yNzwStO3n5fuh1gL8c1WN1MWsgizB2EDGGW2" +
       "aGVlJPDtLCwW2H4fz51GvqQjId/26gdT137w7CGmbW7W4h/3SyWzjXsRHwXi" +
       "+2uG0Lndpfh1honlKRnQYXZw1ndJ9hgwO3d/75UN2v4jIHYYxMqwntt9FoSL" +
       "TI4ridYVVW/87Bez1r1cRsIrSa1mSMpKiU04UgOeTu0xiFcZ8ysXc30mqqFo" +
       "YPYgeRbiXjSH/aoGBZcVjzUrMTPxpuucj/q0kRv/9K88S7EoU2BBDvQfju65" +
       "b27nRe+x/t50x97zM/mBGLI4r+/Zu1P/DC+q/GWYVA2TBlmkiGslLY0zbRjS" +
       "ItvNGyGNzPmem+Lw9bwtG87mBUONT2ww0HgLALxja3yvDXjFLLTyhfC0gDe8" +
       "Jug+v1eEYErXSXyhSIzASoHVFzMGC1nZjMUSNkJlDqkyLXUcpjLEAZvlpg5o" +
       "peqSlsnKDKHMmULWXkHv9cl0yLQV7UPtHe2DsQSQeIx1nQmZO3M1tEyEJ388" +
       "OmJ5NhbtXMj5RV2rLasEymeetoSQiipOy98PAi9LqAr+6i2CF19Px2IlFqsC" +
       "GE8RbA8K+kYOxppLYpcnBvou616BFT0BKH3HCeVceE4HKBcI2hSEUiXGEGsu" +
       "O2E4yHqeoDU5cKYgnPYVKwZig4OFAH31OAGdCc9SkJISdCAIqEKTRihLr9ed" +
       "MBxkvFrQi/JHJ97eEYsXAiMdJ5iz4WkFGd8R9KYgmNBGfFdPGAgy/bqgZg6Q" +
       "+sFYPNY51N3Xm1i9JjZweSE4609gbM4ASa8I+lQQTlhluYZ1wniQ65OCPpSD" +
       "p87D091bCIx9nGDOh2c5IZU1nFa8m+dosHRwPFefMB5k/I6grxYbn96+ocKQ" +
       "rjl2SIiCzIYnBgvmNwW9NgcSYS83FcYSwtdYAEG14LNF0PEcBJVjVIO9jxuk" +
       "o8e61WjpYv0CWG8ugTVTQufTPZ3ZXyXhu0QqaMKnsy+pIJj2NBXb0LPDiB03" +
       "bptU+naexbfdjbmb5JieTj3yu49/Fdn+hxcL7LtqHMP8oobbQ5/MGhDZWjyR" +
       "uZQdfHjZxPM3/m3u0EVj645jv7QgACjIctele15ctUS+PUzKsrlF3pFMbqe2" +
       "3Iyi1qJO2tKHcvKKpuwQzEDTNhG2xFYuFXS+3w29Yc8bz7A3nwKOOE1wOlXQ" +
       "uuCgejl2yHONHibswRJJ+HexuMchtZjnUd1ZY6muO9dLfEsf0cGL3Xrmqfce" +
       "bVb6pbCKu3PzLnBLcg6geFzQhz8V+yCnBwS9vbh9wpyVC3O2C1NYICLOFD37" +
       "7S1hv8ex2AXB2eKnh3F3ae7xzLX7JMzFms2Bpwuiz2OC7jpGcwXDA7NUlWDy" +
       "oKD3FLeUH+izJb7tx+Jph1QbeqdFIQcuvV/pt9QU7MrHxQFgdEvj2xvue/cR" +
       "HmWCm5NAY7p12zc+idy6Lew7Um3OO9X09+HHqkzPqVgsxbh3WikprMfKd/Zu" +
       "+en3t9wSFhjvgEQSNgEalXRvZH+cO7J12ZENud7V6CXufePUsiD8l4jyR3WH" +
       "eiKmUB8E0wZBa07WHZBJiNPqI8cUWHYwOb8t4ROvYfFrMNooddxY6ZsTvylq" +
       "Oaw+cDI2wtNS0gjPGoC1UdANJ2sjZJIUdN1RgwuzkesDTQUjjNj22kybP5ew" +
       "5DtYvAnZhqrb1HI81syQb30OhhwlZMo+QXefrCGRyU5BHyhuyHLGpZyhxeIv" +
       "3IEssrh4YGEnUzxOTH6v+aXrJpv/yM5tqlV7rWS1W6MFrjB8fT7Y8/Z7r0xt" +
       "epSdc5aPSDZf4IN3P/lXOzk3NswodVncVyLuEY6XGRRxfxQ0Yk9wkvHkFosP" +
       "3bz130dbE1cxVkvBUzSqjzpjrOXPRcxD8hzs60F5fD1sZootiDO8kNWpGTrF" +
       "U0P3Gz8cV41I9m4NPmYKKn83V54J45pj8S2mTnFvD9WU+DYFi0rYl8ioF4dR" +
       "ovm0DJ9A/yjRpgErD4LJ0qYCCxf++tibXO9/DpNrgpCpPxB058lOLmTyoKAl" +
       "FvYyb/fGJhfbdh1mBplXwliYxoZmgbEUCjubgLFCsz87Y7FlD3eTW+H9SUEf" +
       "O1ljIZNdgj5U3FgVjEtF1liHPYuxN2aa1hJmW45FC7jtxjS1NuXlneB3Egab" +
       "SGfassWFMzPo4s/OoKzhFfD8BNKJxZzOfOMYDcoiTgyLYBZeLzi9LuiB4lYN" +
       "BJ3WPGvYGzXVoZHB1XEgq9FyHWkVr/s8X/1yCaPjoVboXNzFmCbVFbELF8eA" +
       "gaBYPg6SPbufdzz5egYCZoEtPt6ZzMn7nwZ+Dy8/OllfPXtyzWt8oXHvymvi" +
       "pDqZ1jT/6bXvvdK0aFJl41LDz7JNBrQLonKhgweYpvwFVQ6t4o0vccjUnMaw" +
       "8/N++Fv2OiSsoOxQn+kO0oIiiYwLOsMj/xy/z7E42ng0i/qOJJpz1nf23yPu" +
       "Xj7N/38kIe+d7Om9+tD5O/n1n6xJmzcjl2pYivklo1iK/Yl+kJvLq7Jr2ZFp" +
       "+2oWu4l+zvVjQLcFhe/XYinTYTdim5+e/aMLHp58i10L/g/MHra01iMAAA==");
}
