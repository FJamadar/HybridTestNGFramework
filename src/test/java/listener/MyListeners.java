package listener;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.CommonUtilities;

public class MyListeners implements ITestListener {

	WebDriver driver;
	ExtentReports extentReports;
	ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) {
		extentReports = CommonUtilities.generateExtentReport();
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		
		extentTest = extentReports.createTest(result.getName());
		  
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS, result.getName()+"Test Pass Successfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		extentTest.log(Status.FAIL, result.getName()+"Test got Failed");
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String screenshotPath = CommonUtilities.takeScreenShot(driver, result.getName());
		extentTest.addScreenCaptureFromPath(screenshotPath);
		extentTest.log(Status.INFO, result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		extentTest.log(Status.SKIP, result.getName()+"Test got skipped");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReports.flush();
		
		File extentReportFile = new File (System.getProperty("user.dir")+"\\Reports\\testNGReport.html");
		
		try {
			Desktop.getDesktop().browse(extentReportFile.toURI());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	

}
