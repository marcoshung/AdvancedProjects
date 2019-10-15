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
		double startTime = System.currentTimeMillis();
		BufferedReader In = new BufferedReader (new FileReader ("ErdosCA.txt")); 
		String firstLine = In.readLine();
		String[] numbers = firstLine.split(" ");
		int distinct1 = Integer.parseInt(numbers[1]);
		int distinct2 = Integer.parseInt(numbers[2]);
		File outputFile = new File("HungMarcosShuffled.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
		int rows =  Integer.parseInt(numbers[3]);
		String[] data = new String[rows];
		
		for(int i = 0;i < data.length; i++) {
			data[i] = In.readLine();
		}
		System.out.println("Time to read file: " + (System.currentTimeMillis() - startTime) + " milliseconds");

		randomize(data);
		System.out.println("Time to shuffle elements: " + (System.currentTimeMillis() - startTime) + " milliseconds");

		for(int i = 0;i < data.length; i++) {
			writer.write(data[i]);
			writer.newLine();
		}
		System.out.println("Time to create output file: " + (System.currentTimeMillis() - startTime) + " milliseconds");

		In.close();
		writer.close();
	}
	
	public static void randomize(String[] array) {
		Random random = new Random();
		random.setSeed(20);
		
		//uses Fisher–Yates shuffle algorithm
		for(int i = array.length - 1; i > 0; i--) {
			int randomized = random.nextInt(i);
			String temp = array[i];
			array[i] = array[randomized];
			array[randomized] = temp;
		}
	}
}
