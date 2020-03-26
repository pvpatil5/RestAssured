package com.restAssured.employee.base;

import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseLib implements IConstants
{
	public static ExtentReports extentreports;
	public static ExtentTest extenttest;
	public static ExtentHtmlReporter extenthtmlreporter;
	public String testcasename;

	/**
	 * to initialize the URI ,port and authentication
	 */

	@BeforeSuite
	public void config() 
	{
		baseURI = BASE_URI;
		//port=4444;
		//given().auth(). bacic(username, password);	
	}

}
