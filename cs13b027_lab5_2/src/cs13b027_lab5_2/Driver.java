package cs13b027_lab5_2;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args){
		
		//Two heaps for the two messages
		
		BinomialHeap heap1 = new BinomialHeap();
		BinomialHeap heap2 = new BinomialHeap();
		int heapSize1, heapSize2;
		
		Scanner input = new Scanner(System.in);
		heapSize1 = input.nextInt();
		heapSize2 = input.nextInt();
		
		for(int i=0;i<heapSize1;i++){
			heap1.insert(input.nextInt());
		}
		
		for(int i=0;i<heapSize2;i++){
			heap2.insert(input.nextInt());
		}
		
		heap1.heapMeld(heap2);
		printBFS(heap1.head, heapSize1+heapSize2);
		Node temp = heap1.head;
		while(temp!=null){
			System.out.printf("%d ",temp.getData());
			temp = temp.getRs();
		}
		System.out.println();

		
	}
	
	public static void printBFS(Node head, int heapSize){
		
		//Method to print BFTraversal ordering of the elements of the array
		Node[] queue = new Node[heapSize];
		int cur = 0, n = 0;
		Node temp,node = head;
		while(node!=null){
			queue[n++] = node;
			while(cur < n){		
				System.out.printf("%d ",queue[cur].getData());
				temp = queue[cur].getLmc();
				while(temp!=null){
					queue[n++] = temp;
					temp = temp.getRs();
				}
				cur++;
			}
			cur = n =  0;
			System.out.printf("\n");
			node = node.getRs();
		}
		
	}
	
}
