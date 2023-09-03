package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.AddProductToShoppingCart;

public class ShoppingCartStepDefs{

	WebDriver driver = new ChromeDriver();
	AddProductToShoppingCart sp = new AddProductToShoppingCart(driver);
	
	
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
