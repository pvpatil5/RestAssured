package com.restAssured.employee.base;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Test1 extends BaseLib
{
 @Test
 public void getTest() 
 {
	 Response res = ApiMethods.executeRequest(testcasename, excelPath, sheetname);
	 System.out.println(res.prettyPrint());
	 
 }
 @Test
 public void postTest() throws IOException
 {
	 
 }
 

}
