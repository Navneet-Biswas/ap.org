package org.acharyaprashant.utilities;

import org.acharyaprashant.testCases.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class AllureListener  implements ITestListener{
	
	// Attache screen shot to Allure report
	
	@Attachment
	public byte[] saveScreenshot(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment(value = "{0}", type = "test/plain")
	public static String saveTextLog(String message) {
		return message;
	}

	
	// Take screenshot for pass test
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test Start "+result.getMethod().getMethodName()+" Success");
		WebDriver driver = BaseClass.getDriver();
		if(driver instanceof WebDriver) {
			System.out.println("Screenshot captured for passed testcase: "+result.getMethod().getMethodName());
			saveScreenshot(driver);
		}
		saveTextLog(result.getMethod().getMethodName()+" Passed and screenshot taken");
	}
	
	
	// Take screenshot for failed test
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On Test Start "+result.getMethod().getMethodName()+" Failed");

		WebDriver driver = BaseClass.getDriver();
		if(driver instanceof WebDriver) {
			System.out.println("Screenshot captured for failed testcase: "+result.getMethod().getMethodName());
			saveScreenshot(driver);
		}
		saveTextLog(result.getMethod().getMethodName()+" Failed and screenshot taken");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("On Test Start "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		System.out.println("On Test Skip "+result.getMethod().getMethodName());
		
	}
/*
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		context.setAttribute("WebDriver", BaseClass.getDriver());
		System.out.println("On Start "+context.getName());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Finish "+context.getName());
		
	}
	
*/
	
	
	
	
	
	
	
}
