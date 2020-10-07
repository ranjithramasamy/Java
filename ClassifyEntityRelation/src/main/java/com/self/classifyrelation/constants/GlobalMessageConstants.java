package com.self.classifyrelation.constants;

public class GlobalMessageConstants {
	// Error Messages
	public static final String ERROR_MSG_ILLEGAL_STATE_OF_CLASS_INITIALIZATION = "Illegal state of class initialization.";
	public static final String ERROR_MSG_INVALID_FILE_NAME = "Invalid file name [%s].";
	public static final String ERROR_MSG_FILE_NOT_FOUND = "File [%s] not found in [resources] folder path.";
	public static final String ERROR_MSG_UNABLE_TO_READ_INPUT_FILE = "Unable to process the given file [%s]. Reason: [%s]";
	public static final String ERROR_MSG_BLANK_ENTITY_RELATION = "The given entity list is empty.";
	public static final String ERROR_MSG_UNABLE_TO_WRITE_OUTPUT_FILE = "Unable to write csv file [%s], Reason: [%s]";
	
	// Success Messages
	public static final String MSG_INPUT_CSV_FILE_PROCESSED = "The given CSV file [%s] has processed successfully.";
	public static final String MSG_OUTPUT_CSV_FILE_GENERATED = "The output CSV file has generated successfully at [%s].";
	
	private GlobalMessageConstants() {
		throw new IllegalStateException(ERROR_MSG_ILLEGAL_STATE_OF_CLASS_INITIALIZATION);
	}
}
