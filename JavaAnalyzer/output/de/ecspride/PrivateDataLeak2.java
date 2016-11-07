package de.ecspride;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

/**
 * @testcase_name PrivateDataLeak2
 * @version 0.1
 * @author Secure Software Engineering Group (SSE), European Center for Security
 and Privacy by Design (EC SPRIDE) 
 * @author_mail siegfried.rasthofer@cased.de
 * 
 * @description A value from a password field is written to the log
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges the analysis has to treat the value of password fields as source
 */
public class PrivateDataLeak2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_data_leak2);
        EditText mEdit = (EditText) findViewById(R.id.pwField);
        Log.v("Password", mEdit.getText().toString());
    }
    
    public PrivateDataLeak2() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAM1Xa2wUVRS+u32Xlm0LLYjQAi0oBXYEhGiKSlsobV3ahgLG" +
       "opTbmbvdobMzw5277bZYBRIDMYYQLYiJ9IeB+AivGIkmBlNjIhCMCYb4SgT/" +
       "iQ8S+gd/oOK5d2Z2dqctxn9OMndm7j3n3PP87plTt1CORdFS09AGezWDhUmS" +
       "hXdpq8Ns0CRWuDWyugNTiyiNGrasLTDXLS88F7pz93CsJIhyu9AMrOsGw0w1" +
       "dGszsQytnygRFPJmN2gkbjFUEtmF+7GUYKomRVSL1UXQtDRWhmoirgoSqCCB" +
       "CpJQQar3qICpmOiJeCPnwDqzdqMXUSCCck2Zq8fQgkwhJqY47ojpEBaAhHz+" +
       "vQ2MEsxJiuanbLdtnmDwkaXSyBs7Sj7IQqEuFFL1Tq6ODEow2KQLFcVJvIdQ" +
       "q15RiNKFSnVClE5CVaypQ0LvLlRmqb06ZglKUk7ikwmTULGn57kimdtGEzIz" +
       "aMq8qEo0xf3KiWq4F2yt8Gy1LWzi82BgoQqK0SiWicuS3afqCkNVfo6UjTVP" +
       "AwGw5sUJixmprbJ1DBOozI6dhvVeqZNRVe8F0hwjAbswNGdKodzXJpb7cC/p" +
       "Zmi2n67DXgKqAuEIzsJQuZ9MSIIozfFFKS0+t9rWHtqjN+tBobNCZI3rnw9M" +
       "lT6mzSRKKNFlYjMW1UaO4ooLB4MIAXG5j9im+eiF8XXLKscu2TQPTkLT3rOL" +
       "yKxbPtEz/ercxiWPZ3E18k3DUnnwMywX6d/hrNQlTai8ipREvhh2F8c2f/Hs" +
       "3vfJb0FU2IJyZUNLxCGPSmUjbqoaoRuJTihmRGlBBURXGsV6C8qD94iqE3u2" +
       "PRq1CGtB2ZqYyjXEN7goCiK4i/LgXdWjhvtuYhYT70kTIZQHNyqCuwyh4GPO" +
       "cxVDr0pbLUh3KTaAdyX03ggh0nrSTzQDgig9Y9A+C6JOpFaeM+upoSoN4PGY" +
       "BGFRTYssN6nB/QV1rfDFTpPIalSVpQ6q9oNF6zHDEYL7VkoWlSWFAJ9lUhVe" +
       "/ARhnpXm/0yfJPdfyUAgAKGd6wcWDfRoNjSF0G55JNGwYfxM95VgqtAczzM0" +
       "VyFhd5ewfxcUCAjhM/luds5AxPsAOwBVi5Z0Pt+68+DCLEhWcyAbYsZJpanB" +
       "vdFDmxaBqTKkPBo7NrBv20uPBFEwE6W5hjBVyNk7OLamMLTGX52TyQ0duHnn" +
       "7NFhw6vTDNh34GMiJy//hX5fUkMmCgCqJ752Pj7ffWG4JoiyAVMARxmGvAeI" +
       "qvTvkQEDdS6kcltywOCoQeNY40suDhayGDUGvBkR5Ol8KLPjzePhU1Cg8ROd" +
       "5vHvvvpllfCkC9yhtKOwk7C6NLDgwkICFkq98G6hhADdj8c6Xj9y68B2EVug" +
       "qJ5swxo+NgJIQHTAgy9f2v39jesnrgW9fGBwWiZ6NFVOCltK78EVgPtvfvOK" +
       "5xP8Cbjf6KDN/BTcmHznxZ5uADwaFA9PjpqtetxQoHRwj0Z4Mv4ZWrTi/O+H" +
       "SuxwazDjZsuyfxfgzT/QgPZe2fFHpRATkPnB5/nPI7PRdIYnuZ5SPMj1SO77" +
       "et6bF/FxwGXAQksdIgLekPAHEgGUhC9qxRj2ra3gQ5WVnuOZZZTWoHTLh6/d" +
       "Lt52+9NxoW1mh5Me903YrLOzyI4CbCYhZ+Awu9198tUZJh9nJkGHWf6qb8ZW" +
       "DIQ9Otb2XIk2dhe27YJtZTj7rXYKQJPMSCWHOifvh88+r9h5NQsFm1ChZmCl" +
       "CYuCQwWQ6cSKAUYlzafWIXEN5MNQIvyBJnjIzqLZzpf4mC/Gaj4stnOOvz6U" +
       "TFkqrlzHwpXOc1mapZkyKZo31dkv+pYT+0dGlfaTK+wTuizzPN0A7eLpb/76" +
       "Mnzsp8uTQG0BM8zlGj8t0vbkmFk7NWZuEj2ShzsX9/86Z8uTsZ3/AS6rfAb5" +
       "Rb636dTljYvl14IoK4WUE7q3TKa6dNNgU0qg3dS5k/hMoUi2eakQTOeuXQN3" +
       "Obj+bec5lJ5sNq5NHk/wG5yaDAqPKF5YRbiKHVmDztP0h9UrsoDjbP5dzlAp" +
       "tg/gsGGFGxK6ohGhQ9t9SnMzHzYylG/ojZQAPkHgltznT4aqcYDZfqf7k4bL" +
       "bvS9dfO0nTf+VtFHTA6OvHIvfGgkmNZPV09oadN57J5a6FnMh4d5Ji+43y6C" +
       "o+nns8OfvDt8IOjYuI6h7H5wi3DASj402y5f49RnUao+U64sExXP+/Vwez+h" +
       "vI/IYMko6cmKGv7X/H0HR9fZE/6U7O5ePjMayp81uvVbcfSmOvACONmiCU1L" +
       "S8v0FM01KYmqwsgCGwtN8QCIn5bWAUF43VehaI9NFWUoqAhRvaZr90w3hbBp" +
       "huvhWOhX2WAyMBGiVtpn99RO8SNQdUZWif9Kt3QT9p9lt3x2tLVtz/iak/Zh" +
       "D3+kQ6Kg8uG3ym4pUuW/YEpprqzc5iV3p58rWORmQUaz4dOtavLTdEPcZOL8" +
       "G/p41odr3xm9LpqAfwDNgTIb8A8AAA==");
}
