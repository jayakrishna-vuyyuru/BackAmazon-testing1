package com.floweraura.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.floweraura.page.DynamicImages;

public class DynamicImagesHeadText extends BaseTest {
	
	@Test
	public void allImageHeadText() {
		
		DynamicImages headtext = new DynamicImages(driver);
		headtext.allImagesHeadText(driver);
		// test=report.createTest(getClass().getName());
		//test.log(Status.INFO, "every one is get allImageHeadText data");
		//ExtentReportClas.extentReport();
	//report.createTest("allImageHeadText");
		//test.log(Status.PASS, "Head Text are  taken");
		
	}

	@Test
	public void allImageul_ListText() {
		
		DynamicImages headtext = new DynamicImages(driver);
				headtext.eachImageUlListText(driver);
	
		
	}

	@Test
	public void subText() {
		DynamicImages headtext = new DynamicImages(driver);
		headtext.allImage_SubText(driver);
		

	}	

	@Test
	public void allImage_KnowMore_Link() {
		DynamicImages headtext = new DynamicImages(driver);
		Reporter.log("KNOW MORE_Links all are geting", true);
		headtext.getAllImage_KnowMore_Link(driver);

		
	}

}
