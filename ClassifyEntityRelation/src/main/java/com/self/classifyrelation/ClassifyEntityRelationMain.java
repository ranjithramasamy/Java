package com.self.classifyrelation;

import java.util.List;
import java.util.Set;

import com.self.classifyrelation.constants.GlobalConstants;
import com.self.classifyrelation.model.EntityRelation;
import com.self.classifyrelation.processor.CSVFileProcessor;
import com.self.classifyrelation.processor.ClassifyEntityRelationProcessor;

/**
 * Main Class
 * 
 * @author ranjithr
 *
 */
public class ClassifyEntityRelationMain {
	
	public static void main(String[] args) {
		// Load and extract from given CSV file.
		List<EntityRelation> extractedEntityListFromCsv = CSVFileProcessor.loadAndExtractFromCsv(GlobalConstants.INPUT_CSV_FILE_NAME);
		
		// Group the entities based on the relation
		List<Set<Integer>> groupedEntityList = ClassifyEntityRelationProcessor.classifyEntityRelation(extractedEntityListFromCsv);
		
		// Write the grouped entities into CSV file.
		CSVFileProcessor.writeToCsv(groupedEntityList);
	}
}
