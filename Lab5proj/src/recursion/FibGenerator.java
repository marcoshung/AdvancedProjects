package recursion;

public class FibGenerator {
	static int[] callCounter;
	
	public static int nthFib(int n) {
		callCounter = new int[n + 1];
		return computeFibRecurse(n);
	}
	private static int computeFibRecurse(int n) {
		callCounter[n]++;
		if(n == 1 || n ==2 ) {
			return 1;
		}else {
			return computeFibRecurse(n-2) + computeFibRecurse(n-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Starting");
		nthFib(30);
		for(int i = 1; i < 30; i++) {
			
			System.out.println(callCounter[i] + " calls to fib(" + i +")");
		}
		
		
	}
}
