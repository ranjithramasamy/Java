package com.self;

public class StringReverseWithSpecialChars {

	public static void main(String[] args) {
		String input = "a,b$fgd*";
		String output = reverse(input);
		String outputWithoutSpecialChars = reverseWithoutSpecialChars(input);
		
		System.out.println("Reversed String: " + output);
		System.out.println("Reversed String wihtout Special Characters: " + outputWithoutSpecialChars);
	}
	
	private static String reverse(String input) {
		if(input.length() == 1){
			return input;
		}
		
		return input.substring(input.length()-1) + reverse(input.substring(0, input.length()-1));
	}
	
	private static String reverseWithoutSpecialChars(String actual) {
		char[] strArr = actual.toCharArray();
		int start = 0;
		int end = strArr.length - 1;
		
		while(start < end){
			if(!Character.isAlphabetic(strArr[start])){
				start++;
			}else if(!Character.isAlphabetic(strArr[end])){
				end--;
			}else{
				char currChar = strArr[end];
				strArr[end] = strArr[start];
				strArr[start] = currChar;
				
				start++;
				end--;
			}
		}

		return String.valueOf(strArr);
	}
}
