import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
public class Shuffler {
	
	public static void main(String[] args) throws IOException {
		//BufferedReader Out = new BufferedReader (new FileReader ("LastNameFirstNameShuffled.txt"));
		BufferedReader In = new BufferedReader (new FileReader ("/Users/marcoshung/Downloads/ErdosCA.txt")); 
		System.out.println("Start Time: " + System.currentTimeMillis());
		String firstLine = In.readLine();
		String[] numbers = firstLine.split(" ");
		int distinct1 = Integer.parseInt(numbers[1]);
		int distinct2 = Integer.parseInt(numbers[2]);
		File outputFile = new File("/Users/marcoshung/Downloads/LastNameFirstNameShuffled.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
		int rows =  Integer.parseInt(numbers[3]);
		String[] data = new String[rows];
		
		for(int i = 0;i < data.length; i++) {
			data[i] = In.readLine();
			//System.out.println(data[i]);
		}
		
		randomize(data);
		System.out.println("Start Time: " + System.currentTimeMillis());
		for(int i = 0;i < data.length; i++) {
			writer.write(data[i]);
			writer.newLine();
		}
		
		//Out.close();
		In.close();
		writer.close();
	}
	
	public static void randomize(String[] array) {
		Random random = new Random();
		random.setSeed(20);
		for(int i = array.length - 1; i >= 0; i--) {
			int randomized = random.nextInt(array.length);
			String temp = array[i];
			array[i] = array[randomized];
			array[randomized] = temp;
		}
	}
}
