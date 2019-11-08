package com.excelOperations;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.DigitalProject.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class FaceBook extends BaseTest
{
	
	ExcelAPI e;
	
	@BeforeMethod
	@Parameters("browser")
	public void startProcess(String bType) throws Exception
	{
		test=report.startTest("FaceBook");
		
		e=new ExcelAPI("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		
		init();
		test.log(LogStatus.INFO, "Initilazing the properties files.....");
		
		launch(bType);
		test.log(LogStatus.INFO, "Opened the Browser :-" + p.getProperty("chromebrowser"));
		
		
		navigateUrl("fburl");
		test.log(LogStatus.INFO, "Navigated to url :- " + p.getProperty("fburl"));
	}
	
    @Test
	public void fb() throws Exception 
	{
    	int rcount = e.getRowCount("login");
		for(int i=1;i<rcount;i++)
		{
			driver.findElement(By.name("email")).clear();
			driver.findElement(By.name("email")).sendKeys(e.getCellData("login", "UserName", i));
			
			driver.findElement(By.name("pass")).clear();
			driver.findElement(By.name("pass")).sendKeys(e.getCellData("login", "Password", i));
			
			Thread.sleep(3000);
		}	
	}
    
    @AfterMethod
	public void endProcess()
	{
		
	}

}
