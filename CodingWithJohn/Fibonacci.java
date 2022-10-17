package com.sample;

/**
 * Use cache to find fibonaci numbers as it has previous values stored
 * 0 1 1 2 3 5 8 13 ......
 * f(2) -> f(1) + f(0)
 * f(3) -> f(2) + f(1) -----
 * 
 * @author guruprasadchowdaryp
 *
 */
public class Fibonacci {
	private static long[] cacheNums;
	public static void main(String[] args) {
		int n=6;
		cacheNums=new long[n+1];
		for(int i=0;i<=n;i++) {
			System.out.print(findFib(i) +" ");
		}
		System.out.println(findFib(n));
	}

	private static long findFib(int n) {
		if(n<=1) {
			return n;
		}
		
		if(cacheNums[n] !=0) {
			return cacheNums[n];
		}
		long res = findFib(n-1) + findFib(n-2);
		cacheNums[n] = res;
		return res;
	}

}
