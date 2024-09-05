package org.acharyaprashant.testCases;

import java.io.IOException;
import java.util.HashMap;

import org.acharyaprashant.pageObject.ArticlesHomePage;
import org.acharyaprashant.utilities.JsonDataReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


public class TS_001_ArticlesHomePage extends BaseClass {

	// Pass the index number to get the data set from json file
	@DataProvider(name = "getData")
	public Object[][] getData() throws IOException {
		JsonDataReader gd = new JsonDataReader();
		return gd.getDataFromIndex(0);
	}

	//ArticlesHomePage articlesHomePage = new ArticlesHomePage();

	@Test(priority = 1, alwaysRun = true, dataProvider = "getData")

	@Description("Check the articles VIEW counts")
	@Epic("eg.EP_001")
	@Feature("Articles_View")
	@Story("eg.US_001")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyArticlViewCounts(HashMap<String, String> input) throws InterruptedException {
		ArticlesHomePage articlesHomePage = new ArticlesHomePage();
		articlesHomePage.clikOnArticles();
		articlesHomePage.verifyArtPageTitle(input.get("expArtPageTitle"));
		articlesHomePage.clikOnSeeAllTrendngArticls();
		articlesHomePage.verifyTrendArtPageTitle(input.get("exptTrendingArtsPageTitle"));
	
		articlesHomePage.verifyArticleViewCount();

	}

	@Test(priority = 2, alwaysRun = true)

	@Description("Check the articles LIKE counts")
	@Epic("eg.EP_001")
	@Feature("Articles_Like")
	@Story("eg.US_001")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyArticleLikeCounts() throws InterruptedException {
		ArticlesHomePage articlesHomePage = new ArticlesHomePage();
		articlesHomePage.verifyArticleLikeCount();

	}
	
	@Test(priority = 3, alwaysRun = true, dataProvider = "getData")

	@Description("Check the articles Comments counts")
	@Epic("eg.EP_001")
	@Feature("Articles_Comments")
	@Story("eg.US_001")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyArticleCommentsCounts(HashMap<String, String> input) throws InterruptedException {
		ArticlesHomePage articlesHomePage = new ArticlesHomePage();
		articlesHomePage.verifyArticleCommentCount(input.get("commentData"));

	}
	
	
	@Test(priority = 4, alwaysRun = true, dataProvider = "getData")

	@Description("Check the Hindi articles")
	@Epic("eg.EP_001")
	@Feature("Hindi_Articles")
	@Story("eg.US_001")
	@Severity(SeverityLevel.MINOR)
	public void verifyHindiArticlesToogle(HashMap<String, String> input) throws InterruptedException {
		ArticlesHomePage articlesHomePage = new ArticlesHomePage();
		articlesHomePage.checkLanguageToogle(input.get("expHindiTxt"));

	}
	
}
