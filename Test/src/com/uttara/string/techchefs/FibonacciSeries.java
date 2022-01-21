package com.uttara.string.techchefs;

import java.util.Iterator;

public class FibonacciSeries {

	public static void main(String[] args) {
		fibonacci(10);
//		for (int i = 0; i <10; i++) {
//			System.out.print(recursiveFibonacci(i) + " ");
//		}
	}

	static void fibonacci(int n) {
		int a = 0, b = 1;
		int counter = 0;
		while (counter < n) {
			System.out.print(a + " ");
			int c = a + b;
			a = b;
			b = c;
			counter++;
		}
	}
	static int recursiveFibonacci(int n) {
		if(n <= 1) 
		{
			return n;
		}
		else
		{
			return recursiveFibonacci(n - 1)+recursiveFibonacci(n - 2);
		}
	}
}
