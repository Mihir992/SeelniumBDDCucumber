package com.cucumber.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

import org.testng.ITestContext ;		


public class ITestListenerImpl extends ExtentReportListener implements ITestListener {
	
	private static ExtentReports extent;
	
	@Override		
    public void onTestStart(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("FAIL");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("SKIP");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Execution started..");
		extent = setUp();
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Execution completed..");
		extent.flush();
		System.out.println("Generated Report...");
		
	}		
}
