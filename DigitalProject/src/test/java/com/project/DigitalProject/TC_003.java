package com.project.DigitalProject;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class TC_003 extends BaseTest
{
	
  
  @BeforeMethod
  @Parameters("browser")
  public void startProcess(String bType) 
  {
	  System.out.println("startprocess");
	  	test=report.startTest("TC_003");
		
		init();
		test.log(LogStatus.INFO, "Initilazing the properties files.....");
		
		launch(bType);
		test.log(LogStatus.INFO, "Opened the Browser :-" + p.getProperty("chromebrowser"));
		
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url :- " + p.getProperty("amazonurl"));
  }
  
  
  @Test
  public void amazon() 
  {
	  System.out.println("amazon Test");
	  	selectOption("amazondrowdown_id","amazondropvalue");
		test.log(LogStatus.INFO, "Seleceted the option :- "+ or.getProperty("amazondropvalue") + " by using the locator :- " + or.getProperty("amazondrowdown_id"));

		
		typeValue("amazonsearchtextbox_name","amazonsearchtext");
		test.log(LogStatus.INFO, "Entered the text :- " + or.getProperty("amazonsearchtext") + " by using locator :- "+ or.getProperty("amazonsearchtextbox_name"));

		
		clickElement("amazonsearchbutton_xpath");
		test.log(LogStatus.INFO, "Clicked on element by using the locator :- " + or.getProperty("amazonsearchbutton_xpath"));
  }

  @AfterMethod
  public void endProcess() 
  {
	  System.out.println("endprocess");
	  closeBrowser();
	  report.endTest(test);
	  report.flush();
  }

}
