package com.cucumber.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BasePage {
	
	WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	//common methods
	public void openURL(String url) {
		driver.get(url);	
	}
	
	public static void enterText(WebElement elm,String text) {
		//elm.clear(text);
		elm.clear();
		elm.sendKeys(text);
	}
	
	public void txtElementClick(WebElement txtelement) {
		txtelement.click();
	}
	
	
	public static void click(WebElement elm) {
		elm.click();
	}
	
	public static void clickOnLink(WebElement linkelm) {
		linkelm.click();
	}	
	
	public String getTitle(WebDriver driver) {
		boolean flag = false;

		String text = driver.getTitle();
		if (flag) {
			System.out.println("Title of the page is: \""+text+"\"");
		}
		return text;
	}

	
	public void hoverAndClickElement(WebElement elm1,WebElement elm2) {
		elm1.click();
		elm2.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(elm1).click(elm2).build().perform();
		
	}
	
	/*public static void enterValue(WebElement elmValue,String qtyValue) {
		int qty= Integer.parseInt(qtyValue);
		elmValue.sendKeys(String.valueOf(qty));
	}*/
	
	public void validateText(WebElement elmText,String expectedText) {
		String actualText = elmText.getText();
		Assert.assertTrue(expectedText.equalsIgnoreCase(actualText));
	}
}
