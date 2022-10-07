package com.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.Filter;
import Utilities.ConfigFileReader;

public class FilterTest extends BaseClass {
	private static Logger logger = LogManager.getLogger(FilterTest.class);
	Filter filter;
	ConfigFileReader cr;

	public FilterTest() {
		super();
	}

	@BeforeMethod
	public void seTup() throws IOException {
		setup();
		filter = new Filter(null);
	}

	@Test(priority = 16, groups = { "sanity" })
	public void Is_Filter_Available() throws Exception {
		filter = new Filter(driver);
		SearchPageTest search = new SearchPageTest();
		search.SearchItem();
		Assert.assertEquals("Filters", filter.Check_Filter());
		logger.info(filter.Check_Filter() + " Assertion Passed");
	}

	@Test(priority = 17, groups = { "sanity" })
	public void Filter_Test() throws Exception {
		filter = new Filter(driver);
		SearchPageTest search = new SearchPageTest();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		search.SearchItem();
		filter.FilterPrice();
		logger.info("Minimum Price Selected");
		Thread.sleep(2000);
		filter.Select_Brand();
		logger.info("Brand selected");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		filter.Select_CUSTOMER_RATING();
		logger.info("Customer Rating Entered");
		Thread.sleep(2000);
		filter.Select_Storage();
		logger.info("Storage requirement selected");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		filter.Select_OS();
		logger.info("Operating System requirement selected");
		Thread.sleep(2000);
		filter.Select_Network_Type();
		logger.info("Type of network selected");
		Thread.sleep(5000);
	}

//	@Test(priority = 17)
//	public void FilterProductBy_Low_to_High() throws Exception {
//		filter = new Filter(driver);
//		SearchPageTest search = new SearchPageTest();
//		search.SearchItem();
//		filter.FilterPrice();
//		Thread.sleep(2000);
//	}
//
//	@Test(priority = 18)
//	public void FilterProductBy_Brand() throws Exception {
//		filter = new Filter(driver);
//		SearchPageTest search = new SearchPageTest();
//		search.SearchItem();
//		filter.Select_Brand();
//		Thread.sleep(2000);
//	}
//
//	@Test(priority = 19)
//	public void FilterProductBy_Storage() throws Exception {
//		filter = new Filter(driver);
//		SearchPageTest search = new SearchPageTest();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		search.SearchItem();
//		js.executeScript("window.scrollBy(0,500)");
//		Thread.sleep(2000);
//		filter.Select_CUSTOMER_RATING();
//		Thread.sleep(2000);
//	}
//
//	@Test(priority = 20)
//	public void FilterProductBy_CustomerRating() throws Exception {
//		filter = new Filter(driver);
//		SearchPageTest search = new SearchPageTest();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		search.SearchItem();
//		js.executeScript("window.scrollBy(0,500)");
//		Thread.sleep(2000);
//		filter.Select_Storage();
//		Thread.sleep(2000);
//	}
//
//	@Test(priority = 21)
//	public void FilterProductBy_OperatinSystem() throws Exception {
//		filter = new Filter(driver);
//		SearchPageTest search = new SearchPageTest();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		search.SearchItem();
//		js.executeScript("window.scrollBy(0,500)");
//		Thread.sleep(2000);
//		filter.Select_OS();
//		Thread.sleep(2000);
//	}
//
//	@Test(priority = 22)
//	public void FilterProductBy_NetworkType() throws Exception {
//		filter = new Filter(driver);
//		SearchPageTest search = new SearchPageTest();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		search.SearchItem();
//		js.executeScript("window.scrollBy(0,500)");
//		Thread.sleep(2000);
//		filter.Select_Network_Type();
//		Thread.sleep(5000);
//	}
}
