package constants;

import java.text.SimpleDateFormat;

import managers.FileReaderManager;

public interface ApplicationConstants {
	public static String CLASSPATH = System.getProperty("user.dir");
	public static String REPORT_PATH = CLASSPATH + FileReaderManager.getInstance().getConfigReader().getReportConfigPath();
	public static String SET_REPORT_PATH = CLASSPATH + FileReaderManager.getInstance().getConfigReader().setReportConfigPath();
	//public static String PROPERTY_FILE_PATH = CLASSPATH + "\\configs\\Configuation.properties";
	public static String SCREENSHOT_PATH = CLASSPATH + FileReaderManager.getInstance().getConfigReader().getScreenShotPath();
	public static SimpleDateFormat REPORT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	public static String FILE_SEPARATOR = "\\";
	public static String HTML_EXTENSION = ".html";
	public static String PNG_EXTENSION = ".png";
	public static String PDF_EXTENSION = ".pdf";
	public static String ZIP_EXTENSION = ".zip";
	public static String JPG_EXTENSION = ".jpg";
	public static String XLSX_EXTENSION = ".xlsx";
	
}
