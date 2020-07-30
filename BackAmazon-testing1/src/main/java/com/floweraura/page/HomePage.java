package com.floweraura.page;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
      
		/*
	 * @FindBy(xpath="a") List<WebElement> links;
	 * 
	 * @FindBy(xpath="img") List<WebElement> imglinks;
	 */

	public void verifyAllLinks(WebDriver driver) {
		List<WebElement> ancchorlinks = driver.findElements(By.tagName("a"));
		ancchorlinks.addAll(driver.findElements(By.tagName("img")));
		System.out.println(ancchorlinks.size());
		List<WebElement> activelinks = new ArrayList<WebElement>();

		for (int i = 0; i < ancchorlinks.size(); i++) {
			if (ancchorlinks.get(i).getAttribute("href") != null) {
				activelinks.add(ancchorlinks.get(i));
			}

		}
		System.out.println("contains only href :" + activelinks.size());

		for (int j = 0; j < activelinks.size(); j++) {
			try {
				HttpURLConnection connection = (HttpURLConnection) new URL(activelinks.get(j).getAttribute("href"))
						.openConnection();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				connection.connect();
				String responcemessage = connection.getResponseMessage();
				System.out.println(activelinks.get(j).getAttribute("href") + "---->>>> "+ j +"--<><><>" + responcemessage);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public void homeurl(WebDriver driver) {
		String homepageurl = driver.getCurrentUrl();
		System.out.println(homepageurl);
	}
	
	
   	
      
}
