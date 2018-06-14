package stepDefinitions;
 
import com.cucumber.listener.Reporter;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import pageObjects.CartPage;
 
public class CartPageSteps {
	
	TestContext testContext;
	CartPage cartPage;
	
	public CartPageSteps(TestContext context) {
		testContext = context;
		cartPage = testContext.getPageObjectManager().getCartPage();
	}
	
	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart(){
		Reporter.addScenarioLog("Successfully navigate to mini cart.");
		cartPage.clickOn_Cart();
		Reporter.addStepLog("Successfully click to cart link");
		cartPage.clickOn_ContinueToCheckout();	
		Reporter.addStepLog("Successfully click to continue to checkout button");
	}
 
}
