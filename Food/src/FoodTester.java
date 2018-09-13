import java.util.ArrayList;
import java.util.Collections;
/**
 * Write a description of class FoodTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FoodTester 
{
    public static void main(String[] args)
    {
        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food("pizza",5));
        foods.add(new Food("pizza",6.5));
        foods.add(new Food("chicken",8));
        foods.add(new Food("burger",8));
        foods.add(new Food("soup",3.45));
        foods.add(new Food("fries",2.75));
        foods.add(new Food("steak",9));
        
        Collections.sort(foods);
        System.out.println(foods.toString());
        System.out.println("Expected: [" + "fries: $2.75, " + "soup: $3.45, " + 
        "pizza: $5.0, " + "pizza: $6.5, " + "burger: $8.0, " + 
        "chicken: $8.0, " + "steak: $9.0]");
        
          
     
    }
}