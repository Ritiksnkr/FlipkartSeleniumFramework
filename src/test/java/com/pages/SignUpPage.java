package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	WebDriver driver;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "New to Flipkart? Create an account")
	WebElement SIGNUP;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
	WebElement MOBILE;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")
	WebElement CONT;

	public void Click_CreateAccount() {
		SIGNUP.click();
	}

	public void Enter_Mobile(String Mob) {
		MOBILE.sendKeys(Mob);
		CONT.click();
	}
}
