package com.uttara.virtusa;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Optional;

public class FindTheLongestString {

	public static void main(String[] args) 
	{
		/*
		 * Given a string s,
		 *  find the length of the longest substring without repeating
		 * characters. htte eeefgrrddd Output : 4
		 * 
		 */
		String str = "htteeeefgrrddd";
//		System.out.println(str+":"+findLongestSubstring(str));
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++)
		{
					if(hashMap.containsKey(str.charAt(i)))
					{
						hashMap.put(str.charAt(i), hashMap.get(str.charAt(i))+1);
					}
					else
						hashMap.put(str.charAt(i), 1);
		}
		Comparator<Integer> c =(e1,e2) -> e1.compareTo(e2)==0?e1:e2;
		Entry<Character, Integer> max = hashMap.entrySet()
	            .stream()
	            .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
	            .get();
//	            .getKey();
		String s = "";
	 for (int i = 0; i < max.getValue(); i++) {
		s = s +max.getKey();
	}
		System.out.println(s);
		 hashMap.keySet().stream().forEach(System.out::println);
		
	}
	// Function to find and print longest
	// substring without repeating characters.
	public static String findLongestSubstring(String str)
	{
		int i;
		int n = str.length();
		
		// Starting point
		// of current substring.
		int st = 0;
		
		// length of
		// current substring.
		int currlen = 0;
		
		// maximum length
		// substring without
		// repeating characters.
		int maxlen = 0;
		
		// starting index of
		// maximum length substring.
		int start = 0;
		
		// Hash Map to store last
		// occurrence of each
		
		// already visited character.
		HashMap<Character,
				Integer> pos = new HashMap<Character,
											Integer>();
		
		// Last occurrence of first
		// character is index 0;
		pos.put(str.charAt(0), 0);
		
		for (i = 1; i < n; i++)
		{
			// If this character is not present in hash,
			// then this is first occurrence of this
			// character, store this in hash.
			if (!pos.containsKey(str.charAt(i)))
			{
				pos.put(str.charAt(i), i);
			}
			else
			{
				// If this character is present
				// in hash then this character
				// has previous occurrence,
				// check if that occurrence
				// is before or after starting
				// point of current substring.
				if (pos.get(str.charAt(i)) >= st)
				{
					// find length of current
					// substring and update maxlen
					// and start accordingly.
					currlen = i - st;
					if (maxlen < currlen)
					{
					maxlen = currlen;
					start = st;
					}
			
					// Next substring will start
					// after the last occurrence
					// of current character to avoid
					// its repetition.
					st = pos.get(str.charAt(i)) + 1;
				}
			
				// Update last occurrence of
				// current character.
				pos.replace(str.charAt(i), i);
			}
		}
		
		// Compare length of last
		// substring with maxlen and
		// update maxlen and start
		// accordingly.
		if (maxlen < i - st)
		{
			maxlen = i - st;
			start = st;
		}
		
		// The required longest
		// substring without
		// repeating characters
		// is from str[start]
		// to str[start+maxlen-1].
		return str.substring(start,
							start +
							maxlen);
	}

}
