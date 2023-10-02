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
			System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\eclipseworkspace\\CucumberFramework\\Driver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			login.openLoginPage("https://automationteststore.com/index.php?rt=account/login");
			logInfo.pass("Open Chrome Browser and entered login page url");
			logInfo.addScreenCaptureFromPath(captureScreenshot(driver));
		}catch(AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@When("^valid \\\"(.*)\\\" and \\\"(.*)\\\" is entered$")
    public void when_valid_username_and_password_is_entered(String username,String password) throws Throwable{
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("When"),"when_valid_username_and_password_is_entered");
			login.enterUsername(username);
			login.enterPassword(password);
			logInfo.addScreenCaptureFromPath(captureScreenshot(driver));
		}catch(AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@Then("^User should be logged in successfully$")
	public void then_user_should_logged_in_successfully()  throws Throwable {
		ExtentTest logInfo = null;
		try {
			logInfo = test.createNode(new GherkinKeyword("Then"),"then_user_should_logged_in_successfully");
			login.user_click_Login_button();
			logInfo.addScreenCaptureFromPath(captureScreenshot(driver));
			}catch(AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);
		}	
	}
	
}
