package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver) {
		elementUtils = new ElementUtils(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//input[@value='Login']")
	WebElement loginButton;
	
	@FindBy (id="input-email")
	WebElement emailField;
	
	@FindBy (id="input-password")
	WebElement passwordField;
	
	public void enterEmailAddress(String emailText) {
		elementUtils.enterTextIntoTextField(emailField, emailText);
		
	}
	
	public void enterPassword(String passwordText) {
		elementUtils.enterTextIntoTextField(passwordField, passwordText);
		
	}
	
	public MyAccountPage clickOnLoginButton() {
		elementUtils.clickOnTheWebElemenet(loginButton);
		
		return new MyAccountPage(driver);
	}

}
