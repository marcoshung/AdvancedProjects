package cs146F19.Hung.project2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// This class will demonstrate the brute force approach to solving the Max Sub Array Problem in O(n^2) running time


public class BruteForce {

	public MaxValue findMax(int[] list) {
		int maxSum = 0;
		int beginIndex = -1;
		int endIndex = -1;
		//this is the beginning of the sub array
		for(int i = 0; i <list.length; i++) {
			int tempSum = 0;
			
			//this is the end of the sub array that it is iterating through
			for(int j = i; j < list.length; j++) {
				tempSum += list[j];
				
				//switches overall Max is the current sum is greater
				if(tempSum >= maxSum) {
					maxSum = tempSum;
					beginIndex = i;
					endIndex = j;
				}
			}
		}
		
		return new MaxValue(maxSum,beginIndex, endIndex);
	}
	
}
