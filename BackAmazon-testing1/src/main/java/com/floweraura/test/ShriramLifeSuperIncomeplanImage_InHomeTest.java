package com.floweraura.test;

import org.testng.annotations.Test;

import com.floweraura.page.ShriramLifeSuperIncomeplanImage_InHomePage;

public class ShriramLifeSuperIncomeplanImage_InHomeTest extends BaseTest{
	
	@Test
	public void shriramLifeSuperIncomeplanImage_InHomePage() {
	ShriramLifeSuperIncomeplanImage_InHomePage sliihp=new ShriramLifeSuperIncomeplanImage_InHomePage(driver);
	sliihp.secondImageMobileNumberTextBox(driver);
	
	}
}
