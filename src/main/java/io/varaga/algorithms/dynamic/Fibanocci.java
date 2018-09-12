package io.varaga.algorithms.dynamic;

public class Fibanocci {

    //recursive method. Time: O(2^n)
	public int fib_recurse(int n){
		if(n < 1) {
			return 0;
		}
		int result = -1;
		if(n == 1 || n == 2){
			result = 1;
		} else {
			result = fib_recurse(n - 1) + fib_recurse(n - 2);
		}
		return result;
	}
	
	//memoize/store intermediate variables, Time: O(n)
	public int fib_memoize(int n, Integer[] fibResults){
		if(n < 1) {
			return 0;
		}
		
		if(fibResults[n] != null){
			return fibResults[n];
		}
		int result = -1;
		if(n == 1 || n == 2){
			result = 1;
		} else {
			result = fib_memoize(n - 1, fibResults) + fib_memoize(n - 2, fibResults);
		}
		fibResults[n] = result;
		return result;
	}

    //bottom up approach, Time: O(n) but no stack overflow as in the fib_recurse method
	public int fib_bottomUp(int n, Integer[] fibResults){
		if(n < 1) {
			return 0;
		}
		
		fibResults[1] = 1;
		fibResults[2] = 1;
	
		for(int index = 3; index <= n; index++) {
			fibResults[index] = fibResults[index-1] + fibResults[index - 2];	
		}
		
		return fibResults[n];
	}

    public static void main(String ...args){
		Fibanocci fib = new Fibanocci();
		int fibN = 40;
		Integer[] fibResults = new Integer[fibN + 1];
		long start = System.currentTimeMillis();
		System.out.println(fib.fib_recurse(fibN) + "\n - Time Taken to run fib in recursion: for " + fibN + " numbers :" + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		System.out.println(fib.fib_memoize(fibN, fibResults) + "\n - Time Taken to run fib in recursive memoize: for " + fibN + " numbers :" + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		System.out.println(fib.fib_bottomUp(fibN, fibResults) + "\n - Time Taken to run fib in iterative bottom up: for " + fibN + " numbers :" + (System.currentTimeMillis() - start));
	}

}
