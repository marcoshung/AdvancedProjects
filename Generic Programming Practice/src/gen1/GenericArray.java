package gen1;
public class GenericArray
{
   /**
      @param array is a generic array
      @param value all array elements are set to this value
   */
   public static <T> void setAll(T[] array, T value)
   {
      for (int i = 0; i < array.length; i++)
         array[i] = value;
   }
}