package org.acharyaprashant.utilities;

import org.acharyaprashant.testCases.BaseClass;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomeListeners extends BaseClass implements ITestListener{
	
	// Attache screen shot local
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// Take screenshots
		CaptureScreenShot.TakeScreenshot(driver, "Passed-"+ result.getMethod().getMethodName());	
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// Take screenshots
		
		CaptureScreenShot.TakeScreenshot(driver, "Failed-"+ result.getMethod().getMethodName());
		
	}
	

}
