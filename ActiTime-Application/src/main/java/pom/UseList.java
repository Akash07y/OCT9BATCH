package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UseList {

private WebDriver driver ;
	
	@FindBy (xpath = "((//div[@id='container']//table//table)[10]//input)[1]") 
	private  WebElement creatNewAcc ;


	public UseList(WebDriver driver){  
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public String verifyCreatNewAccButton() {
		
		String creatNewAccTest = creatNewAcc.getAttribute("value");
		return creatNewAccTest;
		
	}
	
}
