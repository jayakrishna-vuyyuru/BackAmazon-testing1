package com.floweraura.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShriramLifeSuperIncomeplanImage_InHomePage extends BasePage {
	public ShriramLifeSuperIncomeplanImage_InHomePage(WebDriver driver){
		super(driver);
	}
	Actions action ;
	@FindBy(xpath="//section[@class=\" home-hero-section slider-bg-img plan_94 94 item\"]")
	WebElement SecondImgMobileNumberTxtBox;
	@FindBy(xpath="//p[text()=\"WHO WE ARE\"]")
	WebElement whoweare;
	public void secondImageMobileNumberTextBox(WebDriver driver) {
		
		action =new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(SecondImgMobileNumberTxtBox));
		action.doubleClick(SecondImgMobileNumberTxtBox).build().perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		String text=whoweare.getText();
		Assert.assertEquals(text, "WHO WE ARE");
		System.out.println(text);
	}
}
