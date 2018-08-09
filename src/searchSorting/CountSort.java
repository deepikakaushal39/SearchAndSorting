package searchSorting;

import java.util.*;

public class CountSort{
 
  public static void main(String[] args) {
 
    int [] unsorted = {20,10,45,22,20,35,34,22,56,7,8,9,12}; 
    System.out.println("Before: " + Arrays.toString(unsorted));
 
    int [] sorted = CountSortDemo(unsorted);
    System.out.println("After:  " + Arrays.toString(sorted));
 
  }
  public static int[] CountSortDemo(int[] array) {
	  int[] output=new int[array.length];
	  int min=array[0];
	  int max=array[0];
	  for(int i=0;i<array.length;i++){
		  if(min>array[i])
			  min=array[i];
		  else if(max<array[i])
			  max=array[i];
	  }
	  int[] counts=new int[max-min+1];
	  for(int j=0;j<array.length;j++){
		 counts[array[j]-min]++;
	  }
	  counts[0]--;
	  for(int j=1;j<counts.length;j++){
			 counts[j]=counts[j]+counts[j-1];
		  }
	  for(int j=0;j<output.length;j++){
			 output[counts[array[j]-min]--]=array[j];
			
		  }
	  return output;
  }

}


