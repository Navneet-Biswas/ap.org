package org.acharyaprashant.pageObject;

import org.acharyaprashant.testCases.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	
	
	public void simpleLogin(String eid,String pwd) {

		eleLoginBtn.click();
			 
		eleSigInWithEmailBtn.click();
		
		eleEmailField.sendKeys(eid);
			
		elePasswordField.sendKeys(pwd);
		
		eleSignInBtn.click();
		
	}
	
	

}
