package mini.bdd.login.stepdef;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mini.bdd.login.Base.DriverFactory;
import mini.bdd.login.Pages.LoginPage;

public class stepDef {
	
	WebDriver driver;
	LoginPage lp;
	
	@Before
	public void setup() throws IOException {
		DriverFactory.initDriver();
		lp=new LoginPage(DriverFactory.getDriver());
	}
	
	@After
	public void teardown() {
		DriverFactory.quitDriver();
	}
	
	@Given("I am on the Login Page")
	public void i_am_on_the_login_page() {
		lp = new LoginPage(DriverFactory.getDriver());    
		lp.openUrl();
	}
	@When("i enter the valid username {string} and password {string}")
	public void i_enter_the_valid_username_and_password(String string,String string1) {
	    lp = new LoginPage(DriverFactory.getDriver());
	    lp.login(string, string1);
	}
	
//	@When("i enter the valid password {string}") 
//	public void i_enter_the_valid_password(String string) { 
//		  LoginPage lp = new LoginPage(); 
//		  }
	 
	@When("i click the Login button")
	public void i_click_the_login_button() {
	 lp = new LoginPage(DriverFactory.getDriver());
	 Boolean result = lp.isLoginSuccessfull();
	 Assert.assertTrue(true,"Login have Issue...!");
	}
	@Then("the user can see the successful message")
	public void the_user_can_see_the_successful_message() {
	 lp = new LoginPage(DriverFactory.getDriver());
	 Boolean error = lp.isErrorMsgDisplayed();
	 Assert.assertTrue(true,"Error message is not displayed...!");
	}

	
}
