package stepDefinitions;

import com.cucumber.listener.Reporter;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import enums.Context;
import pageObjects.ProductListingPage;

public class ProductPageSteps {

	TestContext testContext;
	ProductListingPage productListingPage;

	public ProductPageSteps(TestContext context) {
		testContext = context;
		productListingPage = testContext.getPageObjectManager().getProductListingPage();
	}

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() {
		//for verification purpose
		String productName = productListingPage.getProductName(0); 
		testContext.scenarioContext.setContext(Context.PRODUCT_NAME, productName);
		Reporter.addScenarioLog("Successfully choose : "+productName+" for buy.");
		productListingPage.select_Product(0);
		Reporter.addScenarioLog("First Product select successfully");
		productListingPage.clickOn_AddToCart();		
		Reporter.addScenarioLog("Successfully navigate to cart page.");
	}
}