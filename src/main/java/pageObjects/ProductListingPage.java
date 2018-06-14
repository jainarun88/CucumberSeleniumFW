package pageObjects;
 
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

import selenium.Wait;
 
public class ProductListingPage {
	WebDriver driver;
	
	public ProductListingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CSS, using = "button.single_add_to_cart_button") 
	private WebElement btn_AddToCart;
	
	@FindAll(@FindBy(how = How.CSS, using = ".noo-product-inner"))
	private List<WebElement> prd_List;	
	
	public void clickOn_AddToCart() {
		btn_AddToCart.click();
		Reporter.addStepLog("Successfully click on add to cart button.");
		Wait.untilJqueryIsDone(driver);
	}
	
	public void select_Product(int productNumber) {
		prd_List.get(productNumber).click();
		Reporter.addStepLog("Successfully click on product.");
	}
	
	public String getProductName(int productNumber) {
		Reporter.addStepLog("Successfully get product name as : "+prd_List.get(productNumber).findElement(By.cssSelector("h3")).getText());
		return prd_List.get(productNumber).findElement(By.cssSelector("h3")).getText();
	}
 
}