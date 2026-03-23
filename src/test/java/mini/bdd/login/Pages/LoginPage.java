package mini.bdd.login.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mini.bdd.login.Base.DriverFactory;

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;
			
			
	private By userNamefield = By.id("username");
	private By passwordfield = By.id("password");
	private By submitButton = By.id("submit");
	private By successmsg = By.xpath("//h1[contains(text(),'Logged In Successfully')]");
	private By errormsg = By.cssSelector("div[class^=\"show\"]");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	public void openUrl() { 
		String baseUrl=DriverFactory.getconfig("baseUrl");
		driver.get(baseUrl);
	}
	
	public void login(String userName, String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(userNamefield)).sendKeys(userName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordfield)).sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
	}
	
	public boolean isLoginSuccessfull() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(successmsg)).isDisplayed();
	}
	
	public boolean isErrorMsgDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(errormsg)).isDisplayed();
	}
	
	
}
