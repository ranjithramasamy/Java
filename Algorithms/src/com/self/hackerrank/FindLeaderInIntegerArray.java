package com.self.hackerrank;

/**
 * Find and print leader integers from given array.
 * 
 * Example:
 * Input:	[8, 23, 19, 21, 15, 6, 11]
 * Output:	11 15 21 23  ->  Pick numbers which is greater than previous number (from right to left in array).
 * @author ranjithr
 *
 */
public class FindLeaderInIntegerArray {

	public static void main(String[] args) {
		int[] input = {8, 23, 19, 21, 15, 6, 11};
		
		System.out.print("Leaders are: " + input[input.length - 1]);
		
		for(int idx = input.length - 1; idx > 0; idx--) {
			if(input[idx - 1] > input[idx]) {
				System.out.print(" " + input[idx - 1]);
			}
		}
	}

}
