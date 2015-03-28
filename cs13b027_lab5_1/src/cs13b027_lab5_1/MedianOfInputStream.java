package cs13b027_lab5_1;

import java.util.Scanner;

public class MedianOfInputStream {

	public static void main(String[] args){
		
		/*
		 * minHeap for elements greater than the median at any instant
		 * maxHeap for elements less than or equal to the median at any instant
		 * 
		 */
		
		MaxHeap maxHeap = new MaxHeap();
		MinHeap minHeap = new MinHeap();
		Scanner input = new Scanner(System.in);
		int numOfElements=0;
		
		//putting elements appropriately will give the structure as mentioned above and median can be easily obtained
		while(input.hasNext()){
			numOfElements++;
			int newElement = input.nextInt();
			if(numOfElements%2!=0){
				if(minHeap.getCurSize()==0 || newElement<minHeap.viewMin()){
					maxHeap.insert(newElement);
				}
				else{
					maxHeap.insert(minHeap.extractMin());
					minHeap.insert(newElement);
				}
				System.out.println(maxHeap.viewMax());
			}
			else{
				if(newElement<maxHeap.viewMax()){
					minHeap.insert(maxHeap.extractMax());
					maxHeap.insert(newElement);
				}
				else{
					minHeap.insert(newElement);
				}
				System.out.println(minHeap.viewMin());
			}
			
		}
		
		
	}
}
