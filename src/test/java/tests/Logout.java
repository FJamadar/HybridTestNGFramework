package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.MyAccountPage;

public class Logout extends Base{
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		driver = openBrowserAndApplicationURL();
		homePage = new HomePage(driver);
	    loginPage = homePage.navigateToLoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		
		closingTheBrowser(driver);
		
	}
	
	@Test (priority = 1)
	public void verifyLogoutfromdropDown() {
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		myAccountPage = new MyAccountPage(driver);
		myAccountPage.clickOnLogoutFromDropDownMenu();
		Assert.assertEquals(driver.getTitle(), "Account Logout");
		
	}
	
	@Test (priority = 2)
	public void verifyLogoutfromMenu() {
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		myAccountPage = new MyAccountPage(driver);
		myAccountPage.clickOnLogoutFromSideMenu();
		Assert.assertEquals(driver.getTitle(), "Account Logout");
		
	}

}
