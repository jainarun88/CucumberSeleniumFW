package stepDefinitions;
 
import com.cucumber.listener.Reporter;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import pageObjects.CheckoutPage;
import managers.FileReaderManager;
import testDataTypes.Customer;
 
public class CheckoutPageSteps {
	TestContext testContext;
	CheckoutPage checkoutPage;
	
	public CheckoutPageSteps(TestContext context) {
		testContext = context;
		checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
	}
	
	@When("^enter \\\"(.*)\\\" personal details on checkout page$")
	public void enter_personal_details_on_checkout_page(String customerName){
		Customer customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
		checkoutPage.fill_PersonalDetails(customer);	
		Reporter.addScenarioLog("Successfully filled details for : "+customer);
	}
	
	@When("^select same delivery address$")
	public void select_same_delivery_address(){
		checkoutPage.check_ShipToDifferentAddress(false);
		Reporter.addScenarioLog("Select same delivery address for billing.");
	}
	
	@When("^select payment method as \"([^\"]*)\" payment$")
	public void select_payment_method_as_payment(String arg1){
		checkoutPage.select_PaymentMethod("CheckPayment");
		Reporter.addScenarioLog("Select Payment method as : "+arg1);
	}
 
	@When("^place the order$")
	public void place_the_order() {
		checkoutPage.check_TermsAndCondition(true);
		Reporter.addScenarioLog("Accept Terms and Condition.");
		checkoutPage.clickOn_PlaceOrder();		
		Reporter.addScenarioLog("Successfully click to Place Order button.");
		Reporter.addScenarioLog("Successfully navigate to Confirmation page");
	}	

}