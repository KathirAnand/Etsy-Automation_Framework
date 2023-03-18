package com.etsy.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.etsy.utills.ExtentReport;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase extends ExtentReport {
	@BeforeClass
	public WebDriver setUp() {
		switch (BrowserObjects.BROWSER) {
		case "Chrome":
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(BrowserObjects.MAX_WAIT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(BrowserObjects.MAX_PAGELOADWAIT));
		driver.get(BrowserObjects.URL);
		return driver;

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
