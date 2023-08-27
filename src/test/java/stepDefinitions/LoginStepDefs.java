package stepDefinitions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.Login;

public class LoginStepDefs extends BasePage {

	//WebDriver driver;
	public LoginStepDefs(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	WebDriver driver = new ChromeDriver();
	public Login login = new Login(driver);
	
	
	@Given("user on the Login Page")
	public void user_on_the_Login_Page(){
		driver.manage().window().maximize();
		login.openLoginPage("https://automationteststore.com/index.php?rt=account/login");
		
	}

	@Then("Verify page title {string}")
	public void Verify_page_title(String expTitle) {
		String actTitle = login.getLoginPageTitle();
		Assert.assertTrue(actTitle.equalsIgnoreCase(expTitle));
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
	public void verify_page_title(String expTitle) {
		String actTitle = login.getLoginPageTitle();
		Assert.assertTrue(actTitle.equalsIgnoreCase(expTitle));
	}


}
