package org.acharyaprashant.testCases;

import java.time.Duration;

import org.acharyaprashant.pageObject.LoginPage;
import org.acharyaprashant.utilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	static ReadConfig readconfig = new ReadConfig();
	public String baseUrl = readconfig.getApplicationUrl();
	public static String userId = readconfig.getUserId();
	public static String password = readconfig.getPassword();
	
	public static WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	//public static  Properties prop;
	
	
	public WebDriver initBrowser() {
		
		// It will handle the ChromeDriver.exe
		//WebDriverManager.chromedriver().setup();
		
		WebDriverManager.chromedriver().clearDriverCache().setup();
		
		// This code is for headless browser execution
		/*
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--headless=new");
		driver = new ChromeDriver(opt);
		*/
		
		
		// Initialize the ChromeDriver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		tdriver.set(driver);
		return getDriver();
	}

	public void openUrl() {
		driver.get(baseUrl);

	}
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		initBrowser();
		openUrl();
		
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
	// to pass same driver instance to the allure listers class
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}
	
	

}
