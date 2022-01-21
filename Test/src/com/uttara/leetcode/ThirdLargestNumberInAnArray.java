package com.uttara.leetcode;

public class ThirdLargestNumberInAnArray 
{
	public static void main(String args[])
	{
	      int size;
	      int array[] = {10, 20, 25, 63, 96, 57,9};
	      size = array.length;

	      for(int i = 0; i<size; i++ )
	      {
	         for(int j = i+1; j<size; j++){

	            if(array[i]>array[j]){
	              int  temp = array[i];
	               array[i] = array[j];
	               array[j] = temp;
	            }
	         }
	      }
	      System.out.println("Third second largest number is:: "+array[size-3]);
	   }
}
