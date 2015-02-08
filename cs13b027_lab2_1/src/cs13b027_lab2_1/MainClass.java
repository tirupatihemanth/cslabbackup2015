package cs13b027_lab2_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;


public class MainClass {

	public static void main(String[] args){
		
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		long length;
		
		ArrayList<Integer> iArrayList = new ArrayList<Integer>();
		LinkedList<Integer> iLinkedList = new LinkedList<Integer>();
		
//		ArrayList<String> sArrayList = null;
//		LinkedList<String> sLinkedList = null;
		
		Sort<Integer> sort = new Sort<Integer>(iArrayList);
		
		for(int i=2;i<=6;i++){
			length = (long)Math.pow(10, i);
			while((length=length-1)>=0){
				iArrayList.add(random.nextInt(5000));
			}
			//sort.mergeSort();
			sort.insertionSort();
			//sort.mergeSortBottomed();
			for(Integer val: iArrayList){
				System.out.printf("%d ",val.intValue());
			}
			iArrayList.clear();
			System.out.println();
		}
		
//		
//		for(int i=2;i<=9;i++){
//			length = (long)Math.pow(10, i);
//			while((length=length-1)>=0){
//				iLinkedList.add(random.nextInt(5000));
//			}
//		}
//		
//		sort.setList(iLinkedList);
//		sort.insertionSort();
		
		
	}
}