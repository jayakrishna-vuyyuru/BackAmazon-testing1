package com.amazon.test;

import org.testng.annotations.Test;

import com.amazon.page.OrangeHRMLinkPage;
import com.amazon.page.OrangeHomePage;

public class AmazonLoginTest extends BaseTest{
	@Test
	public void signUpButtonClick() {
		/*
		 * AmazonLogin login =new AmazonLogin(driver); login.signUpButton();
		 */
		OrangeHomePage oangehome =new OrangeHomePage(driver);
		oangehome.login(driver);
		OrangeHRMLinkPage anpotherlinkpage=new OrangeHRMLinkPage(driver);
		anpotherlinkpage.linkToAnotherPage(driver);
	}

}
