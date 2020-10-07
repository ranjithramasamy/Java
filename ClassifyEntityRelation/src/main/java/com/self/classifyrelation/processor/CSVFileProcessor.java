package com.self.classifyrelation.processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.self.classifyrelation.constants.GlobalConstants;
import com.self.classifyrelation.constants.GlobalMessageConstants;
import com.self.classifyrelation.model.EntityRelation;
import com.self.classifyrelation.utils.CommonUtils;

/**
 * 1. Load and extract the CSV file then return the entities as a List. 2. Write
 * the grouped entities into CSV file.
 * 
 * @author ranjithr
 *
 */
public class CSVFileProcessor {
	private static final Logger logger = LoggerFactory.getLogger(CSVFileProcessor.class);
	private static final CommonUtils commonUtils = new CommonUtils();

	private CSVFileProcessor() {
		throw new IllegalStateException(GlobalMessageConstants.ERROR_MSG_ILLEGAL_STATE_OF_CLASS_INITIALIZATION);
	}

	/**
	 * Load and extract the entities from CSV file
	 * 
	 * @param fileName
	 * @return
	 */
	public static List<EntityRelation> loadAndExtractFromCsv(String fileName) {
		if (null == fileName) {
			throw new IllegalArgumentException(
					String.format(GlobalMessageConstants.ERROR_MSG_INVALID_FILE_NAME, fileName));
		}

		List<EntityRelation> extractedEntityListFromCsv = null;

		try (BufferedReader br = new BufferedReader(new FileReader(commonUtils.getQualifiedUrlPath(fileName)))) {
			String records = null;
			boolean firstRow = true;
			extractedEntityListFromCsv = new ArrayList<>();

			while ((records = br.readLine()) != null) {
				// Ignoring the header which is the first line from CSV
				if (!firstRow) {
					String[] values = records.split(GlobalConstants.COMMA_DELIMITER);

					extractedEntityListFromCsv
							.add(new EntityRelation(Integer.valueOf(values[0]), Integer.valueOf(values[1])));
				}

				firstRow = false;
			}
			logger.info(String.format(GlobalMessageConstants.MSG_INPUT_CSV_FILE_PROCESSED, fileName));
		} catch (IOException ex) {
			logger.error(String.format(GlobalMessageConstants.ERROR_MSG_UNABLE_TO_READ_INPUT_FILE, fileName,
					ex.getMessage()));
		}

		return extractedEntityListFromCsv;
	}
	
	/**
	 * Write the given groups into CSV file.
	 * 
	 * @param groupedEntityList
	 */
	public static void writeToCsv(List<Set<Integer>> groupedEntityList) {
		try (PrintWriter writer = new PrintWriter(new File(GlobalConstants.OUTPUT_CSV_FILE_NAME))) {
			StringBuilder sb = new StringBuilder();
			sb.append(GlobalConstants.OUTPUT_CSV_COLUMN_HEADER);
			sb.append(GlobalConstants.NEWLINE_DELIMITER);

			for (Set<Integer> groupedEntity : groupedEntityList) {
				sb.append(escapeSpecialCharacters(groupedEntity.toString()));
				sb.append(GlobalConstants.NEWLINE_DELIMITER);
			}

			writer.write(sb.toString());
			writer.flush();
			logger.info(String.format(GlobalMessageConstants.MSG_OUTPUT_CSV_FILE_GENERATED,
					GlobalConstants.OUTPUT_CSV_FILE_NAME));
		} catch (FileNotFoundException ex) {
			logger.error(String.format(GlobalMessageConstants.ERROR_MSG_UNABLE_TO_WRITE_OUTPUT_FILE,
					GlobalConstants.OUTPUT_CSV_FILE_NAME, ex.getMessage()));
		}
	}

	/**
	 * Escape the special characters before writing into CSV file
	 * 
	 * @param data
	 * @return
	 */
	private static String escapeSpecialCharacters(String data) {
		String escapedData = data.replaceAll("\\R", " ");

		if (data.contains(",")) {
			data = data.replace("\"", "\"\"");
			escapedData = "\"" + data + "\"";
		}
		return escapedData;
	}
}
