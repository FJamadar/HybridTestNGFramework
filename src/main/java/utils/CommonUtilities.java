package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;

public class CommonUtilities {

	public static Properties loadCommonProperties() throws IOException {

		Properties prop = new Properties();
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			prop.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return prop;

	}

	public static String dynamicEmailID() {

		String Email = "sumaiyyamj" + System.currentTimeMillis() + "@gmail.com";

		return Email;
	}

	public static String dynamicPassword() {

		String password = "123" + System.currentTimeMillis();

		return password;
	}

	public static ExtentReports generateExtentReport() {

		ExtentReports extentReports = new ExtentReports();

		ExtentSparkReporter sparkReport = new ExtentSparkReporter(
				new File(System.getProperty("user.dir")) + "\\Reports\\testNGReport.html");
		ExtentSparkReporterConfig sparkReportConfig = sparkReport.config();
		sparkReportConfig.setDocumentTitle("TutorialsNinja Report");
		sparkReportConfig.setReportName("TutorialsNinja_TestResults");

		extentReports.attachReporter(sparkReport);

		extentReports.setSystemInfo("UserName", "Fatima Jamadar");
		extentReports.setSystemInfo("SeleniumVersion", "4.39.0");
		extentReports.setSystemInfo("Browser", "Chrome");

		return extentReports;
	}

	public static String takeScreenShot(WebDriver driver, String testName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenShotPath = ts.getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") + "\\ScreenShots\\" + testName + ".png";

		try {
			FileHandler.copy(screenShotPath, new File(screenshotPath));
		} catch (IOException e) {

			e.printStackTrace();
		}
		return screenshotPath;

	}

	public static Object[][] getTestData(MyXLSReader xls_received, String testName, String sheetName) {

		MyXLSReader xls = xls_received;

		String testCaseName = testName;

		String testDataSheet = sheetName;

		int testStartRowNumber = 1;

		while (!(xls.getCellData(testDataSheet, 1, testStartRowNumber).equals(testCaseName))) {

			testStartRowNumber++;

		}

		int columnStartRowNumber = testStartRowNumber + 1;
		int dataStartRowNumber = testStartRowNumber + 2;

		int rows = 0;
		while (!(xls.getCellData(testDataSheet, 1, dataStartRowNumber + rows).equals(""))) {

			rows++;

		}

		// Total number of columns in the required test
		int columns = 1;

		while (!(xls.getCellData(testDataSheet, columns, columnStartRowNumber).equals(""))) {

			columns++;

		}

		Object[][] obj = new Object[rows][1];

		HashMap<String, String> map = null;

		// Reading the data in the test
		for (int i = 0, row = dataStartRowNumber; row < dataStartRowNumber + rows; row++, i++) {

			map = new HashMap<String, String>();

			for (@SuppressWarnings("unused")
			int j = 0, column = 1; column < columns; column++, j++) {

				String key = xls.getCellData(testDataSheet, column, columnStartRowNumber);

				String value = xls.getCellData(testDataSheet, column, row);

				map.put(key, value);

			}

			obj[i][0] = map;

		}

		return obj;

	}

}
