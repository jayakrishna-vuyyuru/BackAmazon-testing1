package com.amazon.test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.amazon.page.HomePage;

public class HomeTest extends BaseTest {
	@Test
	public void clickAmazonPay() throws MalformedURLException, IOException  {
		HomePage homepage = new HomePage(driver);
		homepage.amazonPay(driver);
		
		//homepage.login(driver);
	}
	
}
