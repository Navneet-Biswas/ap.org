package org.acharyaprashant.utilities;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.acharyaprashant.testCases.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitUtil extends BaseClass {
	
	public static void fluentWaitForElements(List<WebElement> locaterName) {
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofSeconds(5));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfAllElements(locaterName));
		
		
	}
	
	public static void explicitWaitForElement(WebElement locaterName) {
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofSeconds(5));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(locaterName));
	}

}
