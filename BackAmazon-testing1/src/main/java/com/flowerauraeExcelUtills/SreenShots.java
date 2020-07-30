package com.flowerauraeExcelUtills;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.floweraura.test.BaseTest;

public class SreenShots extends BaseTest {
	
	public static String  takeScreenShot(String methodename) {
		/*
		 * File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); Date
		 * date=new Date(); screenshotname=date.toString().replace(":",
		 * "_").replace(" ", "_")+".png"; try { FileHandler.copy(file, new
		 * File("..//BackAmazon//ScreenShots/")); } catch(IOException e) {
		 * e.printStackTrace(); }
		 */
		String filename=getReportname( methodename);
		String directorry=System.getProperty("user.dir")+"/ScreenShots/";
		new File(directorry).mkdirs();
		String path=directorry+filename;
		
		try {
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(file, new File(path));
			
			System.out.println("Given The Path  ---->"   +path);
			}catch (Exception e) {
		
		}
		return path;
		
	  }
	 public static String getReportname(String methodename) {
  	   Date d=new Date();
  	   String filename=methodename+"Extent_" + d.toString().replaceAll(":", "_")+".png";
  	   return filename;
     }

	/*
	 * public static String takeScreenShot(String methodename) { Date date=new
	 * Date(); String screenshotname=methodename+date.toString().replace(":",
	 * "_").replace(" ", "_")+".jpg"; String
	 * distonary="..//BackAmazon//ScreenShots/"; String
	 * path=distonary+screenshotname; new File(path).mkdir();
	 * 
	 * try { File
	 * screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 * FileHandler.copy(screenshot, new File(path)); }catch(Exception e){
	 * 
	 * }
	 * 	return path;
	 */

}


