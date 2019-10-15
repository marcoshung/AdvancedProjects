package cs146F19.Hung.project2;

public class KadanesAlgorithm {
	
	public MaxValue findMaxSum(int[] a) {
		
		int maxSum = 0;
		int maxTemp= 0;
		int arrive = -1;
		int depart = 0;
		int tempArrive = 0;
		for(int i = 0; i < a.length; i++) {
			maxTemp = maxTemp+ a[i];
			if(maxTemp < 0) {
				maxTemp = 0;
				arrive=i+1; //next day is the arrival since i-th not included
			}
			if(maxSum < maxTemp) {
				maxSum = maxTemp;
				depart = i;
				tempArrive = arrive;
			}
		}
		arrive=tempArrive;
		return new MaxValue(maxSum, arrive, depart);
	}
	
	
}
