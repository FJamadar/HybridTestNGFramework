package utils;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtils {
	
	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void enterTextIntoTextField (WebElement element , String elementText) {
		
		if(isElementDisplayed(element) && isElementInEnabledState(element)) {
			element.clear();
			element.sendKeys(elementText);
			
		}
		
		
	}
	
	public void clickOnTheWebElemenet (WebElement element) {
		
		if(isElementDisplayed(element) && isElementInEnabledState(element)) {
			element.click();
		}
		
	}
	
	public boolean isElementInEnabledState(WebElement element) {
		
		boolean b = false;
		if (isElementDisplayed(element)) {
			b = element.isEnabled();
		}
		
		return b ;
		
		
	}
	
	public boolean isElementDisplayed(WebElement element) {
		
		boolean b = false;
		
		try {
			
			b= element.isDisplayed();
		}
		catch (NoSuchElementException e) {
			b = false;
		}
		
		return b;
}
}