package com.self.hackerrank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Evaluate the given string is palindrome or not.
 * @author ranjithr
 *
 */
public class Palindrome {
	public static void main(String[] args) {
		String input = "A man, a plan, a canal. Panama";
		boolean palindrome = isPalindrome(input.toCharArray());
		
		System.out.println("isPalindrome: " + palindrome);
	}
	
	private static boolean isPalindrome(char[] input) {
		boolean isPalindrome = true;
		int start = 0;
		int end = input.length - 1;
		Pattern regex = Pattern.compile("[^A-Za-z0-9]");
				
		while(start < end){
			boolean posChanged = false;
			Matcher smatch = regex.matcher(String.valueOf(input[start]));
			Matcher ematch = regex.matcher(String.valueOf(input[end]));

			if(smatch.find()) {
				start++;
				posChanged = true;
			}
			
			if(ematch.find()) {
				end--;
				posChanged = true;
			}
			
			if(String.valueOf(input[start]).equalsIgnoreCase(String.valueOf(input[end]))) {
				start++;
				end--;
			} else if(!posChanged) {
				isPalindrome = false;
				break;
			}
		}
		
		return isPalindrome;
	}
}
