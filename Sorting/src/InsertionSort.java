public class InsertionSort {

	public int[] sort(int[] arr){
		int arrlen = arr.length;
		for(int i=1;i<arrlen-1;i++){
			if(arr[i]<arr[i-1]){
				insert(arr,i);
			}
		}
		return arr;
	}

	private void insert(int[] arr, int i) {
		// TODO Auto-generated method stub
		int element = arr[i];
		while(i>0 && arr[i-1] > element){
			arr[i] = arr[i-1];
			i--;
		}
		arr[i] = element;
	}

}