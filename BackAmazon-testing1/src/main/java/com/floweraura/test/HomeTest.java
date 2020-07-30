package com.floweraura.test;

import org.testng.annotations.Test;
import com.floweraura.page.HomePage;
public class HomeTest  extends BaseTest{
	@Test
	public void imageAndLinks() {
		HomePage homepage=new HomePage(driver);
		homepage.verifyAllLinks(driver);
		//HomePage.allImagesHeadText(driver);
		homepage.homeurl(driver);
	}

}
