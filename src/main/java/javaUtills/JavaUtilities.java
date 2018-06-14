package javaUtills;

import java.util.Date;

import constants.ApplicationConstants;

public class JavaUtilities {
	
	public static String generateResultFilePath(final String baseFileName, final String extension) {
		return (baseFileName + "_" + ApplicationConstants.REPORT_DATE_FORMAT.format(new Date()) + extension);
	}
}
