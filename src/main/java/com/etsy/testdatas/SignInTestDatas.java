package com.etsy.testdatas;

import org.testng.annotations.DataProvider;

import com.etsy.testbase.ConstantFilePaths;
import com.etsy.utills.TestDataProvider;


public class SignInTestDatas {
	@DataProvider(name = "validSingInTestDatas")
	public static Object[][] testData() throws Exception {
		Object[][] signInDatas = TestDataProvider.singleTestData(ConstantFilePaths.TESTDATA_FILE, 0);
		return signInDatas;
	}
//	public static void main(String[] args) throws Exception {
//		testData();
//	}
}
