package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// *********Web Elements by using Page Factory*********
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
	public WebElement mobile;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")
	public WebElement password;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")
	public WebElement loginButton;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Please enter Password')]")
	public WebElement PASSWORD_ERROR;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),\"Looks like you're new here!\")]")
	public WebElement LOGIN_ERROR2;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Please enter valid Email ID/Mobile number')]")
	public WebElement EMAIL_ERROR;

	public void EnterMobile(String Mob) {
		mobile.sendKeys(Mob);
	}

	public void EnterPassword(String Pswrd) {
		password.sendKeys(Pswrd);
	}

	public void ClickLoginBtn() {
		loginButton.click();
	}

	public String Error() {
		return PASSWORD_ERROR.getText();
	}

	public String Error2() {
		return LOGIN_ERROR2.getText();
	}

	public String EmailError() {
		return EMAIL_ERROR.getText();
	}
}
