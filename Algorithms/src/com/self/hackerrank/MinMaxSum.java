package com.self.hackerrank;

/**
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. 
 * Then print the respective minimum and maximum values as a single line of two space-separated long integers.
 * 
 * For example, arr = [1, 3, 5, 7, 9]. Our minimum sum is 1 + 3 + 5 + 7 = 16 and our maximum sum is 3 + 5 + 7 + 9 = 24. We would print 16, 24
 * 
 * @author ranjithr
 *
 */
public class MinMaxSum {

	public static void main(String[] args) {
		int[] input = {1, 3, 5, 7, 9};
		
		findMinMaxSum(input);
	}
	
	private static void findMinMaxSum(int[] input) {
		int excludeIdx = 0;
		int minSum = 0;
		int maxSum = 0;
		
		do {
			int tmpSum = 0;
			
			for(int idx = 0; idx < input.length; idx++) {
				if(idx != excludeIdx) {
					tmpSum += input[idx];
				}
			}
			
			if(minSum == 0 || minSum > tmpSum) {
				minSum = tmpSum;
			}

			if(maxSum == 0 || maxSum < tmpSum) {
				maxSum = tmpSum;
			}
		}while(++excludeIdx < input.length);
		
		System.out.println(minSum + " " + maxSum);
	}
}
