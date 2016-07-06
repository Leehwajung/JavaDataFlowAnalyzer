import java.util.*;

public class Generics {
    
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("Hello");
        al.add("World");
        for (String s : al) { System.out.println(s); }
    }
    
    public Generics() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1443886510000L;
    public static final String jlc$ClassType$jl7 =
      ("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");
}
