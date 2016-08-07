package com.example.memocpcontracttest;

import android.net.Uri;

public class MemoContract {
    public static String AUTHORITY = "com.example.memocptest";
    public static String MEMO_ID = "_id";
    public static String MEMO_TITLE = "title";
    public static String MEMO_CONTENT = "content";
    public static String MEMO_DATE = "date";
    public static Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY +
                                                "/memos");
    public static Uri CONTENT_TITLE_URI = Uri.parse("content://" + AUTHORITY +
                                                      "/memos/" + MEMO_TITLE);
    
    public MemoContract() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1470576009000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "RJ5x8j4n+mF9EKtRh/+da5rOSBDYPigpKD932+9GALvvRsCwOhwBCpm96raX" +
       "AqCSE2MThUruMH7eGxI/v07xh6F0QfnQbf8QIX5xI+Ijs3fc9pcB8buE+KVc" +
       "KT8WhaC0TgQSlE2w8afdtjMCwf0bQYDMkk5LPgog6BYIsoXJ0thkKQrDA+vE" +
       "MEREVhoruu1dERjkjWBAZl9w2+GgZwgMh0dLkUpQ1gngoNOJveTsG5uLAHBy" +
       "IwCQWdVtjwcAbHLPvzIznWs6N7zRRaqc0RnPzFhqCJW2TlRIBh/xfocs9noE" +
       "qvpGUCGzK257OYCqt4lK+Adiw4lTISALNwDSiBYoJgTyZBG/hFsm3XbcJ4vv" +
       "ViR4b9+y1mNVPLQvPnF+WSlcOuA8KfuCD8AxvV576Tf//kXmwp9/FvF2SHHD" +
       "/IyGz53AnuhnvlcD5kb9q/7WcJ7i8svL6c7tyzO/FYlz67mcgry0Wtc0/y3l" +
       "6ydMi1VVcVulnDvLFM1ZyLdv/JyBG3T1oBD+jMPiSbBPHwuI2W7PT3SOkzYg" +
       "wu43zIj7ybmZG7GgJlpG0Pdx1uxT3t5ATiP+Q3KPcKLu/ItUkV9ZPjr58LU7" +
       "LzmZvqzRpSXk0pknSec90Xoq3bomtyavxPjQ9c2XU7fF3Qw08NIIybYrOpUe" +
       "q5lcJL9LP9j+vbu/s/yueAH8D9kGkh7cEwAA");
}
