package com.self.hackerrank;

import java.util.HashSet;
import java.util.Set;

/**
 * Find a given string has duplicate letter and 
 * return 'true' if it has duplicates else return 'false'.
 * 
 * Example:
 * Input:  	'learnersbucket'
 * Output:	true
 * 
 * Input:  	'abcdefghijk'
 * Output:	true
 * 
 * @author ranjithr
 *
 */
public class FindStringHasDuplicatesOrNot {

	public static void main(String[] args) {		
		String input = "learnersbucket";
		String input1 = "abcdefghijk";
		boolean lower = true;
		
		System.out.println(approach1(input, lower));
		System.out.println(approach1(input1, lower));
		
		System.out.println(approach2(input));
		System.out.println(approach2(input1));
	}
	
	private static boolean approach1(String input, boolean lower) {
		int[] visited = new int[25];
		char lowerChar = lower ? 'a' : 'A';
		
		for(char currChar : input.toCharArray()) {
			int pos = currChar - lowerChar;
			
			if(visited[pos] == 0) {
				visited[pos] = 1;
			}else {
				return true;
			}
		}
		
		return false;
	}

	private static boolean approach2(String input) {
		Set<String> hashSet = new HashSet<>();
		int idx = 0;
		
		while(idx < input.length()) {
			String temp = input.substring(idx, ++idx);
			
			if(!hashSet.add(temp)) {
				return true;
			}
		}
		
		return false;
	}
}
