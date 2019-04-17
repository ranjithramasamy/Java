package com.self.hackerrank;

import java.util.Arrays;
/**
 *
 * Every student receives a grade in the inclusive range from 0 to 100.
 * Any grade less than 40 is a failing grade.
 * 
 * Sam is a professor at the university and likes to round each student's grade according to these rules:
 * 		If the difference between the grade and the next multiple of 5 is less than 3, round grade up to the next multiple of 5.
 *		If the value of grade is less than 38, no rounding occurs as the result will still be a failing grade.
 *
 * 	For example, grade = 84 will be rounded to 85 but grade = 29 will not be rounded because the rounding would result in a number that is less than 40.
 * 
 * Given the initial value of  for each of Sam's  students, write code to automate the rounding process.
 * 
 * Example:
 * Input:	73, 67, 38, 33
 * Output:	75, 67, 40, 33
 * 
 * @author ranjithr
 *
 */
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
