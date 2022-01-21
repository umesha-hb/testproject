package com.uttara.remove.duplicateInArray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicateElementsInArrayUsingSet {

	public static void removeDuplicateUsingSet(int arr[]) {

		// Declare set
		Set<Integer> st = new HashSet<>();
		int len = arr.length;

		// Traverse an array and add element in a set
		for (int i = 0; i < len - 1; i++) {
			// It only add unique value
			st.add(arr[i]);
		}

		// Print each element
		st.forEach(elem -> System.out.print(elem + " "));
		
	
	}

	public static void main(String[] args) {

		int arr[] = { 5, 1, 2, 6, 4, 4, 5, 6, 8, 7 };

		removeDuplicateUsingSet(arr);
	}
}