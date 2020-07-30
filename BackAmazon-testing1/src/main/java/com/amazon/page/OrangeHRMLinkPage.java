package com.amazon.page;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeHRMLinkPage extends BasePage{
	
	public OrangeHRMLinkPage(WebDriver driver){
		super(driver);
	}


		
	 @FindBy(xpath="//p[@class=\"highlight\"]")
     WebElement paragraph;
 
	 @FindBy(xpath="//a[@href=\"/features/personnel-information-management-pim/\"][2]")
  WebElement linkmore;
	 
	  public void linkToAnotherPage(WebDriver driver) {
		  Set<String> windows=	driver.getWindowHandles();
			Iterator<String> windowsids=windows.iterator();
			String parentid=windowsids.next();
			String chaildid=windowsids.next();
			driver.switchTo().window(chaildid);
			System.out.println("parent id"+parentid);
			System.out.println("chaild id"+chaildid);
			
			
			driver.manage().timeouts().implicitlyWait(50,  TimeUnit.SECONDS);
			
		  linkmore.click();
		 // System.out.println(paragraph.getSize());
		  driver.close();
		  driver.switchTo().window(parentid);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 System.out.println("curent tittle is :"+driver.getTitle()); 
	  }

}
