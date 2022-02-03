package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {


	 
	 String r ="hjkl";
	 
	 
	 
	private WebDriver driver ;
	
	@FindBy (xpath = "//input[@name='username']") 
	private  WebElement userName ;
	
	@FindBy (xpath = "//input[@name='pwd']") 
	private WebElement password ;
	
	@FindBy (xpath = "//a[text()='Login']") 
	private WebElement logInButton ;

	public LoginPage(WebDriver driver){  
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void accepttheAletr() {	
		Alert alt= driver.switchTo().alert();
		alt.accept();
	}
	public void sendUserName() {
		
			userName.sendKeys("admin");
	}

	public void sendPassword() {
			password.sendKeys("manager");
	}
	
	public void clickOnLoginButton() {
			logInButton.click();
	}
	
	public void loginToActitime() {
		userName.sendKeys("admin");
		password.sendKeys("manager");
		logInButton.click();
	}
	
	

}
