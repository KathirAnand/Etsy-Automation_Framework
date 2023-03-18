package com.etsy.utills;

public class TestDataProvider {
	public static  Object[][] testData(String filePath,int sheetIndex) throws Exception{
		ExcelFileReader read=new ExcelFileReader(filePath);
		int rowCount=read.totalRowsCount(sheetIndex);
		int colCount=read.totalColumnCount(sheetIndex);
		Object[][] data=new Object[rowCount][colCount];
		System.out.println(rowCount);
		System.out.println(colCount);
		for(int rowIndex=0;rowIndex<rowCount;rowIndex++) {
			for(int colIndex=0;colIndex<colCount;colIndex++) {
				data[rowIndex][colIndex]=read.getData(sheetIndex, rowIndex+1, colIndex);
				System.out.println(data[rowIndex][colIndex]);
			}
		}
		return data;
	}
	
	public static  Object[][] singleTestData(String filePath,int sheetIndex) throws Exception{
		ExcelFileReader read=new ExcelFileReader(filePath);
		int rowCount=read.totalRowsCount(sheetIndex);
		int colCount=read.totalColumnCount(sheetIndex);
//		rowCount--;
		Object[][] data=new Object[rowCount][colCount];
//		System.out.println(rowCount);
//		System.out.println(colCount);
		for(int rowIndex=0;rowIndex<rowCount;rowIndex++) {
			for(int colIndex=0;colIndex<colCount;colIndex++) {
				data[rowIndex][colIndex]=read.getData(sheetIndex, rowIndex+1, colIndex);
//				System.out.println(data[rowIndex][colIndex]);
			}
		}
		return data;
	}
	
	
}
