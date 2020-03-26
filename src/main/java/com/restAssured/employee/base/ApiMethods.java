package com.restAssured.employee.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.poi.EncryptedDocumentException;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class ApiMethods extends ExcelLib
{
	
	public static Response executeRequest(String testcasename,String excelPath , String sheetname) throws Throwable, IOException
			{
		LinkedHashMap reqPara = ExcelLib.getRequestParameters(testcasename, excelPath, sheetname);
		String httpMethod = reqPara.get("HTTPMethod").toString();
				switch (httpMethod) 
				{
				case "GET":
					return given().queryParam("queryPara", reqPara.get("QueryParameter").toString())
							.when().get(reqPara.get("EndPoint").toString());
				case "POST":
					try 
					{
						FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "../RestAssuredFramework/src/test/resources/req_Parameters.xlsx"  +  testcasename + "json");
						return given().queryParam("reqPara", reqPara.get("QueryParameter").toString()).when().get(reqPara.get("EndPoint").toString());
						}
					catch (IOException e ) 
					{
						
					}
					
					
				}
				return null;
			}
	
}	
