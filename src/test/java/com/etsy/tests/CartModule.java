package com.etsy.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.etsy.helpercodes.AddToCartHelperCodes;
import com.etsy.helpercodes.HomePageHelperCodes;
import com.etsy.helpercodes.SingInHelperCodes;
import com.etsy.testbase.TestBase;
import com.etsy.testdatas.SignInTestDatas;
import com.etsy.utills.ExtentReport;

public class CartModule extends TestBase {
	HomePageHelperCodes home = new HomePageHelperCodes();
	SingInHelperCodes singIn = new SingInHelperCodes();
	AddToCartHelperCodes cart=new AddToCartHelperCodes();
	@Ignore
	@BeforeTest
	public void startReport() {
		startReport("SignIn_Test");
	}
	@Ignore
	@Test(priority=1)
	public void btnSignInClick() {
		ExtentReport.logger = ExtentReport.extent.startTest("signInWithValidCredentials");
		home.btnSignIn(driver);
	}
	@Ignore
	@Test(dataProvider="validSingInTestDatas",dataProviderClass=SignInTestDatas.class,priority=2)
	public void login_withValidCredentials(String emailId, String password) throws Exception {
		ExtentReport.logger=ExtentReport.extent.startTest("signInWithValidCredentials");
		singIn.signin_WithValidCredentials(emailId, password, driver);
		ExtentReport.logPassedStepReportWithScreenshot(driver, logger, "passed", "signIn button is clicked with Valid signin credentials");

	}
	
	public void searchProducts(String productName) {
		ExtentReport.logger=ExtentReport.extent.startTest("SearchProducts");
		cart.searchProducts(productName, driver);
	}
	
	public void selectingProduct() {
		cart.clickProduct(driver);
	}
	public void addToCart() {
		
	}
}
