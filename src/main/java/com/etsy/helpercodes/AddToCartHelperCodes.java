package com.etsy.helpercodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.etsy.pageactions.PageActions;
import com.etsy.pageobjects.CartPageObjects;
import com.etsy.pageobjects.HomePageObjects;

public class AddToCartHelperCodes extends PageActions{
	public void searchProducts(String productName,WebDriver dirver) {
		HomePageObjects home=new HomePageObjects(dirver);
		sendKey(home.searchBar, productName);
		clicker(home.searchButton);
	}
	public void clickProduct(WebDriver driver) {
		CartPageObjects cart=new CartPageObjects(driver);
		clicker(cart.targetLink);
	}
	
	public void selectSizeAndColor(WebDriver driver) {
		CartPageObjects cart=new CartPageObjects(driver);
		selectByIndex(cart.dropdownSize, 1);
		selectByIndex(cart.dropdownColor, 1);
	}
	public void addToBasket(WebDriver driver) {
		CartPageObjects cart=new CartPageObjects(driver);
		clicker(cart.btnAddToBasket);
	}
	
}
