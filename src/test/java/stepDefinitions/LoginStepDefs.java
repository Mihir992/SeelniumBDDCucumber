package com.cucumber.stepDefinitions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.pageObject.Login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefs{

	public WebDriver driver;
	Login login;
	
	@Given("user on the Login Page")
	public void user_on_the_Login_Page() throws InterruptedException{
		//ExtentTest logInfo = null;
		try {
			//test = extent.createTest(Feature.class,"To test Login functionality");
			//test = test.createNode(Scenario.class,"Test user Login with different credentials");
			//logInfo = test.createNode(new GherkinKeyword("Given"),"user_on_the_Login_Page");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			login = new Login(driver);
			//login.openLoginPage("https://automationteststore.com/index.php?rt=account/login");
			//driver.get("https://automationteststore.com/index.php?rt=account/login");
			//logInfo.pass("Open Chrome Browser and entered login page url");
			//logInfo.addScreenCaptureFromPath(captureScreenshot(driver));
		}catch(AssertionError | Exception e) {
			//testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@When("^User enter the Usename \"(.*)\" and Password \"(.*)\"$")
	public void valid_and_is_entered(String username,String password) throws Throwable{
		//ExtentTest logInfo = null;
		try {
			//logInfo = test.createNode(new GherkinKeyword("When"),"when_valid_username_and_password_is_entered");
			login = new Login(driver);
			login.clickOnUsernameTextField();;
			login.enterUsername(username);
			login.clickOnPasswordTextField();
			login.enterPassword(password);
			//logInfo.addScreenCaptureFromPath(captureScreenshot(driver));
		}catch(AssertionError | Exception e) {
			//testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully()  throws Throwable {
		//ExtentTest logInfo = null;
		try {
			//logInfo = test.createNode(new GherkinKeyword("Then"),"user_should_be_logged_in_successfully");
			login = new Login(driver);
			login.user_click_Login_button();
			login.getLoginPageTitle();
			//logInfo.addScreenCaptureFromPath(captureScreenshot(driver));
			}catch(AssertionError | Exception e) {
			//testStepHandle("FAIL",driver,logInfo,e);
		}	
	}
	
	@When("user click on Logoff icon")
	public void user_click_on_Logoff_icon() throws Throwable{
		//ExtentTest logInfo = null;
		try {
			//logInfo = test.createNode(new GherkinKeyword("When"),"when_valid_username_and_password_is_entered");
			login = new Login(driver);
			login.user_click_Logoff_button();
			//logInfo.addScreenCaptureFromPath(captureScreenshot(driver));
		}catch(AssertionError | Exception e) {
			//testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@And("click on Continue button")
	public void click_on_Continue_button() throws Throwable{
		//ExtentTest logInfo = null;
		try {
			//logInfo = test.createNode(new GherkinKeyword("When"),"when_valid_username_and_password_is_entered");
			login = new Login(driver);
			login.user_click_Continue_button();
			//logInfo.addScreenCaptureFromPath(captureScreenshot(driver));
		}catch(AssertionError | Exception e) {
			//testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	
	@Then("validate the Logout page title")
	public void validate_the_Logout_page_title()  throws Throwable {
		//ExtentTest logInfo = null;
		try {
			//logInfo = test.createNode(new GherkinKeyword("Then"),"user_should_be_logged_in_successfully");
			login = new Login(driver);
			login.getLogoutPageTitle();
			//logInfo.addScreenCaptureFromPath(captureScreenshot(driver));
			}catch(AssertionError | Exception e) {
			//testStepHandle("FAIL",driver,logInfo,e);
		}	
	}
}
