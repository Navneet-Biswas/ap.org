package org.acharyaprashant.utilities;

import java.time.Duration;
import java.util.List;

import org.acharyaprashant.testCases.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait extends BaseClass {
	
	
	public static void explicitWaitForElements(List<WebElement> locaterName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElements(locaterName));
	}
	

	public static void explicitWaitForElement(WebElement locaterName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(locaterName));
	}
		public static void explicitWaitForElementClicable(WebElement locaterName) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.elementToBeClickable(locaterName));
	}
	
	
	//*************************************************************************************************************
	
	
	/*
	 * public static void explicitWait(WebElement locators) { WebDriverWait wait =
	 * new WebDriverWait(driver, Duration.ofSeconds(60));
	 * wait.until(ExpectedConditions.visibilityOf(locators)); }
	 * 
	 * public static void explicitWait(List<WebElement> locators) { WebDriverWait
	 * wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	 * wait.until(ExpectedConditions.visibilityOfAllElements(locators)); }
	 */
	
		
	
}
