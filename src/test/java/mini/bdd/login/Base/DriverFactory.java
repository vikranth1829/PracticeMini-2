package mini.bdd.login.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class DriverFactory {
	private static WebDriver driver;
	private static Properties config;
	static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	


	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	public static void loadConfig() throws IOException {
	
		if(config==null) 
		{
		config = new Properties();
		FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
		config.load(fis);
		}
	}

	public static String getconfig(String key) {
		return config.getProperty(key);
	}
	
	public static void initDriver() throws IOException {
	
		if(driver==null) {
			loadConfig();
			String baseUrl = config.getProperty("baseUrl");
			String browserName = config.getProperty("browserName");
		
			if(browserName==null || browserName.isEmpty()) 
			{
			browserName="chrome";
			}
		
		switch (browserName.toLowerCase()) {
		case "chrome":
			tlDriver.set(new ChromeDriver());
			break;
			
		case "edge":
			tlDriver.set(new EdgeDriver());
			break;
			
		case "firefox":
			tlDriver.set(new FirefoxDriver());
			break;
		}
		getDriver().manage().window().maximize();
		
		}
	}
	
	public static void quitDriver() {
		if(getDriver()!=null) {
			getDriver().quit();
			tlDriver.remove();
		}
	}
}
