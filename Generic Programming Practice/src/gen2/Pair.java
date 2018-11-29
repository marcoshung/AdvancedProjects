package  gen2;
public class Pair<T extends Comparable<T>> 
{
   private T e1;
   private T e2;

   /**
      Constructs a Pair.
      @param e1 is the first member
      @param e2 is the second member
   */
   public Pair(T e1, T e2){
      this.e1 = e1;
      this.e2 = e2;
   }

   public T  min(){  
      if(this.e1.compareTo(e2) > 0) {
    	  return e2;
      }
      return e1;
   }
}