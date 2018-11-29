package recursion;

public class FactorialGenerator {
	int[] callCounter;
	public static float nthFactorial(int n) {
		
		return computeFactorialRecurse(n);
	}
	
	private static float computeFactorialRecurse(int n) {
		assert n >=0 : "Illegal n:" + n;
		if(n == 0) {
			return 1;
		}else {
			
			return n * computeFactorialRecurse(n-1);
		}
	}
	public static void main(String[] args) {
		
			System.out.println(nthFactorial(-1));
		
	}
}
