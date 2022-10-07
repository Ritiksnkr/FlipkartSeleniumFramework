package com.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pages.LoginPage;

import Utilities.CommonUtils;
import Utilities.ConfigFileReader;
import Utilities.ReadXLSXdata;

public class LoginPageTest extends BaseClass {
	private static Logger logger = LogManager.getLogger(LoginPageTest.class);
	LoginPage loginPage;
	ConfigFileReader cr;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		setup();
		loginPage = new LoginPage(null);
	}

	@Test(priority = 1, groups = { "smoke" })
	public void LoginTest_with_ValidCredential() throws Exception {

		loginPage = new LoginPage(driver);
		ReadXLSXdata excel = new ReadXLSXdata();
		String EXECUTION_REQUIRED = excel.readingData(2, 1);
		CommonUtils.toCheckExecutionRequired(EXECUTION_REQUIRED);
		String USERID = excel.readingData(0, 1);
		String PASSWORD = excel.readingData(1, 1);
		loginPage.EnterMobile(USERID);
		logger.info("User's valid Mobile Number is entered");
		loginPage.EnterPassword(PASSWORD);
		logger.info("User's valid Password is entered");
		Thread.sleep(5000);
		loginPage.ClickLoginBtn();
		logger.info("Clicked on login button");
		String ActualTitle = driver.getTitle();
		logger.info("Actual Title is", ActualTitle);
		String ExpectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		logger.info("Expected Title is", ExpectedTitle);
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

	@Test(priority = 2, groups = { "smoke" })
	public void LoginTest_with_InValidCredential() throws Exception {
		loginPage = new LoginPage(driver);
		ReadXLSXdata excel = new ReadXLSXdata();
		String EXECUTION_REQUIRED = excel.readingData(2, 2);
		CommonUtils.toCheckExecutionRequired(EXECUTION_REQUIRED);
		String USERID = excel.readingData(0, 2);
		String PASSWORD = excel.readingData(1, 1);
		loginPage.EnterMobile(USERID);
		logger.info("User's Invalid Mobile Number or Email is entered");
		loginPage.EnterPassword(PASSWORD);
		logger.info("User's Invalid Password is entered");
		loginPage.ClickLoginBtn();
		logger.info("Clicked on login button");
		Thread.sleep(5000);
		String Actual = loginPage.Error2();
		logger.info("Actual Title is", Actual);
		String Expected = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		logger.info("Expected Title is", Expected);
		Assert.assertEquals(Actual, Expected);
	}

	@Test(priority = 3, groups = { "smoke" })
	public void LoginTest_with_BlankPassword() throws Exception {
		loginPage = new LoginPage(driver);
		ReadXLSXdata excel = new ReadXLSXdata();
		String EXECUTION_REQUIRED = excel.readingData(2, 2);
		CommonUtils.toCheckExecutionRequired(EXECUTION_REQUIRED);
		String USERID = excel.readingData(0, 1);
		loginPage.EnterMobile(USERID);
		logger.info("Mobile Number or Email is entered");
		loginPage.EnterPassword("");
		logger.info("Password is not entered");
		loginPage.ClickLoginBtn();
		logger.info("Clicked on login button");
		Thread.sleep(5000);
		String Actual = loginPage.Error();
		logger.info("Actual Title is", Actual);
		String Expected = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		logger.info("Expected Title is", Expected);
		Assert.assertEquals(Actual, Expected);
	}

	@Test(priority = 4, groups = { "smoke" })
	public void LoginTest_with_BlankEmail() throws Exception {
		loginPage = new LoginPage(driver);
		ReadXLSXdata excel = new ReadXLSXdata();
		String EXECUTION_REQUIRED = excel.readingData(2, 2);
		CommonUtils.toCheckExecutionRequired(EXECUTION_REQUIRED);
		String PASSWORD = excel.readingData(1, 2);
		loginPage.EnterMobile("");
		logger.info("Email or Moile is not entered");
		loginPage.EnterPassword(PASSWORD);
		logger.info("Password is entered");
		loginPage.ClickLoginBtn();
		logger.info("Clicked on login button");
		Thread.sleep(5000);
		String Actual = loginPage.EmailError();
		logger.info("Actual Title is", Actual);
		String Expected = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		logger.info("Expected Title is", Expected);
		Assert.assertEquals(Actual, Expected);
	}
}
