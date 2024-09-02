package org.acharyaprashant.pageObject;

import org.acharyaprashant.testCases.BaseClass;
import org.acharyaprashant.utilities.ExplicitWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ArticlesHomePage extends BaseClass {

	public ArticlesHomePage() {

		PageFactory.initElements(driver, this);
	}

	// locate and navigate to the "Articles" page from top menu bar
	@FindBy(xpath = "(//span[contains(text(),'Articles')])[1]")
	WebElement eleArticles;

	public void clikOnArticles() {

		eleArticles.click();

	}

	// verify page title after navigating to the Article Home Page
	public void verifyArtPageTitle(String ptitle1) {
		Assert.assertEquals(driver.getTitle(), ptitle1);
	}

	// Click on "See All" of Trending Articles

	@FindBy(xpath = "(//span[contains(@class,'svelte-zvfkc7')][normalize-space()='See All'])[16]")
	WebElement eleSeeAllTrendngArt;

	public void clikOnSeeAllTrendngArticls() {

		eleSeeAllTrendngArt.click();

	}

	// verify page title of Trending Articles page
	public void verifyTrendArtPageTitle(String ptitle2) {
		Assert.assertEquals(driver.getTitle(), ptitle2);
	}

	// Open 3rd article from Trending Articles list

	@FindBy(xpath = "//div[contains(@class,'flex w-full flex-col laptop:mt-3 laptop:w-2/3 laptop:pb-10')]//child::div[6]")
	WebElement eleThirdArticlFrmTrendngArtLst;

	public void clikOnThirdArticlFrmTrendngArtLst() {

		eleThirdArticlFrmTrendngArtLst.click();
		// System.out.println(driver.getTitle());
	}

	// verify page title of Trending Articles page
	public void verifyThirdArticlOfTrendngArtPageTitle(String ptitle3) throws InterruptedException {

		Assert.assertEquals(driver.getTitle(), ptitle3);
		Thread.sleep(6000);
	}

// Verify view count increases
	
	@FindBy(xpath = "//div[contains(@class,'flex items-center space-x-1 text-lg font-medium text-slate-500')]//child::span[1]")
	WebElement eleGetcurntViewCount;

	@FindBy(xpath = "//button[@aria-label='Go back']//*[name()='svg']")
	WebElement eleBackButton;

	@FindBy(xpath = "(//div[@class='flex items-center'])[9]/div")
	WebElement eleGetUpdatedViewCount;

	public void verifyArticleViewCount() {
		
		int curntViewCount1 = 0;
		try {
	        // Attempt to interact with the element
			String curntViewCount = eleGetcurntViewCount.getText();
			System.out.println("The current" + " View " + "count is : " + curntViewCount);
			curntViewCount1 = Integer.parseInt(curntViewCount);
	    } catch (NoSuchElementException e) {
	        // If no comments, print a message and continue
	       System.out.println("There are no Views yet, assuming current Views count as 0.");
	    } 

		// Navigate back to “Article Home Page”
		eleBackButton.click();
		driver.navigate().refresh();

		String updatedViewCount = eleGetUpdatedViewCount.getText();
		System.out.println("The updated" + " View " + "count is : " + updatedViewCount);

		// Convert view counts to integers
	   
	    int updatedViewCount1 = Integer.parseInt(updatedViewCount);

	    // Assert that the updated view count is greater than the current view count
	    Assert.assertTrue(curntViewCount1 < updatedViewCount1, "Test failed: Current view count is not less than the updated view count.");
	}

// Verify like counts

	@FindBy(xpath = "(//div[contains(@class,'flex items-center space-x-4 laptop:space-x-7')])[1]//span")
	WebElement eleClickLikeBtn;

	@FindBy(xpath = "(//div[contains(@class,'flex items-center space-x-4 laptop:space-x-7')])[1]//span")
	WebElement eleGetcurntLikeCount;

	@FindBy(xpath = "(//div[@class='flex items-center'])[10]/div/span")
	WebElement eleGetUpdatedVLikeCount;

	public void verifyArticleLikeCount() throws InterruptedException {

		// open 3rd article again
		eleThirdArticlFrmTrendngArtLst.click();
		// hit the like button
		eleClickLikeBtn.click();

		// get current like count
		int curntLikeCount1 = 0;
		try {
	        // Attempt to interact with the element
			String curntLikeCount = eleGetcurntLikeCount.getText();
			System.out.println("The current" + " Like " + "count is : " + curntLikeCount);
			curntLikeCount1 = Integer.parseInt(curntLikeCount);
	    } catch (NoSuchElementException e) {
	        // If no comments, print a message and continue
	        System.out.println("There are no Likes yet, assuming current Like count as 0.");
	    } 
		
		// Handle the login flow
		LoginPage login = new LoginPage();
		login.simpleLogin(userId, password);

		eleClickLikeBtn.click();
		

		// Navigate back to “Article Home Page”
		eleArticles.click();
		Thread.sleep(2000);
		// Click on See all Trending articles
		eleSeeAllTrendngArt.click();

		Thread.sleep(3000);

		driver.navigate().refresh();

		// get updated like count
		String updatedLikeCount = eleGetUpdatedVLikeCount.getText();
		System.out.println("The updated" + " Like " + "count is : " + updatedLikeCount);
		
		// Convert view counts to integers
	   
	    int updatedLikeCount1 = Integer.parseInt(updatedLikeCount);

	    // Assert that the updated view count is greater than the current view count
	    Assert.assertTrue(curntLikeCount1 < updatedLikeCount1, "Test failed: Current Like count is not less than the updated view count.");

	}

// Verify "Comments" counts

	@FindBy(xpath = "(//div[contains(@class,'flex items-center space-x-4 laptop:space-x-7')])[1]/button[2]/span")
	WebElement eleGetcurntComentCount;

	@FindBy(xpath = "(//div[contains(@class,'flex items-center space-x-4 laptop:space-x-7')])[1]/button[2]")
	WebElement eleClickComentBtn;

	@FindBy(xpath = "//span[normalize-space()='Add a comment...']")
	WebElement eleClickAddComent;

	@FindBy(xpath = "//textarea[contains(@class,'w-full resize-none border-0 bg-slate-100 px-4 py-4 caret-brand-600 focus:border-0 focus:ring-0')]")
	WebElement eleEnterComentField;

	@FindBy(xpath = "//span[normalize-space()='Post']")
	WebElement eleClickPostBtn;

	@FindBy(xpath = "(//*[name()='svg'][contains(@class,'h-7 w-7 fill-current')])[1]")
	WebElement eleClickCancelBtn;

	@FindBy(xpath = "(//div[@class='flex items-center'])[11]/div/span")
	WebElement eleGetUpdatedComentCount;

	public void verifyArticleCommentCount(String entrComent) throws InterruptedException {

		// open 3rd article again
		eleThirdArticlFrmTrendngArtLst.click();

		// get current Comments count
		int curntComentCount1 = 0;
		try {
	        // Attempt to interact with the element
	        String curntComentCount = eleGetcurntComentCount.getText();
	        System.out.println("The current Comments count is : " + curntComentCount);
	        curntComentCount1 = Integer.parseInt(curntComentCount);
	    } catch (NoSuchElementException e) {
	        // If no comments, print a message and continue
	       System.out.println("There are no comments yet, assuming current comment count as 0.");
	    } 

		// Open Comments section
		eleClickComentBtn.click();

		// Open Comment box
		eleClickAddComent.click();

		// Enter comments

		eleEnterComentField.sendKeys(entrComent);

		Thread.sleep(5000);

		// post the comment

		eleClickPostBtn.click();
		
		// close the comment box
		eleClickCancelBtn.click();

		// Navigate back to “Trending Article List”

		eleBackButton.click();
		driver.navigate().refresh();

		// get updated like count
		String updatedComentCount = eleGetUpdatedComentCount.getText();
		System.out.println("The updated" + " Comments " + "count is : " + updatedComentCount);
		
		
		// Convert view counts to integers
	    
	    int updatedComentCount1 = Integer.parseInt(updatedComentCount);

	    // Assert that the updated view count is greater than the current view count
	    Assert.assertTrue(curntComentCount1 < updatedComentCount1, "Test failed: Current Comments count is not less than the updated view count.");

	}
	
	
//Navigate back to “Article Home Page”. On language toggle (English to Hindi), verify Hindi articles should be shown.
	
	@FindBy(xpath = "//button[contains(@class,'w-28 whitespace-nowrap rounded-3xl px-5 py-1.5 font-semibold text-slate-600 hover:bg-slate-200')]")
	WebElement eleHindiTogle;
	
	@FindBy(xpath = "//span[contains(text(),'जो कठिनतम है उसे साध लो, बाकी अपने आप सध जाएगा')]")
	WebElement elehindiArticle;
	
	public void checkLanguageToogle(String expText) throws InterruptedException {
		
		
        try {
            // Click on Articles
            eleArticles.click();

            // Wait until the Hindi Toggle button is clickable and click it
            ExplicitWait.explicitWaitForElementClicable(eleHindiTogle);
            eleHindiTogle.click();
            Thread.sleep(2000);
            driver.navigate().refresh();
           // eleHindiTogle.click();
            
            // Wait until the Hindi article is visible
            ExplicitWait.explicitWaitForElementVisibility(elehindiArticle);
            

            // Check if the Hindi article is displayed
            
            if (elehindiArticle.isDisplayed()) {
                System.out.println("Hindi articles are displayed successfully.");
                String hindiTxt=elehindiArticle.getText();
               Assert.assertEquals(hindiTxt, expText);
            } else {
                System.out.println("Hindi articles are NOT displayed.");
            }

        } catch (StaleElementReferenceException e) {
            // Handle the StaleElementReferenceException if necessary
           // System.out.println("Caught StaleElementReferenceException: " + e.getMessage());
            // Optionally, retry the operation or handle accordingly
        }
		
	}

}
