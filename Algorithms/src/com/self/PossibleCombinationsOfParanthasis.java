package com.self;

import java.util.ArrayList;
import java.util.List;

public class PossibleCombinationsOfParanthasis {

	public static void main(String[] args) {
		int pairs = 3;
		List<String> result = new ArrayList<>();
		
		printAllPossibleParanthasis(pairs, pairs, "", result);
		
		System.out.println(result);
	}
	
	private static List<String> printAllPossibleParanthasis(int open, int close, String currPairs, List<String> result) {
		if(open == 0 && close  == 0) {
			result.add(currPairs);
		}
		
		if(open > close) {
			return null;
		}
		
		if(open > 0) {
			printAllPossibleParanthasis(open - 1, close, currPairs + "(", result);
		}
		
		if(close > 0) {
			printAllPossibleParanthasis(open, close - 1, currPairs + ")", result);
		}
		
		return result;
	}
}
