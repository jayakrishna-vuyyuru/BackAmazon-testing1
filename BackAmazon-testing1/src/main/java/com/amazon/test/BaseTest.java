package com.amazon.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	String browsername="chrome";
   WebDriver driver;
	
	@BeforeTest
    public void  launchBrowser() {
		if(browsername.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
     //  System.setProperty("webdriver.firefox.driver", "//BackAmazon//Resources//geckodriver.exe");
       driver=new FirefoxDriver();
       driver.get("https://www.youtube.com/");
		}
		else if(browsername.equalsIgnoreCase("internetexplorer")) {
			WebDriverManager.iedriver().setup();
			 driver =new InternetExplorerDriver();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
			driver.get("https://www.google.com");
		}
		else if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty(ChromeDriverService. CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			WebDriverManager.chromedriver().setup();
		    driver =new ChromeDriver();
			//driver.get("http://www.amazon.in");
		    driver.get("https://opensource-demo.orangehrmlive.com/");
			driver.manage().window().maximize();
			
		
		}
	}

	@AfterTest
	public void closeBrowserWindow() {
		
		driver.quit();
		
	}
}
