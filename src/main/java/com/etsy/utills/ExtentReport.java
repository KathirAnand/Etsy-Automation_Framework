package com.etsy.utills;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.etsy.testbase.ConstantFilePaths;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {
	protected WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest logger;

	public void startReport(String testName) {
		extent = new ExtentReports(ConstantFilePaths.EXTENTREPORT_HOME + "ExtentReport\\" + testName + ".html", true);
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String destination = ConstantFilePaths.EXTENTREPORT_FILE + screenshotName + "-" + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@AfterMethod
	public void getReport(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case failed in " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case failed in " + result.getThrowable());

			String screenshotPath = getScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test case Skipped in " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test case Passes successfully in " + result.getName());
			String screenshotPath = getScreenshot(driver, result.getName());
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		}
		extent.endTest(logger);
	}

	public static void logPassedStepReportWithScreenshot(WebDriver driver, ExtentTest test, String passedMessage,
			String screenhotName) throws Exception {
		test.log(LogStatus.PASS, passedMessage);
		String screenInfo = getScreenshot(driver, screenhotName);
		test.log(LogStatus.PASS, " " + test.addScreenCapture(screenInfo));
		extent.endTest(test);
		extent.flush();
	}

	@AfterTest
	public void testEnd() {
		extent.flush();
	}

}
