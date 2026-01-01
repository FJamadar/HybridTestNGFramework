package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class RegisterPage {
	
	WebDriver driver;
	ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver) {
		elementUtils = new ElementUtils(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="input-firstname")
	WebElement firstName;
	
	@FindBy (id="input-lastname")
	WebElement lastName;
	
	@FindBy (id="input-email")
	WebElement email;
	
	@FindBy (id="input-telephone")
	WebElement telePhone;
	
	@FindBy (id="input-password")
	WebElement password;
	
	@FindBy (id="input-confirm")
	WebElement confirmPassword;
	
	@FindBy (xpath="//input[@name='agree']")
	WebElement agreePrivacyPolicy;
	
	@FindBy (xpath="//input[@value='Continue']")
	WebElement continueButton;
	
	@FindBy (xpath="//input[@name='newsletter'][@value='1']")
	WebElement yesNewsLetter;
	
	@FindBy (xpath="//input[@name='newsletter'][@value='0']")
	WebElement noNewsLetter;
	
	public void enterFirstName(String firstNameText) {
		elementUtils.enterTextIntoTextField(firstName, firstNameText);
		
	}
	
	public void enterLastName(String lastNameText) {
		elementUtils.enterTextIntoTextField(lastName, lastNameText);
		
	}
	
	public void enterEmail(String emailText) {
		elementUtils.enterTextIntoTextField(email, emailText);
		
	}
	
	public void enterTelephone (String telephoneText) {
		elementUtils.enterTextIntoTextField(telePhone, telephoneText);
		
	}
	
	public void enterPassword(String passwordText) {
		elementUtils.enterTextIntoTextField(password, passwordText);
		
	}
	
	public void enterConfirmPassword (String confirmPasswordtext) {
		elementUtils.enterTextIntoTextField(confirmPassword, confirmPasswordtext);
		
	}
	
	public void clickAgreePrivacyPolicy() {
		elementUtils.clickOnTheWebElemenet(agreePrivacyPolicy);
		
	}
	
	public AccountCreatedPage clickOnContinueButton() {
		elementUtils.clickOnTheWebElemenet(continueButton);
		
		return new AccountCreatedPage(driver);
	}
	
	public void selectYestoNewsLetter() {
		elementUtils.clickOnTheWebElemenet(yesNewsLetter);
		
	}
	
	public void selectNotoNewsLetter() {
		elementUtils.clickOnTheWebElemenet(noNewsLetter);
		
	}

}
