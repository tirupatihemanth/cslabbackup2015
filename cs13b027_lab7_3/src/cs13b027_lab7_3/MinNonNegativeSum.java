package cs13b027_lab7_3;

import java.util.Scanner;

public class MinNonNegativeSum {
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] nums = new int[n];
		
		for(int i=0;i<n;i++){
			nums[i] = input.nextInt();
		}
		int sum = 0;
		
		for(int i=0;i<n;i++){
			sum+=nums[i];
		}
		
		/**
		 * Memoisation array the problem is equivalent to an 0-1 knapsac problem
		 */
		int[][] memArray = new int[n+1][sum/2+1];
		
		/**
		 *  TABULATION method
		 */
		for(int i=0;i<=n;i++){
			
			for(int numWt=0;numWt<=sum/2;numWt++){
				if(numWt == 0){
					memArray[i][numWt] = 0;
				}
				else if(i == 0){
					memArray[i][numWt] = 0;
				}
				else if(nums[i-1]<=numWt){
					memArray[i][numWt] = nums[i-1]+memArray[i-1][numWt-nums[i-1]]>memArray[i-1][numWt]?nums[i-1]+memArray[i-1][numWt-nums[i-1]]:memArray[i-1][numWt];
				}
				else{
					memArray[i][numWt] = memArray[i-1][numWt];
				}
			}
			
		}
		
		System.out.println(sum - 2*memArray[n][sum/2]);
		
	}

}
