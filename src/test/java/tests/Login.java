package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountCreatedPage;
import pages.HomePage;
import utils.CommonUtilities;

public class Login extends Base{

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

	@Test(priority = 1)
	public void loginWithValidCredentials(){
        
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(prop.getProperty("validPassword"));
		myAccountPage = loginPage.clickOnLoginButton();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement myAccountTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']//h2")));
	    Assert.assertEquals(myAccountTitle.getText(), "My Account");
	    accountCreatedPage = new AccountCreatedPage(driver);
	    Assert.assertTrue(accountCreatedPage.verifyLogoutOption());
		
	}

	@Test(priority = 2)
	public void loginWithInvalidCredentials() {
       
		loginPage.enterEmailAddress(CommonUtilities.dynamicEmailID());
		loginPage.enterPassword(CommonUtilities.dynamicPassword());
		myAccountPage = loginPage.clickOnLoginButton();
		
		Assert.assertEquals(myAccountPage.getTheAlertMessageText(), "Warning: No match for E-Mail Address and/or Password.");
	}

	@Test(priority = 3)
	public void loginWithInvalidEmailAddress() {
		loginPage.enterEmailAddress(CommonUtilities.dynamicEmailID());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		myAccountPage = loginPage.clickOnLoginButton();
		Assert.assertEquals(myAccountPage.getTheAlertMessageText(), "Warning: No match for E-Mail Address and/or Password.");

	}

	@Test(priority = 4)
	public void loginWithInvalidPassword() {
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(CommonUtilities.dynamicPassword());
		myAccountPage = loginPage.clickOnLoginButton();
		Assert.assertEquals(myAccountPage.getTheAlertMessageText(), "Warning: No match for E-Mail Address and/or Password.");

	}

	@Test(priority = 5)
	public void loginWithoutEmailPassword() {
		myAccountPage = loginPage.clickOnLoginButton();
		Assert.assertEquals(myAccountPage.getTheAlertMessageText(), "Warning: No match for E-Mail Address and/or Password.");

	}



}
