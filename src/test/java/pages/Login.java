/**
 * 
 */
package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitions.LoginStepDefs;

/**
 * 
 */
public class Login{

	WebDriver driver = new ChromeDriver();
	LoginStepDefs login = new LoginStepDefs(driver);
	
	
	@Given("user on the Login Page")
	public void user_on_the_Login_Page() {
		driver.manage().window().maximize();
		login.openLoginPage("https://automationteststore.com/");
	}

	@Then("Verify page title {string}")
	public void Verify_page_title(String expAccountLoginTitle) {
		String actAccountLoginPageTitle = login.getPageTitle();
		Assert.assertEquals(actAccountLoginPageTitle,expAccountLoginTitle,"Page Title is not getting matched");
	}

	@When("user enters username {string} and password {string}")
	public void  user_enters_username_and_password(String uid,String pwd){
		login.enterUsername(uid);
		login.enterPassword(pwd);
		
	}
	
	@And("user clicks on Login button")
	public void user_clicks_on_Login_button() {
		login.user_click_Login_button();
	}
	
	@Then("verify page title {string}")
	public void verify_page_title(String expMyAccountTitle) {
		String actMyAccountPageTitle = login.getPageTitle();
		Assert.assertEquals(actMyAccountPageTitle,expMyAccountTitle,"Page Title is not getting matched");
	}
	
}
