package com.self.hackerrank;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Find the median of two sorted arrays.
 * 
 * Example 1:  arr1 = [1, 3], arr2 =  [2]
 * Output: 2 (Middle item being returned)
 * 
 * Example 2:  arr1 = [1, 3, 5], arr2 =  [2, 4, 6]
 * Output: (3 + 4) / 2  ->  3.5 (Mean of middle items)
 * 
 * @author ranjithr
 *
 */
public class MedianOfTwoArrays {

	public static void main(String[] args) {
		int[] arr1 =  {1, 3, 5};
		int[] arr2 =  {2, 4, 6};
		
		int[] arr3 =  {1, 2, 4, 5, 5};
		int[] arr4 =  {7, 8, 8, 9};
		DecimalFormat format = new DecimalFormat("0.#");
		
		System.out.println(format.format(findMedian(arr1, arr2)));
		System.out.println(format.format(findMedian(arr3, arr4)));
	}
	
	private static float findMedian(int[] arr1, int[] arr2) {
		int[] mergedArr = mergeSortedArrays(arr1, arr2);
		int midIdx = mergedArr.length / 2;
		float median;		
		
		System.out.println(Arrays.toString(mergedArr));
		
		if(mergedArr.length % 2 == 0) {
			median = (float)(mergedArr[midIdx - 1] + mergedArr[midIdx]) / 2;
		}else {
			median = mergedArr[midIdx];
		}
		
		return median;
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
