package com.uttara.lti.pgm;

import java.util.HashMap;
import java.util.Map;

public class FindNumberOfOccurence {

	public static void main(String[] args) {
		String str = "My Name is Sachin and Sachin playing cricket for india";
		String[] s = str.split(" ");
		Map<String,Integer> hs = new HashMap<String,Integer>();
		for(int i =0;i<s.length;i++)
		{
		    if(hs.containsKey(s[i]))
		    {
		        
		         hs.put(s[i],hs.get(s[i])+1);
		    }
		    else
		    hs.put(s[i],1);
		}
		hs.entrySet().stream().forEach(System.out::println);

	}

}
