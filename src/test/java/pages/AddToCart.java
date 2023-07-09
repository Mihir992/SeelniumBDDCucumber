/**
 * 
 */
package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitions.ShoppingCartStepDefs;

/**
 * 
 */
public class AddToCart {
	
	WebDriver driver = new ChromeDriver();
	ShoppingCartStepDefs sp = new ShoppingCartStepDefs(driver);
	
	
	@Given("user clicks on Tshirts")
	public void user_clicks_on_Tshirts(){
		sp.clickOnTshirtsMenu();
	}
	
	@When("user clicks on {string} product name")
	public void user_clicks_on_product_name() {
		sp.clickOnProductNameLink();
	}
	
	@Then("Verify the page title {string} product")
	public void Verify_the_page_title_product() {
		sp.getPageTitle();
	}
	
	@And("validate the product name text")
	public void validateProductName() {
		
	}
	  
	@And("validate the product price")
	public void validateProductPrice() {
		
	}
	  
	@And("user enters the quantity {string}")
	public void user_enters_the_quantity(String qty) {
		sp.enterQuantity(qty);
	}
	
	@When("user click on Add to Cart button")
	public void user_click_on_AddtoCart_button() {
		sp.clickonCartButton();
	}
	
	@Then("Verify the page title {string}")
	public void Verify_the_page_title(String expShoppingCartTitle) {
		String actShoppingCartPageTitle = sp.getShoppingCartPageTitle();
		Assert.assertEquals(actShoppingCartPageTitle,expShoppingCartTitle,"Page Title is not getting matched");
	}
	
	
}
