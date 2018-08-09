package searchSorting;

import java.io.IOException;

public class HeapSortDemo {
	
	public static void main(String[] args) throws IOException {
		int[] a={45,32,67,23,101,350,200,6,100};
		HeapSort h=new HeapSort(a.length);
		h.Build_Heap(a);
		for(int i=0;i<a.length;i++)
			System.out.println("this:  "+a[i]);
		h.HeapIncreaseKey(a, 2, 670);
		System.out.println("extract:  "+h.ExtractMax(a));
		
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
		h.HeapSorting(a);
		for(int i=0;i<a.length;i++)
			System.out.println("sorted:   "+a[i]);
	}
}
class HeapSort{
	int heap_Size;
	public HeapSort(int size) {
		heap_Size=size;
	}
	public void Max_Heapify(int[] a, int i){
		int largest=i,j;
		j=0;
		int left=largest*2+1;
		int right=largest*2+2;
		if(left<heap_Size){
			if(a[left]>a[largest]){
				largest=left;
				j=1;
			}
		}
		if(right<heap_Size){
			if(a[right]>a[largest]){
				largest=right;
				j=1;
			}
		}
		if(j==1){
			int temp=a[largest];
			a[largest]=a[i];
			a[i]=temp;
			Max_Heapify(a, largest);
		}
		
	}
	public void Build_Heap(int[] a){
		int n=a.length;
		for(int i=(int) Math.floor(n/2)-1;i>=0;i--){
			Max_Heapify(a, i);
		}
	}
	public int ExtractMax(int[] a){
		int max=a[0];
		a[0]=a[a.length-1];
		heap_Size--;
		Max_Heapify(a, 0);
		return max;
	}
	public void HeapIncreaseKey(int[] a, int i, int key){
		if(key<a[i])
			return;
		a[i]=key;
		while(i>0 && a[i/2]<a[i]){
			a[i]=a[i/2];
			a[i/2]=key;
			i=i/2;
		}
		
	}
	public void HeapSorting(int[] a){
		Build_Heap(a);
		for(int i=a.length-1;i>=1;i--){
			int max=a[0];
			a[0]=a[i];
			a[i]=max;
			heap_Size--;
			Max_Heapify(a, 0);
		}
		
		
	}
}
