/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitions.LoginStepDefs;

/**
 * 
 */
public class Login extends BasePage{

	public Login(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	//private LoginStepDefs login = new LoginStepDefs(driver);
	
	@FindBy(xpath="//input[@id='loginFrm_loginname']")
	private WebElement username;
	

	@FindBy(xpath="//div[@class='form-group']//input[@id='loginFrm_password']")
	private WebElement password;
	

	@FindBy(xpath="//form[@id='loginFrm']/fieldset/button")
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
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}	
}
