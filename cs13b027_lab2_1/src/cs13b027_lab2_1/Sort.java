package cs13b027_lab2_1;

import java.util.LinkedList;
import java.util.List;

public class Sort<T extends Comparable<T>> {

	private List<T> list;
	
	public Sort(List<T> list){
		this.list = list;
	}
	
	public void setList(List<T> list){
		this.list = list;
	}
	
	public void insertionSort(){
		insertionSort(this.list);
	}
	
	public void insertionSort(List<T> list){
		insertionSort(list,0,list.size()-1);
	}
	public void insertionSort(List<T> list, int a, int b){
		int j;
		T temp;
		for(int i=a+1;i<=b;i++){
			j=i;
			while(list.get(j).compareTo(list.get(j-1)) < 0){
				temp = list.get(j-1);
				list.set(j-1, list.get(j));
				list.set(j, temp);
				j--;
				if(j==a)
					break;
			}
		}
		
	}
	
	public void mergeSort(){
		mergeSort(this.list);
	}
	
	public void mergeSort(List<T> list){
		mergeSort(list, 0, list.size()-1);
	}
	
	private void mergeSort(List<T> list, int a, int b){
		
		if(a==b){
			return;
		}
		
		mergeSort(list,a,(a+b)/2);
		mergeSort(list, (a+b)/2+1,b);
		merge(list, a, (a+b)/2, b);
		return;
	}
	
	public void mergeSortBottomed(){
		mergeSortBottomed(this.list);
	}
	
	public void mergeSortBottomed(List<T> list){
		mergeSortBottomed(list,0,list.size()-1);
	}
	
	private void mergeSortBottomed(List<T> list, int a, int b){
		
		if(b-a<=9){
			insertionSort(list,a,b);
			return;
		}
		
		mergeSort(list,a,(a+b)/2);
		mergeSort(list, (a+b)/2+1,b);
		merge(list, a, (a+b)/2, b);
		return;
		
	}
	private void merge(List<T> list, int a, int b, int c){
		
		LinkedList<T> tempList = new LinkedList<T>();
		
		int i=a,j=b+1;
		
		while(true){
			
			if(i>b && j>c){
				break;
			}
			else if(i>b&&j<=c){
				tempList.add(list.get(j));
				j++;
			}
			else if(i<=b&&j>c){
				tempList.add(list.get(i));
				i++;
			}
			else if(list.get(i).compareTo(list.get(j))<=0){
				tempList.add(list.get(i));
				i++;
			}
			else{
				tempList.add(list.get(j));
				j++;
			}
			
		}
		
		i=0;
		while(i+a<=c){
			list.set(i+a, tempList.get(i));
			i++;
		}
		
	}
	
}
