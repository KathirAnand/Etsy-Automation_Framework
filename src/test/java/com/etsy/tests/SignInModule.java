package com.etsy.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.etsy.helpercodes.HomePageHelperCodes;
import com.etsy.helpercodes.SingInHelperCodes;
import com.etsy.testbase.TestBase;
import com.etsy.testdatas.SignInTestDatas;
import com.etsy.utills.ExtentReport;

public class SignInModule extends TestBase {
	HomePageHelperCodes home = new HomePageHelperCodes();
	SingInHelperCodes signIn = new SingInHelperCodes();

	@BeforeTest
	public void startReport() {
		startReport("SignIn_Test");
	}

	@Test(priority = 1)
	public void btnSignInClick() throws Exception {
		ExtentReport.logger = ExtentReport.extent.startTest("sign-in Button clicked successfully");
		home.btnSignIn(driver);
		
	}

	@Test(priority = 2)
	public void vissiblityOfSignInPageWebElements() throws InterruptedException {
		ExtentReport.logger = ExtentReport.extent.startTest("VisibilityOfWebElements");
		Thread.sleep(3500);
		signIn.validatingVissiblityOfSignInPageWebElements(driver);
		
	}

	@Test(priority = 3)
	public void signin_withoutCredentials() throws Exception {
		ExtentReport.logger = ExtentReport.extent.startTest("login_withoutCredentials");
		signIn.signin_WithoutCredentials(driver);
	}

	@Test(dataProvider = "validSingInTestDatas", dataProviderClass = SignInTestDatas.class, priority = 4)
	public void signin_withoutPassword(String emailId, String password) throws Exception {
		ExtentReport.logger = ExtentReport.extent.startTest("login_withoutPassword");
		signIn.signin_WithoutPassword(emailId, password, driver);
	}

	@Test(dataProvider = "validSingInTestDatas", dataProviderClass = SignInTestDatas.class, priority = 5)
	public void signin_withoutEmailId(String emailId, String password) throws Exception {
		ExtentReport.logger = ExtentReport.extent.startTest("login_withoutEmailId");
		signIn.signin_WithoutEmailId(emailId, password, driver);
	}

	@Test(dataProvider = "validSingInTestDatas", dataProviderClass = SignInTestDatas.class, priority = 6)
	public void signin_withValidCredentials(String emailId, String password) throws Exception {
		ExtentReport.logger = ExtentReport.extent.startTest("signInWithValidCredentials");
		signIn.signin_WithValidCredentials(emailId, password, driver);
	}

}
