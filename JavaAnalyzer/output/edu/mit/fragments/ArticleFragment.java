package edu.mit.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ArticleFragment extends Fragment {
    static final String ARG_POSITION = "position";
    int mCurrentPosition = -1;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }
        return inflater.inflate(R.layout.article_view, container, false);
    }
    
    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if (args != null) {
            updateArticleView(args.getInt(ARG_POSITION), "");
        } else
            if (mCurrentPosition != -1) {
                updateArticleView(mCurrentPosition, "");
            }
    }
    
    public void updateArticleView(int position, String value) {
        TextView article = (TextView) getActivity().findViewById(R.id.article);
        article.setText(Ipsum.Articles[position]);
        mCurrentPosition = position;
        Log.i("DroidBench", value);
    }
    
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }
    
    public ArticleFragment() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478515351000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAM1YbWwcRxmeu/N3nfgrcRIncZzEDSQttyS0lZCTEvsSJxcu" +
       "tmU7Lhw0l/HunG+Tvd3t7qx9dmtIIrWJghSV4qZBavyHRECVNBG0AoRaGSFo" +
       "qyKkogoKEi3iD4U2UoNEqQhQ3pn93vPZQuEHJ+3M3sy83+88885evYmqTQPd" +
       "o2vK9ISi0SQp0eRx5f4kndaJmTyUuX8IGyaRUgo2zVEYy4lbbjR9ePvJQnMc" +
       "1WRRG1ZVjWIqa6o5TExNmSRSBjX5o/sVUjQpas4cx5NYsKisCBnZpD0ZdFeA" +
       "lKLujKuCACoIoILAVRB6/VVAtIKoVjHFKLBKzUfQV1Asg2p0kalH0eYwEx0b" +
       "uOiwGeIWAIc69n8MjOLEJQN1ebbbNpcZ/PQ9wtwzR5u/l0BNWdQkqyNMHRGU" +
       "oCAkixqLpDhODLNXkoiURS0qIdIIMWSsyDNc7yxqNeUJFVPLIJ6T2KClE4PL" +
       "9D3XKDLbDEukmuGZl5eJIrn/qvMKngBb231bbQv72TgY2CCDYkYei8QlqToh" +
       "qxJFm6IUno3dn4cFQFpbJLSgeaKqVAwDqNWOnYLVCWGEGrI6AUurNQukUNRR" +
       "kSnztY7FE3iC5ChaG103ZE/BqnruCEZC0eroMs4JotQRiVIgPjcHdp9/VD2o" +
       "xrnOEhEVpn8dEHVGiIZJnhhEFYlN2LgjcwG3v3Q2jhAsXh1ZbK/5wWO39t7b" +
       "ufCqvWb9ImsGx48TkebEy+Mr39iQ2v7ZBFOjTtdMmQU/ZDlP/yFnpqekw85r" +
       "9ziyyaQ7uTD88y+efI68F0cNaVQjaopVhDxqEbWiLivEOEBUYmBKpDSqJ6qU" +
       "4vNpVAvvGVkl9uhgPm8SmkZVCh+q0fh/cFEeWDAX1cK7rOY1913HtMDfSzpC" +
       "qBYe1AjPeoQSotMfpeiccMSEdBcKU/i4pU5kCBH2kUmiaBBE2K2SocnSCLUk" +
       "WRP2sfc+cHgBNn2eiNOiQoR+A08UiUq9kV0C1nXBNEShiGVV4MlGJEsoylTI" +
       "O4sBBwzYdApxqZNsmf5/pU2J+a55KhaDsG6IgooC+/GgpkjEyIlzVt/+W8/n" +
       "Xo97m8zxOiAYiEqCqKQnKhkRhWIxLmEVE2knDYT8BIAHwGrj9pGHDx07uyUB" +
       "2apPVUHQ2FKhMrqnfLhJc1AVIefRwsWpU2Nf/XQcxcMwzdSEoQZGPsTA1QPR" +
       "7uj2XIxv05l3P7x+YVbzN2oI9x38KKdk+39L1KGGJoKvDOKz39GFX8y9NNsd" +
       "R1UAKgCkFALIMKozKiOEAz0upjJbqsHgvGYUscKmXCBsoAVDm/JHeKRXsqbV" +
       "DjqLR0RBDsd7RvRLb/3yz5/hnnSRuylwFo4Q2hNAC8asieNCix/eUYMQWPf7" +
       "i0PfePrmmS/x2MKKrYsJ7GZtClACogMefPzVR377ztuX34z7+UDhuLTGFVks" +
       "cVtaPoZfDJ5/s4dteTbAegD+lAM3XR7e6EzyNl83QB4F0I8lR/cRtahJcl7G" +
       "4wphyfjPprt3vvj++WY73AqMuNly7/IM/PF1fejk60f/3snZxER28vn+85fZ" +
       "cNrmc+41DDzN9Cid+tXGb76CLwEwAxia8gzh+Ia4PxAPoMB9sYO3ycjcTtZs" +
       "MoM5Ht5GgQolJz755gcrxj54+RbXNlziBON+GOs9dhbZUQBhXG7SwdnH3Z7N" +
       "tumsXVUCHdZEd/1BbBaA2X0LA19uVhZug9gsiBXh8DcHDUCbUiiVnNXVtb/7" +
       "yU/bj72RQPF+1KBoWOrHfMOhesh0YhYAqEr65/Yi/puqg6aZ+wOVecjOorX8" +
       "XxwU3F4Za/pZGeNv17X/GFTGT//xozJPcZRZ5PSO0GeFq892pB58j9P7251R" +
       "d5bKERhKPp9213PFv8W31PwsjmqzqFl06skxrFhsp2WhhjLdIhNqztB8uB6y" +
       "D/8eD842RKEmIDYKND7ywztbzd4bIlnBHrQLng2QDT9y+ovBrIjBlg4ByF5O" +
       "3MXbrazZZkcHdr7JS1cKesgqVkqeFB7LZof7M07/tYAUihp7hw/khgZH0qPp" +
       "wQFOuBrKep5azBNJuzK00ZC1u1jTa4t4oGIq9YRV6IRnI4h+y+lfDhmK+Mvh" +
       "xc1DEWuqXBaLsALFiynLgCOAugXX0qk7ZMhwKMuTTuEozLa+c+LZd6/ZRWE0" +
       "TyOLydm5cx8nz8/FA6X41rJqOEhjl+M8EVaw5pNs529eSgqn6P/T9dkff2f2" +
       "jK1Va7iw3A/3pmu//tcvkhf/8NoidUcCLg2R2A0sEbvS4jGIsddP+IHgvxoH" +
       "yh52+ocCgQiAB2JGbqxU5XMDL5+em5cGr+yMO8j8BQp4pemfUljBF2BVBZx2" +
       "VA7mYX7J8cHgldN/6Rh9sHDsvyh3NkX0jLL87uGrrx3YJj4VRwkPGsquX2Gi" +
       "njAgNBgE7ovqaAgWNnqe5XGATYq6wNwqu098FNwtfjSXDRN3f4PD5K9O/340" +
       "TP7pmOBcEi4IrMd2mZ2clMlUMoOn4WqYVgHp4ILormkPrRmD5oChWbo73eJO" +
       "a2ayz1IlhXD91SWO5UnWFACXNDVlEJDFmJbx88T5eS2H87rRy+uYS93qo9rg" +
       "JDEMWSJLbIXyM5EPEM+9d7HBdfAIsBmGnX7fncaKMUk5/Z7KsQq67Ikl5s6y" +
       "5iRFtRr7vmHY31ZGHPRh3UMUVU2CS31HnqroSDb82B27bA88QF2fcfqOCi5j" +
       "zdFyBzGSdU7fVtlBcftwZH/HWJPmrC8s4Sp++n4dkszSJcg7537GkoxNnPMd" +
       "9NRyp99yHrgPnjRYozh96k6ThjHpc/rdlX0S87mYXM63lnDHFdZcoqgNMgdP" +
       "evcx9pWMRBwy/z/MmBIU1JGrMbsArC37mmd/gRKfn2+qWzN/5Df8duh9JYLk" +
       "qstbihIsxQLvNbpB8jI3s94uzHTeXYPol93U4TTy3rm6V+3FN2BXOYvhoIU2" +
       "OPl9GIJJ9vqCB4erXPjCup50rSvFwqel59XW5dIscMBuDR2L/AOpe4RZ9ifS" +
       "nHh9/tDAo7ceuGJfWkUFz8wwLnUZVGtfjb1jcHNFbi6vmoPbb6+8UX+3e2SH" +
       "Ls0R3TYtfivcX9Qpv8fN/HDNC7u/Pf82v8z+B76BDHy5FgAA");
}
