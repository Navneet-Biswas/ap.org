package org.acharyaprashant.pageObject;

import org.acharyaprashant.testCases.BaseClass;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BaseClass {

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	// locate the Login button
	@FindBy(xpath = "//span[normalize-space()='Log in']")
	WebElement eleLoginBtn;

	// locate the Sign in with Email ID
	@FindBy(xpath = "//span[normalize-space()='Sign In with Email']")
	WebElement eleSigInWithEmailBtn;

	// locate the emailid input field
	@FindBy(xpath = "//input[@id='main-website-input-username']")
	WebElement eleEmailField;

	// locate the password input field
	@FindBy(xpath = "//input[@id='password']")
	WebElement elePasswordField;

	// locate the Sign In button
	@FindBy(xpath = "//span[normalize-space()='Sign In']")
	WebElement eleSignInBtn;

	// locate the error message element
    @FindBy(xpath = "//span[contains(text(),'Login Failed! Please enter correct email and password')]")
    WebElement eleErrorMessage;
	
	public void simpleLogin(String eid,String pwd) {

		eleLoginBtn.click();
			 
		eleSigInWithEmailBtn.click();
		
		eleEmailField.sendKeys(eid);
			
		elePasswordField.sendKeys(pwd);
		
		eleSignInBtn.click();
		
		  // Condition to check if the login pass or fail
		try {
            
            if (eleErrorMessage.isDisplayed()) {
            	System.out.println("----------Login Failed! Please enter correct email and password.----------");
                Assert.fail("Login Failed! Please enter correct email and password.");
            }
        } catch (NoSuchElementException e) {
            // If the error message is not found, print login success message
            System.out.println("Login successful!");
        }
		
	}
	
	

}
