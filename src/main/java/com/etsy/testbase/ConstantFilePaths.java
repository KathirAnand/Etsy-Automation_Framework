package com.etsy.testbase;

import java.io.File;

public class ConstantFilePaths {
	public final static  String USER_HOME=System.getProperty("user.dir")+File.separator+File.separator;
	public static final String TESTDATA_HOME=USER_HOME+"TestData"+File.separator;
	public static final String TESTDATA_FILE="C:\\Users\\kathiravan\\Documents\\Eclipse_work-space\\etsyindia\\testdatas\\etsy_validLoginCredential.xlsx";
	public static final String EXTENTREPORT_HOME="C:\\Users\\kathiravan\\Documents\\Eclipse_work-space\\etsyindia\\";
	public static final String EXTENTREPORT_FILE=EXTENTREPORT_HOME+"test-output\\FailedTestsScreenshots\\";

}
//C:\Users\kathiravan\Documents\Eclipse_work-space\etsyindia\testdatas\etsy_validLoginCredential.xlsx