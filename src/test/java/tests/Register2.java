package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import utils.CommonUtilities;

public class Register2 extends Base {

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

    // getting test data from excel sheet using Apache POI Libraries 
	
	@Test(priority = 1)
	public void verifyRegistrationFunctionalityWithOnlyMandatoryFields() throws Throwable {

		registerPage.enterFirstName(myXLSReader.getCellData("DataSheet", 2, 2));
		registerPage.enterLastName(myXLSReader.getCellData("DataSheet", 2, 3));
		registerPage.enterEmail(CommonUtilities.dynamicEmailID());
		registerPage.enterTelephone(myXLSReader.getCellData("DataSheet", 2, 4));
		registerPage.enterPassword(myXLSReader.getCellData("DataSheet", 2, 5));
		registerPage.enterConfirmPassword(myXLSReader.getCellData("DataSheet", 2, 5));
		registerPage.clickAgreePrivacyPolicy();
		accountCreatedPage = registerPage.clickOnContinueButton();
		
        Thread.sleep(5000);
        
		Assert.assertTrue(accountCreatedPage.verifyLogoutOption());

		String pageTitle1 = driver.getTitle();

		Assert.assertEquals(pageTitle1, "Your Account Has Been Created!");

		accountCreatedPage.clickOnContinueButton();

		String pageTitle2 = driver.getTitle();

		Assert.assertEquals(pageTitle2, "My Account");

	}

	@Test(priority = 2)
	public void verifyRegistrationFunctionalityWithAllFunctionality() {

		registerPage.enterFirstName(myXLSReader.getCellData("DataSheet", 2, 2));
		registerPage.enterLastName(myXLSReader.getCellData("DataSheet", 2, 3));
		registerPage.enterEmail(CommonUtilities.dynamicEmailID());
		registerPage.enterTelephone(myXLSReader.getCellData("DataSheet", 2, 4));
		registerPage.enterPassword(myXLSReader.getCellData("DataSheet", 2, 5));
		registerPage.enterConfirmPassword(myXLSReader.getCellData("DataSheet", 2, 5));
		registerPage.selectYestoNewsLetter();
		registerPage.clickAgreePrivacyPolicy();
		accountCreatedPage = registerPage.clickOnContinueButton();

		Assert.assertTrue(accountCreatedPage.verifyLogoutOption());

		Assert.assertEquals(driver.getTitle(), "Your Account Has Been Created!");

		accountCreatedPage.clickOnContinueButton();

		Assert.assertEquals(driver.getTitle(), "My Account");

	}

	@Test(priority = 3)
	public void averifyRegistrationFunctionalityWithNoNewsletter() {

		registerPage.enterFirstName(myXLSReader.getCellData("DataSheet", 2, 2));
		registerPage.enterLastName(myXLSReader.getCellData("DataSheet", 2, 3));
		registerPage.enterEmail(CommonUtilities.dynamicEmailID());
		registerPage.enterTelephone(myXLSReader.getCellData("DataSheet", 2, 4));
		registerPage.enterPassword(myXLSReader.getCellData("DataSheet", 2, 5));
		registerPage.enterConfirmPassword(myXLSReader.getCellData("DataSheet", 2, 5));
		registerPage.selectNotoNewsLetter();
		registerPage.clickAgreePrivacyPolicy();
		accountCreatedPage = registerPage.clickOnContinueButton();

		Assert.assertTrue(accountCreatedPage.verifyLogoutOption());

		Assert.assertEquals(driver.getTitle(), "Your Account Has Been Created!");

		accountCreatedPage.clickOnContinueButton();

		Assert.assertEquals(driver.getTitle(), "My Account");

	}


}
