package cs13b027_lab5_1;

public class Heap {
	
	//Heap class which extends Heap Class
	private int maxSize;
	private int curSize;
	private Integer[] heap;
	
	public int parentIdx(int index){
		return (int)Math.floor(index/2);
	}
	
	public int leftChildIdx(int index){
		return 2*index;
	}
	
	public int rightChildIdx(int index){
		return 2*index+1;
	}
	
}
