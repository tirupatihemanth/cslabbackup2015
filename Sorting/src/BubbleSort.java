//This is the improvised version of bubble sort The bubble sort algorithm can be easily optimized by 
//observing that the n-th pass finds the n-th largest element and puts it into its final place. 
//So, the inner loop can avoid looking at the last n-1 items when running for the n-th time
//best performance(when already sorted): O(n)
//worst performance and average: O(n^2)
//Stable i.e doen't interchange the order in which elements with same number 


public class BubbleSort {
	
	public int[] sort(int[] arr){
		
		int arrlen = arr.length;
		boolean sorted = false;
		
		while(!sorted){
			sorted = true;
			for(int i=0;i<arrlen-1;i++){
				if(arr[i]>arr[i+1]){
					swap(arr,i,i+1);
					sorted = false;
				}
			}
			arrlen--;
		}
		return arr;
	}

	private void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		arr[i] = arr[i]^arr[j];
		arr[j] = arr[i]^arr[j];
		arr[i] = arr[i]^arr[j];
		
	}
}
