package com.hackathon.af.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernameInput;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordInput;
	
	@FindBy(xpath = "//button[@id='log-in']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-warning']")
	private WebElement alertTxt;
	
	
	protected WebDriver driver;
	protected WebDriverWait wait ;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, 60);
	}
	
	public void login(String username, String password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginBtn.click();
	}
	
	public boolean isAlertVisible(String message) {
		if(alertTxt.getText().equalsIgnoreCase(message)) {
			if  (alertTxt.getCssValue("z-index").contains("-1"))
				return false;
			else 
				return true;
		}		
		else
			return false;
	}
	
}
