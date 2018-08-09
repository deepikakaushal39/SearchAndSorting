package searchSorting;

import java.io.IOException;

public class QuickSort {
	public static void main(String[] args) throws IOException {
		Integer[] sort={154,55,35,5,45,655,9,5,1000,7,89,5555,346,9,7,2,4,65};
		QuickSortProc(sort,0,sort.length-1);
		for(int i=0;i<sort.length;i++)
			System.out.println(sort[i]);
			
	}
	public static void QuickSortProc(Integer[] sort,int start,int length){
		if(start<length){
			int q = Partition(sort,start,length);
			QuickSortProc(sort,start,q-1);
			QuickSortProc(sort,q+1,length);
					}


	}
	public static int Partition(Integer[] sort,int start,int length){
		int end=sort[length];
		int i;
		int j=start-1;
		for(i=start;i<=length-1;i++){
			if(sort[i]<=end){
				j++;
				int temp=sort[j];
				sort[j]=sort[i];
				sort[i]=temp;
				
			}
		}

			sort[length]=sort[j+1];
			sort[j+1]=end;
		
		
		return j+1;
					
	}

}
