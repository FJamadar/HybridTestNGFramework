package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	
	public SearchPage (WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText="HP LP3065")
	WebElement serchedProductResult;
	
	@FindBy (xpath = "//div[@id='content']//p[2]")
	WebElement errorMessageforInvalidProduct;
	
	public String getSearchedProductText() {
		return serchedProductResult.getText();
	}
	
	public String getErrorMessageTextOfInvalidProduct() {
		return errorMessageforInvalidProduct.getText();
	}

}
