package cs13b027_lab7_1;

import java.util.Scanner;

/**
 * @author HemanthKumarTirupati
 *         <p>
 *         Dynamic Programming Practice Problem 1
 *         </p>
 */

public class SaucenHisCalculator {

	/**
	 * Main class to evaluate the problem
	 */
	private static int[] array;
	/**
	 * main method 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		array = new int[10];
		int val;
		int[] valArray;
		while (testCases>0) {
			
			for (int i = 0; i < 10; i++) {
				array[i] = input.nextInt();
			}
			
			val = input.nextInt();
			valArray = new int[val+1];
			
			for(int i=0;i<=val;i++){
				valArray[i] = Integer.MAX_VALUE;
			}
			
			/**
			 * valArray is a memoization array
			 */
			
			for(int i=1;i<=val;i++){
				if(val%i == 0){
					valArray[i] = valArray[i]<stepsToPress(i)?valArray[i]:stepsToPress(i);
					if(valArray[i]!=Integer.MAX_VALUE){
						for(int j=2;i*j<=val;j++){
							if(valArray[i]!=Integer.MAX_VALUE && valArray[j] != Integer.MAX_VALUE){
								valArray[i*j] = valArray[i*j]<valArray[i]+valArray[j]+1?valArray[i*j]:valArray[i]+valArray[j]+1;
							}
						}
					}

				}
			}
			
			if(valArray[val] == Integer.MAX_VALUE){
				System.out.println("Impossible");
			}
			else{
				System.out.println(valArray[val]+1);
			}
			testCases--;

		}
	}
	
	/**
	 * function to process stepstopress
	 * @param num
	 * @return
	 */
	public static int stepsToPress(int num){
		if(num<10){
			if(array[num] ==0){
				return Integer.MAX_VALUE;
			}
			else{
				return 1;
			}
		}
		else{
			String val = String.valueOf(num);
			for(int i=0;i<val.length();i++){
				if(array[val.charAt(i)-'0'] == 0){
					return Integer.MAX_VALUE;
				}
			}
			return val.length();
		}
	}
}
