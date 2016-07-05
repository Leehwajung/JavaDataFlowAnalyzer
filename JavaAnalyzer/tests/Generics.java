
import java.util.*;

public class Generics {
   public static void main(String[] args) {
      ArrayList<String> al = new ArrayList<String>();

      al.add("Hello");
      al.add("World");

      for(String s : al) {
         System.out.println( s );
      }
   }
}

