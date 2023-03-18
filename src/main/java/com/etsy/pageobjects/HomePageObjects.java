package com.etsy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	public HomePageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[name='search_query']")
	public WebElement searchBar;
	
	@FindBy(css="[value='Search']")
	public WebElement searchButton;
	
	@FindBy(xpath="//span[@id='ge-tooltip-label-favorites']/preceding-sibling::a")
	public WebElement favourites;
	
	@FindBy(xpath="//button[normalize-space(text())='Sign in']")
	public WebElement btnSignIn;
	
	@FindBy(xpath="//span[@id='catnav-primary-link-891']")
	public WebElement btnHomeAndLiving;
	
	@FindBy(xpath="//a[normalize-space(text())='Lighting']")
	public WebElement btnLighiting;
	
	@FindBy(xpath="//span[@id='catnav-primary-link-891']")
	public WebElement btnClothingAndShoes;
	
	@FindBy(css="[aria-label='Basket with 0 items']")
	public WebElement linkCart;
	
}
