package cs13b027_lab2_1;

import java.awt.datatransfer.ClipboardOwner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class MainClass {

	public static void main(String[] args) {

		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		long length, startTime, endTime, totalTime = 0L, temp;

		ArrayList<Integer> iArrayList = new ArrayList<Integer>();
		LinkedList<Integer> iLinkedList = new LinkedList<Integer>();
		ArrayList<Integer> iArrayListClone = new ArrayList<Integer>();
		LinkedList<Integer> iLinkedListClone = new LinkedList<Integer>();

		Sort<Integer> sort = new Sort<Integer>(iArrayList);

		/*
		 * Array List sorting using mergeSort
		 */

		for (int i = 2; i <= 4; i++) {
			temp = (long) Math.pow(10, i);

			for (int j = 1; j <= 15; j++) {
				length = temp;

				while ((length = length - 1) >= 0) {
					iArrayList.add(random.nextInt(5000));
				}

				if (j <= 5) {
					sort.mergeSort(iArrayList);
				}

				else {
					startTime = System.nanoTime();
					sort.mergeSort(iArrayList);
					endTime = System.nanoTime();
					totalTime += endTime - startTime;
				}
				iArrayList.clear();

			}

			System.out
					.printf("sorting %d elements using built in ArrayList by Merge Sort took %d microseconds\n",
							temp, totalTime / 10000L);
			totalTime = 0L;
		}

		/*
		 * ArrayList sorting using merge sort bottomed
		 */

		for (int i = 2; i <= 4; i++) {
			temp = (long) Math.pow(10, i);

			for (int j = 1; j <= 15; j++) {
				length = temp;

				while ((length = length - 1) >= 0) {
					iArrayList.add(random.nextInt(5000));
				}

				if (j <= 5) {
					sort.mergeSortBottomed(iArrayList);
				}

				else {
					startTime = System.nanoTime();
					sort.mergeSortBottomed(iArrayList);
					endTime = System.nanoTime();
					totalTime += endTime - startTime;
				}
				iArrayList.clear();

			}

			System.out
					.printf("sorting %d elements using built in ArrayList by Bottomed Merge Sort took %d microseconds\n",
							temp, totalTime / 10000L);
			totalTime = 0L;
		}

		/*
		 * Array LIst sorting using insertion sort
		 */

		for (int i = 2; i <= 4; i++) {
			temp = (long) Math.pow(10, i);

			for (int j = 1; j <= 15; j++) {
				length = temp;

				while ((length = length - 1) >= 0) {
					iArrayList.add(random.nextInt(5000));
				}

				if (j <= 5) {
					sort.insertionSort(iArrayList);
				}

				else {
					startTime = System.nanoTime();
					sort.insertionSort(iArrayList);
					endTime = System.nanoTime();
					totalTime += endTime - startTime;
				}
				iArrayList.clear();

			}

			System.out
					.printf("sorting %d elements using built in ArrayList by Insertion Sort took %d microseconds\n",
							temp, totalTime / 10000L);
			totalTime = 0L;
		}

		/*
		 * Linked list sorting using merge sort
		 */

		for (int i = 2; i <= 4; i++) {
			temp = (long) Math.pow(10, i);

			for (int j = 1; j <= 15; j++) {
				length = temp;

				while ((length = length - 1) >= 0) {
					iLinkedList.add(random.nextInt(5000));
				}

				if (j <= 5) {
					sort.mergeSort(iLinkedList);
				}

				else {
					startTime = System.nanoTime();
					sort.mergeSort(iLinkedList);
					endTime = System.nanoTime();
					totalTime += endTime - startTime;
				}
				iLinkedList.clear();

			}

			System.out
					.printf("sorting %d elements using built in LinkedList by Merge Sort took %d microseconds\n",
							temp, totalTime / 10000L);
			totalTime = 0L;
		}

		/*
		 * linked list sorting using merge sort bottomed algorithm
		 */

		for (int i = 2; i <= 4; i++) {
			temp = (long) Math.pow(10, i);

			for (int j = 1; j <= 15; j++) {
				length = temp;

				while ((length = length - 1) >= 0) {
					iLinkedList.add(random.nextInt(5000));
				}

				if (j <= 5) {
					sort.mergeSortBottomed(iLinkedList);
				}

				else {
					startTime = System.nanoTime();
					sort.mergeSortBottomed(iLinkedList);
					endTime = System.nanoTime();
					totalTime += endTime - startTime;
				}
				iLinkedList.clear();

			}

			System.out
					.printf("sorting %d elements using built in Linked List by Bottomed Merge Sort took %d microseconds\n",
							temp, totalTime / 10000L);
			totalTime = 0L;
		}

		/*
		 * Linked list sorting using insertion Sort
		 */

		for (int i = 2; i <= 3; i++) {
			temp = (long) Math.pow(10, i);

			for (int j = 1; j <= 15; j++) {
				length = temp;

				while ((length = length - 1) >= 0) {
					iLinkedList.add(random.nextInt(5000));
				}

				if (j <= 5) {
					sort.insertionSort(iLinkedList);
				}

				else {
					startTime = System.nanoTime();
					sort.insertionSort(iLinkedList);
					endTime = System.nanoTime();
					totalTime += endTime - startTime;
				}
				iLinkedList.clear();

			}

			System.out
					.printf("sorting %d elements using built in LinkedList by insertion Sort took %d microseconds\n",
							temp, totalTime / 10000L);
			totalTime = 0L;
		}

	}

	//function to clone  a list might be useful for future reference
	
	/*
	 * private static void clone(List<Integer> listClone,
	 * List<Integer> list) { // TODO Auto-generated method stub
	 * 
	 *     listClone.clear(); 
	 * 
	 *     for(Integer num: iArrayList){
	 *         listClone.add(num); 
	 *     }
	 * 
	 * }
	 */
	
	
}
