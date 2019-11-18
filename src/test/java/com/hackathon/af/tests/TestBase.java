package com.hackathon.af.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;


public abstract class TestBase {
	
	protected static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "src//test//resources//driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.applitools.com/hackathonV2.html/showAd=true");
			
	}
	
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
