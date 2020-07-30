package com.alllistenerclasses;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.extentreport.ExtentManager;
import com.flowerauraeExcelUtills.SreenShots;

public class ListenerTest implements ITestListener {
	static Date d = new Date();
	 static String filename ="_Application_" + d.toString().replaceAll(":", "_");
	  public static ExtentReports extent = ExtentManager.createInstance("./Shriram lifeInsurance ExtentReport/shrieram Extent Report2"
	  +filename + ".html");
	public static ThreadLocal<ExtentTest> local = new ThreadLocal<ExtentTest>();
	public WebDriver driver;

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getTestClass().getName() + " :: " + result.getMethod().getMethodName());
		local.set(test);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodename = result.getMethod().getMethodName();
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		local.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
				+ "</font>" + "</b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details>" + "\n");

		String path = SreenShots.takeScreenShot(methodename);
		try {

			local.get().fail("<b>" + "<font color=" + "red>" + "ScreenShot of Failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (IOException e) {
			local.get().fail("Test Failed,  Cannot attached The Path");
		}

		String failurelog = "<b>methodename" + methodename + "failed</b>";
		Markup m = MarkupHelper.createLabel(failurelog, ExtentColor.RED);
		local.get().log(Status.FAIL, m);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodename = result.getMethod().getMethodName();
		String logertext = "<b>" + "TEST CASE: -" + methodename.toUpperCase() + "  SKIPPED" + "</b>";
		Markup m = MarkupHelper.createLabel(logertext, ExtentColor.YELLOW);
		local.get().skip(m);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodename = result.getMethod().getMethodName();
		String logertext = "<b>" + "TEST CASE: -" + methodename.toUpperCase() + "   PASSED" + "</b>";
		Markup m = MarkupHelper.createLabel(logertext, ExtentColor.GREEN);
		local.get().pass(m);
	}

	@Override
	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
		}
	}
}
