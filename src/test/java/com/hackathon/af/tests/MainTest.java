package com.hackathon.af.tests;

import com.hackathon.af.pages.LoginPage;
import com.hackathon.af.pages.MainPage;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainTest extends TestBase {

	MainPage main = new MainPage(driver);
	LoginPage login = new LoginPage(driver);
	
	
	@Test
	public void aTableSortTest() {
		login.login("abc", "123");
		main.amountSort();
		Assert.fail("The result cannot be tested using Traditional Automation since String sort problem");
	}
	
	@Test
	public void bChartTest() {
		main.expenseChart();
		Assert.fail("The result cannot be tested using Traditional Automation since image view");
	}
	
	@Test
	public void cDynamicContentTest() {
		Assert.fail("The result cannot be tested using Traditional Automation since image view");
	}
	
}
