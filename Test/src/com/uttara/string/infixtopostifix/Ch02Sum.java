package com.uttara.string.infixtopostifix;

import java.util.HashMap;
import java.util.Map;

public class Ch02Sum {

	public static void main(String[] args) {
	int[] numbers = {3, 1, 5, 7, 5, 9 };
	int target = 10;
	int[] result = getToSum(numbers, target);
	System.out.println(numbers[result[0]]+" "+numbers[result[1]]);

	}
	public static int[] getToSum(int[] numbers,int target)
	{
		Map<Integer, Integer> vistedNumbers = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++)
		{
			int delta = target - numbers[i];
			if(vistedNumbers.containsKey(delta))
			{
				return new int[] {i,vistedNumbers.get(delta)};
			}
			vistedNumbers.put(numbers[i], i);
		}
		return new int[] {-1,-1};
	}
}
