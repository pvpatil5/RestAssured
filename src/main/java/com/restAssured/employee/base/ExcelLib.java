package com.restAssured.employee.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib 
{

	/**
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static LinkedHashMap getRequestParameters(String testcasename,String excelPath , String sheetname) throws EncryptedDocumentException, IOException
	{
		@SuppressWarnings("rawtypes")
		LinkedHashMap apireqData=new LinkedHashMap();
		try
		{
			FileInputStream fis =new FileInputStream(excelPath);
			Workbook wb= WorkbookFactory.create(fis);
			Sheet sht=wb.getSheet(sheetname);
			int rows =sht.getPhysicalNumberOfRows();
			for (int i = 0; i < rows; i++) 
			{
				if(sht.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase(testcasename))
				{
					for (int j = 2; j < sht.getRow(i).getPhysicalNumberOfCells(); j++) 
					{
						apireqData.put(sht.getRow(1).getCell(j).getStringCellValue(),sht.getRow(i).getCell(j).getStringCellValue());	
					}
					break;
				}
			}
		}
		catch(FileNotFoundException e) 
		{
			//e.printStackTrace();
		}
		return apireqData;
	}
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		LinkedHashMap map = getRequestParameters("getAllEmployees","../src/test/resources/req_Parameters.xlsx", "Sheet1");
		System.out.println(map);
	}


}



