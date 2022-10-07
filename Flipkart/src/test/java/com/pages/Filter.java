package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Filter {
	WebDriver driver;

	public Filter(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[4]/div[1]/select")
	WebElement PRICEFROM;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div[1]/div/section[3]/div[2]/div/div/div/label/div[2]")
	WebElement BRAND;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[1]/div/section[5]/div[1]/div")
	WebElement CUSTOMER_RATING;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[1]/div/section[5]/div[2]/div/div[1]/div/label/div[2]")
	WebElement RATING;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[1]/div/section[9]/div[1]/div")
	WebElement INTERNAL_STORAGE;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[1]/div/section[9]/div[2]/div/div[2]/div/label/div[2]")
	WebElement STORAGE;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[1]/div/section[17]/div[1]")
	WebElement OS;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[1]/div/section[17]/div[2]/div/div/div/label/div[2]")
	WebElement IOS;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[1]/div/section[17]/div/div")
	WebElement NETWORK_TYPE;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[1]/div/section[17]/div[2]/div/div[2]/div/label/div[2]")
	WebElement N5G;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[1]/div/section[1]/div[1]/div[1]/span")
	WebElement FILTER;

	public void FilterPrice() throws InterruptedException {
		Select s = new Select(PRICEFROM);
		s.selectByValue("10000");
	}

	public void Select_Brand() throws InterruptedException {

		BRAND.click();
	}

	public void Select_CUSTOMER_RATING() throws InterruptedException {

		RATING.click();
	}

	public void Select_Storage() throws InterruptedException {
		INTERNAL_STORAGE.click();
		Thread.sleep(2000);
		STORAGE.click();

	}

	public void Select_OS() throws InterruptedException {
		OS.click();
		Thread.sleep(2000);
		IOS.click();
	}

	public void Select_Network_Type() throws InterruptedException {
		NETWORK_TYPE.click();
		Thread.sleep(2000);
		N5G.click();
	}
	
	public String Check_Filter()
	{
		return FILTER.getText();
	}
}
