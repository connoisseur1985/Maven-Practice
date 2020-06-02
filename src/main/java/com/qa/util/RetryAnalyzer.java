package com.qa.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int count =0;
		
	public boolean retry(ITestResult result) {
		
		while(count<3) {
			
			count++;
			
			return true;
		
		}
		return false;
	}

	

}
