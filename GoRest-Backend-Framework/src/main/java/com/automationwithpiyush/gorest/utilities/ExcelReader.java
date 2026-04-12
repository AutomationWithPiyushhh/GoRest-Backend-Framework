package com.automationwithpiyush.gorest.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	private FileInputStream fi;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private String path;

	public ExcelReader(String path) {
		this.path = path;
	}

	public int getRowCount(String sheetName) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowCount;
	}

	public int getCellCount(String sheetName, int rowNum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellCount;
	}

	public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowNum);
		XSSFCell cell = row.getCell(colNum);

		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			// Formatter safely converts cell data to string regardless of its original type
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}

		workbook.close();
		fi.close();
		return data;
	}
}