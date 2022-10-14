package com.scaler.recursion;

public class RecursionSolve {

	static int bar(int x, int y) {
		if (y == 0)
			return 0;
		System.out.println(3 + " + bar(" + x + "," + (y - 1) + ")");
		return (x + bar(x, y - 1));
	}

	static int foo(int x, int y) {
		if (y == 0)
			return 1;
		System.out.println("bar(" + x + "," + "foo(" + x + "," + (y - 1) + ")");
		return bar(x, foo(x, y - 1));
	}

	public static void main(String[] args) {
		System.out.println(foo(3, 5));
	}

}
