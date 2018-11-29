package gen2;
public class PairTester
{
   public static void main(String[] args)
   {
      Pair<Integer> pair1 = new Pair<Integer>(29, 17);
      Integer m1 = pair1.min();
      System.out.println(m1);
      System.out.println("Expected: 17");
      
      Pair<String> pair2 = new Pair<String>("Hello", "World");
      String m2 = pair2.min();
      System.out.println(m2);
      System.out.println("Expected: Hello");
   }
}