package com.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.MyOrders;

public class MyOrdersTest extends BaseClass {

	private static Logger logger = LogManager.getLogger(MyOrdersTest.class);
	MyOrders order;

	public MyOrdersTest() {
		super();
	}

	@BeforeMethod
	public void seTup() throws IOException {
		setup();
		order = new MyOrders(null);
	}

	@Test(priority = 23, groups = { "sanity" })
	public void MyOrders_Test() throws Exception {
		order = new MyOrders(driver);
		MyProfileTest profile = new MyProfileTest();
		profile.MyProfile_Test();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,900)");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,-600)");
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(order.MyORDERS).click().perform();
		logger.info("Mouse hover on My Orders and clicked");
		Thread.sleep(3000);
		if (order.VerifyPage.isDisplayed()) {
			logger.info("My Orders Page is displayed");
			;
		} else {
			logger.info("My Orders Page is not displayed");
			throw new Exception("Orders Page Not Found!");
		}
	}

}
