package edu.mit.icc_non_constant_class_object;

import edu.mit.icc_non_constant_class_object.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class InFlowActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = getIntent();
        String imei = i.getStringExtra("DroidBench");
        Log.i("DroidBench", imei);
    }
    
    public InFlowActivity() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513034000L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAANVXW2wUVRg+u72XwrYFCiKXAgXltiNXY4pIKS0tLrShQGJV" +
       "ltOZs90pszPDmbPtUqyCiYH4QIgWxET6BPESblGJJgZTYyIQjBFDQI2Cb+KF" +
       "BF7wARH/c2ZmZ2d6UR+dZM7MnHP++/9/558Tt1CBRdEC09B2dWoGi5IMi3Zp" +
       "y6Nsl0ms6PrY8lZMLaLUa9iyNsNcXJ51JnL33sFkeRgVtqPxWNcNhplq6NYm" +
       "YhlaN1FiKOLNNmgkZTFUHuvC3VhKM1WTYqrFamNoTA4pQzUxVwUJVJBABUmo" +
       "INV5u4BoLNHTqXpOgXVm7UQvolAMFZoyV4+hmX4mJqY45bBpFRYAh2L+vRWM" +
       "EsQZiqqztts2DzH40AKp/41t5e/noUg7iqh6G1dHBiUYCGlHZSmS6iDUqlMU" +
       "orSjCp0QpY1QFWtqr9C7HVVaaqeOWZqSrJP4ZNokVMj0PFcmc9toWmYGzZqX" +
       "UImmuF8FCQ13gq1Vnq22hY18HgwsVUExmsAycUnyd6i6wtCMIEXWxpqnYQOQ" +
       "FqUISxpZUfk6hglUacdOw3qn1MaoqnfC1gIjDVIYmjIiU+5rE8s7cCeJMzQ5" +
       "uK/VXoJdJcIRnIShicFtghNEaUogSjnxubVx5YHdepMeFjorRNa4/sVAND1A" +
       "tIkkCCW6TGzCsvmxw7jq3P4wQrB5YmCzveejF+6sXjh98IK95+Fh9rR0dBGZ" +
       "xeVjHeMuT62f90QeV6PYNCyVB99nuUj/VmelNmNC5VVlOfLFqLs4uOmLZ/a8" +
       "R34Lo9JmVCgbWjoFeVQhGylT1QhdR3RCMSNKMyohulIv1ptREbzHVJ3Ysy2J" +
       "hEVYM8rXxFShIb7BRQlgwV1UBO+qnjDcdxOzpHjPmAihIrhRGdwlcP/gPK8x" +
       "9IG0xYJ0l5I9uCutd8YIkdaSbqIZEESoVoUaqtLG0opqSGv5+xpweFJq5klZ" +
       "D+obOtEZvKTSuiqL+pDqZKZ2q2yXb/ZxCZumZFFZSmFVl0QKEiUtpVQmqbIc" +
       "1w09LjtAEBf1HzdEJEBUo2b0uEyjnNL8f6qd4dEo7wmFIFGmBmFKgwpvMjSF" +
       "0Ljcn17TcOdU/FI4W7ZOHBlaBtKjID06qvSoXzoKhYTQCVwLOzMhr3YAQgF2" +
       "l81re3799v2z8qAkzJ58yAq+VRr5CKn3MK1ZyJahsNDgkZ69W196LIzC/rOA" +
       "aw5TpZy8lSN4FqlrghgwHN/Ivpt3Tx/uMzw08B0uDkgNpeQgMyvoY2rI4D5K" +
       "PPbzq/HZ+Lm+mjDKB+QCXzIIMwfC6UEZPrCpdYGb21IABicMmsIaX3LRtpQl" +
       "qdHjzYjgj+NDpZ0HPB4BBQXmP9lmHv32q1+WCk+6x0Mk58BtI6w2B5I4s4gA" +
       "nwovvJspIbDvxyOtrx+6te9ZEVvYMXs4gTV85EUB0QEPvnJh53c3rh+7Evby" +
       "gcGZnO7QVDkjbKl4AFcI7r/4zXGFT/AnnC71DqZVZ0HN5JLneroBvGmQozw5" +
       "arboKUNREyru0AhPxj8jcxaf/f1AuR1uDWbcbFn4zwy8+YfWoD2Xtv0xXbAJ" +
       "yfx49fznbbMxe7zHuY5SvIvrkdn7zbQ3z+OjgP6AuJbaSwSIIuEPJAIoCV/M" +
       "F2M0sLaYDzOs3Bz3l1FOGxSXD165PXbr7U/vCG39fVRu3Ddgs9bOIjsKIGwR" +
       "cgYO5vfdJ18db/JxQgZ0mBSs+iZsJYHZssGNz5Vrg/dAbDuIlaHDsFooAFDG" +
       "l0rO7oKi7z/7vGr75TwUbkSlmoGVRiwKDpVAphMrCdiVMZ9ajcTVUwxDufAH" +
       "GuIhO4smO1/io1qMs/kw1845/vpIJmupuAodC686z69zLPXzpGjaSB2G6I6O" +
       "vdw/oLQcX2z3AZX+U7sBmtKTV+9/GT3y08VhILiEGeYijR82OTI5Zs4fGTM3" +
       "iE7Mw53zL/86ZfOq5Pb/AJczAgYFWb674cTFdXPl18IoL4uUQ3pEP1Ftrmkg" +
       "lBJoanXuJD5TKpJtWjYEY7hrl9pdRGiV86zKTTYb14aPJ/jNpAaDwiOKF9YQ" +
       "51nq8JroPMuCYfWKLOQ4m39PZKgC2yd91LCia9K6ohGhw8ZRSnMTH9YxVGzo" +
       "9ZQAPkHg5o3yv0RVOG3VbqfHlPoqb+x46+ZJO2+CDWlgM9nf/+qD6IH+cE7X" +
       "PntI45xLY3fuQs+xfHiUZ/LM0aQIisafT/d98k7fvrBj42qG8rvBLcIBS/jQ" +
       "ZLt8hVOfZdn6zLqyUlQ8/yuItnQTSlWF+Eh8JT1cUTM0zt91cGydPORvzP6D" +
       "kE8NRIonDWy5Jg7ebJdfAudaIq1pOUmZm6CFJiUJVZhYYiOhKR4A8HP+VV/E" +
       "0LRR14VVHTbTBIMG3GbKUB6MuYsqTMEif+0yXRdOcLMResao64VMaCjaLbHb" +
       "gJH9GwSz2b4EFT/CLgqk7V/huHx6YP3G3XdWHLf7BrCqt1f8OMF/oN2dZJFk" +
       "5ojcXF6FTfPujTtTMsdNKF/fEtBtxvAHc0PKZOIo7f140ocr3x64LvqJvwHe" +
       "NivPoRAAAA==");
}
