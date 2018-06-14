package stepDefinitions;

import org.testng.Assert;

import com.cucumber.listener.Reporter;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageObjects.ConfirmationPage;
import enums.Context;

public class ConfirmationPageSteps {
	TestContext testContext;
	ConfirmationPage confirmationPage;
	
	public ConfirmationPageSteps(TestContext context) {
		testContext = context;
		confirmationPage = testContext.getPageObjectManager().getConfirmationPage();
	}
	
	@Then("^verify the order details$")
	public void verify_the_order_details(){
		String productName = (String)testContext.scenarioContext.getContext(Context.PRODUCT_NAME);
		Reporter.addScenarioLog("Validating order details for :: "+productName);
		Assert.assertTrue(confirmationPage.getProductNames().stream().filter(x -> x.contains(productName)).findFirst().get().length()>0);	
		Reporter.addScenarioLog("Validating done successfully.");
	}
}
