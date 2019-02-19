package com.self;

import java.util.Arrays;

public class GradingStudents {

	public static void main(String[] args) {
		int[] input = {73, 67, 38, 33};
		int[] output = gradingStudents(input);
				
		System.out.println(Arrays.toString(output));
	}
	
	private static int[] gradingStudents(int[] grades) {
		int MOD_BASE_VAL = 5;
		int[] roundedGrades = new int[grades.length];
		
		for(int idx = 0; idx < grades.length; idx++) {
			int currGrade = grades[idx];
			
			if(currGrade < 38) {
				roundedGrades[idx] = currGrade;
			} else {
				int diff = MOD_BASE_VAL - (currGrade % MOD_BASE_VAL);
				
				if(diff < 3) {
					roundedGrades[idx] = currGrade + diff;
				}else {
					roundedGrades[idx] = currGrade;
				}
			}
		}
		
		return roundedGrades;
	}
}
