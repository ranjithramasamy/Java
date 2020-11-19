package com.self.hackerrank;

import java.util.Iterator;
import java.util.Stack;

/**
 * Remove all the adjacent pairs which is duplicate in the given string by using Stack data structure.
 * 
 * Example 1:
 * Input: azxxzy
 * Output: ay
 * 
 * Example 2:
 * Input: acaaabbbacdddd
 * Output: acabac
 * 
 * @author ranjithr
 *
 */
public class RemoveAllDuplicatesPairsUsingStack {

	public static void main(String[] args) {
		String input = "caaabbbaacdddd";

		System.out.println("Output: " + removeAllAdjacentPairOfDuplicates(input));
	}

	private static String removeAllAdjacentPairOfDuplicates(String input) {
		Stack<Character> stack = new Stack<>();
		char[] inputToChars = input.toCharArray();

		for (char ch : inputToChars) {
			if (stack.isEmpty()) {
				stack.push(ch);
			} else {
				if (stack.peek().equals(ch)) {
					stack.pop();
				} else {
					stack.push(ch);
				}
			}
		}

		Iterator<Character> stackIterator = stack.iterator();
		StringBuilder output = new StringBuilder();

		while (stackIterator.hasNext()) {
			output.append(stackIterator.next());
		}

		return output.toString();
	}
}
