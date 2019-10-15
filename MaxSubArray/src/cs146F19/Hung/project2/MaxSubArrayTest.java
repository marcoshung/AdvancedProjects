package cs146F19.Hung.project2;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

import java.io.*;
public class MaxSubArrayTest {
	
	private File testFile = new File("maxSumtest.txt");
	private ArrayList<int[]> testCases = new ArrayList<int[]>();
	private ArrayList<int[]> answersList = new ArrayList<int[]>();
	
	@Test
	public void bruteForceCheckMaxSum() throws IOException{
		BruteForce test1 = new BruteForce();
		convertFileToArray(testFile);
		//uses test cases in test file
		for(int i = 0; i < testCases.size(); i++) {
			MaxValue result1 = test1.findMax(testCases.get(i));
			assertEquals(result1.getValue(),answersList.get(i)[0]);
			assertEquals(result1.getBeginIndex(), answersList.get(i)[1]);
			assertEquals(result1.getEndIndex(), answersList.get(i)[2]);
		}
		
		
		int[] testCase2 = {-2, -3, 4, -1, -2, 1, 5, -3};
		MaxValue result2 =  test1.findMax(testCase2);
		assertEquals(result2.getValue(), 7);
		assertEquals(result2.getBeginIndex(), 2);
		assertEquals(result2.getEndIndex(), 6);
		
		//all neg
		int[] testCase3 = {-2, -3, -4, -1, -2, -1, -5, -3};
		MaxValue result3 = test1.findMax(testCase3);
		assertEquals(result3.getValue(), 0);
		assertEquals(result3.getBeginIndex(),-1);
		assertEquals(result3.getEndIndex(),-1);
		
		//all pos
		int[] testCase4 = {2, 3, 4, 1, 2, 1, 5, 3};
		MaxValue result4 = test1.findMax(testCase4);
		assertEquals(result4.getValue(),21);
		assertEquals(result4.getBeginIndex(),0);
		assertEquals(result4.getEndIndex(), 7);
		
	}
	
	@Test
	public void divideAndConquerCheckMaxSum() throws IOException {
		DivideAndConquer test = new DivideAndConquer();
		convertFileToArray(testFile);

		for(int i = 0; i < testCases.size(); i++) {
			MaxValue result1 = test.findMax(testCases.get(i), 0, testCases.get(i).length - 1);
			assertEquals(result1.getValue(),answersList.get(i)[0]);
			assertEquals(result1.getBeginIndex(), answersList.get(i)[1]);
			assertEquals(result1.getEndIndex(), answersList.get(i)[2]);
		}
		int[] testCase2 = {-2, -3, 4, -1, -2, 1, 5, -3};
		MaxValue result2 = test.findMax(testCase2, 0, testCase2.length - 1);
		System.out.println(result2.getValue() + " " + result2.getBeginIndex() + " " + result2.getEndIndex());
		
		int[] testCase3 = {-2, -3, -4, -1, -2, -1, -5, -3};
		MaxValue result3 = test.findMax(testCase3,0, testCase3.length - 1);
		assertEquals(result3.getValue(), 0);
		assertEquals(result3.getBeginIndex(),-1);
		assertEquals(result3.getEndIndex(),-1);
		
		int[] testCase4 = {2, 3, 4, 1, 2, 1, 5, 3};
		MaxValue result4 = test.findMax(testCase4, 0 ,testCase3.length - 1);
		assertEquals(result4.getValue(),21);
		assertEquals(result4.getBeginIndex(),0);
		assertEquals(result4.getEndIndex(), 7);
		
	}
	
