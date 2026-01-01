package tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import utils.CommonUtilities;

public class Register extends Base {

	public WebDriver driver;


	@BeforeMethod
	public void setup() {
		
		driver = openBrowserAndApplicationURL();
		homePage = new HomePage(driver);
		registerPage = homePage.navigateToRegisterPage();
		

	}

	@AfterMethod
	public void tearDown() {
		
		closingTheBrowser(driver);
		

	}

	
	@Test(priority = 1)
	public void verifyRegistrationFunctionalityWithOnlyMandatoryFields() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(CommonUtilities.dynamicEmailID());
		registerPage.enterTelephone(prop.getProperty("phoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.clickAgreePrivacyPolicy();
		accountCreatedPage = registerPage.clickOnContinueButton();

		Assert.assertTrue(accountCreatedPage.verifyLogoutOption());

		String pageTitle1 = driver.getTitle();

		Assert.assertEquals(pageTitle1, "Your Account Has Been Created!");

		accountCreatedPage.clickOnContinueButton();
		
		String pageTitle2 = driver.getTitle();

		Assert.assertEquals(pageTitle2, "My Account");


	}

	@Test(priority = 2)
	public void averifyRegistrationFunctionalityWithAllFunctionality() {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(CommonUtilities.dynamicEmailID());
		registerPage.enterTelephone(prop.getProperty("phoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectYestoNewsLetter();
		registerPage.clickAgreePrivacyPolicy();
		accountCreatedPage = registerPage.clickOnContinueButton();

		Assert.assertTrue(accountCreatedPage.verifyLogoutOption());

	
		Assert.assertEquals(driver.getTitle(), "Your Account Has Been Created!");

		accountCreatedPage.clickOnContinueButton();

		Assert.assertEquals(driver.getTitle(), "My Account");


	}

	@Test(priority = 3)
	public void averifyRegistrationFunctionalityWithNoNewsletter() throws IOException {

		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail(CommonUtilities.dynamicEmailID());
		registerPage.enterTelephone(prop.getProperty("phoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectNotoNewsLetter();
		registerPage.clickAgreePrivacyPolicy();
		accountCreatedPage = registerPage.clickOnContinueButton();

		Assert.assertTrue(accountCreatedPage.verifyLogoutOption());

		Assert.assertEquals(driver.getTitle(), "Your Account Has Been Created!");

		accountCreatedPage.clickOnContinueButton();

		Assert.assertEquals(driver.getTitle(), "My Account");

	}


}
