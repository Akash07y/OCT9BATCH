package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Base {
	
	public static WebDriver openChromeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Automation Class\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver openFirefoxBrowser() {
		
		System.setProperty("webdriver.gecko.driver", "F:\\Automation Class\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
	public static WebDriver openOperaBrowser() {
		
		System.setProperty("webdriver.opera.driver", "F:\\Automation Class\\operadriver.exe");
		WebDriver driver = new OperaDriver();
		return driver;
	}

}
