package com.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.SignUpPage;

import Utilities.ConfigFileReader;
import Utilities.ReadXLSXdata;

public class SignUpPageTest extends BaseClass {
	private static Logger logger = LogManager.getLogger(SignUpPageTest.class);
	static SignUpPage signup;
	static ConfigFileReader cr;

	public SignUpPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		setup();
		signup = new SignUpPage(null);
	}

	@Test(priority = 5, groups = { "smoke" })
	public void CreateAccount() throws Exception {
		signup = new SignUpPage(driver);

		signup.Click_CreateAccount();
		logger.info("Clicked on create account");

		ReadXLSXdata excel = new ReadXLSXdata();
		String MOBILE = excel.readingData(0, 2);
		signup.Enter_Mobile(MOBILE);
		logger.info("Mobile or email entered");

		Thread.sleep(3000);
	}
}
