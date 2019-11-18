package com.hackathon.af.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	@FindBy(xpath = "//th[@id='amount']")
	private WebElement amountHeader;
	
	@FindBy(xpath = "//a[@id='showExpensesChart']")
	private WebElement chartBtn;
	
	
	protected WebDriver driver;
	protected WebDriverWait wait ;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, 60);
	}
	
	public void amountSort() {
		amountHeader.click();
	}
	
	public void expenseChart() {
		chartBtn.click();
	}
	

}
