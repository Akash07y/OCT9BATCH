package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActitimeHeader {

	// New canges//
	@FindBy (xpath = "//a[@class='content users']") 
	private  WebElement user ;
	
	@FindBy (xpath = "//a[@class='content reports']") 
	private WebElement report ;
	
	@FindBy (xpath = "(//a[@class='content tasks'])[9]") 
	private WebElement task ;
	
	@FindBy (xpath = "//a[text()='Logout']") 
	private WebElement logOut ;
	
	public ActitimeHeader(WebDriver driver1){  // asd = driver = new ChromeDriver()

		PageFactory.initElements(driver1, this);
	}
	
	public void clcikOnUserTab() {
		user.click();
	}
	
	public void clcikOnReportTab() {
		report.click();
	}
	
	public void clcikOnTaskTab() {
		task.click();
	}
	
	public void clcikOnLogout() {
		logOut.click();
	}
	
	
}
