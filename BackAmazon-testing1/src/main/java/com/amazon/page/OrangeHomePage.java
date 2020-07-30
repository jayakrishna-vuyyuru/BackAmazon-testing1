package com.amazon.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class OrangeHomePage  extends BasePage{
	
	  public OrangeHomePage(WebDriver driver){ 
		  super(driver);
		  }
	  
	@FindBy(xpath = "//input[@id='txtUsername']")
	WebElement username;
	@FindBy(xpath = "//input[@id='txtPassword']")
	WebElement password;
	@FindBy(xpath = "//input[@id='btnLogin']")
	WebElement loginbtn;
	@FindBy(xpath = "//a[@id='menu_admin_viewAdminModule']")
	WebElement Admin;
	@FindBy(xpath = "//a[@id='menu_admin_UserManagement']")
	WebElement UserManagementLink;
	@FindBy(xpath = "//a[@id='menu_admin_viewSystemUsers']")
	WebElement usermanage__user;
	
	@FindBy(xpath="//input[@class=\"delete\"]")
	WebElement DeleteButton;
	
	@FindBy(xpath="//input[@id=\"ohrmList_chkSelectRecord_15\"]")
	WebElement TableInFirstCheckBox;
	
	@FindBy(xpath="//a[@href=\"http://www.orangehrm.com\"]")
	WebElement orangeHRM_Inclink;
      @FindBy(xpath="//p[@class=\"highlight\"]")
      WebElement paragraph;
	
	public void login(WebDriver driver)  {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		try {
			Thread.sleep(3000);
			Actions action = new Actions(driver);
			action.moveToElement(Admin).moveToElement(UserManagementLink).moveToElement(usermanage__user).click()
					.build().perform();

			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		orangeHRM_Inclink.click();
	
		
	
		
		/*
		 * TableInFirstCheckBox.click(); if(TableInFirstCheckBox.isDisplayed() &&
		 * TableInFirstCheckBox.isEnabled()) {
		 * 
		 * System.out.
		 * println("Delete Button  is displayed and enabled and test case is pass");
		 * }else { System.out.println("Test case is fauiled"); }
		 */		
		/*
		 * List<WebElement> links=driver.findElements(By.tagName("a"));
		 * links.addAll(driver.findElements(By.tagName("img"))); //
		 * System.out.println("all images and links"+links.size());
		 * 
		 * List <WebElement> activelinks =new ArrayList<WebElement>(); for(int
		 * i=0;i<links.size();i++) { if(links.get(i).getAttribute("href")!=null) {
		 * System.out.println(links.get(i).getAttribute("href")+i);
		 * activelinks.add(links.get(i)); }
		 * 
		 * } System.out.println("Active links size"+activelinks.size());
		 * DesiredCapabilities desired =new DesiredCapabilities();
		 * 
		 * for(int j=0;j<activelinks.size();j++) {
		 * 
		 * HttpURLConnection conection =(HttpURLConnection) new
		 * URL(activelinks.get(j).getAttribute("href")).openConnection();
		 * 
		 * conection.connect(); String responce = conection.getResponseMessage();
		 * desired.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 * conection.disconnect();
		 * System.out.println(activelinks.get(j).getAttribute("href") + "---->" +
		 * responce+j); }
		 * 
		 */
	}

}
