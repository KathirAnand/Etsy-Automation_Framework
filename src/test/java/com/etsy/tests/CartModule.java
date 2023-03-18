package com.etsy.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.etsy.helpercodes.HomePageHelperCodes;
import com.etsy.helpercodes.SingInHelperCodes;
import com.etsy.testbase.TestBase;
import com.etsy.testdatas.SignInTestDatas;
import com.etsy.utills.ExtentReport;

public class CartModule extends TestBase {
	HomePageHelperCodes home = new HomePageHelperCodes();
	SingInHelperCodes singIn = new SingInHelperCodes();

	@BeforeTest
	public void startReport() {
		startReport("SignIn_Test");
	}
	@Test(priority=1)
	public void btnSignInClick() {
		ExtentReport.logger = ExtentReport.extent.startTest("signInWithValidCredentials");
		home.btnSignIn(driver);
	}
	@Test(dataProvider="validSingInTestDatas",dataProviderClass=SignInTestDatas.class,priority=2)
	public void login_withValidCredentials(String emailId, String password) throws Exception {
		ExtentReport.logger=ExtentReport.extent.startTest("signInWithValidCredentials");
		singIn.login_WithValidCredentials(emailId, password, driver);
		ExtentReport.logPassedStepReportWithScreenshot(driver, logger, "passed", "signIn button is clicked with Valid signin credentials");

	}
}
