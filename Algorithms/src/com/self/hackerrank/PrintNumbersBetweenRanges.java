package com.self.hackerrank;

import java.util.Set;
import java.util.TreeSet;

/**
 * Print all possible numbers between the range then return the output in sorted
 * order and without duplicates.
 * 
 * Example: Input: "1", "11-17", "8", "7-9", "13-18" 		Output: 1, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18
 * 
 * @author ranjithr
 *
 */
public class PrintNumbersBetweenRanges {
	public static void main(String[] args) {
		String[] input = { "1", "11-17", "8", "7-9", "13-18" };
		
		System.out.println("Expanded Values: " + printExpandedValues(input));
	}

	private static Set<Integer> printExpandedValues(String[] input) {
		Set<Integer> output = new TreeSet<>();

		for (String range : input) {
			expandRange(range, output);
		}

		return output;
	}

	private static void expandRange(String range, Set<Integer> output) {
		if (range.indexOf('-') == -1) {
			output.add(Integer.parseInt(range));
		} else {
			String[] tempRangeArr = range.split("-");
			int start = Integer.parseInt(tempRangeArr[0]);
			int end = Integer.parseInt(tempRangeArr[1]);

			for (int idx = start; idx <= end; idx++) {
				output.add(idx);
			}
		}
	}
}
