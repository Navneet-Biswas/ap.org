package org.acharyaprashant.utilities;

import org.acharyaprashant.testCases.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HandleAssertions extends BaseClass {
	
	//Toast message assertion*************************************************************************************
	
		
		public static void toastMessageAssertion() throws InterruptedException  {
			
			 WebElement toastMsg=driver.findElement(By.xpath("//div[@class='popup-content']//span"));
			
			 ExplicitWait.explicitWaitForElement(toastMsg);
			 
			 String actual=toastMsg.getText();
			 String expected1="Success Message";
			 String expected2="Success Message.";
			 String expected3="Error Message";
			 String expected4="Error Message.";
			 if(actual.equalsIgnoreCase(expected1) || actual.equalsIgnoreCase(expected3) ) {
			 
			 Assert.assertEquals(actual, expected1, "Data not saved !!!");
			 }
			 else if(actual.equalsIgnoreCase(expected2) || actual.equalsIgnoreCase(expected4)) {
				 
				 Assert.assertEquals(actual, expected2, "Data not saved !!!");
			 }
				 
					
		}
		

}
