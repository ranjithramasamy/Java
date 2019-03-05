package com.self;

public class RemoveDuplicateOfString {

	public static void main(String[] args) {		
		String input = "geeksforgeeks";
		boolean lower = true;
		
		System.out.println(approach1(input, lower));
	}
	
	private static String approach1(String input, boolean lower) {
		int[] visited = new int[25];
		StringBuilder output = new StringBuilder();
		int idx = 0;
		char lowerChar = lower ? 'a' : 'A';
		
		while(idx < input.length()) {
			char current = input.charAt(idx++);
			int pos = current - lowerChar;

			if(visited[pos] == 0) {
				visited[pos] = 1;
				output.append(current);
			}
		}
		
		return output.toString();
	}

}
