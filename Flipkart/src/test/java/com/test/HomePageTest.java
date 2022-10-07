package com.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.HomePage;

public class HomePageTest extends BaseClass {

	private static Logger logger = LogManager.getLogger(HomePageTest.class);
	HomePage home;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() throws IOException {
		setup();
		home = new HomePage(null);
	}

	@Test(priority = 6, groups = { "sanity" })
	public void Verify_Title() {
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		logger.info("Title Verified");
	}

	@Test(priority = 7, groups = { "sanity" })
	public void SearchBoxDisplayed() {
		home = new HomePage(driver);
		home.searchBox.isDisplayed();
		logger.info("Search Box is displayed");
	}

	@Test(priority = 8, groups = { "sanity" })
	public void is_Cart_Displayed() {
		home = new HomePage(driver);
		home.CARTBTN.isDisplayed();
		logger.info("Cart Option is displayed");
	}

	@Test(priority = 9, groups = { "sanity" })
	public void is_Logo_Displayed() {
		home = new HomePage(driver);
		home.LOGO.isDisplayed();
		logger.info("Logo is displayed");
	}
}
