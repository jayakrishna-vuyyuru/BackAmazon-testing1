package com.amazon.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonLogin extends BasePage{
	public AmazonLogin(WebDriver driver){
		super(driver);
	}
	@FindBy(xpath="//div[@id=\"nav-signin-tooltip\"]//span")
	WebElement SignUpButton;
	 @FindBy(xpath="//input[@id=\"continue\"]")
	 WebElement ContinueButton;

	 public void signUpButton() {
		 if(SignUpButton.isDisplayed() &&  SignUpButton.isEnabled()) {
			String element=SignUpButton.getText();
			System.out.println(element);
			 boolean button =SignUpButton.isEnabled();
		      System.out.println("  button displayed "+button);
		      SignUpButton.click();
		      
	    }
	 }
}
