package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrders {
	
	WebDriver driver;

	public MyOrders(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]")
	public WebElement MyORDERS;

	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/input[1]")
	public WebElement VerifyPage;
	
}
