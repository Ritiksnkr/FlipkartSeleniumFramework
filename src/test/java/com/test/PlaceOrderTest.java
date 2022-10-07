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
import com.pages.PlaceOrder;

import Utilities.ReadXLSXdata;

public class PlaceOrderTest extends BaseClass {
	private static Logger logger = LogManager.getLogger(PlaceOrderTest.class);
	PlaceOrder po;

	public PlaceOrderTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		setup();
		po = new PlaceOrder(null);
	}

	@Test(priority = 14, groups = { "sanity" })
	public void placeOrderTest() throws Exception {
		po = new PlaceOrder(driver);
		CartPage cart = new CartPage(driver);
		SearchPageTest.SearchItem();
		cart.SelectItem();
		logger.info("Item Selected");

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)");
		Thread.sleep(3000);

		cart.ClickAddToCart();
		logger.info("Clicked on add to cart");

		Thread.sleep(2000);
		po.clickPlaceOrder();
		logger.info("Clicked on Place Order");

		ReadXLSXdata excel = new ReadXLSXdata();
		String USERID = excel.readingData(0, 1);
		String PASSWORD = excel.readingData(1, 1);
		po.Login(USERID, PASSWORD);
		logger.info("Entered Mobile number and Pasword");
		logger.info("Clicked on login");

		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(tabs2.get(0));
	}
}
