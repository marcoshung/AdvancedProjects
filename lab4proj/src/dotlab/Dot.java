package dotlab;
import java.util.*;

public class Dot {
	
	private static String[] LEGAL_COLOR_NAMES = {"RED", "YELLOW", "BLUE", "CYAN", "GREEN", "MAGENTA", "ORANGE", "BLACK"};
	private String color = "";
	private int x;
	private int y;
	private int radius;
	
	public Dot(String color, int x, int y, int radius) {
		HashSet<String> colors = new HashSet(Arrays.asList(LEGAL_COLOR_NAMES));
		if(colors.contains(color.toUpperCase())) {
			this.color = color;
		}else{
			throw new IllegalArgumentException(color + " is a bad color name");
		}
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public String getColorName() {
		return this.color;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getRadius() {
		return this.radius;
	}
	
	public String toString() {
		return "color: " + this.color + ", x: " + this.x + ", y:" + this.y + ", radius: " + this.radius;
	}
	
	public static void main(String[] args) {
		Dot dot1 = new Dot("red",1,1,1);
		System.out.println(dot1.toString());
	}
}
