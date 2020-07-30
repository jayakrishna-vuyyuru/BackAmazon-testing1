package com.extentreport;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
       private static ExtentReports extent;
       public  static ExtentReports createInstance(String filename) {	
    	  // String filename=getReportname();
			/*
			 * String dictionary=System.getProperty("user.dir")
			 * +"/Shriram lifeInsurance ExtentReport/"; new File(dictionary).mkdirs();
			 * String path=dictionary;
			 */
    	   ExtentHtmlReporter htmlreport=new  ExtentHtmlReporter(filename);
       	   htmlreport.config().setEncoding("utf-8"); 
       	//htmlreport.config().setAutoCreateRelativePathMedia(true);
    	   htmlreport.config().setDocumentTitle("Automation Reports");
    	   htmlreport.config().setReportName("Shriram Lifeinsurance");  
    	   htmlreport.config().setTheme(Theme.DARK); 
    	   
    	   extent=new ExtentReports();
    	   extent.setSystemInfo("Organization", "Im a fresher");
    	   extent.setSystemInfo("Browser", "Chrome");
    	   extent.attachReporter(htmlreport);
    	   
    	   return extent;
       }
		/*
		 * public static String getReportname() { Date d=new Date(); String
		 * filename="Automation"+"Extent_" + d.toString().replaceAll(":", "_")+".html";
		 * return filename; }
		 */}
