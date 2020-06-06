package com.qa.util;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.qa.base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TestListener extends TestBase implements ITestListener{
	
	public TestListener() throws IOException {
		super();
	}

	ExtentReports report ;
	ExtentTest logger;
	RandomStringUtils random;
	
	public void onTestStart(ITestResult result) {
	
	report = new ExtentReports(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\report\\extent.html");
	logger = report.startTest("Maven Prac");
	
	System.out.println("Hi I am a test "+result.getMethod().getMethodName()+" and i am STARTING ");
	}
	
	
	public void onTestSuccess(ITestResult result) {
		
		try {
			System.out.println("Hi, Dekho main pass ho gya");
			logger.log(LogStatus.PASS, "The test case "+result.getMethod().getMethodName()+" got passed."+logger.addScreenCapture(Utilities.getScreenShot(driver)));
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		report.flush();
	}
	

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Main Fail Ho Gya :( ");
			logger.log(LogStatus.FAIL, "The Test Case "+result.getMethod().getMethodName()+" failed and the error is "+result.getThrowable()+" "+logger.addScreenCapture(Utilities.getScreenShot(driver)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		report.flush();
	}
	
	
	
	public void onTestSkipped(ITestResult result) {
		
		try {
			System.out.println("Mainu Skip karta ");
			logger.log(LogStatus.SKIP, "The Test Case "+result.getMethod().getMethodName()+" skipped and the error is "+result.getThrowable()+" "+logger.addScreenCapture(Utilities.getScreenShot(driver)));
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		report.flush();
	}
	

	public void onFinish(ITestContext context) {
	
		report.flush();
	}
	
	
	
}
