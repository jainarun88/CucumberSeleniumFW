package runners;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import constants.ApplicationConstants;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import javaUtills.JavaUtilities;

@CucumberOptions(
		features = "src/test/java/resources/functionalTestFeatures",
		glue= {"stepDefinitions"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"},
		monochrome = true
		)


public class TestRunner extends AbstractTestNGCucumberTests {
	@BeforeClass
	public  static void setup() {
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		//	        extentProperties.setExtentXServerUrl("http://localhost:1337");
		//	        extentProperties.setProjectName("TestNGProject");
		extentProperties.setReportPath(JavaUtilities.generateResultFilePath(ApplicationConstants.SET_REPORT_PATH, ApplicationConstants.HTML_EXTENSION));
	}


	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(ApplicationConstants.REPORT_PATH));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", 	"Windows 10" + " 64 Bit");
		Reporter.setSystemInfo("Selenium", "3.8.1");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Java Version", "1.8.0_151");
		Reporter.setTestRunnerOutput("Sample test runner output message");
	}
}
