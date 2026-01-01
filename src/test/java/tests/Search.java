package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.SearchPage;

public class Search extends Base {
	
	public WebDriver driver;

	@BeforeMethod
	public void setup () {
		driver = openBrowserAndApplicationURL();
		homePage = new HomePage(driver);
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		closingTheBrowser(driver);
		
	}
	
	@Test (priority=1)
	public void serachWithExistingProductName () {
		
		homePage.enterProductInSearchTextboxField(prop.getProperty("validProduct"));
	    homePage.clickOnSearchButton();
	    searchPage = new SearchPage(driver);
		Assert.assertEquals(searchPage.getSearchedProductText(), "HP LP3065");
		
	}
	
	@Test (priority=2)
	public void searchWithNonExistingProductName() throws IOException {
	
		homePage.enterProductInSearchTextboxField(prop.getProperty("invalidProduct"));
	    homePage.clickOnSearchButton();
	    searchPage = new SearchPage(driver);
		Assert.assertEquals(searchPage.getErrorMessageTextOfInvalidProduct(), "There is no product that matches the search criteria.");
	}
	
	@Test (priority=3)
	public void searchWithBlankSearchField() {
		   homePage.clickOnSearchButton();
		
	}
	
	

}
