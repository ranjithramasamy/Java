package com.self.hackerrank;

import java.util.Arrays;

/**
 * Merge two sorted integer arrays.
 * 
 * Example 1:  arr1 = [1, 3, 5], arr2 =  [2, 4, 6]
 * Output: [1, 2, 3, 4, 5, 6]
 * 
 * @author ranjithr
 *
 */
public class MergeTwoSortedIntegerArrays {

	public static void main(String[] args) {
		int[] arr1 = {1, 3, 5};
		int[] arr2 = {2, 4, 6};
		
		System.out.println(Arrays.toString(mergeSortedArrays(arr1, arr2)));
	}
	
	private static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
		int[] arr3 = new int[arr1.length + arr2.length];
		int idx1 = 0; 
		int idx2 = 0; 
		int idx3 = 0;
		
		while(idx1 < arr1.length && idx2 < arr2.length) {
			if(arr1[idx1] < arr2[idx2]) {
				arr3[idx3++] = arr1[idx1++];
			}else {
				arr3[idx3++] = arr2[idx2++];
			}
		}
		
		while(idx1 < arr1.length) {
			arr3[idx3++] = arr1[idx1++];
		}
		
		while(idx2 < arr2.length) {
			arr3[idx3++] = arr2[idx2++];
		}
		
		return arr3;
	}
}
