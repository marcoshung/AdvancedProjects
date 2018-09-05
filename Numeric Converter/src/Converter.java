import java.util.*;

public class Converter {
	public static void main(String[] args) {
		boolean running = true;
		Scanner console = new Scanner(System.in);
		System.out.println("Enter whatever you wish to convert to binary");
		while(running) {
			String input = console.nextLine();
			if(input.toLowerCase().equals("quit")) {
				running = false;
				System.out.println("YOU ARE DONE");
			}else {
				System.out.println(convert(input));
			}
		}
	}
	
	public static String convert(String input) {
		String[] words = input.split(" ");
		String convertedString = "";
		for(int i = 0; i < words.length; i++) {
			String convertedWord = "";
			
			for(int j = 0; j < words[i].length(); j++) {
				int numVal = (int) (words[i].charAt(j));
				if(numVal >47 && numVal < 58) {
					numVal = Integer.parseInt(words[i].substring(j, j+1));
				}
				for(int k = 128; k > 0; k /= 2) {
					if(numVal >= k) {
						convertedWord += "1";
						numVal -= k;
					}else {
						convertedWord += "0";
					}
				}
				
			}
			convertedString += convertedWord + "\n";
		}
		return convertedString;
	}
}
