package cs13b027_lab5_1;

public class MinHeap extends Heap{

	//MinHeap class which extends Heap class
	private int maxSize;
	private int curSize;
	private Integer[] heap;
	
	public MinHeap(int maxSize){
		this.maxSize = maxSize;
		this.curSize = 0;
		heap = new Integer[maxSize+1];
		heap[0] = -1;
	}
	
	public MinHeap(){
		maxSize = 1000;
		this.curSize = 0;
		heap = new Integer[1001];
		heap[0] = -1;
	}
	
	public int getCurSize(){
		return curSize;
	}
	
	public int viewMin(){
		return heap[1];
	}
	
	private void swap(int idx1, int idx2){
		int temp;
		temp = heap[idx1];
		heap[idx1] = heap[idx2];
		heap[idx2] = temp;
/*		heap[idx1] = heap[idx1]^heap[idx2];
		heap[idx2] = heap[idx1]^heap[idx2];
		heap[idx1] = heap[idx1]^heap[idx2];*/
	}
	
	//To correct any wrong element at given index assuming rest of the tree follows MinHeap property
	public void correctHeap(int index){
		int minIndex = index;
		if(leftChildIdx(index)<=curSize && heap[minIndex]>heap[leftChildIdx(index)]){
			minIndex = leftChildIdx(index);
		}
		if(rightChildIdx(index)<=curSize && heap[minIndex]>heap[rightChildIdx(index)]){
			minIndex = rightChildIdx(index);
		}
		
		if(minIndex!=index){
			swap(index,minIndex);
			correctHeap(minIndex);
		}
		return;
	}
	
	//extractMin implemented using correctHeap method
	public int extractMin(){
		swap(1, curSize);
		curSize--;
		correctHeap(1);
		return heap[curSize+1];
	}
	
	//decreaseKey operation using repeated swapping
	public void decreaseKey(int index, int newValue){
		heap[index] = newValue;
		while(index>1 && heap[index]<heap[parentIdx(index)]){
			swap(index, parentIdx(index));
			index = parentIdx(index);
		}
	}
	
	//insert operation through decrease key operation
	public void insert(int newElement){
		curSize++;
		heap[curSize] = Integer.MAX_VALUE;
		decreaseKey(curSize, newElement);
	}
}
