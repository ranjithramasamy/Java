package com.self.classifyrelation;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.self.classifyrelation.model.EntityRelation;
import com.self.classifyrelation.processor.ClassifyEntityRelationProcessor;

/**
 * Classify entity relation tests
 * 
 * @author ranjithr
 *
 */
public class ClassifyEntityRelationTest {

	@Test
    public void assertComputedGroupsListReturnsSizeOfTwo() {
		List<Integer> relationA = Arrays.asList(1, 3, 5, 3, 4);
		List<Integer> relationB = Arrays.asList(2, 4, 10, 1, 3);
		List<EntityRelation> extractedEntityListFromCsv = new ArrayList<>();
		
		for(int idx = 0; idx < relationA.size(); idx++) {
			extractedEntityListFromCsv
			.add(new EntityRelation(relationA.get(idx), relationB.get(idx)));
		}
		
		List<Set<Integer>> expectedList = new ArrayList<>();
		Set<Integer> group1 = new HashSet<>();
		Set<Integer> group2 = new HashSet<>();
		
		group1.add(1);
		group1.add(2);
		group1.add(3);
		group1.add(4);
		
		group2.add(5);
		group2.add(10);
		
		expectedList.add(group1);
		expectedList.add(group2);
		
		List<Set<Integer>> computedList = ClassifyEntityRelationProcessor.classifyEntityRelation(extractedEntityListFromCsv);
		
		assertEquals(2, computedList.size());
		assertEquals(expectedList.get(0), computedList.get(0));
		assertEquals(expectedList.get(1), computedList.get(1));
    }
	
	@Test
    public void assertComputedGroupsListReturnsSizeOfFour() {
		List<Integer> relationA = Arrays.asList(1, 5, 2, 6, 7, 9);
		List<Integer> relationB = Arrays.asList(5, 3, 4, 2, 8, 10);
		List<EntityRelation> extractedEntityListFromCsv = new ArrayList<>();
		
		for(int idx = 0; idx < relationA.size(); idx++) {
			extractedEntityListFromCsv
			.add(new EntityRelation(relationA.get(idx), relationB.get(idx)));
		}
		
		List<Set<Integer>> expectedList = new ArrayList<>();
		Set<Integer> group1 = new HashSet<>();
		Set<Integer> group2 = new HashSet<>();
		Set<Integer> group3 = new HashSet<>();
		Set<Integer> group4 = new HashSet<>();

		group1.add(1);
		group1.add(3);
		group1.add(5);
		
		group2.add(2);		
		group2.add(4);
		group2.add(6);
		
		group3.add(7);
		group3.add(8);
		
		group4.add(9);		
		group4.add(10);
		
		expectedList.add(group1);
		expectedList.add(group2);
		expectedList.add(group3);
		expectedList.add(group4);
		
		List<Set<Integer>> computedList = ClassifyEntityRelationProcessor.classifyEntityRelation(extractedEntityListFromCsv);
		
		assertEquals(4, computedList.size());
		assertEquals(expectedList.get(0), computedList.get(0));
		assertEquals(expectedList.get(1), computedList.get(1));
		assertEquals(expectedList.get(2), computedList.get(2));
		assertEquals(expectedList.get(3), computedList.get(3));
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void assertEmptyListExceptionThrownIfExtractedListPassedAsEmpty() {
		List<EntityRelation> extractedEntityListFromCsv = new ArrayList<>();
		
		ClassifyEntityRelationProcessor.classifyEntityRelation(extractedEntityListFromCsv);
	}
}
