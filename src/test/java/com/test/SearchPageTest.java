package com.test;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.SearchPage;

import Utilities.ConfigFileReader;

public class SearchPageTest extends BaseClass {
	private static Logger logger = LogManager.getLogger(SearchPageTest.class);
	static SearchPage search;
	static ConfigFileReader cr;

	public SearchPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		setup();
		search = new SearchPage(null);
	}

	@Test(priority = 10, groups = { "sanity" })
	public static void SearchItem() throws Exception {
		Actions actions = new Actions(driver);
		Action sendEsc = actions.sendKeys(Keys.ESCAPE).build();
		sendEsc.perform();

		search = new SearchPage(driver);
		search.ClickSearchBox(ConfigFileReader.getProperty("SEARCH_ITEM"));
		logger.info("Clicked on searchbox");

		Thread.sleep(2000);
		search.ClickSearchBtn();
		logger.info("Search Button clicked");

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(5000);
		String ActualTitle = driver.getTitle();
		logger.info("Actual Title is ", ActualTitle);

		String ExpectedTitle = cr.getProperty("SEARCH_ITEM")
				+ "- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
		logger.info("Expected Title is ", ExpectedTitle);

		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

	@Test(priority = 11, groups = { "sanity" })
	public void FetchTotalProducts() throws InterruptedException {
		Actions actions = new Actions(driver);
		Action sendEsc = actions.sendKeys(Keys.ESCAPE).build();
		sendEsc.perform();

		search = new SearchPage(driver);
		search.ClickSearchBox(cr.getProperty("SEARCH_ITEM"));
		logger.info("");

		Thread.sleep(2000);
		search.ClickSearchBtn();
		logger.info("");

		Thread.sleep(2000);
		Action sendPageDown = actions.sendKeys(Keys.PAGE_DOWN).build();
		sendPageDown.perform();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> ListTotal = driver.findElements(By.xpath("//*[@class='_1YokD2 _3Mn1Gg']/div"));
		System.out.println("Total no. of Products" + ListTotal.size());
		logger.info("");

	}
}
