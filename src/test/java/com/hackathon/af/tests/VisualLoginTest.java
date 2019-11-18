package com.hackathon.af.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.applitools.eyes.BatchInfo;
import com.hackathon.af.pages.LoginPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VisualLoginTest extends VisualTestBase {

	private static BatchInfo batch;
	LoginPage login = new LoginPage(driver);
	
	@Test
	public void acheckElement() {
		validateWindow();
	}
	
	@Test
	public void bLoginWithoutUsernameAndPassword() {
		login.login("","");
		validateWindow();
	}
	
	@Test
	public void cLoginWithoutUsername() {
		login.login("","123");
		validateWindow();
	}
	
	@Test
	public void dLoginWithUsernameAndPassword() {
		login.login("abc","123");
		validateWindow();
		driver.navigate().back();
	}
	
	@Test
	public void eLoginWithoutPassword() {
		login.login("abc","");
		validateWindow();
	}
	
	public void validateWindow() {
		batch = new BatchInfo("Login");
		batch.setId("login123");
		eyes.setBatch(batch); 
		eyes.open(driver, "Hackathon", Thread.currentThread().getStackTrace()[2].getMethodName());
		eyes.checkWindow();
		eyes.close();
	}

}
