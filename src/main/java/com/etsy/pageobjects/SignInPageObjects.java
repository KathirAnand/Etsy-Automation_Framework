package com.etsy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPageObjects {
	public SignInPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h1[@id='join-neu-overlay-title']")
	public WebElement signInPageHeading;
	
	@FindBy(css="[for='join_neu_email_field']")
	public WebElement emailLabel;
	
	@FindBy(css="#join_neu_email_field")
	public WebElement emailInputField;
	
	@FindBy(css="[for='join_neu_password_field']")
	public WebElement passwordLabel;
	
	@FindBy(css="#join_neu_password_field")
	public WebElement passwordInputField;
	
	@FindBy(css="#aria-join_neu_email_field-error")
	public WebElement emailErrorMsg;
	
	@FindBy(css="#aria-join_neu_password_field-error")
	public WebElement passwordErrorMsg;
	
	@FindBy(xpath="//div[text()='Password was incorrect']")
	public WebElement withEmailAndWithIncorrectpasswordErrorMsg;
		
	@FindBy(xpath="(//span[@aria-label='Close']/parent::button)[2]")
	public WebElement btnClose;
	
	@FindBy(id="persisent")
	public WebElement signedInChkbox;
	
	@FindBy(xpath="//a[text()='Forgot your password?']")
	public WebElement forgetPasswordLink;
	
	@FindBy(xpath="//button[normalize-space(text())='Register']")
	public WebElement registerBtn;
	
	@FindBy(css="[name='submit_attempt']")
	public WebElement btnSignIn;
}
