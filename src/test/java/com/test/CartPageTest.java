package com.test;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.CartPage;
import com.pages.SearchPage;

public class CartPageTest extends BaseClass {
	private static Logger logger = LogManager.getLogger(CartPageTest.class);
	CartPage cart;
	SearchPage search;

	public CartPageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() throws IOException {
		setup();
		cart = new CartPage(null);
	}

	@Test(priority = 12)
	public void GotoCart_Test() throws Exception {
		cart = new CartPage(driver);
		LoginPageTest login = new LoginPageTest();
		login.LoginTest_with_ValidCredential();
		Thread.sleep(3000);
		cart.ClickCart();
		logger.info("Cart Clicked");
		Thread.sleep(2000);

	}

	@Test(priority = 13)
	public void AddToCart() throws Exception {
		cart = new CartPage(driver);
		SearchPageTest st = new SearchPageTest();
		st.SearchItem();
		cart.SelectItem();
		logger.info("Item Selected");

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)");
		Thread.sleep(3000);

		cart.ClickAddToCart();
		logger.info("ADD_TO_CART Clicked");
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
