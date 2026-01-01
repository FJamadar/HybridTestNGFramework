package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	ElementUtils elementUtils;
	
	public HomePage (WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement myAccountDropDownMenu ;
	
	@FindBy(linkText="Register")
	WebElement registerOption;
	
	@FindBy (linkText="Login")
	WebElement loginOption;
	
	@FindBy (xpath="//input[@name='search']")
	WebElement searchTextBoxFiled;
	
	@FindBy (xpath="//button[@class='btn btn-default btn-lg']")
	WebElement searchButton;
	
	
	
	public LoginPage clickLoginOption() {
		elementUtils.clickOnTheWebElemenet(loginOption);
		
		return new LoginPage(driver);
	}
	
	public void clickMyAccountMenu() {
		elementUtils.clickOnTheWebElemenet(myAccountDropDownMenu);
		
	}
	
	public RegisterPage clickRegisterOption () {
		elementUtils.clickOnTheWebElemenet(registerOption);
		
		return new RegisterPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage() {
		
		clickMyAccountMenu();
		return clickRegisterOption();
	}
	
	public LoginPage navigateToLoginPage() {
		clickMyAccountMenu();
		return clickLoginOption();
	}
	
	public void enterProductInSearchTextboxField(String productText) {
		elementUtils.enterTextIntoTextField(searchTextBoxFiled, productText);
		
	}
	
	public void clickOnSearchButton() {
		elementUtils.clickOnTheWebElemenet(searchButton);
		
	}
	
	

}
