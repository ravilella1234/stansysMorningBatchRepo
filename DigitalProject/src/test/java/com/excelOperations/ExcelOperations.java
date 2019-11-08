package com.excelOperations;

public class ExcelOperations 
{

	public static void main(String[] args) throws Exception
	{
		ExcelAPI e1=new ExcelAPI("C:\\Users\\DELL\\Desktop\\testdata.xlsx");

		System.out.println(e1.getCellData("login", 1, 3));
		
		System.out.println(e1.getCellData("login", "UserName", 4));
		
		e1.setCellData("login", 4, 1, "Failed");
		
		System.out.println(e1.getRowCount("login"));
		
		System.out.println(e1.columnCount("login"));
	}

}
