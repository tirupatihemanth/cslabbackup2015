package cs13b027_lab5_1;

public class MaxHeap extends Heap{
	
	//MaxHeap class which extends Heap class
	private int maxSize;
	private int curSize;
	private Integer[] heap;
	
	public MaxHeap(int maxSize){
		this.maxSize = maxSize;
		this.curSize = 0;
		heap = new Integer[maxSize+1];
		heap[0] = -1;
	}
	
	public MaxHeap(){
		maxSize = 1000;
		this.curSize = 0;
		heap = new Integer[1001];
		heap[0] = -1;
	}
	
	public int getCurSize(){
		return curSize;
	}
	
	public int viewMax(){
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
	
	//To correct any wrong element at given index assuming rest of the tree follows MaxHeap property
	public void correctHeap(int index){
		int maxIndex = index;
		if(leftChildIdx(index)<=curSize && heap[maxIndex]<heap[leftChildIdx(index)]){
			maxIndex = leftChildIdx(index);
		}
		if(rightChildIdx(index)<=curSize && heap[maxIndex]<heap[rightChildIdx(index)]){
			maxIndex = rightChildIdx(index);
		}
		
		if(maxIndex!=index){
			swap(index,maxIndex);
			correctHeap(maxIndex);
		}
		return;
	}
	
	//extractMax implemented using correctHeap method
	public int extractMax(){
		swap(1,curSize);
		curSize--;
		correctHeap(1);
		return heap[curSize+1];
	}
	
	//increaseKey operation implemented using repeated swapping
	public void increaseKey(int index, int newValue){
		heap[index] = newValue;
		while(index>1 && heap[index]>heap[parentIdx(index)]){
			swap(index, parentIdx(index));
			index = parentIdx(index);
		}
	}
	
	//insert operation obtained through increase key operation
	public void insert(int newElement){
		curSize++;
		heap[curSize] = Integer.MIN_VALUE;
		increaseKey(curSize, newElement);
	}
	
}
