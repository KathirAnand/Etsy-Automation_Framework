package com.etsy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPageObjects {
	public CartPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="variation-selector-0")
	public WebElement dropdownSize;
	
	@FindBy(id="variation-selector-1")
	public WebElement dropdownColor;
	
	@FindBy(xpath="//button[normalize-space(text())='Add to basket']")
	public WebElement btnAddToBasket;
	
	@FindBy(css="[title='3D Waves and Bird Multicolor Wooden Walldecor, House Gift, Youngroom, Livingroom, Bedroom Wallhanging, Custom Made Decor, Large Size, Ocean']")
	public WebElement targetLink;
}
