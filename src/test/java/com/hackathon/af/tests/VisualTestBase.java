package com.hackathon.af.tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;

public abstract class VisualTestBase {
	
	protected static WebDriver driver;
	protected static Eyes eyes;
	protected static EyesRunner runner;
	
	@BeforeClass
	public static void setUp() {
		Properties prop = System.getProperties();
		try {
			prop.load(new FileInputStream(new File("src/test/resources/test.properties")));
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		
		System.setProperty("webdriver.chrome.driver", "src//test//resources//driver//chromedriver.exe");
		driver = new ChromeDriver();
		initiateEyes();
		
		driver.get("https://demo.applitools.com/hackathon.html?showAd=true");
		//driver.get("https://demo.applitools.com/hackathonV2.html?showAd=true");
			
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
		eyes.abortIfNotClosed();
	}
	
	private static void initiateEyes() {
		runner = new ClassicRunner();
		eyes = new Eyes(runner);
		eyes.setApiKey(System.getProperty("applitools.api.key"));
	}
	

}
