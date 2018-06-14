package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

import managers.FileReaderManager;
import testDataTypes.ProductDetails;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void perform_Search_For(String product) {
		driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl() + "/?s=" + product + "&post_type=product");
		Reporter.addStepLog("Successfully Search for the product : "+product);
	}
	
	public void perform_Search(ProductDetails product) {
		perform_Search_For(product.productName);
	}

	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		Reporter.addStepLog("Successfully navigate to : "+FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

}