package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class AccountCreatedPage {
	
	WebDriver driver;
	ElementUtils elementUtils;
	
	public AccountCreatedPage(WebDriver driver) {
		elementUtils = new ElementUtils (driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy (linkText = "Continue")
	WebElement continueButton;
	
	@FindBy (linkText="Logout")
	WebElement logoutOption;
	
	
	public void clickOnContinueButton() {
		elementUtils.clickOnTheWebElemenet(continueButton);
		
		
	}
	
	public boolean verifyLogoutOption() {
		return logoutOption.isDisplayed();
	}
	


}
