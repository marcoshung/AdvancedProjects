public class Food implements Comparable
{
    private String kind;
    private double price;
    
    public Food(String theKind, double thePrice)
    {
        this.kind = theKind;
        this.price = thePrice;
        
    }
    
    public String getKind()
    {
        return kind;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public int compareTo(Object otherObject){
    	Food object = (Food) (otherObject);
    	
    	if(Double.compare(this.price,object.getPrice()) == 0) {
    		return this.kind.compareTo(object.getKind());	
    	}else {
    		return Double.compare(this.price, object.getPrice());
    		}
    	}
         
    
    public String toString()
    {
       return this.getKind() + ": $" + this.getPrice();
    }
    

}