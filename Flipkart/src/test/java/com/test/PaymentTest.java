package com.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.Payment;

public class PaymentTest extends BaseClass {
	private static Logger logger = LogManager.getLogger(PaymentTest.class);
	Payment payment;

	public PaymentTest() {
		super();
	}

	@BeforeMethod
	public void seTup() throws IOException {
		setup();
		payment = new Payment(null);
	}

	@Test(priority = 15, groups = { "smoke" })
	public void ProceedToPayment() throws Exception {
		payment = new Payment(driver);
		CartPageTest cart = new CartPageTest();
		cart.GotoCart_Test();
		payment.ClickPlaceOrder();
		logger.info("Clicked on place order");

		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.moveToElement(payment.CLICKandHOLD);
		logger.info("Mouse hover on press and hold button for verification");

		actions.clickAndHold().perform();
		logger.info("Button is pressed and hold");

		// payment.Payment();
		// Thread.sleep(2000);
		// payment.Accept_OpenBoxDel();
		// Thread.sleep(2000);
	}
}
