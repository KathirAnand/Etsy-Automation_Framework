package com.etsy.utills;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelFileReader(String filePath) throws Exception {
		File file = new File(filePath);
		FileInputStream inputFile = new FileInputStream(file);
		try {
			workbook = new XSSFWorkbook(inputFile);
		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	public String getData(int sheetIndex, int rowNum, int cellNum) {
		sheet = workbook.getSheetAt(sheetIndex);
		String data = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}

	public int totalRowsCount(int sheetIndex) {
		int rowCount = workbook.getSheetAt(sheetIndex).getLastRowNum();
		return rowCount;
	}

	public int totalColumnCount(int sheetIndex) {
		int columnCount = workbook.getSheetAt(sheetIndex).getRow(1).getLastCellNum();
		return columnCount;
	}
	
}
