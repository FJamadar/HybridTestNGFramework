package base;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import pages.AccountCreatedPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisterPage;
import pages.SearchPage;
import utils.CommonUtilities;
import utils.MyXLSReader;

public class Base {
	
	WebDriver driver;
	
	public Properties prop;
	public HomePage homePage;
	public RegisterPage registerPage;
	public AccountCreatedPage accountCreatedPage;
	public MyAccountPage myAccountPage;
	public LoginPage loginPage;
	public SearchPage searchPage;
	public MyXLSReader myXLSReader;

	
	public WebDriver openBrowserAndApplicationURL() {
		
		try {
			prop = CommonUtilities.loadCommonProperties();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		myXLSReader = new MyXLSReader("\\src\\test\\resources\\ProjectData.xlsx");
		
		String browserName = myXLSReader.getCellData("DataSheet", 2, 10);
		
		if(browserName.equals("chrome")) {
			
			driver = new ChromeDriver();
		}
		else if(browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("Edge")) {
			driver = new EdgeDriver();
		}
		else if(browserName.equals("Safari")) {
			driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get(myXLSReader.getCellData("DataSheet", 2, 1));
		
		
		return driver;
		
	}
	
	public void closingTheBrowser(WebDriver driver) {
		
		if(!(driver==null)) {
			driver.quit();
		}
		
		
	}

}
