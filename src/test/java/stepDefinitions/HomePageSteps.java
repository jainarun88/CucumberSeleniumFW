package stepDefinitions;
 
import com.cucumber.listener.Reporter;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import pageObjects.HomePage;
import testDataTypes.ProductDetails;
 
public class HomePageSteps {
	
	TestContext testContext;
	HomePage homePage;
	
	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}
	
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page(){
		homePage.navigateTo_HomePage();	
		Reporter.addScenarioLog("Successfully navigate to Home Page");
	}
 
	@When("^he search for \\\"(.*)\\\"$")
	public void he_search_for(String productName)  {
		ProductDetails product = FileReaderManager.getInstance().getJsonReader().getProductByName(productName);
		Reporter.addScenarioLog("Searching for the : "+productName +" on home page.");
		homePage.perform_Search(product);
		Reporter.addStepLog("Successfully navigate to Product listing page.");
	}
 
}