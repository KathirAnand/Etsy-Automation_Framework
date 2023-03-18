package com.etsy.helpercodes;

import org.openqa.selenium.WebDriver;

import com.etsy.pageactions.PageActions;
import com.etsy.pageobjects.HomePageObjects;

public class HomePageHelperCodes extends PageActions{
	public void btnSignIn(WebDriver driver) {
		HomePageObjects home = new HomePageObjects(driver);
		clicker(home.btnSignIn);
	}
}
