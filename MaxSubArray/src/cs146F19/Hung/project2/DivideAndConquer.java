package cs146F19.Hung.project2;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DivideAndConquer {
	private int[] input;
	private int beginIndex = -1;
	private int endIndex = -1;

	public MaxValue findMax(int[] array, int begin, int end) {
		
		if(begin == end) {
			return new MaxValue(array[end],begin, end);
		}
		int middle = (begin + end)/2;
		
		MaxValue leftSum = findMax(array,begin,middle);
		MaxValue rightSum = findMax(array,middle + 1, end);
		MaxValue crossSum = sumSide(array,begin,end,middle);
		
		//corner case: all values are negative. Returns 0 and -1 as arrival and departure dates
		if(leftSum.getValue() <= 0 && rightSum.getValue() <= 0 && crossSum.getValue() <= 0) {
			return new MaxValue(0, -1,-1);
		}
		
		//checks if the leftSum is the greatest
		if(leftSum.getValue() > rightSum.getValue() && leftSum.getValue() > crossSum.getValue()) {
			return leftSum;
		}
		
		//checks if rightSum is greatest
		if(rightSum.getValue() > leftSum.getValue() && rightSum.getValue() > crossSum.getValue()) {
			return rightSum;
		}
		
		//if neither of above are true then crossSum must be greatest
		return crossSum;
		
		
	}
	
	private MaxValue sumSide(int[] array, int begin, int end, int middle) {
		
		int tempSum = 0;
		
		int maxSumLeft = 0;
		//sums up the left side of the array and tracks the greatest sum
		for(int i = middle; i >= begin; i--) {
			tempSum += array[i];
			if(tempSum > maxSumLeft) {
				maxSumLeft = tempSum;
				this.beginIndex = i;
			}
		}
		
		tempSum = 0;
		
		int maxSumRight = 0;
		
		//sums of the right side of the array and keeps track of the greatest sum
		for(int i = middle + 1; i <= end; i++ ) {
			tempSum += array[i];
			if(tempSum > maxSumRight) {
				maxSumRight = tempSum;
				this.endIndex = i;
			}
		}
		
		return new MaxValue(maxSumLeft + maxSumRight, this.beginIndex, this.endIndex);
	}
}
