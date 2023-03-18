package com.etsy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPasswordPageObjects {
	public ForgetPasswordPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy (id="email")
	public WebElement emailInputField;
	
	//Your email address
	@FindBy (css="[for='email']")
	public WebElement emailLabel;
	
	//Reset your password
	@FindBy (xpath="//h1[text()='Reset your password']")
	public WebElement forgetPasswordHeading;
	
	//Please enter a valid email address.
	@FindBy(css="[id='error-msg']")
	public WebElement errorMsg;
	
	@FindBy(xpath="//button[normalize-space(text())='Email me a sign-in link']")
	public WebElement btnSignIn;
}
