package com.training.utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static com.training.utilities.Constants.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadXL 
{
	static XSSFWorkbook ExcelWbook;
	static XSSFSheet ExcelWSheet;
	static XSSFRow ExcelRow;
	static XSSFCell ExcelCell;

	public static void main(String[] args) throws IOException 
	{
		String filePath = USER_DIR+FILE_SEPARATOR; //+Excel_Sheet;
		//File holding syntax
		FileInputStream ExcelFile = new FileInputStream(filePath);
		ExcelWbook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWbook.getSheet("Login");
		int totalRows = ExcelWSheet.getLastRowNum();
		System.out.println(totalRows);
		//int totalCol = 2;
		//System.out.println(totalCol);
		ExcelCell = ExcelWSheet.getRow(0).getCell(0);
		System.out.println(ExcelCell);

	}

}
