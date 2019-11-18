package com.hackathon.af.tests;

import org.junit.Assert;
import org.junit.*;
import org.junit.runners.MethodSorters;

import com.hackathon.af.pages.LoginPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends TestBase {
	
	LoginPage login = new LoginPage(driver);
	
	@Test
	public void acheckElement() {
		System.out.println("The result cannot be tested using Traditional Automation since difficult to define the Asserts");
	}
	
	
	@Test
	public void bLoginWithoutUsernameAndPassword() {
		login.login("","");
		Assert.assertTrue(login.isAlertVisible("Please enter both username and password"));
	}
	
	@Test
	public void cLoginWithoutUsername() {
		login.login("","123");
		Assert.assertTrue(login.isAlertVisible("Username must be present"));
	}
	
	@Test
	public void dLoginWithUsernameAndPassword() {
		login.login("abc","123");
		driver.navigate().back();
	}
	
	@Test
	public void eLoginWithoutPassword() {
		login.login("abc","");
		Assert.assertTrue(login.isAlertVisible("Password must be present"));
	}
	
}
