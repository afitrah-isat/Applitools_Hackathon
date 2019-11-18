package com.hackathon.af.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.applitools.eyes.BatchInfo;
import com.hackathon.af.pages.LoginPage;
import com.hackathon.af.pages.MainPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VisualMainTest extends VisualTestBase {
	private static BatchInfo batch;
	MainPage main = new MainPage(driver);
	LoginPage login = new LoginPage(driver);
	
	@Test
	public void aDynamicContentTest() {
		login.login("abc", "123");
		validateWindow();
	}
	
	@Test
	public void bTableSortTest() {
		main.amountSort();
		validateWindow();
	}
	
	@Test
	public void cChartTest() {
		main.expenseChart();
		validateWindow();
	}
	
	
	public void validateWindow() {
		batch = new BatchInfo("Main");
		batch.setId("main123");
		eyes.setBatch(batch); 
		eyes.setForceFullPageScreenshot(true);
		eyes.open(driver, "Hackathon", Thread.currentThread().getStackTrace()[2].getMethodName());
		eyes.checkWindow();
		eyes.close();
	}

}
