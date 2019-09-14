import java.util.*;

public class Encrypt2 {
	private static String PASSWORD = "test";
	private static ArrayList<Concealed> concealedValues = new ArrayList<Concealed>();
	
	public static void main(String[] args) {
		System.out.println("Enter the password");
		Scanner console = new Scanner(System.in);
		String input = console.nextLine();
		encrypt();
		if(input.equals(decrypt())) {
			System.out.println(decrypt());
			System.out.println("here are the files");
			printEncrypted();
			System.out.println(decrypt());
		}else {
			System.out.println("wrong password");
			printEncrypted();
		}
		decrypt();
		console.close();
	}
	
	public static void encrypt() {
		while(!PASSWORD.isEmpty()) {
			concealedValues.add(new Concealed(PASSWORD.charAt(0)));
			PASSWORD = PASSWORD.substring(1);
		}
	}
	
	public static void printEncrypted() {
		for(Concealed n : concealedValues) {
			System.out.println(n.getConcealedValue());
		}
	}
	
	public static String decrypt() {
		String p = "";
		for(Concealed c : concealedValues) {
			p+= c.convertBack();
		}
		return p;
	}
}
