package com.self.hackerrank;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Find the median of unsorted array.
 * 
 * Example 1:  arr1 = [0, 1, 2, 4, 6, 5, 3]
 * Output: 3 (Middle element after sorting)
 * 
 * Example 2:  arr1 = [2, 1, 4, 7, 5, 8, 3, 6]
 * Output: (4 + 5) / 2  ->  4.5 (Mean of middle items after applying the sorting)
 * 
 * @author ranjithr
 *
 */
public class MedianOfUnsortedArray {

	public static void main(String[] args) {
		int[] arr1 =  {0, 1, 2, 4, 6, 5, 3};
		int[] arr2 =  {2, 1, 4, 7, 5, 8, 3, 6};
		DecimalFormat format = new DecimalFormat("0.#");
		
		System.out.println(format.format(findMedian(arr1)));
		System.out.println(format.format(findMedian(arr2)));
	}
	
	private static float findMedian(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
		
		int midIdx = arr.length / 2;
		float median;		
		
		System.out.println(Arrays.toString(arr));
		
		if(arr.length % 2 == 0) {
			median = (float)(arr[midIdx - 1] + arr[midIdx]) / 2;
		}else {
			median = arr[midIdx];
		}
		
		return median;
	}
	
	public static void quickSort(int arr[], int begin, int end){
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            // Recursively sort elements of the 2 sub-arrays
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int arr[], int begin, int end){
        int pivot = arr[end];
        int i = (begin-1);

        for (int j=begin; j<end; j++){
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}
