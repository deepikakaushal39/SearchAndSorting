package searchSorting;

import java.io.IOException;

public class InsertionSort {

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
	Integer[] sort=new Integer[7];
	sort[0]=300;
	sort[1]=15;
	sort[2]=17;
	sort[3]=8;
	sort[4]=100;
	sort[5]=250;
	sort[6]=128;
	int i,j;
	for(i=1;i<=sort.length-1;i++){
		j=i-1;
		int key=sort[i];
		while(j>=0 && sort[j]>key){
			sort[j+1]=sort[j];
			sort[j]=key;
					j--;
			
			//TRIED MYSELF BUT LENGTHY
			//sort[i-k]=sort[j];
			//sort[j]=key;
			//j--;
			//k++;
			}
	}
	for(j=0;j<=sort.length-1;j++)
		System.out.println(sort[j]);
	  
	}

}
