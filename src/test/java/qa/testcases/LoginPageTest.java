package qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.Base;
import qa.pages.HomePage;
import qa.pages.LoginPage;

public class LoginPageTest extends Base {

	LoginPage loginPage;
	HomePage homePage;

	//create constructor of test class
	public LoginPageTest() {
		super(); 
			/*This keyword will call the super class constructor (Base class constructor)
			 * We need to initialize properties as well and these are in the base class constructor
			 * If we don't do this we will get a null pointer exception when launching the browser
			*/
	}
		
	@BeforeMethod
	public void setup() {
			
		launchBrowser();
			
		//create object of landing page class
		loginPage = new LoginPage(driver);	
		homePage = new HomePage(driver);
			
		//Using Page Factory
		//landingPage = new LandingPage();	
	}
		
		
	@Test(priority = 1)
	public void loginAndVerifyHeadingOnHomePage() {
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		Assert.assertEquals(homePage.headingOnHomePage(), "Dashboard");
	}
	
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
