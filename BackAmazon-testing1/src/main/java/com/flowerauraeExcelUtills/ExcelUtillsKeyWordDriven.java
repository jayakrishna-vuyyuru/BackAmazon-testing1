package com.flowerauraeExcelUtills;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtillsKeyWordDriven {
	
	public static  Properties prop;
	
	static String path="..//BackAmazon//connfig.properties";
	public static Properties getProperties() {
		prop =new Properties();
		try {
			FileInputStream ip=new FileInputStream(path);
				prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}

	public static Workbook wb;
	public static Sheet shhet;
	
	public final String excelpath="..//BackAmazon//excelfile//New Microsoft Excel Worksheet.xlsx";
	public void startExcution(String sheetname) {
		FileInputStream fip=null;
		try {
			fip=new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
     }
		try {
			wb=	WorkbookFactory.create(fip);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		wb.getSheet(sheetname);
		int k=0;
		for(int i=0;i<shhet.getLastRowNum();i++) {
			String loactervalue=shhet.getRow(i+1).getCell(k+1).toString().trim();
		if(loactervalue.equalsIgnoreCase("NA")) {
			
		    }
		}
	}
}
