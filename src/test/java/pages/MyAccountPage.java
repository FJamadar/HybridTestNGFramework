package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class MyAccountPage {
	WebDriver driver;
	ElementUtils elementUtils;
	
	public  MyAccountPage(WebDriver driver) {
	elementUtils = new ElementUtils(driver);
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText="Logout")
	WebElement logoutOption;
	
	@FindBy (xpath="//div[@id='content']//h2")
	WebElement myAccountPageTitle;
	
	@FindBy (xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement invalidCredentialsAlertMessage;
	
	@FindBy (linkText="Logout")
	WebElement logoutOptionFromDropDownMenu;
	
	@FindBy (linkText="Logout")
	WebElement logoutOption1;
	

	
	public boolean verifyMyAccountPageTitle() {
		return myAccountPageTitle.isDisplayed();
	}
	
	public String getTheAlertMessageText() {
		return invalidCredentialsAlertMessage.getText();
	}
	
	public void clickOnLogoutFromDropDownMenu() {
		elementUtils.clickOnTheWebElemenet(logoutOptionFromDropDownMenu);
		
	}
	
	public void clickOnLogoutFromSideMenu() {
		elementUtils.clickOnTheWebElemenet(logoutOption);
		
	}
	
	

}
