package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payment {
	WebDriver driver;

	public Payment(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"to-payment\"]/button")
	WebElement CONT_TO_PAYMENT;

	@FindBy(xpath = "//span[contains(text(),'Place Order')]")
	WebElement PLACE_ORDER;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div/div/button")
	WebElement OPENBOXDEL;

	@FindBy(xpath = "//*[@id=\"injKWYlZkxsqfwg\"]")
	public WebElement CLICKandHOLD;

	public void ClickPlaceOrder() {
		PLACE_ORDER.click();
	}

	public void payment() {
		CONT_TO_PAYMENT.click();

	}

	public void Accept_OpenBoxDel() {
		OPENBOXDEL.click();
	}
}
