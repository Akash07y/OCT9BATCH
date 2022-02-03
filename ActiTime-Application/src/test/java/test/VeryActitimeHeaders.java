package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utils.Utility;
import base.Base;
import pom.ActitimeHeader;
import pom.LoginPage;
import pom.UseList;

public class VeryActitimeHeaders extends Base{
	
	private WebDriver driver;
	private ActitimeHeader actitimeHeader;
	private LoginPage loginPage;
	private UseList useList;
	private SoftAssert softAssert ;
	private int testID;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) {
		System.out.println("launchBrowser");
		
		if(browser.equals("chrome"))
		{
			driver = openChromeBrowser();
		}
		
		if(browser.equals("firefox"))
		{
			driver = openFirefoxBrowser();
		}
		
		if(browser.equals("opera"))
		{
			driver = openOperaBrowser();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
	}
	
	@BeforeClass
	public void initializePomClasses() {
		loginPage = new LoginPage(driver); // driver1 = driver
		actitimeHeader = new ActitimeHeader(driver);
		useList = new UseList(driver);
	}
	
	@BeforeMethod
	public void loginActiTime() {
		System.out.println("loginActiTime");
		driver.get("http://desktop-b2220qc/login.do");	

		loginPage.sendUserName();
		loginPage.sendPassword();
		loginPage.clickOnLoginButton();

		softAssert = new SoftAssert();	
	}
	
	@Test 
	public void toVerityUserTab() {
		testID = 101;
		System.out.println("toVerityUserTab");
		
		actitimeHeader.clcikOnUserTab();
		String url = driver.getCurrentUrl();
		System.out.println( url );
		
		Assert.assertEquals(url, "http://desktop-b2220qc/administration/userlist.do"); 
		
		String tital = driver.getTitle();
		
		softAssert.assertEquals(tital, "actiTIME - User List");
		
		String buttonName = useList.verifyCreatNewAccButton();
		
		softAssert.assertEquals(buttonName, "Create New User");
		
		softAssert.assertAll();
	}
	@Test
	public void toVerityReportTab() {
		testID = 102;
		System.out.println("toVerityReportTab");

		actitimeHeader.clcikOnReportTab();
		String url = driver.getCurrentUrl();
		System.out.println( url );
		
	}
	
	@AfterMethod
	public void logoutFromActimie(ITestResult result) {
		
		if(ITestResult.FAILURE  == result.getStatus())
		{
			Utility.saveScrenshot(driver, testID);
		}

		actitimeHeader.clcikOnLogout();
		System.out.println("ogoutFromActimie");
		
	}
	
	@AfterClass
	public void clearObjects() {
		loginPage = null;
		actitimeHeader = null;
		useList = null;
	}
	
	@AfterTest
	public void closedBrowser() {
		System.out.println("closedBrowser");
		driver.quit();
		driver = null;
		System.gc();
	}
	
}
