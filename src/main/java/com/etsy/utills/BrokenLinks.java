package com.etsy.utills;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLinks {
	public void brokenLinks(WebDriver driver) throws Exception {
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		System.out.println("No.of Links in the Page"+allLinks.size());
		List<WebElement> activeLinks=new ArrayList<WebElement>();
		for(WebElement link:allLinks) {
			if(link.getAttribute("a")!=null) {
				activeLinks.add(link);
			}
		}
		for(int i=0;i<activeLinks.size();i++) {
			HttpURLConnection connection=(HttpURLConnection)new URL(activeLinks.get(i).getAttribute("href")).openConnection();
			connection.connect();
			int responseCode=connection.getResponseCode();
			String responseMessage=connection.getResponseMessage();
			connection.disconnect();
			System.out.println("URL"+activeLinks.get(i).getAttribute("href")+" Response Code=====> "+responseCode+" Response Message=====> "+responseMessage);
		}
		
	}
}
