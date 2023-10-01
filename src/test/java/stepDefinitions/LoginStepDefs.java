package com.cucumber.stepDefinitions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.cucumber.listeners.ExtentReportListener;
import com.cucumber.pageObject.Login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefs extends ExtentReportListener{

	//WebDriver driver = new ChromeDriver();
	public static WebDriver driver;
	Login login = new Login(driver);
	
	
	@Given("user on the Login Page")
	public void user_on_the_Login_Page() throws InterruptedException{
		ExtentTest logInfo = null;
		try {
			test = extent.createTest(Feature.class,"To test Login functionality");
			test = test.createNode(Scenario.class,"Scenario name");
			logInfo = test.createNode(new GherkinKeyword("Given"),"user_on_the_Login_Page");
			System.setProperty("webdriver.chromer.driver","C:\\Users\\admin\\eclipseworkspace\\CucumberFramework\\Driver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			login.openLoginPage("https://automationteststore.com/index.php?rt=account/login");
			logInfo.pass("Open Chrome Browser and entered login page url");
			logInfo.addScreenCaptureFromPath(captureScreenshot(driver));
		}catch(AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@Then("Verify page title {string}")
	public void Verify_page_title(String expTitle) {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("Then"),"Verify_page_title");
			String actTitle = login.getLoginPageTitle();
			Assert.assertTrue(actTitle.equalsIgnoreCase(expTitle));
			logInfo.addScreenCaptureFromPath(captureScreenshot(driver));
			driver.quit();
		}catch(AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@When("user enters validusername {string} and invalidpassword {string}")
	public void  user_enters_validusername_and_invalidpassword(String validuid,String invalidpwd){
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("When"),"user_enters_validusername_and_invalidpassword");
			login.enterUsername(validuid);
			login.enterPassword(invalidpwd);
			logInfo.addScreenCaptureFromPath(captureScreenshot(driver));
		}catch(AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@And("user clicks on Login button")
	public void user_clicks_on_Login_button() {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("And"),"user_clicks_on_Login_button");
			login.user_click_Login_button();
			logInfo.addScreenCaptureFromPath(captureScreenshot(driver));
			}catch(AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}	
	}
	
	@Then("verify validation message as {string}")
	public void verify_validation_message() {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("Then"),"verify_validation_message");
			login.getvalidationMessageText();
			logInfo.addScreenCaptureFromPath(captureScreenshot(driver));
			driver.quit();
			}catch(AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	
	@When("user enters username {string} and password {string}")
	public void  user_enters_username_and_password(String uid,String pwd){
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("When"),"user_enters_username_and_password");
			login.enterUsername(uid);
			login.enterPassword(pwd);
			logInfo.addScreenCaptureFromPath(captureScreenshot(driver));
		}catch(AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	
	@Then("verify page title {string}")
	public void verify_page_title(String expTitle) {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("Then"),"verify_page_title");
			String actTitle = login.getLoginPageTitle();
			Assert.assertTrue(actTitle.equalsIgnoreCase(expTitle));
			logInfo.addScreenCaptureFromPath(captureScreenshot(driver));
			}catch(AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
}
