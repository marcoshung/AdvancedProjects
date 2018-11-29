package gen3;
public class GenericUtil
{
   /**
      Finds first match.
      @param value an array of values
      @param pred a predicate
      @return the first value for which pred is true
   */
   public static <T> T findFirstMatch(T[] values, Predicate<T> pred)
   {
      for (T value : values )
         if (pred.invoke(value))
            return value;
      return null;
   }
}