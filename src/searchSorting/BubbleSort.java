package searchSorting;
import java.io.IOException;

public class BubbleSort {
public static void main(String[] args) throws IOException {
		
		Integer[] sort=new Integer[9];
		sort[0]=300;
		sort[1]=15;
		sort[2]=17;
		sort[3]=8;
		sort[4]=100;
		sort[5]=250;
		sort[6]=400;
		sort[7]=128;
		sort[8]=200;
		int i,j,k;
		k=1;
		for(i=sort.length;i>0 && k==1;i--){
			k=0;
			for(j=0;j<i-1;j++){
				if(sort[j+1]<sort[j]){
					int temp=sort[j];
					sort[j]=sort[j+1];
					sort[j+1]=temp;
					k=1;
				}
			}
		}
		
	for(j=0;j<sort.length;j++)
	System.out.println(sort[j]);
	}
}

