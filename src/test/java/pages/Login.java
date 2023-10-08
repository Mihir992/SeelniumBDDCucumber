/**
 * 
 */
package com.cucumber.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login extends BasePage{
	WebDriver driver;
	
	public Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
		driver.get("https://automationteststore.com/index.php?rt=account/login");
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//input[@id='loginFrm_loginname']")
	private WebElement username;
	

	@FindBy(xpath="//div[@class='form-group']//input[@id='loginFrm_password']")
	private WebElement password;
	

	@FindBy(xpath="//form[@id='loginFrm']/fieldset/button")
	private WebElement loginButton;
	
	@FindBy(xpath="//a[@title='Continue']")
	private WebElement ContinueButton;
	
	@FindBy(xpath="//i[@class='fa fa-lock fa-fw']")
	private WebElement logoffButton;
	
	//@FindBy(xpath="//div[@class='alert alert-error alert-danger']")
	//private WebElement validationMessage;
	
	
	public void openLoginPage(String expURL) {
		openURL(expURL);
	}

	public void clickOnUsernameTextField() {
		txtElementClick(username);
	}
	
	public void enterUsername(String uname) {
		enterText(username,uname);
	}
	
	public void clickOnPasswordTextField() {
		txtElementClick(password);
	}
	
	public void enterPassword(String passwd) {
		enterText(password,passwd);
	}
	
	public void user_click_Login_button() {
		click(loginButton);
	}
	
	public void user_click_Logoff_button() {
		click(logoffButton);
	}
	
	public void user_click_Continue_button() {
		click(ContinueButton);
	}
	
	/*public void getvalidationMessageText()
	{
		validationMessage.getText();
	}*/
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String getLogoutPageTitle() {
		return driver.getTitle();
	}
}
