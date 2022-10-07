package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.LoginPageTest;

public class CartPage {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[6]/div/div/a")
	public WebElement CART;

	@FindBy(xpath = "//div[contains(text(),'APPLE iPhone 13 (Starlight, 128 GB)')]")
	public WebElement SelectItem;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")
	public WebElement AddtoCart;

	public void ClickCart() {
		CART.click();
	}

	public void SelectItem() {
		SelectItem.click();
	}

	public void ClickAddToCart() {
		AddtoCart.click();
	}

}
