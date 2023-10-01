package com.cucumber.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener {
	public static ExtentHtmlReporter report = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;

	public static ExtentReports setUp()
	{
		String reportLocation = "./Reports/Extent_Reprot.html";
		report = new ExtentHtmlReporter(reportLocation);
		report.config().setDocumentTitle("AutomationTestReport");
		report.config().setReportName("AutomationTestReport");
		report.config().setTheme(Theme.STANDARD);
		System.out.println("Extent Reprot initialized");
		report.start();

		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Application","AutomationStore");
		//extent.setSystemInfo("Operating System",System.getProperty("os.name");
		extent.setSystemInfo("User Name",System.getProperty("user.name"));
		System.out.println("System Info. set in Extent Report");
		return extent;
	}

	public static void testStepHandle(String teststatus,WebDriver driver,ExtentTest extenttest,Throwable throwable) {
		switch(teststatus)
		{
			case "FAIL":
			extenttest.fail(MarkupHelper.createLabel("Test case is failed:", ExtentColor.RED));
			extenttest.error(throwable.fillInStackTrace());
			
			try {
				extenttest.addScreenCaptureFromPath(captureScreenshot(driver));
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			if(driver!=null){
				driver.quit();
			}
			break;
		
		       case "PASS":
			  extenttest.fail(MarkupHelper.createLabel("Test case is passed:", ExtentColor.GREEN));
			  break;
		
		       default:
			break;
			}
		}
	
	public static String captureScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = "C:\\Users\\admin\\eclipseworkspace\\CucumberFramework\\screenshot\\screenshot.png";
		File target = new File(dest);
		FileUtils.copyFile(src,target);
		return dest;
		}
}