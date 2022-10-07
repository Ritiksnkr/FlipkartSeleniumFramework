package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfile {
	WebDriver driver;

	public MyProfile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")
	public WebElement MOUSE_HOVER;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div[2]/div[2]/div/ul/li[1]/a/div")
	public WebElement MyProfile;

	@FindBy(xpath = "//div[contains(text(),'Ritik Sonker')]")
	public WebElement VerifyPROFILE;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/a[2]/div")
	public WebElement MANAGEADDRESS;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[2]/div/div/div/div[1]/div/div")
	public WebElement ADD_NEW_ADDRESS;

	@FindBy(name = "name")
	public WebElement NAME;

	@FindBy(name = "phone")
	public WebElement PHONE;

	@FindBy(name = "pincode")
	public WebElement PINCODE;

	@FindBy(name = "addressLine2")
	public WebElement LOCALITY;

	@FindBy(name = "addressLine1")
	public WebElement ADDRESS;

	@FindBy(name = "city")
	public WebElement CITY;

	@FindBy(name = "state")
	public WebElement STATE;

	@FindBy(name = "landmark")
	public WebElement LANDMARK;

	@FindBy(name = "alternatePhone")
	public WebElement ALTERNATE_PHONE;

	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/label[1]/div[1]")
	public WebElement ADDRESS_TYPE;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	public WebElement SAVE;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div/div/div[3]/button[1]")
	public WebElement CONFIRM;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[2]/div/div/div/div[2]/div[1]/div/div[1]")
	public WebElement Del_MOUSEHOVER;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[2]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[2]/span")
	public WebElement DELETE_ADDRESS;

	@FindBy(xpath = "//button[contains(text(),'YES, DELETE')]")
	public WebElement DELETE_BTN;

	public String Verify() {
		return VerifyPROFILE.getText();
	}

	public void Name(String name) {
		NAME.sendKeys(name);
	}

	public void Phone(String phn) {
		PHONE.sendKeys(phn);
	}

	public void Pincode(String pin) {
		PINCODE.sendKeys(pin);
	}

	public void Locality(String local) {
		LOCALITY.sendKeys(local);
	}

	public void Address(String addrss) {
		ADDRESS.sendKeys(addrss);
	}

	public void City(String cty) {
		CITY.sendKeys(cty);
	}

	public void Landmark(String landmark) {
		LANDMARK.sendKeys(landmark);
	}

	public void Alternate_Phone(String altphn) {
		ALTERNATE_PHONE.sendKeys(altphn);
	}
}
