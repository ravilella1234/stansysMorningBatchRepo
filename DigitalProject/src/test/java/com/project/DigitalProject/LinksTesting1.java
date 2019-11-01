package com.project.DigitalProject;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class LinksTesting1 extends BaseTest
{

	@BeforeMethod(groups= {"regression"})
	@Parameters("browser")
	public void setup(String bType)
	{
		System.out.println("startprocess");
	  	test=report.startTest("LinksTesting1");
		
		init();
		test.log(LogStatus.INFO, "Initilazing the properties files.....");
		
		launch(bType);
		test.log(LogStatus.INFO, "Opened the Browser :-" + p.getProperty("chromebrowser"));
		
		
		navigateUrl("googleurl");
		test.log(LogStatus.INFO, "Navigated to url :- " + p.getProperty("googleurl"));
		
	}
	
	
	
	
	@Test(groups= {"regression"})
	public void linktesting1()
	
	 {
		String expval="Google Images";
		
		driver.findElement(By.linkText("Images")).click();	
		Reporter.log("Clicked on Image Link");
		String actval=driver.getTitle();
		
		Assert.assertEquals(actval, expval);
		
	 }
	
	@AfterMethod(groups= {"regression"})
	public void tearDown()
	{
		closeBrowser();
		report.endTest(test);
		  report.flush();
	}

}
