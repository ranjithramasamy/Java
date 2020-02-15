package com.self.hackerrank;

import java.util.Arrays;

/**
 * Merge two integer arrays alternatively.
 * 
 * Example 1:  arr1 = [1, 2, 3, 4, 5, 6, 7 , 8],  arr2 =  [11, 22, 33, 44]
 * Output: [1, 11, 2, 22, 3, 33, 4, 44, 5, 6, 7, 8]
 * 
 * @author ranjithr
 *
 */
public class MergeTwoIntegerArraysAlternatively {

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4, 5, 6, 7 , 8};
		int[] arr2 = {11, 22, 33, 44, 55, 66, 77};
		int[] result = new int[arr1.length + arr2.length];
		
		mergeArraysAlternatively(arr1, 0, arr2, 0, result, 0);

		System.out.println(Arrays.toString(result));
	}
	
	private static void mergeArraysAlternatively(int[] arr1, int arr1Pos, int[] arr2, int arr2Pos, int[] result, int resultArrPos) {
		// Terminate the recursion if all items are traversed in both arrays.
		if(arr1Pos == arr1.length && arr2Pos == arr2.length) {
			return;
		}
		
		result[resultArrPos++] = arr1[arr1Pos++];
		result[resultArrPos++] = arr2[arr2Pos++];
		
		// All items traversed in arr1 but items left in arr2.
		if(arr1Pos == arr1.length && arr2Pos < arr2.length) {
			while(arr2Pos < arr2.length) {
				result[resultArrPos++] = arr2[arr2Pos++];
			}
		}
		
		
		// All items traversed in arr2 but items left in arr1.
		if(arr2Pos == arr2.length && arr1Pos < arr1.length) {
			while(arr1Pos < arr1.length) {
				result[resultArrPos++] = arr1[arr1Pos++];
			}
		}
		
		mergeArraysAlternatively(arr1, arr1Pos, arr2, arr2Pos, result, resultArrPos);
	}
}
