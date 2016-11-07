package de.ecspride;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.telephony.TelephonyManager;

public class ContentProvider extends android.content.ContentProvider {
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }
    
    @Override
    public String getType(Uri uri) {
        return null;
    }
    
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }
    
    @Override
    public boolean onCreate() {
        TelephonyManager tm =
          (TelephonyManager)
            getContext().getSystemService(Context.TELEPHONY_SERVICE);
        ApplicationLifecyle3.imei = tm.getDeviceId();
        return false;
    }
    
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        return null;
    }
    
    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        return 0;
    }
    
    public ContentProvider() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAM1YfWwUxxWfO58/MfiDL9cBG7ChhZDbkjSRKtMUOL5MD/uE" +
       "DVGdNGa9O2cv3ttddufsA+pAkCKjSKFR4yRUAv/RQj8QgbRK2kpVUldtIVFS" +
       "JFDUL6mh7T9NS5Hgj6ZVaZu+N7Mfd3u+ays3VU+6md3ZmTdvfu/N772ZC7dI" +
       "pWOTey1TPzSsmyxOcyx+QH8wzg5Z1InvSj6Ykm2Hqglddpx+aBtUVr3c8P7d" +
       "Z0cao6RqgCyUDcNkMtNMw9lDHVMfo2qSNASt23SacRhpTB6Qx2QpyzRdSmoO" +
       "60qSeXlDGelMeipIoIIEKkhcBWlz0AsGzadGNpPAEbLBnIPkCRJJkipLQfUY" +
       "WVkoxJJtOeOKSfEVgIQafN8Hi+KDczZZ4a9drLlowc/fK029+HjjtypIwwBp" +
       "0Iw+VEcBJRhMMkDqMzQzRG1ns6pSdYA0GZSqfdTWZF07zPUeIM2ONmzILGtT" +
       "HyRszFrU5nMGyNUruDY7qzDT9peX1qiuem+VaV0ehrUuCdYqVrgd22GBdRoo" +
       "ZqdlhXpDYqOaoTLSHh7hr7HzM9ABhlZnKBsx/alihgwNpFnYTpeNYamP2Zox" +
       "DF0rzSzMwkhrSaGItSUro/IwHWSkJdwvJT5Br1oOBA5hZHG4G5cEVmoNWSnP" +
       "Prd6Np48Yuw0olxnlSo66l8Dg9pCg/bQNLWpoVAxsH5d8gV5yWsnooRA58Wh" +
       "zqLPdz5/Z9P6tpk3RJ97ZunTO3SAKmxQOTu04NqyxNpPVqAaNZbpaGj8gpVz" +
       "90+5X7pyFuy8Jb5E/Bj3Ps7sufzZY+fpzSip6yZViqlnM+BHTYqZsTSd2juo" +
       "QW2ZUbWb1FJDTfDv3aQanpOaQUVrbzrtUNZNYjpvqjL5O0CUBhEIUTU8a0ba" +
       "9J4tmY3w55xFCKmGP6mHfy3833brK4w8Le11wN2lkXH5QNYYTlIqbaVjVDfB" +
       "iNIjpj3qgNWptAt9ZqttauoWQHxEArNolkPvs2wT8QIWSFPlkKJTabNl6ZrC" +
       "t4rf+IDk2IqkUhjmWLYGD3y/GSxlm2PwasfRJ63/K21yiF3jeCQCZl0WJhUd" +
       "tNhp6tB3UJnKbtl25+LgW1F/k7moM3KPSuPeJPHQJCQS4bIX4WTCXcDYo0Ab" +
       "QKj1a/s+t2v/iVUV4KfWeAxMhV2l0ryeCIimm9OpAt5OZk6NP7nv6MejJFpI" +
       "0KggNNXh8BTSqk+fneGNOZvchsn33r/0woQZbNECxneZo3gk7vxVYShtU6Eq" +
       "cGkgft0K+dXB1yY6oyQGdAIUymRweWCntvAcBQzQ5bEprqUSFpw27Yys4yeP" +
       "AuvYiG2OBy3cxguwaBbmRnuEFORE/Kk+68zPr/7+AY6kx9kNeVGwj7KuPJ5A" +
       "YQ2cEZoC8/bblEK/X51KPff8rclHuW2hR8dsE3ZimQB+AOsAgk+9cfAXN949" +
       "+0408AcGgTI7BM6d42tp+gB+Efj/A/+42bEBa6D8hEs0K3ymsXDmNYFuwDk6" +
       "7Bx0js69RsZUtbQmD+kUnfFvDas3vPrHk43C3Dq0eN6y/l8LCNo/soUce+vx" +
       "P7dxMREFY16AX9BNEOnCQPJm25YPoR65J68v/9IV+QxQMtCgox2mnNkIx4Nw" +
       "A0oci3W8jIe+bcCi3cn38cJtlJebDCrPvnN7/r7br9/h2hYmN/l23y1bXcKL" +
       "hBVgsm3ELYBhI5VejV8XWlguyoEOS8O7fqfsjICwT8z0PNaoz9yFaQdgWgXC" +
       "vtNrA13kClzJ7V1Z/csf/HDJ/msVJLqd1OmmrG6X+YYjteDp1BkBispZn95E" +
       "+G+8BopGjgcpQkh4UYv7xl9W8LIDizXC5/Dxozl/pfxX5caSy249k7fSQpk2" +
       "WV4q7POU5ezxqWm199wGEZybC0PpNsgUX/rp39+On/r1m7MwbS0zrft0DBV5" +
       "c1bBlOtKc+Zunh4FvHPl+B9a+x8e2f8f0GV7aEFhkd/YfeHNHWuUL0ZJhc+U" +
       "RYlb4aCu/KXBpDaFTNNAkLCljjvbct8EGNFJs3iIrHbr9nxnE7z2b9kzQtxE" +
       "AYW0uvWisD2D3VXBpVTw98UMzwkqxuS4QVl8r6157Y3cbzHhjIuEE8yyurRZ" +
       "+H4X6dr0VzuuHp3u+A3fDTWaA4n+Znt4lvwxb8ztCzduXp+//CKPHrEh2RG4" +
       "hRPv4ry6IF3msNVbvEr5C474oXhtaf234zSBC7T8tVcfOv7bvxQRCfeqWdLa" +
       "0PgB6cLp1sTDN/n4IBri6LZccWoCEAVj7z+f+VN0VdWPo6R6gDQq7kFrn6xn" +
       "MRANAAiOd/qCw1jB98KDgsiKu3wfXhb24bxpw3E435tjrMCPF1i5COGu9ejs" +
       "HhrlHspAoGbIOh/zMQh8OjWG2Uh5M6RsLQOxeMw9HUgTzTdGT7/3kiCXMOah" +
       "zvTE1NMfxE9ORfPOWx1FR578MeLMxRWcz7VEultZbhY+YvvvLk187+sTk1E3" +
       "Rm1ipAIcEx/7rZzvd1EBhrehFgYbKqGbBsU4630T6aRmxv1DK3zMFXkwvm8V" +
       "7t0voMdiI1e9TAy1ynzjLpkBWymok1hCme7ZnKh3l+kzjsUOMLhKdcq4TIV3" +
       "vB+LnWJZD7nxrd6PbxEPjOYAqN4xamMaXjCkICTOEhQFTD4/NmDjEkG4kW+6" +
       "9fm5ki0K+bJbny5NtpFASg+f56kywE1icZSR6mHKvNCRCpA7VhI5bD4yF4z8" +
       "gNQCDuvV9XPFCIV4daQ0RtGANHo8H1juRSVFnL+8cxhnOYdr81wZJF/E4hlw" +
       "Qc2AkykLRHMgT354QPKOsF7SBiv6gltPzhVIFPKEW+dKA5mPwFfKfDuHxRlG" +
       "akwjYVM4WPBe+10GxAqYs3rINHUqGwFs0x8ebHyPLoI/JEMVj7n1I3OFDYX0" +
       "unV3adgquRSe6/dwAuT7Lnjic79SBs9vY3EROPRgltqHPBde6rmwKjMZM5p4" +
       "Ims77pUiB/TS/2BDryck1uTW8+YKKAqpcmtSGtAYlxLzAZ0KAOXT/qgMlpex" +
       "eB12btYC3MLB4/v/RcRykPuGbnfwDNtSdBUtrk+Vi9MNNUun9/5MpKjeFWdt" +
       "ktSks7qeny7lPVdZNk1rfGW1XvKE1VVG5uVdM8Fe9B65nj8Rva4xElW5qOuW" +
       "51btJZjRW0MuUnwm5Ng150rDEz7ydRRkaPwO3zsrZcUt/qByaXpXz5E7D50T" +
       "tyuKLh8+jFJqICcXdzj+eWtlSWmerKqda+8ueLl2tZdRFdzuhHRrn/36YlvG" +
       "YvzC4fB3l76y8WvT7/Jbl38CAJZ7bVwZAAA=");
}
