package com.self.classifyrelation.processor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.self.classifyrelation.constants.GlobalMessageConstants;
import com.self.classifyrelation.model.EntityRelation;
import com.self.classifyrelation.utils.DisjointSets;

/**
 * Process the entities from given list and group the related items
 * 
 * @author ranjithr
 *
 */
public class ClassifyEntityRelationProcessor {
	private static DisjointSets disjointSetsUtil = new DisjointSets();
	
	private ClassifyEntityRelationProcessor() {
		throw new IllegalStateException(GlobalMessageConstants
				.ERROR_MSG_ILLEGAL_STATE_OF_CLASS_INITIALIZATION);
	}
	
	/**
	 * Process the given entities and group the relation
	 * 
	 * @param extractedEntityListFromCsv
	 * @return
	 */
	public static List<Set<Integer>> classifyEntityRelation(List<EntityRelation> extractedEntityListFromCsv) {
		if(null == extractedEntityListFromCsv || extractedEntityListFromCsv.isEmpty()) {
			throw new IllegalArgumentException(GlobalMessageConstants.ERROR_MSG_BLANK_ENTITY_RELATION);
		}
		
		initalizeElements(extractedEntityListFromCsv);

		for(EntityRelation entity : extractedEntityListFromCsv) {
			disjointSetsUtil.union(entity.getRelationA(), entity.getRelationB());
		}
		
		return disjointSetsUtil.group();
	}
	
	/**
	 * Initialize the element into disjoint set
	 * 
	 * @param extractedEntityListFromCsv
	 */
	private static void initalizeElements(List<EntityRelation> extractedEntityListFromCsv) {
		Set<Integer> uniqueEntities = new HashSet<>();
		disjointSetsUtil.clear();
		
		for(EntityRelation entity : extractedEntityListFromCsv) {
			uniqueEntities.add(entity.getRelationA());
			uniqueEntities.add(entity.getRelationB());
		}
		
		for(Integer item : uniqueEntities) {
			disjointSetsUtil.initialize(item);
		}
	}
}
