package searchSorting;

import java.io.IOException;

public class MergeSort {
public static void main(String[] args) throws IOException {
		Integer[] sort=new Integer[8];
		sort[0]=300;
		sort[1]=15;
		sort[2]=17;
		sort[3]=8;
		sort[4]=150;
		sort[5]=5;
		sort[6]=97;
		sort[7]=9;
		MergeSortProc(sort,0,sort.length-1);
		for(int i=0;i<sort.length;i++)
			System.out.println(sort[i]);
	}
public static void MergeSortProc(Integer[] sort,int start,int length){
	int mid;
	if(start<length){
		mid= (int) Math.floor((start+length)/2);
		MergeSortProc(sort,start,mid);
		MergeSortProc(sort, mid+1, length);
		Merge(sort,start,mid,length);
	}


}
	
public static void Merge(Integer[] sort,int start,int mid, int length){
	int n1=(mid-start)+1;
	int n2=length-mid;
	Integer[] list1=new Integer[n1+1];
	Integer[] list2=new Integer[n2+1];
	for(int i=0;i<n1;i++){
		list1[i]= sort[start+i];
		
	}
	list1[n1]=Integer.MAX_VALUE;
	for(int j=0;j<n2;j++){
		list2[j]= sort[mid+1+j];
	}
	list2[n2]=Integer.MAX_VALUE;
	int i,j;
	i=0;
	j=0;
	for(int k=0;k<(n1+n2);k++){
		
		if(list1[i]<=list2[j]){
			sort[start+k]=list1[i];
			i++;
		}
		else if(list2[j]<list1[i]){
			sort[start+k]=list2[j];
			j++;
		}
	}

}

}