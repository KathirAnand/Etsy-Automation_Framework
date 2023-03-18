package com.etsy.pageactions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class PageActions {
	public static void clicker(WebElement element) {
		element.click();
	}
	public static void jsClicker(WebElement element, WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void clicker(String locatorType, String locatorValue, WebDriver driver) {
		switch (locatorType) {
		case "id":
			driver.findElement(By.id(locatorValue)).click();
			break;
		case "name":
			driver.findElement(By.name(locatorValue)).click();
			break;
		case "xpath":
			driver.findElement(By.xpath(locatorValue)).click();
			break;
		case "linkText":
			driver.findElement(By.linkText(locatorValue)).click();
			break;
		case "partialLinkText":
			driver.findElement(By.partialLinkText(locatorValue)).click();
			break;
		case "tagName":
			driver.findElement(By.tagName(locatorValue)).click();
			break;
		case "className":
			driver.findElement(By.className(locatorValue)).click();
			break;
		case "cssSelector":
			driver.findElement(By.cssSelector(locatorValue)).click();

		}
	}

	public static void sendKey(String locatorType, String locatorValue, String KeyValue, WebDriver driver) {
		switch (locatorType) {
		case "id":
			driver.findElement(By.id(locatorValue)).sendKeys(KeyValue);
			break;
		case "name":
			driver.findElement(By.name(locatorValue)).sendKeys(KeyValue);
			break;
		case "xpath":
			driver.findElement(By.xpath(locatorValue)).sendKeys(KeyValue);
			break;
		case "linkText":
			driver.findElement(By.linkText(locatorValue)).sendKeys(KeyValue);
			break;
		case "partialLinkText":
			driver.findElement(By.partialLinkText(locatorValue)).sendKeys(KeyValue);
			break;
		case "tagName":
			driver.findElement(By.tagName(locatorValue)).sendKeys(KeyValue);
			break;
		case "className":
			driver.findElement(By.className(locatorValue)).sendKeys(KeyValue);
			break;
		case "cssSelector":
			driver.findElement(By.cssSelector(locatorValue)).sendKeys(KeyValue);
		}
	}

	public static void sendKey(WebElement element, String keyValue) {
		element.sendKeys(keyValue);
	}
	public static void jsSendkey(String keyValue,WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+keyValue+"';", element);
	}
	

	public static WebElement find(String locatorType, String locatorValue, WebDriver driver) {
		WebElement element = null;
		switch (locatorType) {
		case "id":
			element = driver.findElement(By.id(locatorValue));
			break;
		case "name":
			element = driver.findElement(By.name(locatorValue));
			break;
		case "xpath":
			element = driver.findElement(By.xpath(locatorValue));
			break;
		case "linkText":
			element = driver.findElement(By.linkText(locatorValue));
			break;
		case "partialLinkText":
			element = driver.findElement(By.partialLinkText(locatorValue));
			break;
		case "tagName":
			element = driver.findElement(By.tagName(locatorValue));
			break;
		case "className":
			element = driver.findElement(By.className(locatorValue));
			break;
		case "cssSelector":
			element = driver.findElement(By.cssSelector(locatorValue));
		}
		return element;
	}

	public static void clear(String locatorType, String locatorValue, WebDriver driver) {
		switch (locatorType) {
		case "id":
			driver.findElement(By.id(locatorValue)).clear();
			break;
		case "name":
			driver.findElement(By.name(locatorValue)).clear();
			break;
		case "xpath":
			driver.findElement(By.xpath(locatorValue)).clear();
			break;
		case "linkText":
			driver.findElement(By.linkText(locatorValue)).clear();
			break;
		case "partialLinkText":
			driver.findElement(By.partialLinkText(locatorValue)).clear();
			break;
		case "tagName":
			driver.findElement(By.tagName(locatorValue)).clear();
			break;
		case "className":
			driver.findElement(By.className(locatorValue)).clear();
			break;
		case "cssSelector":
			driver.findElement(By.cssSelector(locatorValue)).clear();

		}
	}

	public static void clear(WebElement element) {
		element.clear();
	}

	public static void switchWindow(WebDriver driver, int index) {
		Set<String> windowIds = driver.getWindowHandles();
		List<String> opt = new ArrayList<String>(windowIds);
		driver.switchTo().window(opt.get(index));
	}

	public static void move(WebElement source,WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(source);
	}

	public static void moveTo(String locatorType, String source, String targert, WebDriver driver) {
		WebElement sourceElement = PageActions.find(locatorType, source, driver);
		WebElement targetElement = PageActions.find(locatorType, targert, driver);
		Actions action = new Actions(driver);
		action.moveToElement(sourceElement).click(targetElement).perform();
	}

	public static void moveTo(WebElement sourceElement, WebElement targetElement, WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(sourceElement).click(targetElement).perform();
	}

	public static void visible(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		element = wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void assertVisiblity(WebElement element) {
		Assert.assertTrue(element.isDisplayed());
	}
	
	public static void assertEnabled(WebElement element) {
		Assert.assertTrue(element.isEnabled());
	}
	public static void assertSelected(WebElement element) {
		Assert.assertTrue(element.isSelected());
	}
}
