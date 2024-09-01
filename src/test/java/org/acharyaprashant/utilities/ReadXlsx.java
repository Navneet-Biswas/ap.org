package org.acharyaprashant.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.acharyaprashant.testCases.BaseClass;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadXlsx extends BaseClass{
	
	
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir") + "//src\\test//" + "java//com"
			+ "//hdfc//testData//ReigisterCustomerTestData2.xlsx";
			
			
	
	public static Workbook book;
	public static Sheet sheet;

	public static Object[][] getTestData(String sheetName)  {
		
		FileInputStream file=null;
		
		try {
			file= new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			book=WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		sheet=book.getSheet(sheetName);
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				
			}
		}
		

		
		return data;
		
	}
	
	
}
