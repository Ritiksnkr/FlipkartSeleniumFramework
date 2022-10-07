package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrder {
	WebDriver driver;

	public PlaceOrder(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Place Order')]")
	WebElement PLACEORDER;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[1]/input")
	WebElement MOBILE;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[3]/button")
	WebElement CONTINUE;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[2]/input")
	WebElement PSWRD;

	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/button[1]")
	WebElement LOGIN;

	public void clickPlaceOrder() {
		PLACEORDER.click();
	}

	public void Login(String Mob, String Pswrd) throws InterruptedException {
		MOBILE.sendKeys(Mob);
		Thread.sleep(2000);
		CONTINUE.click();
		Thread.sleep(2000);
		PSWRD.sendKeys(Pswrd);
		Thread.sleep(2000);
		LOGIN.click();

	}
}
