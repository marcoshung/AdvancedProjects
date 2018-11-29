package gen3;
public class GenericUtilTester
{
   public static void main(String[] args)
   {
      Predicate<Integer> isEven = new Predicate<Integer>()
         {
            public boolean invoke(Integer value)
            {
               return value % 2 == 0;
            }
         };
         
      Integer[] values1 = { 3, 5, 7, 9, 4, 6, 8 };
      Integer first1 = GenericUtil.findFirstMatch(values1, isEven);
      System.out.println(first1);
      System.out.println("Expected: 4"); 

      Predicate<String> isLong = new Predicate<String>()
         {
            public boolean invoke(String value)
            {
               return value.length() > 6;
            }
         };
         
      String[] values2 = { "Mary", "had", "a", "little", "lamb" };
      String first2 = GenericUtil.findFirstMatch(values2, isLong);
      System.out.println(first2);
      System.out.println("Expected: null");       
   }
}
