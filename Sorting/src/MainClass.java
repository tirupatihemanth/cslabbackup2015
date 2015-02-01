
public class MainClass {
	
	public static void main(String[] args){
		
		BubbleSort bubbleSort = new BubbleSort();
		InsertionSort insertionSort = new InsertionSort();
		int[] arr = {10,9,4,7,1,3,12,3,5};
		//bubbleSort.sort(arr);
		insertionSort.sort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
