package com.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.MyProfile;
import Utilities.ConfigFileReader;

public class MyProfileTest extends BaseClass {
	private static Logger logger = LogManager.getLogger(MyProfileTest.class);
	MyProfile profile;
	ConfigFileReader cr;

	public MyProfileTest() {
		super();
	}

	@BeforeMethod
	public void seTup() throws IOException {
		setup();
		profile = new MyProfile(null);
	}

	@Test(priority = 20, groups = { "smoke" })
	public void MyProfile_Test() throws Exception {
		profile = new MyProfile(driver);
		LoginPageTest login = new LoginPageTest();
		login.LoginTest_with_ValidCredential();
		Thread.sleep(3000);

		Actions act = new Actions(driver);
		act.moveToElement(profile.MOUSE_HOVER).perform();
		logger.info("Mouse hover on Login");

		profile.MyProfile.click();
		logger.info("Clicke on My Profile");

		Thread.sleep(3000);
		String Actual = profile.Verify();
		logger.info("Actual User Name on profile is ", Actual);

		Assert.assertEquals(Actual, "Ritik Sonker");
		logger.info("Expected User Name on profile is Ritik Sonker");

		Thread.sleep(3000);
	}

	@Test(priority = 21, groups = { "smoke" })
	public void Add_New_Address() throws Exception {
		profile = new MyProfile(driver);
		LoginPageTest login = new LoginPageTest();
		login.LoginTest_with_ValidCredential();
		Thread.sleep(3000);

		Actions act = new Actions(driver);
		act.moveToElement(profile.MOUSE_HOVER).perform();
		logger.info("Mouse hover on Login");

		Thread.sleep(2000);
		profile.MyProfile.click();
		logger.info("Clicked on My Profile");

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,900)");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,-600)");
		Thread.sleep(3000);
		act.moveToElement(profile.MANAGEADDRESS).click().perform();
		logger.info("Mouse hover on Manage Addresses and clicked");

		Thread.sleep(2000);
		profile.ADD_NEW_ADDRESS.click();
		logger.info("clicked on Add New address");

		Thread.sleep(3000);
		profile.Name(cr.getProperty("name"));
		logger.info("Entered Name");

		profile.Phone(cr.getProperty("phn"));
		logger.info("Entered Phone number");

		profile.Phone(cr.getProperty("addrss"));
		logger.info("entered Address");

		profile.Pincode(cr.getProperty("pin"));
		logger.info("entered Pincode");

		profile.Locality(cr.getProperty("locality"));
		logger.info("Entered Locality");

		profile.Address(cr.getProperty("addrss"));
		logger.info("Entered Address");

		profile.City(cr.getProperty("city"));
		logger.info("Entered city");

		Select s = new Select(profile.STATE);
		s.selectByValue("Uttar Pradesh");
		logger.info("entered state");

		profile.Landmark(cr.getProperty("landmark"));
		logger.info("Entered Landmark");

		profile.Alternate_Phone(cr.getProperty("altphn"));
		logger.info("Entered Alternate Phone number");

		profile.ADDRESS_TYPE.click();
		logger.info("clicked on Address Type");

		profile.SAVE.click();
		logger.info("Save button clicked");

		Thread.sleep(2000);
		if (profile.CONFIRM.isDisplayed()) {
			profile.CONFIRM.click();
			logger.info("Confim clicked");
		}
		Thread.sleep(5000);
	}

	@Test(priority = 22, groups = { "smoke" })
	public void Delete_Address() throws Exception {
		profile = new MyProfile(driver);
		LoginPageTest login = new LoginPageTest();
		login.LoginTest_with_ValidCredential();
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(profile.MOUSE_HOVER).perform();
		logger.info("Mouse hover on Login");

		Thread.sleep(2000);
		profile.MyProfile.click();
		logger.info("Clicked on My Profile");

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,900)");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,-600)");
		Thread.sleep(3000);
		act.moveToElement(profile.MANAGEADDRESS).click().perform();
		logger.info("Mouse hover on Manage Addresses and clicked");

		Thread.sleep(2000);

		act.moveToElement(profile.Del_MOUSEHOVER).perform();
		logger.info("Mouse hover on delete option");

		profile.DELETE_ADDRESS.click();
		logger.info("Delete option selected");

		profile.DELETE_BTN.click();
		logger.info("Delete button clicked");
		logger.info("Delete button clicked");
		logger.info("Delete button clicked");

		Thread.sleep(3000);

	}
}
