package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;

public class ShoppingCartStepDefs extends BasePage{
	
	WebDriver driver;
	public ShoppingCartStepDefs(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//*[@id='categorymenu']/nav/ul/li[2]/a")
	private WebElement linkmenuApparelAccessories;
	
	@FindBy(xpath="//*[@id='categorymenu']/nav/ul/li[2]/div/ul[1]/li[2]/a")
	private WebElement linkmenuTShirt;
	
	@FindBy(xpath="//a[text()='Designer Men Casual Formal Double Cuffs Grandad Band Collar Shirt Elegant Tie']")
	private WebElement linkProductName;
	
	@FindBy(xpath="//span[text()='Designer Men Casual Formal Double Cuffs Grandad Band Collar Shirt Elegant Tie']")
	private WebElement txtProductName;
	
	@FindBy(xpath="//div[@id='product_details']/div/div[2]//following-sibling::div/div[@class='productfilneprice']")
	private WebElement txtProductPrice;
	
	@FindBy(xpath="//form[@id='product']/fieldset/div[4]/label/span[@class='total-price']")
	private WebElement txtTotalPrice;
	
	@FindBy(id="product_quantity")
	private WebElement txtQty;
	
	
	@FindBy(xpath="//a[@class='cart']")
	private WebElement btnAddToCart;
	
	
	public void clickOnTshirtsMenu(){
		hoverAndClickElement(linkmenuApparelAccessories, linkmenuTShirt);
	}
	
	public void clickOnProductNameLink() {
		clickOnLink(linkProductName);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void validateProductNameText(String expProductNameText) {
		validateText(txtProductName, expProductNameText);
	}
	
	//public void validateProductNamePrice(String expProductNamePrice) {
		//validateText(txtProductName, expProductNameText);
	//}
	
	public void enterQuantity(String productQuantity) {
		enterValue(txtQty,productQuantity);
	}
	  
	public void clickonCartButton() {
		click(btnAddToCart);
	}
	
	public String getShoppingCartPageTitle() {
		return driver.getTitle();
	}
	  
}
