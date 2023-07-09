package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
	
	WebDriver driver;


	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//common methods
	public void openURL(String url) {
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	public static void enterText(WebElement elm,String text) {
		elm.sendKeys(text);
	}
	
	public static void click(WebElement elm) {
		elm.click();
	}
	
	public static void clickOnLink(WebElement linkelm) {
		linkelm.click();
	}
	
	public static void enterValue(WebElement elmValue,String qtyValue) {
		int qty= Integer.parseInt(qtyValue);
		elmValue.sendKeys(String.valueOf(qty));
	}
	public String getTitle() {
		return driver.getTitle();
	}
	
	
	public void hoverAndClickElement(WebElement elm1,WebElement elm2) {
		elm1.click();
		elm2.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(elm1).click(elm2).build().perform();
		
	}
	
	public void validateText(WebElement elmText,String expectedText) {
		String actualText = elmText.getText();
		Assert.assertTrue("Expected Text:" + expectedText + "is not matching with actual text:" + actualText,
				expectedText.equals(actualText));
	}
}