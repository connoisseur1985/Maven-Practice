package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.qa.base.TestBase;

public class Utilities extends TestBase{
	
	public Utilities() throws IOException {
		super();
	}

	public Object[][] excelData() throws IOException{
		
		FileInputStream fin = new FileInputStream(prop.getProperty("pathExcel"));
		HSSFWorkbook wb = new HSSFWorkbook(fin);
		HSSFSheet ws = wb.getSheetAt(0);
		
		int rowCount = ws.getPhysicalNumberOfRows();
		int columnCount = ws.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rowCount-1][columnCount];
		
		for(int i=1;i<rowCount;i++) {
			
			for(int j=0;j<columnCount;j++) {
				
				data[i-1][j] = ws.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return data;
		
		
	}

}
