package com.etsy.helpercodes;

import org.openqa.selenium.WebDriver;

import com.etsy.pageactions.PageActions;
import com.etsy.pageobjects.SignInPageObjects;

public class SingInHelperCodes extends PageActions {
	public void btnClose(WebDriver driver) {
		SignInPageObjects signIn = new SignInPageObjects(driver);
		assertVisiblity(signIn.btnClose);
		clicker(signIn.btnClose);
	}

	public void linkForgetPassword(WebDriver driver) {
		SignInPageObjects signIn = new SignInPageObjects(driver);
		assertVisiblity(signIn.forgetPasswordLink);
		clicker(signIn.forgetPasswordLink);
	}

	public void validatingVissiblityOfSignInPageWebElements(WebDriver driver) {
		SignInPageObjects signIn = new SignInPageObjects(driver);
		assertVisiblity(signIn.btnClose);
		assertVisiblity(signIn.btnSignIn);
		assertVisiblity(signIn.emailInputField);
		assertVisiblity(signIn.passwordInputField);
		assertVisiblity(signIn.emailLabel);
		assertVisiblity(signIn.passwordLabel);
		assertVisiblity(signIn.forgetPasswordLink);
		assertVisiblity(signIn.signInPageHeading);
		assertVisiblity(signIn.signedInChkbox);
	}

	public void signin_WithValidCredentials(String emailId, String password, WebDriver driver) {
		SignInPageObjects signIn = new SignInPageObjects(driver);
		clear(signIn.emailInputField);
		sendKey(signIn.emailInputField, emailId);
		clear(signIn.passwordInputField);
		sendKey(signIn.passwordInputField, password);
		jsClicker(signIn.btnSignIn, driver);
	}

	public void signin_WithoutEmailId(String emailId, String password, WebDriver driver) {
		SignInPageObjects signIn = new SignInPageObjects(driver);
		clear(signIn.emailInputField);
		clear(signIn.passwordInputField);
		sendKey(signIn.passwordInputField, password);
		jsClicker(signIn.btnSignIn, driver);
	}

	public void signin_WithoutPassword(String emailId, String password, WebDriver driver) {
		SignInPageObjects signIn = new SignInPageObjects(driver);
		clear(signIn.emailInputField);
		sendKey(signIn.emailInputField, emailId);
		clear(signIn.passwordInputField);
		move(signIn.btnSignIn, driver);
	}

	public void signin_WithoutCredentials(WebDriver driver) {
		SignInPageObjects signIn = new SignInPageObjects(driver);
		clear(signIn.emailInputField);
		clear(signIn.passwordInputField);
		move(signIn.btnSignIn, driver);
	}

	public void signin_withInvalidCredentials(String emailId, String password, WebDriver driver) {
		SignInPageObjects signIn = new SignInPageObjects(driver);
		clear(signIn.emailInputField);
		sendKey(signIn.emailInputField, emailId);
		clear(signIn.passwordInputField);
		sendKey(signIn.passwordInputField, password);
		jsClicker(signIn.btnSignIn, driver);
	}
}
