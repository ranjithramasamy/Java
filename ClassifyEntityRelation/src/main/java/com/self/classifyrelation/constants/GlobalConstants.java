package com.self.classifyrelation.constants;

public class GlobalConstants {
	  public static final String INPUT_CSV_FILE_NAME = "input.csv";
	  public static final String OUTPUT_CSV_FILE_NAME = "output.csv";
	  public static final String COMMA_DELIMITER = ",";
	  public static final String NEWLINE_DELIMITER = "\n";
	  
	  public static final String OUTPUT_CSV_COLUMN_HEADER = "Groups";	  
	  
	  private GlobalConstants() {
			throw new IllegalStateException(GlobalMessageConstants
					.ERROR_MSG_ILLEGAL_STATE_OF_CLASS_INITIALIZATION);
		}
}