	@Test public void kadanesCheckMaxSum() throws IOException {
		KadanesAlgorithm test = new KadanesAlgorithm();
		
		convertFileToArray(testFile);

		for(int i = 0; i < testCases.size(); i++) {
			MaxValue result1 = test.findMaxSum(testCases.get(i));
			assertEquals(result1.getValue(),answersList.get(i)[0]);
			assertEquals(result1.getBeginIndex(),answersList.get(i)[1]);
			assertEquals(result1.getEndIndex(),answersList.get(i)[2]);
		}
		
		int[] testCase2 = {-2, -3, 4, -1, -2, 1, 5, -3};
		MaxValue result2 = test.findMaxSum(testCase2);
		assertEquals(result2.getValue(),7);
		assertEquals(result2.getBeginIndex(), 2);
		assertEquals(result2.getEndIndex(), 6);
	}
	
	//this method will generate an array of random numbers between -50 and 50.
	private int[] randomArrayGenerator(int numOfElements) {
		int[] randomArray = new int[numOfElements];
		for(int i = 0; i < numOfElements; i++) {
			randomArray[i] =  -50 + (int)(Math.random()* ( 50 - (-50) + 1));
		}
		return randomArray;
	}
	
	//converts file of test cases into a list of array of ints and stores it in the global variable testCases
	public void convertFileToArray(File f) throws IOException {
		Scanner console = new Scanner(new FileReader(f));
		String line;
		while(console.hasNextLine()) {
			line = console.nextLine();
			
			if(line != null && !(line.isEmpty())) {
				String[] tempInputs = line.split("\\s+");
				
				int[] inputs = convertToInt(tempInputs);
				
				testCases.add(inputs);
			}
		}
	}
	
	
	//converts an array of string of numbers into an array of integers
	private int[] convertToInt(String[] array) {
		
		int[] values = new int[array.length - 4];
		//only goes until array.length - 3 bc last three elements are the answers

		for(int i = 1; i < array.length - 3; i++) {
			values[i - 1] = Integer.parseInt(array[i]);
		}
		
		int[] answers = new int[3];
		
		//creates an array of the answers using the last three elements and adds it to the answerList 
		answers[0] = Integer.parseInt(array[array.length - 3]);
		answers[1] = Integer.parseInt(array[array.length - 2]);
		answers[2] = Integer.parseInt(array[array.length - 1]);
		this.answersList.add(answers);
		

		return values;
	}
	
	@Test
	public void compareRunTimes(){
		BruteForce brute = new BruteForce();
		DivideAndConquer div = new DivideAndConquer();
		KadanesAlgorithm kan = new KadanesAlgorithm();
		
		//test cases numbers
		int[] numOfElements = {100, 200, 500, 1000, 2000, 5000, 100000};
	
		//these will be arrays that store the runtimes of the algoritims to make it easier to copy
		double[] bruteList = new double[numOfElements.length];
		double[] divList = new double[numOfElements.length];
		double[] kanList = new double[numOfElements.length];
		
		//generates arrays of n size and runs all algorithms and checks runtimes
		for(int i = 0; i < numOfElements.length; i++) {
			int[] testArray = randomArrayGenerator(numOfElements[i]);
			if(numOfElements[i] <= 1000) {
				System.out.println("Brute Force");
				double initialTime = System.nanoTime();
				brute.findMax(testArray);
				double finalTime = System.nanoTime() - initialTime;
				System.out.println("Time to Run " + testArray.length + " elements : "+ finalTime);
				bruteList[i] = finalTime;
			}
			
			double initialTime;
			double finalTime;
			
			initialTime = System.nanoTime();
			System.out.println("Divde and Conquer");
			div.findMax(testArray,0, testArray.length - 1);
			finalTime = System.nanoTime() - initialTime;
			System.out.println("Time to Run " + testArray.length + " elements : " + finalTime);
			divList[i] = finalTime;
			
			initialTime = System.nanoTime();
			System.out.println("Kadane's Algorithim");
			kan.findMaxSum(testArray);
			finalTime = System.nanoTime() - initialTime;
			System.out.println("Time to Run " + testArray.length + " elements : "+ finalTime);
			kanList[i] = finalTime;
			
		}
		
		printArray(bruteList);
		printArray(divList);
		printArray(kanList);
	}
	
	public void printArray(double[] array) {
		for(int i = 0; i <array.length; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
	}
}
