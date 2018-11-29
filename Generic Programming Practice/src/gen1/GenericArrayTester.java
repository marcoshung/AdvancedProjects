package gen1;

import java.util.Arrays;

public class GenericArrayTester
{
   public static void main(String[] args)
   {
      String[] a1 = new String[3];
      GenericArray.setAll(a1, "Hello");
      System.out.println(Arrays.toString(a1));
      System.out.println("Expected: [Hello, Hello, Hello]");
      Integer[] a2 = new Integer[5];
      GenericArray.setAll(a2, 42);
      System.out.println(Arrays.toString(a2));
      System.out.println("Expected: [42, 42, 42, 42, 42]");      
   }
}