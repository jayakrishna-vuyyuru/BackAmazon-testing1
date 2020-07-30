package com.floweraura.test;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.flowerauraeExcelUtills.DataDrivenExcel;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	static String browsername = "Chrome";
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	public ExtentHtmlReporter htmlreport;

	// Logger log=LogManager.getLogger(BaseTest.class);
	// Logger logger=Logger.getLogger(BaseTest.class);
	@BeforeSuite
	public static  void launchBrowsers() {
	
		if (browsername.equals(DataDrivenExcel.excelUtility("Sheet1", 0, 1))) {
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			WebDriverManager.chromedriver().setup();
			DesiredCapabilities capabil=new DesiredCapabilities();
			capabil.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new ChromeDriver();
			driver.get("https://shriramlife.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			String tittlename = driver.getTitle();
			System.out.println(tittlename);
		} else if (browsername.equals("ie")) {
			WebDriverManager.iedriver().setup();             
			driver = new InternetExplorerDriver();
			driver.get("https://shriramlife.com/");
			driver.getTitle();
		} else if (browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get("https://shriramlife.com/");
			String title = driver.getTitle();
			System.out.println(title);
		}
	}
	
   @AfterSuite
	public static  void bowserClose() {
		driver.close();
	}
		
    public  static void takeScreenShot(WebDriver driver, String filename) {
		try {
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(file, new File("./ScreenShots/" + filename + ".jpg"));
		} catch (Exception e) {
			System.out.println("Exception whiletacking screenshot " + e.getMessage());
		}
	}

}
