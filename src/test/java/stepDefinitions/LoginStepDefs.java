package stepDefinitions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LoginStepDefs extends BasePage {

	WebDriver driver;
	public LoginStepDefs(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="loginFrm_loginname")
	private WebElement username;
	

	@FindBy(id="loginFrm_password")
	private WebElement password;
	

	@FindBy(xpath="//button[@title='Login']")
	private WebElement loginButton;
	
	public void openLoginPage(String expURL) {
		openURL(expURL);
	}

	public void enterUsername(String uname) {
		enterText(username,uname);
	}
	
	
	public void enterPassword(String passwd) {
		enterText(password,passwd);
	}
	
	public void user_click_Login_button() {
		click(loginButton);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
