package com.test;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.Grocery;

import Utilities.ConfigFileReader;

public class GroceryTest extends BaseClass {
	private static Logger logger = LogManager.getLogger(GroceryTest.class);
	Grocery grocery;
	ConfigFileReader cr;

	public GroceryTest() {
		super();
	}

	@BeforeMethod
	public void Setup() throws IOException {
		setup();
		grocery = new Grocery(null);
	}

	@Test(priority = 18, groups = { "sanity" })
	public void Check_Grocery_Section() {
		grocery = new Grocery(driver);
		logger.info("Actual title is "
				+ "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		logger.info("Expected " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(),
				"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");

	}

	@Test(priority = 19, groups = { "sanity" })
	public void GroceryTest() throws InterruptedException {
		grocery = new Grocery(driver);
		Actions actions = new Actions(driver);
		Action sendEsc = actions.sendKeys(Keys.ESCAPE).build();
		sendEsc.perform();

		grocery.ClickGrocery();
		logger.info("Clicked on Grocery");

		Thread.sleep(5000);
		grocery.PinCode(cr.getProperty("PIN"));
		logger.info("Pin code entered");

		Thread.sleep(2000);
		grocery.click_CurrentLocation();
		logger.info("Clicked on Current Location");

		Thread.sleep(3000);
		grocery.SearchProduct(cr.getProperty("GROCERY_ITEM"));
		logger.info("Product Searched");

		Thread.sleep(3000);
		grocery.SelectItem();
		logger.info("Product Selected");

		ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab2.get(1));
		Thread.sleep(3000);
		grocery.AddToBasket();
		logger.info("Product added to basket");

		Thread.sleep(2000);
		grocery.GotoBasket();
		logger.info("Clicked on goto basket");

		Thread.sleep(2000);
		grocery.PlaceOrder();
		logger.info("Clicked on Place Order");

		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(tab2.get(0));
		driver.navigate().refresh();

	}
}
