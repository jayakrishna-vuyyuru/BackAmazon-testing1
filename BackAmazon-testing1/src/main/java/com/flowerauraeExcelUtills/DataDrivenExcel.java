package com.flowerauraeExcelUtills;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenExcel {
	 
	
	 static Sheet sheet;

	public static  String excelUtility(String sheetname,int rownum,int cellnum  ) {
		 Workbook book;
		try {
			 String path="..//BackAmazon//excelfile//New Microsoft Excel Worksheet.xlsx";
			FileInputStream fip=new FileInputStream(path);
			if(path.contains(".xlsx"))
				book=new XSSFWorkbook(fip);
			else {
				book=new HSSFWorkbook(fip);
			}
			sheet=book.getSheet(sheetname);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String cellandrowddata=sheet.getRow(rownum).getCell(cellnum).getStringCellValue();
		return cellandrowddata;
	}
	

}


