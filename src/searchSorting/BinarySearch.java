package searchSorting;

import java.io.IOException;

public class BinarySearch {
	public static void main(String[] args) throws IOException {
		// Random Input
		Integer[] search={154,55,35,5,45,655,9,5,1000,7,89,5555,346,9,7,2,4,65};
		//QuickSort.QuickSortProc(search,0,search.length-1);
		int index = BinarySearchSearch(search,655);
		System.out.println(index);
	}
	public static int BinarySearchSearch(Integer[] search, int data){
		int low=0;
		int end=search.length-1;
		
		while(low<=end){
			int mid=(int) Math.floor((end-low)/2);
			mid=low+mid;
 			if(search[mid] == data)
				return mid;
			else if(search[mid]<data)
				low=mid+1;
			else
				end=mid-1;
		}
		return -1;
	}
}
