package com.self.hackerrank;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the loyalty integer from given array of Integers.
 * All of the integers except one occur twice. That one is unique in the array
 * 
 * Example 1:  arr = [2, 2]
 * Output: 2 (There is only one element in the array, thus it is unique.)
 * 
 * Example 2:  arr = [0 0 1 4 1]
 * Output: 4 (We have two 0's, two 1's, and one 4. 4 is unique.)
 * 
 * @author ranjithr
 *
 */
public class LoyaltyInteger {

	public static void main(String[] args) {
		int[] arr1 =  {1, 1};
		int[] arr2 =  {2, 2, 4};
		
		System.out.println(findLoyaltyInteger(arr1));
		System.out.println(findLoyaltyInteger(arr2));
	}
	
	private static int findLoyaltyInteger(int[] arr) {
		if(arr.length == 2) {
			return arr[0];
		}
		
		Map<Integer, Integer> countDuplicateMap = new HashMap<Integer, Integer>();
		
		for(int item : arr) {
			if(countDuplicateMap.containsKey(item)) {
				int count = countDuplicateMap.get(item) + 1;
				
				countDuplicateMap.put(item, count);
			}else {
				countDuplicateMap.put(item, 1);
			}
		}
		
		int loyaltyNo = 0;
		
		for(Map.Entry<Integer, Integer> entry : countDuplicateMap.entrySet()) {
			if(entry.getValue() == 1) {
				loyaltyNo = entry.getKey();
				break;
			}
		}
		
		return loyaltyNo;
	}
}
